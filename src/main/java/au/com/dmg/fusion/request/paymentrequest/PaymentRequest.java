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

import au.com.dmg.fusion.util.BigDecimalAdapter;
import au.com.dmg.fusion.request.Request;
import au.com.dmg.fusion.util.InstantAdapter;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.jetbrains.annotations.NotNull;

public class PaymentRequest implements Request {

    @Json(name = "SaleData")
    private final SaleData saleData;
    @Json(name = "PaymentTransaction")
    private final PaymentTransaction paymentTransaction;
    @Json(name = "PaymentData")
    private final PaymentData paymentData;

    @NotNull
    public PaymentTransaction getPaymentTransaction() {
        return paymentTransaction;
    }

    @NotNull
    public SaleData getSaleData() {
        return saleData;
    }

    @NotNull
    public PaymentData getPaymentData() {
        return paymentData;
    }

    public static class Builder {

        private SaleData saleData;
        private PaymentTransaction paymentTransaction;
        private PaymentData paymentData;

        public Builder() {
        }

        Builder(SaleData saleData, PaymentTransaction paymentTransaction, PaymentData paymentData) {
            this.saleData = saleData;
            this.paymentTransaction = paymentTransaction;
            this.paymentData = paymentData;
            
        }

        public Builder saleData(SaleData saleData) {
            this.saleData = saleData;
            return Builder.this;
        }

        public Builder paymentTransaction(PaymentTransaction paymentTransaction) {
            this.paymentTransaction = paymentTransaction;
            return Builder.this;
        }

        public PaymentRequest.Builder paymentData(PaymentData paymentData) {
            this.paymentData = paymentData;
            return PaymentRequest.Builder.this;
        }

        public PaymentRequest build() {
            if (this.saleData == null) {
                throw new NullPointerException("The property \"saleData\" is null. "
                        + "Please set the value by \"saleData()\". "
                        + "The properties \"saleData\", \"paymentTransaction\" are required.");
            }
            if (this.paymentTransaction == null) {
                throw new NullPointerException("The property \"paymentTransaction\" is null. "
                        + "Please set the value by \"paymentTransaction()\". "
                        + "The properties \"saleData\", \"paymentTransaction\" are required.");
            }
            if (this.paymentData == null) {
                throw new NullPointerException("The property \"paymentData\" is null. "
                        + "Please set the value by \"paymentData()\". "
                        + "The properties \"amountsReq\", \"paymentData\" are required.");
            }

            return new PaymentRequest(this);
        }
    }

    private PaymentRequest(Builder builder) {
        this.saleData = builder.saleData;
        this.paymentTransaction = builder.paymentTransaction;
        this.paymentData = builder.paymentData;
    }

    @Override
    public String toJson() {
        Moshi moshi = new Moshi.Builder()
                .add(new BigDecimalAdapter())
                .add(new InstantAdapter())
                .build();
        JsonAdapter<PaymentRequest> jsonAdapter = moshi.adapter(PaymentRequest.class);
        return jsonAdapter.toJson(this);
    }
}


/*
package au.com.dmg.fusionsatellite.PaymentRequest
class PaymentRequest
@Required SaleData saleData
@Required PaymentTransaction paymentTransaction

* */

