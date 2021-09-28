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
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;

public class AmountsReq {
    @Json(name = "Currency")
    private final String currency;
    @Json(name = "RequestedAmount")
    private final BigDecimal requestedAmount;
    @Json(name = "CashBackAmount")
    private final BigDecimal cashBackAmount;
    @Json(name = "TipAmount")
    private final BigDecimal tipAmount;
    @Json(name = "PaidAmount")
    private final BigDecimal paidAmount;
    @Json(name = "MaximumCashBackAmount")
    private final BigDecimal maximumCashBackAmount;
    @Json(name = "MinimumCashBackAmount")
    private final BigDecimal minimumCashBackAmount;

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getRequestedAmount() {
        return requestedAmount;
    }

    @Nullable
    public BigDecimal getCashBackAmount() {
        return cashBackAmount;
    }

    @Nullable
    public BigDecimal getTipAmount() {
        return tipAmount;
    }

    @Nullable
    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    @Nullable
    public BigDecimal getMaximumCashBackAmount() {
        return maximumCashBackAmount;
    }

    @Nullable
    public BigDecimal getMinimumCashBackAmount() {
        return minimumCashBackAmount;
    }

    public static class Builder {

        private String currency;
        private BigDecimal requestedAmount;
        private BigDecimal cashBackAmount;
        private BigDecimal tipAmount;
        private BigDecimal paidAmount;
        private BigDecimal maximumCashBackAmount;
        private BigDecimal minimumCashBackAmount;

        public Builder() {
        }

        Builder(String currency, BigDecimal requestedAmount, BigDecimal cashBackAmount, BigDecimal tipAmount, BigDecimal paidAmount, BigDecimal maximumCashBackAmount, BigDecimal minimumCashBackAmount) {
            this.currency = currency;
            this.requestedAmount = requestedAmount;
            this.cashBackAmount = cashBackAmount;
            this.tipAmount = tipAmount;
            this.paidAmount = paidAmount;
            this.maximumCashBackAmount = maximumCashBackAmount;
            this.minimumCashBackAmount = minimumCashBackAmount;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return Builder.this;
        }

        public Builder requestedAmount(BigDecimal requestedAmount) {
            this.requestedAmount = requestedAmount;
            return Builder.this;
        }

        public Builder cashBackAmount(BigDecimal cashBackAmount) {
            this.cashBackAmount = cashBackAmount;
            return Builder.this;
        }

        public Builder tipAmount(BigDecimal tipAmount) {
            this.tipAmount = tipAmount;
            return Builder.this;
        }

        public Builder paidAmount(BigDecimal paidAmount) {
            this.paidAmount = paidAmount;
            return Builder.this;
        }

        public Builder maximumCashBackAmount(BigDecimal maximumCashBackAmount) {
            this.maximumCashBackAmount = maximumCashBackAmount;
            return Builder.this;
        }

        public Builder minimumCashBackAmount(BigDecimal minimumCashBackAmount) {
            this.minimumCashBackAmount = minimumCashBackAmount;
            return Builder.this;
        }

        public AmountsReq build() {
            if (this.currency == null) {
                throw new NullPointerException("The property \"currency\" is null. "
                        + "Please set the value by \"currency()\". "
                        + "The properties \"currency\", \"requestedAmount\" are required.");
            }
            if (this.requestedAmount == null) {
                throw new NullPointerException("The property \"requestedAmount\" is null. "
                        + "Please set the value by \"requestedAmount()\". "
                        + "The properties \"currency\", \"requestedAmount\" are required.");
            }

            return new AmountsReq(this);
        }
    }

    private AmountsReq(Builder builder) {
        this.currency = builder.currency;
        this.requestedAmount = builder.requestedAmount;
        this.cashBackAmount = builder.cashBackAmount;
        this.tipAmount = builder.tipAmount;
        this.paidAmount = builder.paidAmount;
        this.maximumCashBackAmount = builder.maximumCashBackAmount;
        this.minimumCashBackAmount = builder.minimumCashBackAmount;
    }
}



/*
package au.com.dmg.fusionsatellite.PaymentRequest
class AmountsReq
@Required String currency
@Required BigDecimal requestedAmount
BigDecimal cashBackAmount
BigDecimal tipAmount
BigDecimal paidAmount
BigDecimal maximumCashBackAmount
BigDecimal minimumCashBackAmount
* */