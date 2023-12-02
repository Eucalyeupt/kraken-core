package fun.bigtable.kraken.trace.bean;

import fun.bigtable.kraken.trace.ITrace;

public class DefaultTrace implements ITrace {

    private String lat;

    private String lon;

    private String utc;

    private String unique;

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public void setUtc(String utc) {
        this.utc = utc;
    }

    public void setUnique(String unique) {
        this.unique = unique;
    }

    @Override
    public String getLat() {
        return lat;
    }

    @Override
    public String getLon() {
        return lon;
    }

    @Override
    public String getUtc() {
        return utc;
    }

    @Override
    public String getUnique() {
        return unique;
    }


    public static final class DefaultTraceBuilder {
        private DefaultTrace defaultTrace;

        private DefaultTraceBuilder() {
            defaultTrace = new DefaultTrace();
        }

        public static DefaultTraceBuilder aDefaultTrace() {
            return new DefaultTraceBuilder();
        }

        public DefaultTraceBuilder lat(String lat) {
            defaultTrace.setLat(lat);
            return this;
        }

        public DefaultTraceBuilder lon(String lon) {
            defaultTrace.setLon(lon);
            return this;
        }

        public DefaultTraceBuilder utc(String utc) {
            defaultTrace.setUtc(utc);
            return this;
        }

        public DefaultTraceBuilder unique(String unique) {
            defaultTrace.setUnique(unique);
            return this;
        }

        public DefaultTrace build() {
            return defaultTrace;
        }
    }
}
