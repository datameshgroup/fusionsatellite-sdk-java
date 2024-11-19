package au.com.dmg.fusion.response.storevalueresponse;

import au.com.dmg.fusion.request.paymentrequest.POIData;
import au.com.dmg.fusion.request.paymentrequest.SaleData;
import au.com.dmg.fusion.response.Response;
import au.com.dmg.fusion.response.ResponseResult;
import au.com.dmg.fusion.response.ResponseType;
import au.com.dmg.fusion.response.paymentresponse.PaymentReceipt;
import au.com.dmg.fusion.response.paymentresponse.PaymentResponseSaleData;
import au.com.dmg.fusion.response.reversalresponse.ReversalResponse;
import au.com.dmg.fusion.util.BigDecimalAdapter;
import au.com.dmg.fusion.util.InstantAdapter;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;
import java.util.List;

public class StoredValueResponse implements ResponseType {

    @Json(name = "Response")
    private final Response response;
    @Json(name = "SaleData")
    private final PaymentResponseSaleData saleData;
    @Json(name = "POIData")
    private final POIData poiData;
    @Json(name = "StoredValueResult")
    private final List<StoredValueResult> storedValueResult;
    @Json(name = "PaymentReceipt")
    private final List<PaymentReceipt> paymentReceipt;

    @NotNull
    public Response getResponse() {
        return response;
    }

    @NotNull
    public PaymentResponseSaleData getSaleData() {
        return saleData;
    }

    @NotNull
    public POIData getPoiData() {
        return poiData;
    }

    @Nullable
    public List<StoredValueResult> getStoredValueResult() {
        return storedValueResult;
    }

    @Nullable
    public List<PaymentReceipt> getPaymentReceipt() {
        return paymentReceipt;
    }

    public static class Builder {
        private Response response;
        private PaymentResponseSaleData saleData;
        private POIData poiData;
        private List<StoredValueResult> storedValueResult;
        private List<PaymentReceipt> paymentReceipt;

        public Builder(){}

        Builder(Response response, PaymentResponseSaleData saleData, POIData poiData, List<StoredValueResult> storedValueResult, List<PaymentReceipt> paymentReceipt){
            this.response = response;
            this.saleData = saleData;
            this.poiData = poiData;
            this.storedValueResult = storedValueResult;
            this.paymentReceipt = paymentReceipt;
        }

        public Builder response(Response response) {
            this.response = response;
            return Builder.this;
        }

        public Builder saleData(SaleData saleData) {
            this.saleData = (PaymentResponseSaleData) saleData;
            return Builder.this;
        }

        public Builder poiData(POIData poiData){
            this.poiData = poiData;
            return Builder.this;
        }

        public Builder storedValueResult(List<StoredValueResult> storedValueResult) {
            this.storedValueResult = storedValueResult;
            return Builder.this;
        }

        public Builder storedValueResult(StoredValueResult storedValueResult){
            if (this.storedValueResult == null){
                this.storedValueResult = new LinkedList<>();
            }

            if(storedValueResult != null){
                this.storedValueResult.add(storedValueResult);
            }
            return Builder.this;
        }

        public Builder addStoredValueResult(StoredValueResult storedValueResult){
            if (this.storedValueResult == null){
                this.storedValueResult = new LinkedList<>();
            }

            if(storedValueResult != null){
                this.storedValueResult.add(storedValueResult);
            }
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

        public StoredValueResponse build() {
            if (this.response == null) {
                throw new NullPointerException("The property \"response\" is null. "
                        + "Please set the value by \"response()\". "
                        + "The properties \"response\", \"saleData\" and \"poiData\" are required.");
            }
            else{
                if (this.response.getResult() == ResponseResult.Success){
                    if (this.storedValueResult == null || this.storedValueResult.size() != 1) {
                        throw new NullPointerException("The property \"storedValueResult\" is required if \"response.getResult() == Success\".");
                    }
                }
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

            return new StoredValueResponse(this);
        }
    }

    private StoredValueResponse(Builder builder) {
        this.response = builder.response;
        this.saleData = builder.saleData;
        this.poiData = builder.poiData;
        this.storedValueResult = builder.storedValueResult;
        this.paymentReceipt = builder.paymentReceipt;
    }

    @Override
    public String toJson() {
        Moshi moshi = new Moshi.Builder()
                .add(new BigDecimalAdapter())
                .add(new InstantAdapter())
                .build();
        JsonAdapter<StoredValueResponse> jsonAdapter = moshi.adapter(StoredValueResponse.class);
        return jsonAdapter.toJson(this);
    }
}
