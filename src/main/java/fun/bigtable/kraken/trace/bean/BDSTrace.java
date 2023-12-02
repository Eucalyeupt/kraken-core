package fun.bigtable.kraken.trace.bean;

import fun.bigtable.kraken.trace.ITrace;

/**
 */
public class BDSTrace implements ITrace {
    private String vno;
    private String province;
    private String city;
    private String country;
    private String lat;
    private String lon;
    private String adr;
    private String utc;
    private String spd;
    private String drc;
    private String bst;
    private String alc;
    private String est;
    private String agl;
    private String hgt;
    private String gtm;
    private String mlg;
    private String mil;
    private String stopTime;
    private int stopMin;
    private String state;

    private String des ;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public int getStopMin() {
        return stopMin;
    }

    @Override
    public String getUnique() {
        return vno;
    }

    public void setStopMin(int stopMin) {
        this.stopMin = stopMin;
        if(stopMin<60){
            this.stopTime = stopMin+"分钟";

        }
        if(stopMin>=60&&stopMin<(24*60)){
            this.stopTime = (stopMin/60)+"小时"+((stopMin%60)==0?"":((stopMin%60)+"分钟"));
        }
        if(stopMin>=(24*60)){
            this.stopTime = (stopMin/(24*60))+"天";
            int hour = stopMin%(24*60);
           if(hour>=60){
                this.stopTime+=(hour/60)+"小时";
           }
        }
    }

    public String getVno() {
        return vno;
    }

    public void setVno(String vno) {
        this.vno = vno;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getUtc() {
        return utc;
    }

    public void setUtc(String utc) {
        this.utc = utc;
    }

    public String getSpd() {
        return spd;
    }

    public void setSpd(String spd) {
        this.spd = spd;
    }

    public String getDrc() {
        return drc;
    }

    public void setDrc(String drc) {
        this.drc = drc;
    }

    public String getBst() {
        return bst;
    }

    public void setBst(String bst) {
        this.bst = bst;
    }

    public String getAlc() {
        return alc;
    }

    public void setAlc(String alc) {
        this.alc = alc;
    }

    public String getEst() {
        return est;
    }

    public void setEst(String est) {
        this.est = est;
    }

    public String getAgl() {
        return agl;
    }

    public void setAgl(String agl) {
        this.agl = agl;
    }

    public String getHgt() {
        return hgt;
    }

    public void setHgt(String hgt) {
        this.hgt = hgt;
    }

    public String getGtm() {
        return gtm;
    }

    public void setGtm(String gtm) {
        this.gtm = gtm;
    }

    public String getMlg() {
        return mlg;
    }

    public void setMlg(String mlg) {
        this.mlg = mlg;
    }

    public String getMil() {
        return mil;
    }

    public void setMil(String mil) {
        this.mil = mil;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
