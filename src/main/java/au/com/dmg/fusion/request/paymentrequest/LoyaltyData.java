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

public class LoyaltyData {

    @Json(name = "CardAcquisitionReference")
    @Nullable
    private final SaleTransactionID cardAcquisitionReference;

    @Json(name = "LoyaltyAccountID")
    @Nullable
    private final LoyaltyAccountID loyaltyAccountID;

    @Json(name = "LoyaltyAmount")
    @Nullable
    private final LoyaltyAmount loyaltyAmount;

    @Nullable
    public SaleTransactionID getCardAcquisitionReference() {
        return cardAcquisitionReference;
    }

    @Nullable
    public LoyaltyAccountID getLoyaltyAccountID() {
        return loyaltyAccountID;
    }

    @Nullable
    public LoyaltyAmount getLoyaltyAmount() {
        return loyaltyAmount;
    }

    public static class Builder {

        private SaleTransactionID cardAcquisitionReference;
        private LoyaltyAccountID loyaltyAccountID;
        private LoyaltyAmount loyaltyAmount;

        public Builder() {
        }

        public Builder cardAcquisitionReference(SaleTransactionID cardAcquisitionReference) {
            this.cardAcquisitionReference = cardAcquisitionReference;
            return Builder.this;
        }

        public Builder loyaltyAccountID(LoyaltyAccountID loyaltyAccountID) {
            this.loyaltyAccountID = loyaltyAccountID;
            return Builder.this;
        }

        public Builder loyaltyAmount(LoyaltyAmount loyaltyAmount) {
            this.loyaltyAmount = loyaltyAmount;
            return Builder.this;
        }

        public LoyaltyData build() {
            return new LoyaltyData(this);
        }
    }

    private LoyaltyData(Builder builder) {
        this.cardAcquisitionReference = builder.cardAcquisitionReference;
        this.loyaltyAccountID = builder.loyaltyAccountID;
        this.loyaltyAmount = builder.loyaltyAmount;
    }
}

/*
package au.com.dmg.fusion.request.paymentrequest
class LoyaltyData
SaleTransactionID cardAcquisitionReference
LoyaltyAccountID loyaltyAccountID
LoyaltyAmount loyaltyAmount
* */
