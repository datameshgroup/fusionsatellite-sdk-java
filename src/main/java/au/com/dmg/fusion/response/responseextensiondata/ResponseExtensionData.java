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

package au.com.dmg.fusion.response.responseextensiondata;

import au.com.dmg.fusion.request.paymentrequest.extenstiondata.ExtensionData;
import au.com.dmg.fusion.request.paymentrequest.extenstiondata.TransitData;
import com.squareup.moshi.Json;

public class ResponseExtensionData {

    @Json(name = "POIInformation")
    private final POIInformation poiInformation;

    public POIInformation getPoiInformation() {
        return poiInformation;
    }

    public static class Builder {
        private POIInformation poiInformation;

        public Builder() {
        }

        Builder(POIInformation poiInformation) {
            this.poiInformation = poiInformation;
        }

        public Builder poiInformation(POIInformation poiInformation) {
            this.poiInformation = poiInformation;
            return Builder.this;
        }

        public ResponseExtensionData build() {
            if (this.poiInformation == null) {
                throw new NullPointerException("The property \"poiInformation\" is null or empty. "
                        + "Please set the value by \"poiInformation()\". "
                        + "The properties \"poiInformation\", is required.");
            }
            return new ResponseExtensionData(this);
        }
    }

    private ResponseExtensionData(Builder builder) {
        this.poiInformation = builder.poiInformation;
    }

}


/*
package au.com.dmg.fusionsatellite.PaymentRequest
class PaymentRequest
@Required SaleData saleData
@Required PaymentTransaction paymentTransaction

* */

