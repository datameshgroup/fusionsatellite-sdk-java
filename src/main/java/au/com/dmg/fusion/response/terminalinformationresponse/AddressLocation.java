package au.com.dmg.fusion.response.terminalinformationresponse;

import com.squareup.moshi.Json;

public class AddressLocation {
    @Json(name = "Address1")
    private final String address1;
    @Json(name = "Address2")
    private final String address2;
    @Json(name = "AddressState")
    private final String addressState;
    @Json(name = "Location")
    private final String location;

    public AddressLocation(Builder builder) {
        this.address1 = builder.address1;
        this.address2 = builder.address2;
        this.addressState = builder.addressState;
        this.location = builder.location;
    }

    public String getAddress1(){
        return address1;
    }
    public String getAddress2() {
        return address2;
    }
    public String getAddressState() {
        return addressState;
    }
    public String getLocation() {
        return location;
    }

    public static class Builder {
        private String address1;
        private String address2;
        private String addressState;
        private String location;

        public Builder(){
        }

        Builder(String address1, String address2, String addressState, String location){
            this.address1 = address1;
            this.address2 = address2;
            this.addressState = addressState;
            this.location = location;
        }
        public Builder address1(String address1){
            this.address1 = address1;
            return Builder.this;
        }
        public Builder address2(String address2){
            this.address2 = address2;
            return Builder.this;
        }
        public Builder addressState(String addressState){
            this.addressState = addressState;
            return Builder.this;
        }
        public Builder location(String location){
            this.location = location;
            return Builder.this;
        }
        public AddressLocation build() {
            return new AddressLocation(this);
        }
    }
}
