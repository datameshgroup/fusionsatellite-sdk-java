package au.com.dmg.fusion.response.paymentresponse;

import com.squareup.moshi.Json;

public class PaymentResponseExtensionData {

    @Json(name = "TransitData")
    private final PaymentResponseTransitData transitData;

    public PaymentResponseTransitData getTransitData() {
        return transitData;
    }

    public static class Builder {
        private PaymentResponseTransitData transitData;

        public Builder() {
        }

        Builder(PaymentResponseTransitData transitData) {
            this.transitData = transitData;
        }

        public Builder transitData(PaymentResponseTransitData transitData) {
            this.transitData = transitData;
            return Builder.this;
        }

        public PaymentResponseExtensionData build() {
            return new PaymentResponseExtensionData(this);
        }
    }

    private PaymentResponseExtensionData(Builder builder) {
        this.transitData = builder.transitData;
    }
}
