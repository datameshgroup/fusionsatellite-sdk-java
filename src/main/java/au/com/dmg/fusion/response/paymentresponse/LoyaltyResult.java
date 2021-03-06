/*
 * Copyright (c) 2022. DatameshGroup
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

import au.com.dmg.fusion.request.paymentrequest.AmountsReq.Builder;

import java.math.BigDecimal;

import org.jetbrains.annotations.Nullable;

public class LoyaltyResult {

    @Json(name = "LoyaltyAccount")
    private LoyaltyAccount loyaltyAccount;

    @Json(name = "CurrentBalance")
    @Nullable
    private BigDecimal currentBalance;

    @Json(name = "LoyaltyAmount")
    private LoyaltyAmount loyaltyAmount;

    @Json(name = "LoyaltyAcquirerData")
    private LoyaltyAcquirerData loyaltyAcquirerData;

    @Json(name = "Rebates")
    private Rebates rebates;

    public LoyaltyAccount getLoyaltyAccount() {
        return loyaltyAccount;
    }

    @Nullable
    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public LoyaltyAmount getLoyaltyAmount() {
        return loyaltyAmount;
    }

    public LoyaltyAcquirerData getLoyaltyAcquirerData() {
        return loyaltyAcquirerData;
    }

    public Rebates getRebates() {
        return rebates;
    }

    public static class Builder {

        private LoyaltyAccount loyaltyAccount;
        private BigDecimal currentBalance;
        private LoyaltyAmount loyaltyAmount;
        private LoyaltyAcquirerData loyaltyAcquirerData;
        private Rebates rebates;

        public Builder() {
        }

        Builder(LoyaltyAccount loyaltyAccount, BigDecimal currentBalance, LoyaltyAmount loyaltyAmount, LoyaltyAcquirerData loyaltyAcquirerData, Rebates rebates) {
            this.loyaltyAccount = loyaltyAccount;
            this.currentBalance = currentBalance;
            this.loyaltyAmount = loyaltyAmount;
            this.loyaltyAcquirerData = loyaltyAcquirerData;
            this.rebates = rebates;
        }

        public Builder loyaltyAccount(LoyaltyAccount loyaltyAccount) {
            this.loyaltyAccount = loyaltyAccount;
            return Builder.this;
        }

        public Builder currentBalance(BigDecimal currentBalance) {
            this.currentBalance = currentBalance;
            return Builder.this;
        }

        public Builder loyaltyAmount(LoyaltyAmount loyaltyAmount) {
            this.loyaltyAmount = loyaltyAmount;
            return Builder.this;
        }

        public Builder loyaltyAcquirerData(LoyaltyAcquirerData loyaltyAcquirerData) {
            this.loyaltyAcquirerData = loyaltyAcquirerData;
            return Builder.this;
        }

        public Builder rebates(Rebates rebates) {
            this.rebates = rebates;
            return Builder.this;
        }

        public LoyaltyResult build() {
            if (this.loyaltyAccount == null) {
                throw new NullPointerException("The property \"loyaltyAccount\" is null. "
                        + "Please set the value by \"loyaltyAccount()\". "
                        + "The property \"loyaltyAccount\" is required.");
            } 
            if (this.loyaltyAmount == null) {
                throw new NullPointerException("The property \"loyaltyAmount\" is null. "
                        + "Please set the value by \"loyaltyAmount()\". "
                        + "The property \"loyaltyAmount\" is required.");
            }

            return new LoyaltyResult(this);
        }
    }

    private LoyaltyResult(Builder builder) {
        this.loyaltyAccount = builder.loyaltyAccount;
        this.currentBalance = builder.currentBalance;
        this.loyaltyAmount = builder.loyaltyAmount;
        this.loyaltyAcquirerData = builder.loyaltyAcquirerData;
        this.rebates = builder.rebates;

    }
}

/*
package au.com.dmg.fusionsatellite.response
class LoyaltyResult
LoyaltyAccount loyaltyAccount
BigDecimal currentBalance
LoyaltyAmount loyaltyAmount
LoyaltyAcquirerData loyaltyAcquirerData
Rebates rebates
* */