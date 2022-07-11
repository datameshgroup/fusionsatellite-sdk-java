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

import au.com.dmg.fusion.data.CurrencySymbol;
import au.com.dmg.fusion.data.LoyaltyUnit;

import java.math.BigDecimal;

import org.jetbrains.annotations.Nullable;

public class LoyaltyAmount {

    @Json(name = "LoyaltyUnit")
    @Nullable
    private LoyaltyUnit loyaltyUnit;

    @Json(name = "Currency")
    @Nullable
    private CurrencySymbol currency;

    @Json(name = "AmountValue")
    private BigDecimal amountValue;

    @Nullable
    public LoyaltyUnit getLoyaltyUnit() {
        return loyaltyUnit;
    }

    @Nullable
    public CurrencySymbol getCurrency() {
        return currency;
    }

    public BigDecimal getAmountValue() {
        return amountValue;
    }

    public static class Builder {
        private LoyaltyUnit loyaltyUnit = LoyaltyUnit.Monetary;
        private CurrencySymbol currency = CurrencySymbol.AUD;
        private BigDecimal amountValue;

        public Builder() {
        }

        Builder(LoyaltyUnit loyaltyUnit,  CurrencySymbol currency, BigDecimal amountValue) {
            this.loyaltyUnit = loyaltyUnit;
            this.currency = currency;
            this.amountValue = amountValue;
        }

        public Builder loyaltyUnit(LoyaltyUnit loyaltyUnit){
            this.loyaltyUnit = loyaltyUnit;
            return Builder.this;
        }
        
        public Builder currency(CurrencySymbol currency){
            this.currency = currency;
            return Builder.this;
        }

        public Builder amountValue(BigDecimal amountValue){
            this.amountValue = amountValue;
            return Builder.this;
        }

        public LoyaltyAmount build() {
            if (this.amountValue == null) {
                throw new NullPointerException("The property \"amountValue\" is null. "
                        + "Please set the value by \"amountValue()\""
                );
            }
            return new LoyaltyAmount(this);
        }
    }

    private LoyaltyAmount(Builder builder) {
        this.loyaltyUnit = builder.loyaltyUnit;
        this.currency = builder.currency;
        this.amountValue = builder.amountValue;
    }
}

/*
package au.com.dmg.fusionsatellite.PaymentRequest
class LoyaltyAmount
LoyaltyUnit loyaltyUnit
CurrencySymbol currency
BigDecimal amountValue
* */