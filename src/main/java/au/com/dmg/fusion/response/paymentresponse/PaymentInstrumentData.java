/*
 * Copyright (c) 2021. DatameshGroup
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package au.com.dmg.fusion.response.paymentresponse;

import com.squareup.moshi.Json;
import org.jetbrains.annotations.Nullable;

public class PaymentInstrumentData {

    @Json(name = "PaymentInstrumentType")
    private final String paymentInstrumentType;
    @Json(name = "CardData")
    private final PaymentResponseCardData cardData;
    @Json(name = "LoyaltyData")
    @Nullable
    private final LoyaltyData loyaltyData;

    public String getPaymentInstrumentType() {
        return paymentInstrumentType;
    }

    public PaymentResponseCardData getCardData() {
        return cardData;
    }

    @Nullable
    public LoyaltyData getLoyaltyData() {
        return loyaltyData;
    }

    public static class Builder {

        private String paymentInstrumentType;
        private PaymentResponseCardData cardData;
        private LoyaltyData loyaltyData;

        public Builder() {
        }

        Builder(String paymentInstrumentType, PaymentResponseCardData cardData, LoyaltyData loyaltyData) {
            this.paymentInstrumentType = paymentInstrumentType;
            this.cardData = cardData;
            this.loyaltyData = loyaltyData;
        }

        public Builder paymentInstrumentType(String paymentInstrumentType) {
            this.paymentInstrumentType = paymentInstrumentType;
            return Builder.this;
        }

        public Builder cardData(PaymentResponseCardData cardData) {
            this.cardData = cardData;
            return Builder.this;
        }

        public Builder loyaltyData(LoyaltyData loyaltyData){
            this.loyaltyData = loyaltyData;
            return Builder.this;
        }

        public PaymentInstrumentData build() {
            return new PaymentInstrumentData(this);
        }
    }

    private PaymentInstrumentData(Builder builder) {
        this.paymentInstrumentType = builder.paymentInstrumentType;
        this.cardData = builder.cardData;
        this.loyaltyData = builder.loyaltyData;
    }
}

/*
package au.com.dmg.fusionsatellite.PaymentRequest
class PaymentInstrumentData
String paymentInstrumentType
CardData cardData
LoyaltyData loyaltyData
* */
