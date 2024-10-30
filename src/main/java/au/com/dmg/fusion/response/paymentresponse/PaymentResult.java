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

import au.com.dmg.fusion.data.PaymentType;
import com.squareup.moshi.Json;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;

public class PaymentResult {

    @Json(name = "PaymentType")
    private final PaymentType paymentType;
    @Json(name = "PaymentInstrumentData")
    private final PaymentInstrumentData paymentInstrumentData;
    @Json(name = "AmountsResp")
    private final AmountsResp amountsResp;
    @Json(name = "OnlineFlag")
    private final Boolean onlineFlag;
    @Json(name = "PaymentAcquirerData")
    private final PaymentAcquirerData paymentAcquirerData;
    @Json(name = "SplitPaymentFlag")
    private final Boolean splitPaymentFlag;
    @Json(name = "Currency")
    private final String currency;
    @Json(name = "CurrentBalance")
    private final BigDecimal currentBalance;
    @Json(name = "RRN")
    private final String rrn;

    @Nullable
    public PaymentType getPaymentType() {
        return paymentType;
    }

    @Nullable
    public PaymentInstrumentData getPaymentInstrumentData() {
        return paymentInstrumentData;
    }

    @Nullable
    public AmountsResp getAmountsResp() {
        return amountsResp;
    }

    @Nullable
    public Boolean getOnlineFlag() {
        return onlineFlag;
    }

    @Nullable
    public PaymentAcquirerData getPaymentAcquirerData() {
        return paymentAcquirerData;
    }

    @Nullable
    public Boolean getSplitPaymentFlag(){ return splitPaymentFlag; }

    @Nullable
    public String getCurrency(){ return currency; }

    @Nullable
    public BigDecimal getCurrentBalance() { return currentBalance; }

    @Nullable
    public String getRrn() { return rrn; }

    public static class Builder {

        private PaymentType paymentType;
        private PaymentInstrumentData paymentInstrumentData;
        private AmountsResp amountsResp;
        private Boolean onlineFlag;
        private PaymentAcquirerData paymentAcquirerData;
        private Boolean splitPaymentFlag = false;
        private String currency = null;
        private BigDecimal currentBalance = null;
        private String rrn = null;

        public Builder() {
        }

        Builder(PaymentType paymentType, PaymentInstrumentData paymentInstrumentData, AmountsResp amountsResp, Boolean onlineFlag, PaymentAcquirerData paymentAcquirerData) {
            this.paymentType = paymentType;
            this.paymentInstrumentData = paymentInstrumentData;
            this.amountsResp = amountsResp;
            this.onlineFlag = onlineFlag;
            this.paymentAcquirerData = paymentAcquirerData;
        }

        Builder(PaymentType paymentType, PaymentInstrumentData paymentInstrumentData, AmountsResp amountsResp, Boolean onlineFlag, PaymentAcquirerData paymentAcquirerData, String rrn) {
            this.paymentType = paymentType;
            this.paymentInstrumentData = paymentInstrumentData;
            this.amountsResp = amountsResp;
            this.onlineFlag = onlineFlag;
            this.paymentAcquirerData = paymentAcquirerData;
            this.rrn = rrn;
        }

        Builder(PaymentType paymentType, PaymentInstrumentData paymentInstrumentData, AmountsResp amountsResp, Boolean onlineFlag, PaymentAcquirerData paymentAcquirerData, Boolean splitPaymentFlag) {
            this.paymentType = paymentType;
            this.paymentInstrumentData = paymentInstrumentData;
            this.amountsResp = amountsResp;
            this.onlineFlag = onlineFlag;
            this.paymentAcquirerData = paymentAcquirerData;
            this.splitPaymentFlag = splitPaymentFlag;
        }

        Builder(PaymentType paymentType, PaymentInstrumentData paymentInstrumentData, AmountsResp amountsResp, Boolean onlineFlag, PaymentAcquirerData paymentAcquirerData, Boolean splitPaymentFlag, String rrn) {
            this.paymentType = paymentType;
            this.paymentInstrumentData = paymentInstrumentData;
            this.amountsResp = amountsResp;
            this.onlineFlag = onlineFlag;
            this.paymentAcquirerData = paymentAcquirerData;
            this.splitPaymentFlag = splitPaymentFlag;
            this.rrn = rrn;
        }

        Builder(PaymentType paymentType, PaymentInstrumentData paymentInstrumentData, AmountsResp amountsResp, Boolean onlineFlag, PaymentAcquirerData paymentAcquirerData, String currency, BigDecimal currentBalance) {
            this.paymentType = paymentType;
            this.paymentInstrumentData = paymentInstrumentData;
            this.amountsResp = amountsResp;
            this.onlineFlag = onlineFlag;
            this.paymentAcquirerData = paymentAcquirerData;
            this.currency = currency;
            this.currentBalance = currentBalance;
        }

