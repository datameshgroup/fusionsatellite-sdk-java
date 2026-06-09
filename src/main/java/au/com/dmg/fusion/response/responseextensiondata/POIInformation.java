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
    @Json(name = "LocationID")
    private final String locationID;
    @Json(name = "ExtTerminalID")
    private final String extTerminalID;
    @Json(name = "ApplicationID")
    private final String applicationID;
    @Json(name = "TargetID")
    private final String targetID;
    @Json(name = "IsOpt")
    private final boolean isOpt;
    @Json(name = "PumpIDs")
    private final String pumpIDs;
    @Json(name = "DiscountCardAccepted")
    private final boolean discountCardAccepted;
    @Json(name = "ClientID")
    private final String clientID;
    @Json(name = "ClientSecret")
    private final String clientSecret;
    @Json(name = "ClientID2")
    private final String clientID2;
    @Json(name = "ClientSecret2")
    private final String clientSecret2;
    @Json(name = "ClientUsername")
    private final String clientUsername;
    @Json(name = "URL")
    private final String url;
    @Json(name = "URL2")
    private final String url2;

    public POIInformation(Builder builder) {
        this.tid = builder.tid;
        this.mid = builder.mid;
        this.softwareVersion = builder.softwareVersion;
        this.fusionVersion = Message.FUSION_SATELLITE_VERSION;
        this.addressLocation = builder.addressLocation;
        this.locationID = builder.locationID;
        this.extTerminalID = builder.extTerminalID;
        this.applicationID = builder.applicationID;
        this.targetID = builder.targetID;
        this.isOpt = builder.isOpt;
        this.pumpIDs = builder.pumpIDs;
        this.discountCardAccepted = builder.discountCardAccepted;
        this.clientID = builder.clientID;
        this.clientSecret = builder.clientSecret;
        this.clientID2 = builder.clientID2;
        this.clientSecret2 = builder.clientSecret2;
        this.clientUsername = builder.clientUsername;
        this.url = builder.url;
        this.url2 = builder.url2;
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
    public String getLocationID(){
        return locationID;
    }
    public String getExtTerminalID(){
        return extTerminalID;
    }
    public String getApplicationID(){
        return applicationID;
    }
    public String getTargetID(){
        return targetID;
    }
    public boolean isOpt(){
        return isOpt;
    }
    public String getPumpIDs(){
        return pumpIDs;
    }
    public boolean isDiscountCardAccepted(){
        return discountCardAccepted;
    }

    public String getClientID() {
        return clientID;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getClientID2() {
        return clientID2;
    }

    public String getClientSecret2() {
        return clientSecret2;
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public String getURL() {
        return url;
    }

    public String getURL2() {
        return url2;
    }

    public static class Builder{
        private String tid;
        private String mid;
        private String softwareVersion;
        private String fusionVersion;
        private AddressLocation addressLocation;
        private String locationID;
        private String extTerminalID;
        private String applicationID;
        private String targetID;
        private boolean isOpt;
        private String pumpIDs;
        private boolean discountCardAccepted;
        private String clientID;
        private String clientSecret;
        private String clientID2;
        private String clientSecret2;
        private String clientUsername;
        private String url;
        private String url2;

        public Builder(){
        }

        Builder(String tid, String mid, String softwareVersion, AddressLocation addressLocation){
            this.tid = tid;
            this.mid = mid;
            this.softwareVersion = softwareVersion;
            this.addressLocation = addressLocation;
        }

        Builder(String tid, String mid, String softwareVersion, AddressLocation addressLocation, String locationID, String extTerminalID, String applicationID, String targetID){
            this.tid = tid;
            this.mid = mid;
            this.softwareVersion = softwareVersion;
            this.addressLocation = addressLocation;
            this.locationID = locationID;
            this.extTerminalID = extTerminalID;
            this.applicationID = applicationID;
            this.targetID = targetID;
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

        public Builder locationID(String locationID){
            this.locationID = locationID;
            return Builder.this;
        }

        public Builder extTerminalID(String extTerminalID){
            this.extTerminalID = extTerminalID;
            return Builder.this;
        }

        public Builder applicationID(String applicationID){
            this.applicationID = applicationID;
            return Builder.this;
        }

        public Builder targetID(String targetID){
            this.targetID = targetID;
            return Builder.this;
        }

        public Builder isOpt(boolean isOpt){
            this.isOpt = isOpt;
            return Builder.this;
        }

        public Builder pumpIDs(String pumpIDs){
            this.pumpIDs = pumpIDs;
            return Builder.this;
        }

        public Builder discountCardAccepted(boolean discountCardAccepted){
            this.discountCardAccepted = discountCardAccepted;
            return Builder.this;
        }

        public Builder clientID(String clientID) {
            this.clientID = clientID;
            return Builder.this;
        }

        public Builder clientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return Builder.this;
        }

        public Builder clientID2(String clientID2) {
            this.clientID2 = clientID2;
            return Builder.this;
        }

        public Builder clientSecret2(String clientSecret2) {
            this.clientSecret2 = clientSecret2;
            return Builder.this;
        }

        public Builder clientUsername(String clientUsername) {
            this.clientUsername = clientUsername;
            return Builder.this;
        }

        public Builder url(String url) {
            this.url = url;
            return Builder.this;
        }

        public Builder url2(String url2) {
            this.url2 = url2;
            return Builder.this;
        }

        public POIInformation build(){
            if (this.tid == null|| this.tid.isEmpty()) {
                throw new NullPointerException("The property \"tid\" is null or empty. "
                        + "Please set the value by \"tid()\". "
                        + "The properties \"tid\", is required.");
            }
            return new POIInformation(this);
        }
    }
}
