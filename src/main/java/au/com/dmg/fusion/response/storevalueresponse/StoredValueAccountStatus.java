package au.com.dmg.fusion.response.storevalueresponse;

import au.com.dmg.fusion.request.storedvaluerequest.StoredValueAccountID;
import com.squareup.moshi.Json;

import java.math.BigDecimal;

public class StoredValueAccountStatus {
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

        public Builder(){}

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
            if(this.storedValueAccountID == null){
                throw new NullPointerException("The property \"storedValueAccountID\" is null. "
                        + "Please set the value by \"storedValueAccountID()\". "
                        + "The property \"storedValueAccountID\" is required.");
            }
            return new StoredValueAccountStatus(this);
        }
    }

    public StoredValueAccountStatus(Builder builder) {
        this.storedValueAccountID = builder.storedValueAccountID;
        this.currentBalance = builder.currentBalance;
    }

}
