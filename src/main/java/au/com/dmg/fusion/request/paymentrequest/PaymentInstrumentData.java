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

package au.com.dmg.fusion.request.paymentrequest;

import com.squareup.moshi.Json;

import au.com.dmg.fusion.data.PaymentInstrumentType;
import au.com.dmg.fusion.request.paymentrequest.carddata.CardData;

public class PaymentInstrumentData {

    @Json(name = "PaymentInstrumentType")
    private final PaymentInstrumentType paymentInstrumentType;
    @Json(name = "CardData")
    private final CardData cardData;

    public PaymentInstrumentType getPaymentInstrumentType() {
        return paymentInstrumentType;
    }

    public CardData getCardData() {
        return cardData;
    }

    public static class Builder {

        private PaymentInstrumentType paymentInstrumentType;
        private CardData cardData;

        public Builder() {
        }

        Builder(PaymentInstrumentType paymentInstrumentType, CardData cardData) {
            this.paymentInstrumentType = paymentInstrumentType;
            this.cardData = cardData;
        }

        public Builder paymentInstrumentType(PaymentInstrumentType paymentInstrumentType) {
            this.paymentInstrumentType = paymentInstrumentType;
            return Builder.this;
        }

        public Builder cardData(CardData cardData) {
            this.cardData = cardData;
            return Builder.this;
        }

        public PaymentInstrumentData build() {

            return new PaymentInstrumentData(this);
        }
    }

    private PaymentInstrumentData(Builder builder) {
        this.paymentInstrumentType = builder.paymentInstrumentType;
        this.cardData = builder.cardData;
    }
}

/*
package au.com.dmg.fusionsatellite.PaymentRequest
class PaymentInstrumentData
String paymentInstrumentType
CardData cardData
* */