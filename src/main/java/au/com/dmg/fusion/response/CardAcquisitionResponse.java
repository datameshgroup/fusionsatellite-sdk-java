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

package au.com.dmg.fusion.response;

import au.com.dmg.fusion.request.paymentrequest.POIData;
import au.com.dmg.fusion.request.paymentrequest.SaleData;
import au.com.dmg.fusion.response.paymentresponse.PaymentInstrumentData;
import com.squareup.moshi.Json;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CardAcquisitionResponse implements ResponseType {

    @Json(name = "Response")
    private final Response response;
    @Json(name = "SaleData")
    private final SaleData saleData;
    @Json(name = "POIData")
    private final POIData poiData;
    @Json(name = "PaymentInstrumentData")
    private final PaymentInstrumentData paymentInstrumentData;

    @NotNull
    public Response getResponse() {
        return response;
    }

    @NotNull
    public SaleData getSaleData() {
        return saleData;
    }

    @NotNull
    public POIData getPoiData() {
        return poiData;
    }

    @Nullable
    public PaymentInstrumentData getPaymentInstrumentData() {
        return paymentInstrumentData;
    }

    public static class Builder {

        private Response response;
        private SaleData saleData;
        private POIData poiData;
        private PaymentInstrumentData paymentInstrumentData;

        public Builder() {
        }

        Builder(Response response, SaleData saleData, POIData poiData, PaymentInstrumentData paymentInstrumentData) {
            this.response = response;
            this.saleData = saleData;
            this.poiData = poiData;
            this.paymentInstrumentData = paymentInstrumentData;
        }

        public Builder response(Response response) {
            this.response = response;
            return Builder.this;
        }

        public Builder saleData(SaleData saleData) {
            this.saleData = saleData;
            return Builder.this;
        }

        public Builder POIData(POIData poiData) {
            this.poiData = poiData;
            return Builder.this;
        }

        public Builder paymentInstrumentData(PaymentInstrumentData paymentInstrumentData) {
            this.paymentInstrumentData = paymentInstrumentData;
            return Builder.this;
        }

        public CardAcquisitionResponse build() {
            if (this.response == null) {
                throw new NullPointerException("The property \"response\" is null. "
                        + "Please set the value by \"response()\". "
                        + "The properties \"response\", \"saleData\" and \"poiData\" are required.");
            }
            if (this.saleData == null) {
                throw new NullPointerException("The property \"saleData\" is null. "
                        + "Please set the value by \"saleData()\". "
                        + "The properties \"response\", \"saleData\" and \"poiData\" are required.");
            }
            if (this.poiData == null) {
                throw new NullPointerException("The property \"poiData\" is null. "
                        + "Please set the value by \"poiData()\". "
                        + "The properties \"response\", \"saleData\" and \"poiData\" are required.");
            }

            return new CardAcquisitionResponse(this);
        }
    }

    private CardAcquisitionResponse(Builder builder) {
        this.response = builder.response;
        this.saleData = builder.saleData;
        this.poiData = builder.poiData;
        this.paymentInstrumentData = builder.paymentInstrumentData;
    }
}


/*
package au.com.dmg.fusionsatellite.response
class CardAcquisitionResponse
@Required Response response
@Required SaleData saleData
@Required POIData poiData
PaymentInstrumentData paymentInstrumentData
* */