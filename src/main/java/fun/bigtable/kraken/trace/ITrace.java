package fun.bigtable.kraken.trace;

/**
 * 轨迹接口抽象类
 */
public interface ITrace {

    /**
     * 纬度
     */
    String getLat();

    /**
     * 经度
     */
    String getLon();

    /**
     * 时间
     */
    String getUtc();

    /**
     * 唯一标识
     */
    String getUnique();

}
