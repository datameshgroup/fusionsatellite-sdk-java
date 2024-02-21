package au.com.dmg.fusion.request.storedvaluerequest;

import au.com.dmg.fusion.request.Request;
import au.com.dmg.fusion.util.BigDecimalAdapter;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.math.BigDecimal;

public class StoredValueAccountStatus implements Request {
    @Json(name = "StoredValueAccountID")
    private final StoredValueAccountID storedValueAccountID;
    @Json(name = "CurrentBalance")
    private final BigDecimal currentBalance;

    public StoredValueAccountID getStoredValueAccountID() {
        return storedValueAccountID;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public static class Builder{
        private StoredValueAccountID storedValueAccountID;
        private BigDecimal currentBalance;

        public Builder(StoredValueAccountID storedValueAccountID, BigDecimal currentBalance){
            this.storedValueAccountID = storedValueAccountID;
            this.currentBalance = currentBalance;
        }

        public Builder storedValueAccountID(StoredValueAccountID storedValueAccountID){
            this.storedValueAccountID = storedValueAccountID;
            return Builder.this;
        }

        public Builder currentBalance(BigDecimal currentBalance){
            this.currentBalance = currentBalance;
            return Builder.this;
        }

        public StoredValueAccountStatus build(){
            //TODO validate

            return new StoredValueAccountStatus(this);
        }
    }

    public StoredValueAccountStatus(Builder builder) {
        this.storedValueAccountID = builder.storedValueAccountID;
        this.currentBalance = builder.currentBalance;
    }

    @Override
    public String toJson() {
        Moshi moshi = new Moshi.Builder()
                .add(new BigDecimalAdapter())
                .build();
        JsonAdapter<StoredValueAccountStatus> jsonAdapter = moshi.adapter(StoredValueAccountStatus.class);
        return jsonAdapter.toJson(this);
    }


}
