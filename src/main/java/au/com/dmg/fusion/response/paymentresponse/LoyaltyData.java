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

public class LoyaltyData {

    @Json(name = "LoyaltyBrand")
    private String loyaltyBrand;

    public static class Builder {

        private String loyaltyBrand;

        public Builder() {
        }

        Builder(String loyaltyBrand) {
            this.loyaltyBrand = loyaltyBrand;
        }

        public Builder loyaltyBrand(String loyaltyBrand){
            this.loyaltyBrand = loyaltyBrand;
            return Builder.this;
        }

        public LoyaltyData build() {
            if (this.loyaltyBrand == null) {
                throw new NullPointerException("The property \"loyaltyData\" is null. "
                        + "Please set the value by \"loyalty()\""
                );
            }
            return new LoyaltyData(this);
        }
    }

    private LoyaltyData(Builder builder) {
        this.loyaltyBrand = builder.loyaltyBrand;
    }
}
