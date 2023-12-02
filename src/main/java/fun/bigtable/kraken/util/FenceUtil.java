package fun.bigtable.kraken.util;

import cn.hutool.http.HttpUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import fun.bigtable.kraken.trace.ITrace;
import fun.bigtable.kraken.trace.bean.DefaultTrace;
import fun.bigtable.kraken.util.fence.FenceTypeEnum;
import fun.bigtable.kraken.util.fence.GPSUtils;
import fun.bigtable.kraken.util.fence.WarningRuleFence;

import java.util.ArrayList;
import java.util.List;

public class FenceUtil {

    /**
     * 回转数法判断点是否在多边形内部
     *
     * @see  <a href="https://www.jianshu.com/p/852d7ad081b3">GEOJSON标准格式</a>
     * @see <a href="http://datav.aliyun.com/tools/atlas/index.html#&lat=31.769817845138945&lng=104.29901249999999&zoom=4">dataV</a>
     * @see <a href="https://blog.csdn.net/Form_/article/details/77855163">算法来源</a>
     *
     * @param p    待判断的点
     * @param poly 多边形顶点，
     * @return 点 p 和多边形 poly 的几何关系，是否在多边形内部
     */
    public static boolean windingNumber(ITrace p, List<ITrace> poly) {
        double px = Double.parseDouble(p.getLon());
        double py = Double.parseDouble(p.getLat());
        double sum = 0;

        for (int i = 0, l = poly.size(), j = l - 1; i < l; j = i, i++) {
            double sx = Double.parseDouble(poly.get(i).getLon());
            double sy = Double.parseDouble(poly.get(i).getLat());
            double tx = Double.parseDouble(poly.get(j).getLon());
            double ty = Double.parseDouble(poly.get(j).getLat());

            // 点与多边形顶点重合或在多边形的边上
            if ((sx - px) * (px - tx) >= 0 && (sy - py) * (py - ty) >= 0 && (px - sx) * (ty - sy) == (py - sy) * (tx - sx)) {
                return false;
            }

            // 点与相邻顶点连线的夹角
            double angle = Math.atan2(sy - py, sx - px) - Math.atan2(ty - py, tx - px);

            // 确保夹角不超出取值范围（-π 到 π）
            if (angle >= Math.PI) {
                angle = angle - Math.PI * 2;
            } else if (angle <= -Math.PI) {
                angle = angle + Math.PI * 2;
            }
            sum += angle;
        }

        // 计算回转数并判断点和多边形的几何关系
        return Math.round(sum / Math.PI) != 0;
    }

    /**
     * 圆形围栏判断位置点是否在围栏内部
     *
     * @param center 中心点位置
     * @param p      需判断的点的位置
     * @param radius 判断半径
     */
    public static boolean circleFence(ITrace center, ITrace p, int radius) {
        return GPSUtils.GetDistance(Double.parseDouble(center.getLat()), Double.parseDouble(center.getLon()), Double.parseDouble(p.getLat()), Double.parseDouble(p.getLon())) < radius;

    }

    /**
     * 位置点是否在围栏中
     * @param position 位置点
     * @param warningRuleFence 围栏配置
     * @return 是否在围栏中
     */
    public static boolean checkInFence(ITrace position, WarningRuleFence warningRuleFence) {
        switch (FenceTypeEnum.getTypeByCode(warningRuleFence.getFenceType())) {
            case ROUND:
                String[] split = warningRuleFence.getCenterPosition().split(",");
                DefaultTrace center = new DefaultTrace();
                center.setLat(split[1]);
                center.setLon(split[0]);
                return FenceUtil.circleFence(center, position, warningRuleFence.getRadius());
            case CUSTOM:
                JsonParser parser = new JsonParser();
                JsonArray jsonArray = parser.parse(warningRuleFence.getFenceBorder()).getAsJsonObject().getAsJsonArray("position");

                List<ITrace> poly = new ArrayList<>();

                for (JsonElement jsonElement : jsonArray) {
                    poly.add(DefaultTrace.DefaultTraceBuilder.aDefaultTrace().lon(jsonElement.getAsJsonArray().get(0).getAsString()).lat(jsonElement.getAsJsonArray().get(1).getAsString()).build());
                }

                return FenceUtil.windingNumber(position, poly);
            case AREA:
                parser = new JsonParser();
                String areaStr = HttpUtil.get("https://geo.datav.aliyun.com/areas_v3/bound/geojson?code=" + warningRuleFence.getAreaCode());
                jsonArray = parser.parse(areaStr).getAsJsonObject().getAsJsonArray("features").get(0).getAsJsonObject().getAsJsonObject("geometry").getAsJsonArray("coordinates").get(0).getAsJsonArray().get(0).getAsJsonArray();

                poly = new ArrayList<>();

                for (JsonElement jsonElement : jsonArray) {
                    poly.add(DefaultTrace.DefaultTraceBuilder.aDefaultTrace().lon(jsonElement.getAsJsonArray().get(0).getAsString()).lat(jsonElement.getAsJsonArray().get(1).getAsString()).build());
                }

                poly.remove(0);
                return FenceUtil.windingNumber(position, poly);
            default:
                return false;
        }
    }

}
