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

package au.com.dmg.fusion.request.paymentrequest.extenstiondata;

import au.com.dmg.fusion.request.paymentrequest.CustomField;
import com.squareup.moshi.Json;
import org.jetbrains.annotations.NotNull;

public class ExtensionData {

    @Json(name = "TransitData")
    private final TransitData transitData;

    @Json(name = "POIInformation")
    private final POIInformation poiInformation;

    public TransitData getTransitData() {
        return transitData;
    }
    public POIInformation getPoiInformation() {
        return poiInformation;
    }

    public static class Builder {
        private TransitData transitData;
        private POIInformation poiInformation;

        public Builder() {
        }

        Builder(TransitData transitData, POIInformation poiInformation) {
            this.transitData = transitData;
            this.poiInformation = poiInformation;
        }


        public Builder transitData(TransitData transitData) {
            this.transitData = transitData;
            return Builder.this;
        }
        public Builder poiInformation(POIInformation poiInformation) {
            this.poiInformation = poiInformation;
            return Builder.this;
        }

        public ExtensionData build() {
            return new ExtensionData(this);
        }
    }

    private ExtensionData(Builder builder) {
        this.transitData = builder.transitData;
        this.poiInformation = builder.poiInformation;
    }

}


/*
package au.com.dmg.fusionsatellite.PaymentRequest
class PaymentRequest
@Required SaleData saleData
@Required PaymentTransaction paymentTransaction

* */

