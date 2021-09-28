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

public class PaymentAcquirerData {

    @Json(name = "AcquirerID")
    private final String acquirerID;
    @Json(name = "MerchantID")
    private final String merchantID;
    @Json(name = "AcquirerPOIID")
    private final String acquirerPOIID;
    @Json(name = "AcquirerTransactionID")
    private final AcquirerTransactionID acquirerTransactionID;
    @Json(name = "ApprovalCode")
    private final String approvalCode;
    @Json(name = "ResponseCode")
    private final String responseCode;
    @Json(name = "STAN")
    private final String stan;
    @Json(name = "RRN")
    private final String rrn;
    @Json(name = "HostReconciliationID")
    private final String hostReconciliationID;

    public String getAcquirerID() {
        return acquirerID;
    }

    public String getMerchantID() {
        return merchantID;
    }

    public String getAcquirerPOIID() {
        return acquirerPOIID;
    }

    public AcquirerTransactionID getAcquirerTransactionID() {
        return acquirerTransactionID;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public String getStan() {
        return stan;
    }

    public String getRrn() {
        return rrn;
    }

    public String getHostReconciliationID() {
        return hostReconciliationID;
    }

    public static class Builder {

        private String acquirerID;
        private String merchantID;
        private String acquirerPOIID;
        private AcquirerTransactionID acquirerTransactionID;
        private String approvalCode;
        private String responseCode;
        private String stan;
        private String rrn;
        private String hostReconciliationID;

        public Builder() {
        }

        Builder(String acquirerID, String merchantID, String acquirerPOIID, AcquirerTransactionID acquirerTransactionID, String approvalCode, String responseCode, String stan, String rrn, String hostReconciliationID) {
            this.acquirerID = acquirerID;
            this.merchantID = merchantID;
            this.acquirerPOIID = acquirerPOIID;
            this.acquirerTransactionID = acquirerTransactionID;
            this.approvalCode = approvalCode;
            this.responseCode = responseCode;
            this.stan = stan;
            this.rrn = rrn;
            this.hostReconciliationID = hostReconciliationID;
        }

        public Builder acquirerID(String acquirerID) {
            this.acquirerID = acquirerID;
            return Builder.this;
        }

        public Builder merchantID(String merchantID) {
            this.merchantID = merchantID;
            return Builder.this;
        }

        public Builder acquirerPOIID(String acquirerPOIID) {
            this.acquirerPOIID = acquirerPOIID;
            return Builder.this;
        }

        public Builder acquirerTransactionID(AcquirerTransactionID acquirerTransactionID) {
            this.acquirerTransactionID = acquirerTransactionID;
            return Builder.this;
        }

        public Builder approvalCode(String approvalCode) {
            this.approvalCode = approvalCode;
            return Builder.this;
        }

        public Builder responseCode(String responseCode) {
            this.responseCode = responseCode;
            return Builder.this;
        }

        public Builder stan(String stan) {
            this.stan = stan;
            return Builder.this;
        }

        public Builder rrn(String rrn) {
            this.rrn = rrn;
            return Builder.this;
        }

        public Builder hostReconciliationID(String hostReconciliationID) {
            this.hostReconciliationID = hostReconciliationID;
            return Builder.this;
        }

        public PaymentAcquirerData build() {
            if (this.acquirerID == null) {
                throw new NullPointerException("The property \"acquirerID\" is null. "
                        + "Please set the value by \"acquirerID()\". "
                        + "The properties \"acquirerID\", \"merchantID\", \"acquirerPOIID\", \"acquirerTransactionID\", \"approvalCode\", \"responseCode\" and \"hostReconciliationID\" are required.");
            }
            if (this.merchantID == null) {
                throw new NullPointerException("The property \"merchantID\" is null. "
                        + "Please set the value by \"merchantID()\". "
                        + "The properties \"acquirerID\", \"merchantID\", \"acquirerPOIID\", \"acquirerTransactionID\", \"approvalCode\", \"responseCode\" and \"hostReconciliationID\" are required.");
            }
            if (this.acquirerPOIID == null) {
                throw new NullPointerException("The property \"acquirerPOIID\" is null. "
                        + "Please set the value by \"acquirerPOIID()\". "
                        + "The properties \"acquirerID\", \"merchantID\", \"acquirerPOIID\", \"acquirerTransactionID\", \"approvalCode\", \"responseCode\" and \"hostReconciliationID\" are required.");
            }
            if (this.acquirerTransactionID == null) {
                throw new NullPointerException("The property \"acquirerTransactionID\" is null. "
                        + "Please set the value by \"acquirerTransactionID()\". "
                        + "The properties \"acquirerID\", \"merchantID\", \"acquirerPOIID\", \"acquirerTransactionID\", \"approvalCode\", \"responseCode\" and \"hostReconciliationID\" are required.");
            }
            if (this.approvalCode == null) {
                throw new NullPointerException("The property \"approvalCode\" is null. "
                        + "Please set the value by \"approvalCode()\". "
                        + "The properties \"acquirerID\", \"merchantID\", \"acquirerPOIID\", \"acquirerTransactionID\", \"approvalCode\", \"responseCode\" and \"hostReconciliationID\" are required.");
            }
            if (this.responseCode == null) {
                throw new NullPointerException("The property \"responseCode\" is null. "
                        + "Please set the value by \"responseCode()\". "
                        + "The properties \"acquirerID\", \"merchantID\", \"acquirerPOIID\", \"acquirerTransactionID\", \"approvalCode\", \"responseCode\" and \"hostReconciliationID\" are required.");
            }
            if (this.hostReconciliationID == null) {
                throw new NullPointerException("The property \"hostReconciliationID\" is null. "
                        + "Please set the value by \"hostReconciliationID()\". "
                        + "The properties \"acquirerID\", \"merchantID\", \"acquirerPOIID\", \"acquirerTransactionID\", \"approvalCode\", \"responseCode\" and \"hostReconciliationID\" are required.");
            }

            return new PaymentAcquirerData(this);
        }
    }

    private PaymentAcquirerData(Builder builder) {
        this.acquirerID = builder.acquirerID;
        this.merchantID = builder.merchantID;
        this.acquirerPOIID = builder.acquirerPOIID;
        this.acquirerTransactionID = builder.acquirerTransactionID;
        this.approvalCode = builder.approvalCode;
        this.responseCode = builder.responseCode;
        this.stan = builder.stan;
        this.rrn = builder.rrn;
        this.hostReconciliationID = builder.hostReconciliationID;
    }
}



/*
class PaymentAcquirerData
@Required String acquirerID
@Required String merchantID
@Required String acquirerPOIID
@Required AcquirerTransactionID acquirerTransactionID
@Required String approvalCode
@Required String responseCode
String stan
String rrn
@Required String hostReconciliationID
* */