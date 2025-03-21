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

import au.com.dmg.fusion.request.Request;
import au.com.dmg.fusion.request.paymentrequest.extenstiondata.ExtensionData;
import au.com.dmg.fusion.response.paymentresponse.PaymentReceipt;
import au.com.dmg.fusion.util.BigDecimalAdapter;
import au.com.dmg.fusion.util.InstantAdapter;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PaymentRequest implements Request {

    @Json(name = "SaleData")
    private final SaleData saleData;
    @Json(name = "PaymentTransaction")
    private final PaymentTransaction paymentTransaction;
    @Json(name = "PaymentData")
    private final PaymentData paymentData;
    @Json(name = "CustomFields")
    private final List<CustomField> customFields;
    @Json(name = "ExtensionData")
    private final ExtensionData extensionData;
    @Json(name = "PaymentReceipt")
    @Nullable
    private final List<PaymentReceipt> paymentReceipt;

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

    public List<CustomField> getCustomFields() {
        return customFields;
    }

    public ExtensionData getExtensionData() {return extensionData; }
    @Nullable
    public List<PaymentReceipt> getPaymentReceipt() {
        return paymentReceipt;
    }

    public static class Builder {

        private SaleData saleData;
        private PaymentTransaction paymentTransaction;
        private PaymentData paymentData;
        private List<CustomField> customFields  = new ArrayList<>();
        private ExtensionData extensionData;
        private List<PaymentReceipt> paymentReceipt;

        public Builder() {
        }

        Builder(SaleData saleData, PaymentTransaction paymentTransaction, PaymentData paymentData, List<CustomField> customFields, ExtensionData extensionData) {
            this.saleData = saleData;
            this.paymentTransaction = paymentTransaction;
            this.paymentData = paymentData;
            this.customFields = customFields;
            this.extensionData = extensionData;
            this.paymentReceipt = paymentReceipt;
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

        public Builder customFields(List<CustomField> customFields) {
            if(customFields == null){
                this.customFields = new ArrayList<>();
            } else {
                this.customFields = customFields;
            }
            return PaymentRequest.Builder.this;
        }

        public PaymentRequest.Builder addCustomField(CustomField customField) {
            this.customFields.add(customField);
            return PaymentRequest.Builder.this;
        }

        public PaymentRequest.Builder addCustomFields(List<CustomField> customFields) {
            this.customFields.addAll(customFields);
            return PaymentRequest.Builder.this;
        }

        public Builder extensionData(ExtensionData extensionData){
            this.extensionData = extensionData;
            return Builder.this;
        }
        public Builder paymentReceipt(List<PaymentReceipt> paymentReceipt) {
            this.paymentReceipt = paymentReceipt;
            return Builder.this;
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

        public PaymentRequest build() {
            if (this.saleData == null) {
                throw new NullPointerException("The property \"saleData\" is null. "
                        + "Please set the value by \"saleData()\". "
                        + "The properties \"saleData\", \"paymentTransaction\", and \"extensionData\" are required.");
            }
            if (this.paymentTransaction == null) {
                throw new NullPointerException("The property \"paymentTransaction\" is null. "
                        + "Please set the value by \"paymentTransaction()\". "
                        + "The properties \"saleData\", \"paymentTransaction\", and \"extensionData\" are required.");
            }
            if (this.paymentData == null) {
                throw new NullPointerException("The property \"paymentData\" is null. "
                        + "Please set the value by \"paymentData()\". "
                        + "The properties \"amountsReq\", \"paymentData\", and \"extensionData\" are required.");
            }
             return new PaymentRequest(this);
        }
    }

    private PaymentRequest(Builder builder) {
        this.saleData = builder.saleData;
        this.paymentTransaction = builder.paymentTransaction;
        this.paymentData = builder.paymentData;
        this.customFields = builder.customFields;
        this.extensionData = builder.extensionData;
        this.paymentReceipt = builder.paymentReceipt;
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

