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

import java.util.ArrayList;
import java.util.List;

import com.squareup.moshi.Json;

import au.com.dmg.fusion.data.PaymentBrand;

public class TransactionConditions {

    @Json(name = "AllowedPaymentBrands")
    private final List<PaymentBrand> allowedPaymentBrands;
    @Json(name = "AcquirerID")
    private final List<String> acquirerID;
    @Json(name = "DebitPreferredFlag")
    private final Boolean debitPreferredFlag;
    @Json(name = "ForceOnlineFlag")
    private final Boolean forceOnlineFlag;
    @Json(name = "MerchantCategoryCode")
    private final String merchantCategoryCode;

    public List<PaymentBrand> getAllowedPaymentBrands() {
        return allowedPaymentBrands;
    }

    public List<String> getAcquirerID() {
        return acquirerID;
    }

    public Boolean getDebitPreferredFlag() {
        return debitPreferredFlag;
    }

    public Boolean getForceOnlineFlag() {
        return forceOnlineFlag;
    }

    public String getMerchantCategoryCode() {
        return merchantCategoryCode;
    }

    public static class Builder {

        private List<PaymentBrand> allowedPaymentBrands = new ArrayList<>();
        private List<String> acquirerID = new ArrayList<>();
        private Boolean debitPreferredFlag;
        private Boolean forceOnlineFlag;
        private String merchantCategoryCode;

        public Builder() {
        }

        Builder(List<PaymentBrand> allowedPaymentBrands, List<String> acquirerID, Boolean debitPreferredFlag, Boolean forceOnlineFlag, String merchantCategoryCode) {
            this.allowedPaymentBrands = allowedPaymentBrands;
            this.acquirerID = acquirerID;
            this.debitPreferredFlag = debitPreferredFlag;
            this.forceOnlineFlag = forceOnlineFlag;
            this.merchantCategoryCode = merchantCategoryCode;
        }

        public Builder allowedPaymentBrands(List<PaymentBrand> allowedPaymentBrands) {
            this.allowedPaymentBrands = allowedPaymentBrands;
            return Builder.this;
        }

        public Builder addAllowedPaymentBrands(PaymentBrand allowedPaymentBrands) {
            this.allowedPaymentBrands.add(allowedPaymentBrands);
            return Builder.this;
        }

        public Builder acquirerID(List<String> acquirerID) {
            this.acquirerID = acquirerID;
            return Builder.this;
        }

        public Builder addAcquirerID(String acquirerID) {
            this.acquirerID.add(acquirerID);
            return Builder.this;
        }

        public Builder debitPreferredFlag(Boolean debitPreferredFlag) {
            this.debitPreferredFlag = debitPreferredFlag;
            return Builder.this;
        }

        public Builder forceOnlineFlag(Boolean forceOnlineFlag) {
            this.forceOnlineFlag = forceOnlineFlag;
            return Builder.this;
        }

        public Builder merchantCategoryCode(String merchantCategoryCode) {
            this.merchantCategoryCode = merchantCategoryCode;
            return Builder.this;
        }

        public TransactionConditions build() {

            return new TransactionConditions(this);
        }
    }

    private TransactionConditions(Builder builder) {
        this.allowedPaymentBrands = builder.allowedPaymentBrands;
        this.acquirerID = builder.acquirerID;
        this.debitPreferredFlag = builder.debitPreferredFlag;
        this.forceOnlineFlag = builder.forceOnlineFlag;
        this.merchantCategoryCode = builder.merchantCategoryCode;
    }
}


/*
package au.com.dmg.fusionsatellite.PaymentRequest
class TransactionConditions
List<String> allowedPaymentBrands
List<String> acquirerID
Boolean debitPreferredFlag
Boolean forceOnlineFlag
String merchantCategoryCode
* */