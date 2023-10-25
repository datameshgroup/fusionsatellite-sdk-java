package au.com.dmg.fusion.response.paymentresponse;

import au.com.dmg.fusion.data.EntryMode;
import au.com.dmg.fusion.data.PaymentBrand;
import com.squareup.moshi.Json;

public class PaymentClassification {
    @Json(name = "ProductId")
    String productId;
    @Json(name = "ProductName")
    String productName;
    @Json(name = "ProductLabel")
    String productLabel;
    @Json(name = "Method")
    String method;
    @Json(name = "Account")
    String account;
    @Json(name = "CountryCode")
    String countryCode;



    static PaymentBrand mapPaymentBrand(String productName) {
       for (final PaymentBrand value : PaymentBrand.values()) {
            if (value.toString().equals(productName.replaceAll("\\s", ""))) {
                return value;
            }
        }
        return PaymentBrand.Other;
    }
    static EntryMode mapEntryMode(String method) {
        switch (method){
            case "Swipe":
                return EntryMode.MagStripe;
            case "Insert":
                return EntryMode.ICC;
            case "Tap":
                return  EntryMode.Tapped;
            case "Manual Entry":
                return EntryMode.Manual;
            //TODO: Confirm this
            case "MOTO":
            case "Online":
                return EntryMode.File;
            case "Scanned":
                return EntryMode.Scanned;
            case "Cash":
            default:
                return EntryMode.Unknown;
        }
    }

    public static class Builder {
        String productId;
        String productName;
        String productLabel;
        String method;
        String account;
        String countryCode;

        public Builder(){}

        Builder(String productId, String productName, String productLabel, String method, String account, String countryCode) {
            this.productId = productId;
            this.productName = productName;
            this.productLabel = productLabel;
            this.method = method;
            this.account = account;
            this.countryCode = countryCode;
        }

        public Builder productId(String productId) {
            this.productId = productId;
            return Builder.this;
        }

        public Builder productName(String productName) {
            this.productName = productName;
            return Builder.this;
        }

        public Builder productLabel(String productLabel) {
            this.productLabel = productLabel;
            return Builder.this;
        }

        public Builder method(String method) {
            this.method = method;
            return Builder.this;
        }

        public Builder account(String account) {
            this.account = account;
            return Builder.this;
        }

        public Builder countryCode(String countryCode) {
            this.countryCode = countryCode;
            return Builder.this;
        }

        public PaymentClassification build() {
            if (this.productId == null || this.productId.isEmpty()) {
                throw new NullPointerException("The property \"productId\" is null or empty. "
                        + "Please set the value by \"productId()\". "
                        + "The properties \"productId\", \"productName\" and \"method\" are required.");
            }
            if (this.productName == null || this.productName.isEmpty()) {
                throw new NullPointerException("The property \"timestamp\" is null or empty. "
                        + "Please set the value by \"productName()\". "
                        + "The properties \"productId\", \"productName\" and \"method\" are required.");
            }

            if (this.method == null || this.method.isEmpty()) {
                throw new NullPointerException("The property \"method\" is null or empty. "
                        + "Please set the value by \"method()\". "
                        + "The properties \"productId\", \"productName\" and \"method\" are required.");
            }
            return new PaymentClassification(this);
        }
    }
    private PaymentClassification(Builder builder) {
        this.productId = builder.productId;
        this.productName = builder.productName;
        this.productLabel = builder.productLabel;
        this.method = builder.method;
        this.account = builder.account;
        this.countryCode = builder.countryCode;
    }
}
