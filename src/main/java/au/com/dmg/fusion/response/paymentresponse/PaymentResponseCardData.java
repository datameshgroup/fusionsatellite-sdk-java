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
    @Json(name = "PaymentBrandId")
    private String paymentBrandId;
    @Json(name = "PaymentBrandLabel")
    private String paymentBrandLabel;
    @Json(name = "CardCountryCode")
    private String cardCountryCode;
    @Json(name = "MaskedPAN")
    private String maskedPAN;
    @Json(name = "Account")
    private String account;
    @Json(name = "PaymentToken")
    private PaymentToken paymentToken;
    @Json(name = "Expiry")
    private String expiry;

    public EntryMode getEntryMode() {
        return entryMode;
    }

    public PaymentBrand getPaymentBrand() {
        return paymentBrand;
    }

    public String getPaymentBrandId() {
        return paymentBrandId;
    }

    public String getPaymentBrandLabel() {
        return paymentBrandLabel;
    }
    public String getCardCountryCode(){ return cardCountryCode; }

    public String getMaskedPAN() {
        return maskedPAN;
    }

    public String getAccount() {
        return account;
    }

    public PaymentToken getPaymentToken() {
        return paymentToken;
    }

    public String getExpiry(){ return expiry; }

    public static class Builder {

        private EntryMode entryMode;
        private PaymentBrand paymentBrand;
        private String paymentBrandId;
        private String paymentBrandLabel;
        private String cardCountryCode;
        private String maskedPAN;
        private String account;
        private PaymentToken paymentToken;
        private String expiry;

        public Builder() {
        }

        Builder(EntryMode entryMode, PaymentBrand paymentBrand, String paymentBrandId, String paymentBrandLabel, String cardCountryCode, String maskedPAN, String account, PaymentToken paymentToken, String expiry) {
            this.entryMode = entryMode;
            this.paymentBrand = paymentBrand;
            this.paymentBrandId = paymentBrandId;
            this.paymentBrandLabel = paymentBrandLabel;
            this.cardCountryCode = cardCountryCode;
            this.maskedPAN = maskedPAN;
            this.account = account;
            this.paymentToken = paymentToken;
            this.expiry = expiry;
        }

        public Builder mapPaymentClassification(PaymentClassification paymentClassification){
            if(this.entryMode==null){
                this.entryMode = PaymentClassification.mapEntryMode(paymentClassification.method);
            }

            if(this.paymentBrand==null){
                this.paymentBrand = PaymentClassification.mapPaymentBrand(paymentClassification.productName);
            }

            this.paymentBrandId = paymentClassification.productId;

            if(paymentClassification.productLabel==null){
                this.paymentBrandLabel = paymentClassification.productName;
            }else{
                this.paymentBrandLabel = paymentClassification.productLabel;
            }

            if(this.account==null && !(paymentClassification.account==null)){
                this.account = paymentClassification.account;
            }

            this.cardCountryCode = paymentClassification.countryCode;


            return Builder.this;
        }

        public Builder entryMode(EntryMode entryMode){
            this.entryMode = entryMode;
            return Builder.this;
        }

        public Builder paymentBrand(PaymentBrand paymentBrand){
            this.paymentBrand = paymentBrand;
            return Builder.this;
        }

        public Builder paymentBrandId(String paymentBrandId){
            this.paymentBrandId = paymentBrandId;
            return Builder.this;
        }

        public Builder paymentBrandLabel(String paymentBrandLabel){
            this.paymentBrandLabel = paymentBrandLabel;
            return Builder.this;
        }

        public Builder cardCountryCode(String cardCountryCode){
            this.cardCountryCode = cardCountryCode;
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

        public Builder expiry(String expiry){
            this.expiry = expiry;
            return Builder.this;
        }

        public PaymentResponseCardData build() {
            if(this.maskedPAN == null){
                throw new NullPointerException("The property \"maskedPAN\" is null. "
                        + "Please set the value by \"maskedPAN()\". "
                        + "The property \"maskedPAN\" is required.");
            }

            return new PaymentResponseCardData(this);
        }
    }

    private PaymentResponseCardData(Builder builder) {
        this.entryMode = builder.entryMode;
        this.paymentBrand = builder.paymentBrand;
        this.paymentBrandId = builder.paymentBrandId;
        this.paymentBrandLabel = builder.paymentBrandLabel;
        this.cardCountryCode = builder.cardCountryCode;
        this.maskedPAN = builder.maskedPAN;
        this.account = builder.account;
        this.paymentToken = builder.paymentToken;
        this.expiry = builder.expiry;
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

PaymentClassification Pairing
EntryMode <-> Method
Account <-> Account
CountryCode <-> cardCountryCode
PaymentBrandId <-> ProductID
PaymentBrandName <-> ProductName
PaymentBrandLabel <-> ProductLabel
* */
