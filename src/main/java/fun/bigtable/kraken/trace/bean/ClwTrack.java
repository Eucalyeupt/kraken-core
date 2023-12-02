package fun.bigtable.kraken.trace.bean;

import fun.bigtable.kraken.trace.ITrace;
import org.bson.Document;

/**
 * 车厂合作轨迹
 */
public class ClwTrack implements ITrace {

    //最后定位时间
    private String locationTime;
    //经度
    private String lng;
    //总里程
    private String totalMileage;
    //方向
    private String dir;
    //当前车速
    private String speed;
    //纬度
    private String lat;
    //车牌号
    private String vno;
    //车架号
    private String vin;

    public String getLocationTime() {
        return locationTime;
    }

    public void setLocationTime(String locationTime) {
        this.locationTime = locationTime;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getTotalMileage() {
        return totalMileage;
    }

    public void setTotalMileage(String totalMileage) {
        this.totalMileage = totalMileage;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getLat() {
        return lat;
    }

    @Override
    public String getLon() {
        return lng;
    }

    @Override
    public String getUtc() {
        return locationTime;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getUnique() {
        return vin;
    }

    public void setVno(String vno) {
        this.vno = vno;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Document flatToDocument() {
        Document document = new Document();
        document.put("vno",  vno);
        document.put("locationTime",  locationTime);
        document.put("lng",  lng);
        document.put("totalMileage",  totalMileage);
        document.put("dir", dir);
        document.put("speed", speed);
        document.put("lat", lat);
        document.put("vin", vin);
        return document;
    }

}
