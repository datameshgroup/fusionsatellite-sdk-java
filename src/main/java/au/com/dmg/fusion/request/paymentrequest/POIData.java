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

public class POIData {

    @Json(name = "POITransactionID")
    private final POITransactionID POITransactionID;
    @Json(name = "POIReconciliationID")
    private final String POIReconciliationID;

    public POITransactionID getPOITransactionID() {
        return POITransactionID;
    }

    public String getPOIReconciliationID() {
        return POIReconciliationID;
    }

    public static class Builder {

        private POITransactionID POITransactionID;
        private String POIReconciliationID;

        public Builder() {
        }

        Builder(POITransactionID POITransactionID, String POIReconciliationID) {
            this.POITransactionID = POITransactionID;
            this.POIReconciliationID = POIReconciliationID;
        }

        public Builder POITransactionID(POITransactionID POITransactionID) {
            this.POITransactionID = POITransactionID;
            return Builder.this;
        }

        public Builder POIReconciliationID(String POIReconciliationID) {
            this.POIReconciliationID = POIReconciliationID;
            return Builder.this;
        }

        public POIData build() {
            if (this.POITransactionID == null) {
                throw new NullPointerException("The property \"POITransactionID\" is null. "
                        + "Please set the value by \"POITransactionID()\". "
                        + "The property \"POITransactionID\" is required.");
            }

            return new POIData(this);
        }
    }

    private POIData(Builder builder) {
        this.POITransactionID = builder.POITransactionID;
        this.POIReconciliationID = builder.POIReconciliationID;
    }
}


/*
package au.com.dmg.fusionsatellite.PaymentRequest
class POIData
@Required POITransactionID POITransactionID
String POIReconciliationID
* */