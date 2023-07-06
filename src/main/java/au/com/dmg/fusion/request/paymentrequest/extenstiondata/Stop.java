package au.com.dmg.fusion.request.paymentrequest.extenstiondata;

import com.squareup.moshi.Json;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.time.Instant;

public class Stop {
    @Json(name = "StopIndex")
    private final Integer stopIndex;
    @Json(name = "StopID")
    private final String stopID;
    @Json(name = "StopName")
    private final String stopName;
    @Json(name = "ZoneID")
    private final String zoneID;
    @Json(name = "Latitude")
    private final BigDecimal latitude;
    @Json(name = "Longitude")
    private final BigDecimal longitude;
    @Json(name = "Timestamp")
    private final Instant timestamp;

    @NotNull
    public Integer getStopIndex(){ return stopIndex; }
    public String getStopID(){ return stopID; }
    public String getStopName(){ return stopName; }
    public String getZoneID(){ return zoneID; }
    public BigDecimal getLatitude(){ return latitude; }
    public BigDecimal getLongitude(){ return longitude; }
    @NotNull
    public Instant getTimestamp(){ return timestamp; }

    public static class Builder{
        private Integer stopIndex;
        private String stopID;
        private String stopName;
        private String zoneID;
        private BigDecimal latitude;
        private BigDecimal longitude;
        private Instant timestamp;

        public Builder(){
        }

        Builder(Integer stopIndex, String stopID, String stopName, String zoneID, BigDecimal latitude, BigDecimal longitude, Instant timestamp) {
            this.stopIndex = stopIndex;
            this.stopID = stopID;
            this.stopName = stopName;
            this.zoneID = zoneID;
            this.latitude = latitude;
            this.longitude = longitude;
            this.timestamp = timestamp;
        }

        public Builder stopIndex(Integer stopIndex){
            this.stopIndex = stopIndex;
            return Builder.this;
        }
        public Builder stopID(String stopID){
            this.stopID = stopID;
            return Builder.this;
        }
        public Builder stopName(String stopName){
            this.stopName = stopName;
            return Builder.this;
        }
        public Builder zoneID(String zoneID){
            this.zoneID = zoneID;
            return Builder.this;
        }
        public Builder latitude(BigDecimal latitude){
            this.latitude = latitude;
            return Builder.this;
        }
        public Builder longitude(BigDecimal longitude){
            this.longitude = longitude;
            return Builder.this;
        }
        public Builder timestamp(Instant timestamp){
            this.timestamp = timestamp;
            return Builder.this;
        }

        public Stop build() {
            if(this.stopIndex == null){
                throw new NullPointerException("The property \"stopIndex\" is null. "
                        + "Please set the Value by \"stopIndex()\". "
                        + "the properties \"stopIndex\" and \"timestamp\" are required.");
            }
            if(this.stopName == null){
                this.stopName = "SUBURB";
            }
            if(this.timestamp == null){
                throw new NullPointerException("The property \"timestamp\" is null. "
                        + "Please set the Value by \"timestamp()\". "
                        + "the properties \"stopIndex\" and \"timestamp\" are required.");
            }
            return new Stop(this);
        }
    }

    private Stop(Builder builder) {
        this.stopIndex = builder.stopIndex;
        this.stopID = builder.stopID;
        this.stopName = builder.stopName;
        this.zoneID = builder.zoneID;
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
        this.timestamp = builder.timestamp;
    }
}
