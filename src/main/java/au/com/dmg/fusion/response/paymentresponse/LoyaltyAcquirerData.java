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

import au.com.dmg.fusion.request.paymentrequest.SaleTransactionID;

public class LoyaltyAcquirerData {

    @Json(name = "LoyaltyAcquirerID")
    private String loyaltyAcquirerID;

    @Json(name = "ApprovalCode")
    private String approvalCode;

    @Json(name = "LoyaltyTransactionID")
    private SaleTransactionID loyaltyTransactionID;

    @Json(name = "HostReconciliationID")
    private String hostReconciliationID;

    public String getLoyaltyAcquirerID() {
        return loyaltyAcquirerID;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public SaleTransactionID getLoyaltyTransactionID() {
        return loyaltyTransactionID;
    }

    public String getHostReconciliationID() {
        return hostReconciliationID;
    }

    public static class Builder {
        private String loyaltyAcquirerID;
        private String approvalCode;
        private SaleTransactionID loyaltyTransactionID;
        private String hostReconciliationID;

        public Builder() {
        }

        Builder(String loyaltyAcquirerID, String approvalCode, SaleTransactionID loyaltyTransactionID, String hostReconciliationID) {
            this.loyaltyAcquirerID = loyaltyAcquirerID;
            this.approvalCode = approvalCode;
            this.loyaltyTransactionID = loyaltyTransactionID;
            this.hostReconciliationID = hostReconciliationID;
        }

        public Builder loyaltyAcquirerID(String loyaltyAcquirerID){
            this.loyaltyAcquirerID = loyaltyAcquirerID;
            return Builder.this;
        }
        
        public Builder approvalCode(String approvalCode){
            this.approvalCode = approvalCode;
            return Builder.this;
        }

        public Builder loyaltyTransactionID(SaleTransactionID loyaltyTransactionID){
            this.loyaltyTransactionID = loyaltyTransactionID;
            return Builder.this;
        }

        public Builder hostReconciliationID(String hostReconciliationID){
            this.hostReconciliationID = hostReconciliationID;
            return Builder.this;
        }

        public LoyaltyAcquirerData build() {
            return new LoyaltyAcquirerData(this);
        }
    }

    private LoyaltyAcquirerData(Builder builder) {
        this.loyaltyAcquirerID = builder.loyaltyAcquirerID;
        this.approvalCode = builder.approvalCode;
        this.loyaltyTransactionID = builder.loyaltyTransactionID;
        this.hostReconciliationID = builder.hostReconciliationID;
    }
}

/*
package au.com.dmg.fusionsatellite.PaymentRequest
class LoyaltyAcquirerData
String loyaltyAcquirerID
String approvalCode
SaleTransactionID loyaltyTransactionID
String hostReconciliationID
* */