package au.com.dmg.fusion.request.storedvaluerequest;

import au.com.dmg.fusion.request.Request;
import au.com.dmg.fusion.request.paymentrequest.SaleData;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.LinkedList;
import java.util.List;

public class StoredValueRequest implements Request {
    @Json(name = "SaleData")
    private final SaleData saleData;
    @Json(name = "StoredValueData")
    private final List<StoredValueData> storedValueData;

    public SaleData getSaleData() {
        return saleData;
    }

    public List<StoredValueData> getStoredValueData() {
        return storedValueData;
    }

    public static class Builder {
        private SaleData saleData;
        private List<StoredValueData> storedValueData;


        public Builder(){}

        Builder(SaleData saleData, List<StoredValueData> storedValueData){
            this.saleData = saleData;
            this.storedValueData = storedValueData;
        }

        public Builder saleData(SaleData saleData){
            this.saleData = saleData;
            return Builder.this;
        }

        public Builder storedValueData(List<StoredValueData> storedValueData){
            this.storedValueData = storedValueData;
            return Builder.this;
        }

        public Builder storedValueData(StoredValueData storedValueData){
            if (this.storedValueData == null){
                this.storedValueData = new LinkedList<>();
            }

            if(storedValueData != null){
                this.storedValueData.add(storedValueData);
            }
            return Builder.this;
        }

        public Builder addStoredValueData(StoredValueData storedValueData){
            if (this.storedValueData == null){
                this.storedValueData = new LinkedList<>();
            }

            if(storedValueData != null){
                this.storedValueData.add(storedValueData);
            }
            return Builder.this;
        }

        public StoredValueRequest build() {
            if (this.saleData == null) {
                throw new NullPointerException("The property \"saleData\" is null. "
                        + "Please set the value by \"saleData()\". "
                        + "The properties \"saleData\" and \"storedValueData\" are required.");
            }

            if (this.storedValueData == null) {
                throw new NullPointerException("The property \"storedValueData\" is null. "
                        + "Please set the value by \"storedValueData() or addStoredValueData()\". "
                        + "The properties \"saleData\" and \"storedValueData\" are required.");
            }
            return new StoredValueRequest(this);
        }
    }

    protected StoredValueRequest(Builder builder) {
        this.saleData = builder.saleData;
        this.storedValueData = builder.storedValueData;
    }

    @Override
    public String toJson() {
        Moshi moshi = new Moshi.Builder()
                .build();
        JsonAdapter<StoredValueRequest> jsonAdapter = moshi.adapter(StoredValueRequest.class);
        return jsonAdapter.toJson(this);
    }
}
