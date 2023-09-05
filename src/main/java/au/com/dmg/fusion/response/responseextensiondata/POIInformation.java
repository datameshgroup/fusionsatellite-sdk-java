package au.com.dmg.fusion.response.responseextensiondata;

import au.com.dmg.fusion.Message;
import au.com.dmg.fusion.response.diagnosisresponse.AddressLocation;
import com.squareup.moshi.Json;

public class POIInformation {
    @Json(name = "TID")
    private final String tid;
    @Json(name = "MID")
    private final String mid;
    @Json(name = "SoftwareVersion")
    private final String softwareVersion;
    @Json(name = "FusionVersion")
    private final String fusionVersion;
    @Json(name = "AddressLocation")
    private final AddressLocation addressLocation;

    public POIInformation(Builder builder) {
        this.tid = builder.tid;
        this.mid = builder.mid;
        this.softwareVersion = builder.softwareVersion;
        this.fusionVersion = Message.FUSION_SATELLITE_VERSION;
        this.addressLocation = builder.addressLocation;
    }

    public String getTid(){
        return tid;
    }
    public String getMid(){
        return mid;
    }
    public String getSoftwareVersion() { return  softwareVersion; }
    public String getFusionVersion() { return fusionVersion; }
    public AddressLocation getAddressLocation(){
        return addressLocation;
    }

    public static class Builder{
        private String tid;
        private String mid;
        private String softwareVersion;
        private String fusionVersion;
        private AddressLocation addressLocation;

        public Builder(){
        }

        Builder(String tid, String mid, String softwareVersion, AddressLocation addressLocation){
            this.tid = tid;
            this.mid = mid;
            this.softwareVersion = softwareVersion;
            this.addressLocation = addressLocation;
        }

        public Builder tid(String tid){
            this.tid = tid;
            return Builder.this;
        }
        public Builder mid(String mid){
            this.mid = mid;
            return Builder.this;
        }
        public Builder softwareVersion(String softwareVersion){
            this.softwareVersion = softwareVersion;
            return Builder.this;
        }

        public Builder addressLocation(AddressLocation addressLocation){
            this.addressLocation = addressLocation;
            return Builder.this;
        }

        public POIInformation build(){
            return new POIInformation(this);
        }
    }
}
