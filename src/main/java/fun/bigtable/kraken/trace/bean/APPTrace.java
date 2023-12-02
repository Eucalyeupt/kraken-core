package fun.bigtable.kraken.trace.bean;


import fun.bigtable.kraken.trace.ITrace;
import fun.bigtable.kraken.util.DateTimeUtils;
import org.apache.commons.lang3.StringUtils;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

public class APPTrace implements ITrace {
    private long id;
    private String lon;
    private String lat;
    private String phone;
    private long userId;
    private String areaCode;
    private Date locationTime;
    private String locationTimeString;
    private Date createTime;
    private String des;
    private String month;
    private String type;            //1：开始点   2：结束点
    private String vno;
    private String deviceType;

    private String startDistance;
    private String arriveDistance;
    private String lonAndLat;

    @Override
    public String getUtc() {
        return Optional.of(locationTime).map(DateTimeUtils::formDateToLocalDateTime).map(DateTimeUtils::formateDate).orElse(null);
    }

    @Override
    public String getUnique() {
        return phone;
    }

    public String getVno() {
        return vno;
    }

    public void setVno(String vno) {
        this.vno = vno;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocationTimeString() {
        return locationTimeString;
    }

    public void setLocationTimeString(String locationTimeString) {
        if (StringUtils.isEmpty(locationTimeString)) return;
        this.locationTimeString = locationTimeString.substring(0, locationTimeString.length() - 2);
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Date getLocationTime() {
        return locationTime;
    }

    public void setLocationTime(Date locationTime) {
        this.locationTime = locationTime;
        if (locationTime != null) {
            this.month = DateTimeFormatter.ofPattern("yyyyMM").format(DateTimeUtils.formDateToLocalDateTime(locationTime));
        }
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getStartDistance() {
        return startDistance;
    }

    public void setStartDistance(String startDistance) {
        this.startDistance = startDistance;
    }

    public String getArriveDistance() {
        return arriveDistance;
    }

    public void setArriveDistance(String arriveDistance) {
        this.arriveDistance = arriveDistance;
    }

    public String getLonAndLat() {
        return lonAndLat;
    }

    public void setLonAndLat(String lonAndLat) {
        this.lonAndLat = lonAndLat;
    }
}
