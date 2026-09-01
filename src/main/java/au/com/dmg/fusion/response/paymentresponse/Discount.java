/*
 * Copyright (c) 2026. DatameshGroup
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

import java.math.BigDecimal;

import org.jetbrains.annotations.Nullable;

import com.squareup.moshi.Json;

public class Discount {

    @Json(name = "ApplyDiscount")
    private final boolean applyDiscount;
    @Json(name = "DiscountType")
    @Nullable
    private final String discountType;
    @Json(name = "DiscountRate")
    @Nullable
    private final BigDecimal discountRate;
    @Json(name = "ApplyTieredDiscount")
    private final boolean applyTieredDiscount;
    @Json(name = "TieredVolume")
    @Nullable
    private final Integer tieredVolume;
    @Json(name = "TieredType")
    @Nullable
    private final String tieredType;
    @Json(name = "TieredRate")
    @Nullable
    private final BigDecimal tieredRate;

    public boolean isApplyDiscount() {
        return applyDiscount;
    }

    @Nullable
    public String getDiscountType() {
        return discountType;
    }

    @Nullable
    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public boolean isApplyTieredDiscount() {
        return applyTieredDiscount;
    }

    @Nullable
    public Integer getTieredVolume() {
        return tieredVolume;
    }

    @Nullable
    public String getTieredType() {
        return tieredType;
    }

    @Nullable
    public BigDecimal getTieredRate() {
        return tieredRate;
    }

    public static class Builder {
        private boolean applyDiscount;
        private String discountType;
        private BigDecimal discountRate;
        private boolean applyTieredDiscount;
        private Integer tieredVolume;
        private String tieredType;
        private BigDecimal tieredRate;

        public Builder() {
        }

        public Builder applyDiscount(boolean applyDiscount) {
            this.applyDiscount = applyDiscount;
            return Builder.this;
        }

        public Builder discountType(String discountType) {
            this.discountType = discountType;
            return Builder.this;
        }

        public Builder discountRate(BigDecimal discountRate) {
            this.discountRate = discountRate;
            return Builder.this;
        }

        public Builder applyTieredDiscount(boolean applyTieredDiscount) {
            this.applyTieredDiscount = applyTieredDiscount;
            return Builder.this;
        }

        public Builder tieredVolume(Integer tieredVolume) {
            this.tieredVolume = tieredVolume;
            return Builder.this;
        }

        public Builder tieredType(String tieredType) {
            this.tieredType = tieredType;
            return Builder.this;
        }

        public Builder tieredRate(BigDecimal tieredRate) {
            this.tieredRate = tieredRate;
            return Builder.this;
        }

        public Discount build() {
            return new Discount(this);
        }
    }

    private Discount(Builder builder) {
        this.applyDiscount = builder.applyDiscount;
        this.discountType = builder.discountType;
        this.discountRate = builder.discountRate;
        this.applyTieredDiscount = builder.applyTieredDiscount;
        this.tieredVolume = builder.tieredVolume;
        this.tieredType = builder.tieredType;
        this.tieredRate = builder.tieredRate;
    }
}

/*
package au.com.dmg.fusionsatellite.response.paymentresponse
class Discount
Boolean applyDiscount
String discountType
BigDecimal discountRate
Boolean applyTieredDiscount
Integer tieredVolume
String tieredType
BigDecimal tieredRate
* */
