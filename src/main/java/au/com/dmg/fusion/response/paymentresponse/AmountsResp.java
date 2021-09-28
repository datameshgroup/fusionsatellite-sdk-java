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

import java.math.BigDecimal;

public class AmountsResp {

    @Json(name = "Currency")
    private String currency;
    @Json(name = "AuthorizedAmount")
    private BigDecimal authorizedAmount;
    @Json(name = "TotalFeesAmount")
    private BigDecimal totalFeesAmount;
    @Json(name = "CashBackAmount")
    private BigDecimal cashBackAmount;
    @Json(name = "TipAmount")
    private BigDecimal tipAmount;
    @Json(name = "SurchargeAmount")
    private BigDecimal surchargeAmount;

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getAuthorizedAmount() {
        return authorizedAmount;
    }

    public BigDecimal getTotalFeesAmount() {
        return totalFeesAmount;
    }

    public BigDecimal getCashBackAmount() {
        return cashBackAmount;
    }

    public BigDecimal getTipAmount() {
        return tipAmount;
    }

    public BigDecimal getSurchargeAmount() {
        return surchargeAmount;
    }

    public static class Builder {

        private String currency;
        private BigDecimal authorizedAmount;
        private BigDecimal totalFeesAmount;
        private BigDecimal cashBackAmount;
        private BigDecimal tipAmount;
        private BigDecimal surchargeAmount;

        public Builder() {
        }

        Builder(String currency, BigDecimal authorizedAmount, BigDecimal totalFeesAmount, BigDecimal cashBackAmount, BigDecimal tipAmount, BigDecimal surchargeAmount) {
            this.currency = currency;
            this.authorizedAmount = authorizedAmount;
            this.totalFeesAmount = totalFeesAmount;
            this.cashBackAmount = cashBackAmount;
            this.tipAmount = tipAmount;
            this.surchargeAmount = surchargeAmount;
        }

        public Builder currency(String currency){
            this.currency = currency;
            return Builder.this;
        }

        public Builder authorizedAmount(BigDecimal authorizedAmount){
            this.authorizedAmount = authorizedAmount;
            return Builder.this;
        }

        public Builder totalFeesAmount(BigDecimal totalFeesAmount){
            this.totalFeesAmount = totalFeesAmount;
            return Builder.this;
        }

        public Builder cashBackAmount(BigDecimal cashBackAmount){
            this.cashBackAmount = cashBackAmount;
            return Builder.this;
        }

        public Builder tipAmount(BigDecimal tipAmount){
            this.tipAmount = tipAmount;
            return Builder.this;
        }

        public Builder surchargeAmount(BigDecimal surchargeAmount){
            this.surchargeAmount = surchargeAmount;
            return Builder.this;
        }

        public AmountsResp build() {
            if(this.authorizedAmount == null){
                throw new NullPointerException("The property \"authorizedAmount\" is null. "
                        + "Please set the value by \"authorizedAmount()\". "
                        + "The property \"authorizedAmount\" is required.");
            }

            return new AmountsResp(this);
        }
    }

    private AmountsResp(Builder builder) {
        this.currency = builder.currency;
        this.authorizedAmount = builder.authorizedAmount;
        this.totalFeesAmount = builder.totalFeesAmount;
        this.cashBackAmount = builder.cashBackAmount;
        this.tipAmount = builder.tipAmount;
        this.surchargeAmount = builder.surchargeAmount;
    }

    public void doSomething() {
        // do something
    }
}

/*
package au.com.dmg.fusionsatellite.response
class AmountsResp
String currency
@Required BigDecimal authorizedAmount
BigDecimal totalFeesAmount
BigDecimal cashBackAmount
BigDecimal tipAmount
BigDecimal surchargeAmount
* */