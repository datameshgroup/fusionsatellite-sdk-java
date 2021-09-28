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

package au.com.dmg.fusion.request.cardacquisitionrequest;

import au.com.dmg.fusion.util.BigDecimalAdapter;
import au.com.dmg.fusion.request.Request;
import au.com.dmg.fusion.request.paymentrequest.SaleData;
import au.com.dmg.fusion.util.InstantAdapter;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CardAcquisitionRequest implements Request {

    @Json(name = "SaleData")
    private final SaleData saleData;
    @Json(name = "CardAcquisitionTransaction")
    private final CardAcquisitionTransaction cardAcquisitionTransaction;

    @NotNull
    public SaleData getSaleData() {
        return saleData;
    }

    @Nullable
    public CardAcquisitionTransaction getCardAcquisitionTransaction() {
        return cardAcquisitionTransaction;
    }

    public static class Builder {

        private SaleData saleData;
        private CardAcquisitionTransaction cardAcquisitionTransaction;

        public Builder() {
        }

        Builder(SaleData saleData, CardAcquisitionTransaction cardAcquisitionTransaction) {
            this.saleData = saleData;
            this.cardAcquisitionTransaction = cardAcquisitionTransaction;
        }

        public Builder saleData(SaleData saleData) {
            this.saleData = saleData;
            return Builder.this;
        }

        public Builder cardAcquisitionTransaction(CardAcquisitionTransaction cardAcquisitionTransaction) {
            this.cardAcquisitionTransaction = cardAcquisitionTransaction;
            return Builder.this;
        }

        public CardAcquisitionRequest build() {
            if (this.saleData == null) {
                throw new NullPointerException("The property \"saleData\" is null. "
                        + "Please set the value by \"saleData()\". "
                        + "The property \"saleData\" is required.");
            }

            return new CardAcquisitionRequest(this);
        }
    }

    private CardAcquisitionRequest(Builder builder) {
        this.saleData = builder.saleData;
        this.cardAcquisitionTransaction = builder.cardAcquisitionTransaction;
    }

    @Override
    public String toJson() {
        Moshi moshi = new Moshi.Builder()
                .add(new BigDecimalAdapter())
                .add(new InstantAdapter())
                .build();
        JsonAdapter<CardAcquisitionRequest> jsonAdapter = moshi.adapter(CardAcquisitionRequest.class);
        return jsonAdapter.toJson(this);
    }
}


/*
package au.com.dmg.fusionsatellite.PaymentRequest
class CardAcquisitionRequest
@Required SaleData saleData
CardAcquisitionTransaction cardAcquisitionTransaction
* */