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

package au.com.dmg.fusion.request.paymentrequest.carddata;

import au.com.dmg.fusion.data.EntryMode;
import au.com.dmg.fusion.request.paymentrequest.PaymentRequest;

import com.squareup.moshi.Json;

public class CardData {

    private final EntryMode entryMode;
    private final ProtectedCardData protectedCardData;
    private final PaymentToken paymentToken;

    public static class Builder {

        @Json(name = "EntryMode")
        private EntryMode entryMode;
        @Json(name = "ProtectedCardData")
        private ProtectedCardData protectedCardData;
        @Json(name = "PaymentToken")
        private PaymentToken paymentToken;

        public EntryMode getEntryMode() {
            return entryMode;
        }

        public ProtectedCardData getProtectedCardData() {
            return protectedCardData;
        }

        public PaymentToken getPaymentToken() { return paymentToken; }

        public Builder() {
        }

        Builder(EntryMode entryMode, ProtectedCardData protectedCardData, PaymentToken paymentToken) {
            this.entryMode = entryMode;
            this.protectedCardData = protectedCardData;
            this.paymentToken = paymentToken;
        }

        Builder(EntryMode entryMode, ProtectedCardData protectedCardData) {
            this.entryMode = entryMode;
            this.protectedCardData = protectedCardData;
        }

        public Builder entryMode(EntryMode entryMode) {
            this.entryMode = entryMode;
            return Builder.this;
        }

        public Builder protectedCardData(ProtectedCardData protectedCardData) {
            this.protectedCardData = protectedCardData;
            return Builder.this;
        }

        public Builder paymentToken(PaymentToken paymentToken) {
            this.paymentToken = paymentToken;
            return Builder.this;
        }

        public CardData build() {

            return new CardData(this);
        }
    }

    private CardData(Builder builder) {
        this.entryMode = builder.entryMode;
        this.protectedCardData = builder.protectedCardData;
        this.paymentToken = builder.paymentToken;
    }
}

/*
package au.com.dmg.fusionsatellite.PaymentRequest
class CardData
EntryMode entryMode
ProtectedCardData protectedCardData
PaymentToken paymentToken
* */