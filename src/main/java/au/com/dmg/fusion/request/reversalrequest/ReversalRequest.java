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

package au.com.dmg.fusion.request.reversalrequest;

import au.com.dmg.fusion.data.ReversalReason;
import au.com.dmg.fusion.request.Request;
import au.com.dmg.fusion.request.paymentrequest.OriginalPOITransaction;
import au.com.dmg.fusion.request.reconciliationrequest.ReconciliationRequest;
import au.com.dmg.fusion.response.paymentresponse.PaymentReceipt;
import au.com.dmg.fusion.response.paymentresponse.PaymentResponse;
import au.com.dmg.fusion.response.reversalresponse.ReversalResponse;
import au.com.dmg.fusion.util.BigDecimalAdapter;
import au.com.dmg.fusion.util.DefaultOnDataMismatchAdapter;
import au.com.dmg.fusion.util.InstantAdapter;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;
import java.util.List;

public class ReversalRequest implements Request {

    @Json(name = "ReversalReason")
    private final ReversalReason reversalReason;
    @Json(name = "OriginalPOITransaction")
    private final OriginalPOITransaction originalPOITransaction;

    @NotNull
    public ReversalReason getReversalReason() {
        return reversalReason;
    }

    @NotNull
    public OriginalPOITransaction getOriginalPOITransaction() {
        return originalPOITransaction;
    }

    public static class Builder {

        private ReversalReason reversalReason;
        private OriginalPOITransaction originalPOITransaction;
        private List<PaymentReceipt> paymentReceipt;

        public Builder() {
        }

        Builder(ReversalReason reversalReason, OriginalPOITransaction originalPOITransaction) {
            this.reversalReason = reversalReason;
            this.originalPOITransaction = originalPOITransaction;
        }

        public Builder reversalReason(ReversalReason reversalReason){
            this.reversalReason = reversalReason;
            return Builder.this;
        }

        public Builder originalPOITransaction(OriginalPOITransaction originalPOITransaction){
            this.originalPOITransaction = originalPOITransaction;
            return Builder.this;
        }

        public ReversalRequest build() {
            if(this.reversalReason == null){
                throw new NullPointerException("The property \"reversalReason\" is null. "
                        + "Please set the value by \"reversalReason()\". "
                        + "The properties \"reversalReason\", \"originalPOITransaction\" are required.");
            }
            if(this.originalPOITransaction == null){
                throw new NullPointerException("The property \"originalPOITransaction\" is null. "
                        + "Please set the value by \"originalPOITransaction()\". "
                        + "The properties \"reversalReason\", \"originalPOITransaction\" are required.");
            }

            return new ReversalRequest(this);
        }
    }

    private ReversalRequest(Builder builder) {
        this.reversalReason = builder.reversalReason;
        this.originalPOITransaction = builder.originalPOITransaction;
    }

    @Override
    public String toJson() {
        Moshi moshi = new Moshi.Builder()
                .add(new BigDecimalAdapter())
                .add(new InstantAdapter())
                .add(DefaultOnDataMismatchAdapter.newFactory(ReversalReason.class, ReversalReason.Unknown))
                .build();
        JsonAdapter<ReversalRequest> jsonAdapter = moshi.adapter(ReversalRequest.class);
        return jsonAdapter.toJson(this);
    }
}
