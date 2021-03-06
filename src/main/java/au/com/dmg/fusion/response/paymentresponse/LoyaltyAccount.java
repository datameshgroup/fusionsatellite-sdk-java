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

import au.com.dmg.fusion.data.LoyaltyBrand;

import org.jetbrains.annotations.NotNull;

public class LoyaltyAccount {

    @Json(name = "LoyaltyAccountID")
    private LoyaltyAccountID loyaltyAccountID;
    
    @Json(name = "LoyaltyBrand")
    private LoyaltyBrand loyaltyBrand;

    @NotNull
    public LoyaltyAccountID getLoyaltyAccountID() {
        return loyaltyAccountID;
    }

    @NotNull
    public LoyaltyBrand getLoyaltyBrand() {
        return loyaltyBrand;
    }

    public static class Builder {

        private LoyaltyAccountID loyaltyAccountID;
        private LoyaltyBrand loyaltyBrand;

        public Builder() {
        }

        Builder(LoyaltyAccountID loyaltyAccountID, LoyaltyBrand loyaltyBrand) {
            this.loyaltyAccountID = loyaltyAccountID;
            this.loyaltyBrand = loyaltyBrand;
        }

        public Builder loyaltyAccountID(LoyaltyAccountID loyaltyAccountID){
            this.loyaltyAccountID = loyaltyAccountID;
            return Builder.this;
        }

        public Builder loyaltyBrand(LoyaltyBrand loyaltyBrand){
            this.loyaltyBrand = loyaltyBrand;
            return Builder.this;
        }

        public LoyaltyAccount build() {
            if (this.loyaltyAccountID == null) {
                throw new NullPointerException("The property \"loyaltyAccountID\" is null. "
                        + "Please set the value by \"loyaltyAccountID()\""
                );
            }
            if (this.loyaltyBrand == null) {
                throw new NullPointerException("The property \"loyaltyBrand\" is null. "
                        + "Please set the value by \"loyaltyBrand()\""
                );
            }
            return new LoyaltyAccount(this);
        }
    }

    private LoyaltyAccount(Builder builder) {
        this.loyaltyAccountID = builder.loyaltyAccountID;
        this.loyaltyBrand = builder.loyaltyBrand;
    }
}

/*
package au.com.dmg.fusion.response.paymentresponse
class LoyaltyAccount
LoyaltyAccountID loyaltyAccountID
LoyaltyBrand loyaltyBrand
* */
