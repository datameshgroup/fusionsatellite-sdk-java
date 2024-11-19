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

package au.com.dmg.fusion.response.reversalresponse;

import au.com.dmg.fusion.request.paymentrequest.POIData;
import au.com.dmg.fusion.request.reversalrequest.ReversalRequest;
import au.com.dmg.fusion.response.Response;
import au.com.dmg.fusion.response.ResponseType;
import au.com.dmg.fusion.response.TransactionStatusResponse;
import au.com.dmg.fusion.response.paymentresponse.PaymentReceipt;
import au.com.dmg.fusion.util.BigDecimalAdapter;
import au.com.dmg.fusion.util.InstantAdapter;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;
import java.util.List;

public class ReversalResponse implements ResponseType {

    @Json(name = "Response")
    private final Response response;
    @Json(name = "POIData")
    private final POIData poiData;
    @Json(name = "PaymentReceipt")
    private final List<PaymentReceipt> paymentReceipt;

    @Nullable
    public List<PaymentReceipt> getPaymentReceipt() {
        return paymentReceipt;
    }

    @NotNull
    public Response getResponse() {
        return response;
    }

    @NotNull
    public POIData getPoiData() {
        return poiData;
    }

    public static class Builder {

        private Response response;
        private POIData poiData;
        private List<PaymentReceipt> paymentReceipt;

        public Builder() {
        }

        public Builder addPaymentReceipt(PaymentReceipt paymentReceipt){
            if (this.paymentReceipt == null){
                this.paymentReceipt = new LinkedList<>();
            }

            if(paymentReceipt != null){
                this.paymentReceipt.add(paymentReceipt);
            }
            return Builder.this;
        }


        public ReversalResponse.Builder paymentReceipt(List<PaymentReceipt> paymentReceipt) {
            this.paymentReceipt = paymentReceipt;
            return Builder.this;
        }

        Builder(Response response, POIData poiData) {
            this.response = response;
            this.poiData = poiData;
        }

        public Builder response(Response response){
            this.response = response;
            return Builder.this;
        }

        public Builder poiData(POIData poiData){
            this.poiData = poiData;
            return Builder.this;
        }

        public ReversalResponse build() {
            if(this.response == null){
                throw new NullPointerException("The property \"response\" is null. "
                        + "Please set the value by \"response()\". "
                        + "The properties \"response\", \"poiData\" are required.");
            }
            if(this.poiData == null){
                throw new NullPointerException("The property \"poiData\" is null. "
                        + "Please set the value by \"poiData()\". "
                        + "The properties \"response\", \"poiData\" are required.");
            }

            return new ReversalResponse(this);
        }
    }

    private ReversalResponse(Builder builder) {
        this.response = builder.response;
        this.poiData = builder.poiData;
        this.paymentReceipt = builder.paymentReceipt;
    }

    @Override
    public String toJson() {
        Moshi moshi = new Moshi.Builder()
                .add(new BigDecimalAdapter())
                .add(new InstantAdapter())
                .build();
        JsonAdapter<ReversalResponse> jsonAdapter = moshi.adapter(ReversalResponse.class);
        return jsonAdapter.toJson(this);
    }
}


/*
package au.com.dmg.fusion.response.reversalresponse
class ReversalResponse
@Required Response response
@Required POIData poiData
* */