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
import java.util.Collections;
import java.util.List;

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
    @Json(name = "PartialAuthorizedAmount")
    private BigDecimal partialAuthorizedAmount;
    @Json(name = "RequestedAmount")
    private BigDecimal requestedAmount;
    @Json(name = "AdditionalAmounts")
    private List<AdditionalAmount> additionalAmounts;

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

    public BigDecimal getPartialAuthorizedAmount(){
        return partialAuthorizedAmount;
    }

    public BigDecimal getRequestedAmount(){
        return requestedAmount;
    }

    public List<AdditionalAmount> getAdditionalAmounts() { return additionalAmounts; }

    public BigDecimal getTotalAdditionalAmount(){
        BigDecimal total = null;
        for(AdditionalAmount additionalAmount: additionalAmounts){
            total = total.add(additionalAmount.getValue());
        }
        return null;
    }

    public static class Builder {
        private String currency;
        private BigDecimal authorizedAmount;
        private BigDecimal totalFeesAmount;
        private BigDecimal cashBackAmount;
        private BigDecimal tipAmount;
        private BigDecimal surchargeAmount;
        private BigDecimal partialAuthorizedAmount;
        private BigDecimal requestedAmount;
        private List<AdditionalAmount> additionalAmounts;

        public Builder() {
        }

        Builder(String currency, BigDecimal authorizedAmount, BigDecimal totalFeesAmount, BigDecimal cashBackAmount, BigDecimal tipAmount, BigDecimal surchargeAmount, BigDecimal requestedAmount, List<AdditionalAmount> additionalAmounts) {
            this.currency = currency;
            this.authorizedAmount = authorizedAmount;
            this.totalFeesAmount = totalFeesAmount;
            this.cashBackAmount = cashBackAmount;
            this.tipAmount = tipAmount;
            this.surchargeAmount = surchargeAmount;
            this.requestedAmount = requestedAmount;
            this.additionalAmounts = additionalAmounts;
        }

        Builder(String currency, BigDecimal authorizedAmount, BigDecimal totalFeesAmount, BigDecimal cashBackAmount, BigDecimal tipAmount, BigDecimal surchargeAmount, BigDecimal requestedAmount, BigDecimal partialAuthorizedAmount, List<AdditionalAmount> additionalAmounts) {
            this.currency = currency;
            this.authorizedAmount = authorizedAmount;
            this.totalFeesAmount = totalFeesAmount;
            this.cashBackAmount = cashBackAmount;
            this.tipAmount = tipAmount;
            this.surchargeAmount = surchargeAmount;
            this.partialAuthorizedAmount = partialAuthorizedAmount;
            this.requestedAmount = requestedAmount;
            this.additionalAmounts = additionalAmounts;
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

        public Builder requestedAmount(BigDecimal requestedAmount){
            this.requestedAmount = requestedAmount;
            return Builder.this;
        }

        public Builder partialAuthorizedAmount(BigDecimal partialAuthorizedAmount){
            this.partialAuthorizedAmount = partialAuthorizedAmount;
            return Builder.this;
        }

        public Builder additonalAmounts(List<AdditionalAmount> additionalAmounts){
            this.additionalAmounts = additionalAmounts;
            return Builder.this;
        }

        public Builder additionalAmount(AdditionalAmount additionalAmount){
            if(additionalAmounts==null){
                this.additionalAmounts = Collections.singletonList(additionalAmount);
            }else{
                this.additionalAmounts.add(additionalAmount);
            }
            return Builder.this;
        }

        public Builder addAdditonalAmount(AdditionalAmount additionalAmount){
            this.additionalAmounts.add(additionalAmount);
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
        this.requestedAmount = builder.requestedAmount;
        this.additionalAmounts = builder.additionalAmounts;
		this.partialAuthorizedAmount = builder.partialAuthorizedAmount;
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
BigDecimal partialAuthorizedAmount
* */