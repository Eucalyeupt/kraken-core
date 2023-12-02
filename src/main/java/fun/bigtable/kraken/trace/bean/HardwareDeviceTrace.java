package fun.bigtable.kraken.trace.bean;


import fun.bigtable.kraken.trace.ITrace;
import fun.bigtable.kraken.util.DateTimeUtils;

import java.time.LocalDateTime;

public class HardwareDeviceTrace implements ITrace {

    /**
     * 位置ID，业务无关
     */
    private String positionId;

    /**
     * 方向
     */
    private Integer course;

    /**
     * 设备imei
     */
    private String imei;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 经度
     */
    private String lng;

    /**
     * 位置类型，GPS/LBS
     */
    private String positionType;

    /**
     * 速度
     */
    private Integer speed;

    /**
     * 定位点时间
     */
    private LocalDateTime time;

    /**
     * 类型，暂无无用处
     */
    private Integer type;

    private Long boxId;
    /**
     * 车牌号*
     */
    private String plateNo;

    @Override
    public String getLon() {
        return lng;
    }

    @Override
    public String getUtc() {
        return DateTimeUtils.formateDate(time);
    }

    @Override
    public String getUnique() {
        return imei;
    }

    public Long getBoxId() {
        return boxId;
    }

    public void setBoxId(Long boxId) {
        this.boxId = boxId;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public HardwareDeviceTrace(){

    }

    public static PositionBuilder builder() {
        return new PositionBuilder();
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    HardwareDeviceTrace(String positionId, Integer course, String imei, String lat, String lng, String positionType, Integer speed, LocalDateTime time, Integer type, Long boxId, String plateNo) {
        this.positionId = positionId;
        this.course = course;
        this.imei = imei;
        this.lat = lat;
        this.lng = lng;
        this.positionType = positionType;
        this.speed = speed;
        this.time = time;
        this.type = type;
        this.boxId = boxId;
        this.plateNo = plateNo;
    }

    public static class PositionBuilder {
        private String positionId;
        private Integer course;
        private String imei;
        private String lat;
        private String lng;
        private String positionType;
        private Integer speed;
        private LocalDateTime time;
        private Integer type;
        private Long boxId;
        private String plateNo;

        PositionBuilder() {
        }

        public PositionBuilder positionId(String positionId) {
            this.positionId = positionId;
            return this;
        }

        public PositionBuilder course(Integer course) {
            this.course = course;
            return this;
        }

        public PositionBuilder imei(String imei) {
            this.imei = imei;
            return this;
        }

        public PositionBuilder lat(String lat) {
            this.lat = lat;
            return this;
        }

        public PositionBuilder lng(String lng) {
            this.lng = lng;
            return this;
        }

        public PositionBuilder positionType(String positionType) {
            this.positionType = positionType;
            return this;
        }

        public PositionBuilder speed(Integer speed) {
            this.speed = speed;
            return this;
        }

        public PositionBuilder time(LocalDateTime time) {
            this.time = time;
            return this;
        }

        public PositionBuilder type(Integer type) {
            this.type = type;
            return this;
        }

        public PositionBuilder boxId(Long boxId) {
            this.boxId = boxId;
            return this;
        }

        public PositionBuilder plateNo(String plateNo) {
            this.plateNo = plateNo;
            return this;
        }

        public HardwareDeviceTrace build() {
            return new HardwareDeviceTrace(positionId, course, imei, lat, lng, positionType, speed, time, type, boxId, plateNo);
        }

        public String toString() {
            return "HardwareDeviceTrace.PositionBuilder(positionId=" + this.positionId + ", course=" + this.course + ", imei=" + this.imei + ", lat=" + this.lat + ", lng=" + this.lng + ", positionType=" + this.positionType + ", speed=" + this.speed + ", time=" + this.time + ", type=" + this.type + ", boxId=" + this.boxId + ")";
        }
    }
}