        Builder(PaymentType paymentType, PaymentInstrumentData paymentInstrumentData, AmountsResp amountsResp, Boolean onlineFlag, PaymentAcquirerData paymentAcquirerData, String currency, BigDecimal currentBalance, String rrn) {
            this.paymentType = paymentType;
            this.paymentInstrumentData = paymentInstrumentData;
            this.amountsResp = amountsResp;
            this.onlineFlag = onlineFlag;
            this.paymentAcquirerData = paymentAcquirerData;
            this.currency = currency;
            this.currentBalance = currentBalance;
            this.rrn = rrn;
        }

        Builder(PaymentType paymentType, PaymentInstrumentData paymentInstrumentData, AmountsResp amountsResp, Boolean onlineFlag, PaymentAcquirerData paymentAcquirerData, Boolean splitPaymentFlag, String currency, BigDecimal currentBalance) {
            this.paymentType = paymentType;
            this.paymentInstrumentData = paymentInstrumentData;
            this.amountsResp = amountsResp;
            this.onlineFlag = onlineFlag;
            this.paymentAcquirerData = paymentAcquirerData;
            this.splitPaymentFlag = splitPaymentFlag;
            this.currency = currency;
            this.currentBalance = currentBalance;
        }

        Builder(PaymentType paymentType, PaymentInstrumentData paymentInstrumentData, AmountsResp amountsResp, Boolean onlineFlag, PaymentAcquirerData paymentAcquirerData, Boolean splitPaymentFlag, String currency, BigDecimal currentBalance, String rrn) {
            this.paymentType = paymentType;
            this.paymentInstrumentData = paymentInstrumentData;
            this.amountsResp = amountsResp;
            this.onlineFlag = onlineFlag;
            this.paymentAcquirerData = paymentAcquirerData;
            this.splitPaymentFlag = splitPaymentFlag;
            this.currency = currency;
            this.currentBalance = currentBalance;
            this.rrn = rrn;
        }

        public Builder paymentType(PaymentType paymentType) {
            this.paymentType = paymentType;
            return Builder.this;
        }

        public Builder paymentInstrumentData(PaymentInstrumentData paymentInstrumentData) {
            this.paymentInstrumentData = paymentInstrumentData;
            return Builder.this;
        }

        public Builder amountsResp(AmountsResp amountsResp) {
            this.amountsResp = amountsResp;
            return Builder.this;
        }

        public Builder onlineFlag(Boolean onlineFlag) {
            this.onlineFlag = onlineFlag;
            return Builder.this;
        }

        public Builder paymentAcquirerData(PaymentAcquirerData paymentAcquirerData) {
            this.paymentAcquirerData = paymentAcquirerData;
            return Builder.this;
        }

        public Builder splitPaymentFlag(Boolean splitPaymentFlag) {
            this.splitPaymentFlag = splitPaymentFlag;
            return Builder.this;
        }

        public Builder currency(String currency){
            this.currency = currency;
            return Builder.this;
        }

        public Builder currentBalance(BigDecimal currentBalance){
            this.currentBalance = currentBalance;
            return Builder.this;
        }

        public Builder rrn(String rrn){
            this.rrn = rrn;
            return Builder.this;
        }

        public PaymentResult build() {
            if (this.onlineFlag == null) {
                throw new NullPointerException("The property \"onlineFlag\" is null. "
                        + "Please set the value by \"onlineFlag()\". "
                        + "The property \"onlineFlag\" is required.");
            }

            return new PaymentResult(this);
        }
    }

    private PaymentResult(Builder builder) {
        this.paymentType = builder.paymentType;
        this.paymentInstrumentData = builder.paymentInstrumentData;
        this.amountsResp = builder.amountsResp;
        this.onlineFlag = builder.onlineFlag;
        this.paymentAcquirerData = builder.paymentAcquirerData;
        this.splitPaymentFlag = builder.splitPaymentFlag;
        this.currency = builder.currency;
        this.currentBalance = builder.currentBalance;
        this.rrn = builder.rrn;
    }
}


/*
package au.com.dmg.fusionsatellite.response
class PaymentResult
PaymentType paymentType
PaymentInstrumentData paymentInstrumentData
AmountsResp amountsResp
@Required Boolean onlineFlag
PaymentAcquirerData paymentAcquirerData
String currency
BigDecimal currentBalance
String rrn
* */