package au.com.dmg.fusion.request.paymentrequest;

import com.squareup.moshi.Json;
import org.jetbrains.annotations.NotNull;

public class SponsoredMerchant {
    @Json(name = "SiteID")
    private final String siteID;
    @Json(name = "BusinessID")
    private final String businessID;
    @Json(name = "RegisteredIdentifier")
    private final String registeredIdentifier;

    @NotNull
    public String getSiteID() {
        return siteID;
    }
    @NotNull
    public String getBusinessID() {
        return businessID;
    }
    @NotNull
    public String getRegisteredIdentifier() {
        return registeredIdentifier;
    }

    public static class Builder {
        private String siteID;
        private String businessID;
        private String registeredIdentifier;

        public Builder() {
        }

        Builder(String siteID, String businessID, String registeredIdentifier) {
            this.siteID = siteID;
            this.businessID = businessID;
            this.registeredIdentifier = registeredIdentifier;
        }

        public SponsoredMerchant.Builder siteID(String siteID) {
            this.siteID = siteID;
            return SponsoredMerchant.Builder.this;
        }

        public SponsoredMerchant.Builder businessID(String businessID) {
            this.businessID = businessID;
            return SponsoredMerchant.Builder.this;
        }

        public SponsoredMerchant.Builder registeredIdentifier(String registeredIdentifier) {
            this.registeredIdentifier = registeredIdentifier;
            return SponsoredMerchant.Builder.this;
        }
        public SponsoredMerchant build() {
            if (this.siteID == null) {
                throw new NullPointerException("The property \"siteID\" is null. "
                        + "Please set the value by \"siteID()\". "
                        + "The properties \"siteID\", \"businessID\", and \"registeredIdentifier\" are required.");
            }
            if (this.businessID == null) {
                throw new NullPointerException("The property \"businessID\" is null. "
                        + "Please set the value by \"businessID()\". "
                        + "The properties \"siteID\", \"businessID\", and \"registeredIdentifier\" are required.");
            }
            if (this.registeredIdentifier == null) {
                throw new NullPointerException("The property \"registeredIdentifier\" is null. "
                        + "Please set the value by \"registeredIdentifier()\". "
                        + "The properties \"siteID\", \"businessID\", and \"registeredIdentifier\" are required.");
            }
            return new SponsoredMerchant(this);
        }
    }

    public SponsoredMerchant(String siteID, String businessID, String registeredIdentifier) {
        this.siteID = siteID;
        this.businessID = businessID;
        this.registeredIdentifier = registeredIdentifier;
    }

    private SponsoredMerchant(Builder builder) {
        this.siteID = builder.siteID;
        this.businessID = builder.businessID;
        this.registeredIdentifier = builder.registeredIdentifier;
    }
}
