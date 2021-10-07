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

public class OriginalPOITransaction {
    @Json(name = "SaleID")
    private final String saleID;
    @Json(name = "POIID")
    private final String POIID;
    @Json(name = "POITransactionID")
    private final POITransactionID POITransactionID;
    @Json(name = "ReuseCardDataFlag")
    private final Boolean reuseCardDataFlag;
    @Json(name = "ApprovalCode")
    private final String approvalCode;
    @Json(name = "LastTransactionFlag")
    private final boolean lastTransactionFlag;

    public String getSaleID() {
        return saleID;
    }

    public String getPOIID() {
        return POIID;
    }

    public au.com.dmg.fusion.request.paymentrequest.POITransactionID getPOITransactionID() {
        return POITransactionID;
    }

    public Boolean getReuseCardDataFlag() {
        return reuseCardDataFlag;
    }

    public String getApprovalCode() {
        return approvalCode;
    }



    public static class Builder {

        private String saleID;
        private String POIID;
        private POITransactionID POITransactionID;
        private Boolean reuseCardDataFlag;
        private String approvalCode;
        private boolean lastTransactionFlag;

        public Builder() {
        }

        Builder(String saleID, String POIID, POITransactionID POITransactionID, Boolean reuseCardDataFlag, String approvalCode) {
            this.saleID = saleID;
            this.POIID = POIID;
            this.POITransactionID = POITransactionID;
            this.reuseCardDataFlag = reuseCardDataFlag;
            this.approvalCode = approvalCode;
        }

        public Builder saleID(String saleID) {
            this.saleID = saleID;
            return Builder.this;
        }

        public Builder POIID(String POIID) {
            this.POIID = POIID;
            return Builder.this;
        }

        public Builder POITransactionID(POITransactionID POITransactionID) {
            this.POITransactionID = POITransactionID;
            return Builder.this;
        }

        public Builder reuseCardDataFlag(Boolean reuseCardDataFlag) {
            this.reuseCardDataFlag = reuseCardDataFlag;
            return Builder.this;
        }

        public Builder approvalCode(String approvalCode) {
            this.approvalCode = approvalCode;
            return Builder.this;
        }
        
        public Builder approvalCode(boolean lastTransactionFlag) {
            this.lastTransactionFlag = lastTransactionFlag;
            return Builder.this;
        }

        public OriginalPOITransaction build() {
            if (this.saleID == null) {
                throw new NullPointerException("The property \"saleID\" is null. "
                        + "Please set the value by \"saleID()\". "
                        + "The properties \"saleID\", \"POIID\" and \"POITransactionID\" are required.");
            }
            if (this.POIID == null) {
                throw new NullPointerException("The property \"POIID\" is null. "
                        + "Please set the value by \"POIID()\". "
                        + "The properties \"saleID\", \"POIID\" and \"POITransactionID\" are required.");
            }
            if (this.POITransactionID == null) {
                throw new NullPointerException("The property \"POITransactionID\" is null. "
                        + "Please set the value by \"POITransactionID()\". "
                        + "The properties \"saleID\", \"POIID\" and \"POITransactionID\" are required.");
            }

            return new OriginalPOITransaction(this);
        }
    }

    private OriginalPOITransaction(Builder builder) {
        this.saleID = builder.saleID;
        this.POIID = builder.POIID;
        this.POITransactionID = builder.POITransactionID;
        this.reuseCardDataFlag = builder.reuseCardDataFlag;
        this.approvalCode = builder.approvalCode;
        this.lastTransactionFlag = builder.lastTransactionFlag;
    }
}



/*
package au.com.dmg.fusionsatellite.PaymentRequest
class OriginalPOITransaction
@Required String saleID
@Required String POIID
@Required POITransactionID POITransactionID
Boolean reuseCardDataFlag
String approvalCode
@Required lastTransactionFlag
* */