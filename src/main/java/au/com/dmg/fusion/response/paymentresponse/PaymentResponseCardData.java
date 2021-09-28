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

import au.com.dmg.fusion.data.EntryMode;
import au.com.dmg.fusion.data.PaymentBrand;
import au.com.dmg.fusion.request.paymentrequest.carddata.PaymentToken;
import com.squareup.moshi.Json;

public class PaymentResponseCardData {

    @Json(name = "EntryMode")
    private EntryMode entryMode;
    @Json(name = "PaymentBrand")
    private PaymentBrand paymentBrand;
    @Json(name = "MaskedPAN")
    private String maskedPAN;
    @Json(name = "Account")
    private String account;
    @Json(name = "PaymentToken")
    private PaymentToken paymentToken;

    public EntryMode getEntryMode() {
        return entryMode;
    }

    public PaymentBrand getPaymentBrand() {
        return paymentBrand;
    }

    public String getMaskedPAN() {
        return maskedPAN;
    }

    public String getAccount() {
        return account;
    }

    public PaymentToken getPaymentToken() {
        return paymentToken;
    }

    public static class Builder {

        private EntryMode entryMode;
        private PaymentBrand paymentBrand;
        private String maskedPAN;
        private String account;
        private PaymentToken paymentToken;

        public Builder() {
        }

        Builder(EntryMode entryMode, PaymentBrand paymentBrand, String maskedPAN, String account, PaymentToken paymentToken) {
            this.entryMode = entryMode;
            this.paymentBrand = paymentBrand;
            this.maskedPAN = maskedPAN;
            this.account = account;
            this.paymentToken = paymentToken;
        }

        public Builder entryMode(EntryMode entryMode){
            this.entryMode = entryMode;
            return Builder.this;
        }

        public Builder paymentBrand(PaymentBrand paymentBrand){
            this.paymentBrand = paymentBrand;
            return Builder.this;
        }

        public Builder maskedPAN(String maskedPAN){
            this.maskedPAN = maskedPAN;
            return Builder.this;
        }

        public Builder account(String account){
            this.account = account;
            return Builder.this;
        }

        public Builder paymentToken(PaymentToken paymentToken){
            this.paymentToken = paymentToken;
            return Builder.this;
        }

        public PaymentResponseCardData build() {
            if(this.entryMode == null){
                throw new NullPointerException("The property \"entryMode\" is null. "
                        + "Please set the value by \"entryMode()\". "
                        + "The properties \"entryMode\", \"paymentBrand\" and \"maskedPAN\" are required.");
            }
            if(this.paymentBrand == null){
                throw new NullPointerException("The property \"paymentBrand\" is null. "
                        + "Please set the value by \"paymentBrand()\". "
                        + "The properties \"entryMode\", \"paymentBrand\" and \"maskedPAN\" are required.");
            }
            if(this.maskedPAN == null){
                throw new NullPointerException("The property \"maskedPAN\" is null. "
                        + "Please set the value by \"maskedPAN()\". "
                        + "The properties \"entryMode\", \"paymentBrand\" and \"maskedPAN\" are required.");
            }

            return new PaymentResponseCardData(this);
        }
    }

    private PaymentResponseCardData(Builder builder) {
        this.entryMode = builder.entryMode;
        this.paymentBrand = builder.paymentBrand;
        this.maskedPAN = builder.maskedPAN;
        this.account = builder.account;
        this.paymentToken = builder.paymentToken;
    }
}


/*
package au.com.dmg.fusionsatellite.response.paymentresponse
class CardData
@Required EntryMode entryMode
@Required PaymentBrand paymentBrand
@Required String maskedPAN
String account
PaymentToken paymentToken
* */
