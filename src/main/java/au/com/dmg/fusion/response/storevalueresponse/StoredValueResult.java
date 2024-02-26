package au.com.dmg.fusion.response.storevalueresponse;

import au.com.dmg.fusion.data.StoredValueInformation;
import com.squareup.moshi.Json;


public class StoredValueResult extends StoredValueInformation {
    @Json(name = "StoredValueAccountStatus")
    private final StoredValueAccountStatus storedValueAccountStatus;

    public StoredValueAccountStatus getStoredValueAccountStatus(){ return storedValueAccountStatus; }

    public static class Builder extends StoredValueInformation.Builder {
        private StoredValueAccountStatus storedValueAccountStatus;

        public Builder() {
        }

        Builder(StoredValueAccountStatus storedValueAccountStatus){
            this.storedValueAccountStatus = storedValueAccountStatus;
        }

        public Builder storedValueAccountStatus(StoredValueAccountStatus storedValueAccountStatus){
            this.storedValueAccountStatus = storedValueAccountStatus;
            return Builder.this;
        }

        public StoredValueResult build() {
            if (this.storedValueTransactionType == null) {
                throw new NullPointerException("The property \"storedValueTransactionType\" is null. "
                        + "Please set the value by \"storedValueTransactionType()\". "
                        + "The property \"storedValueTransactionType\" is required.");
            }
            return new StoredValueResult(this);
        }
    }
    protected StoredValueResult(Builder builder) {
        super(builder);
        this.storedValueAccountStatus = builder.storedValueAccountStatus;
    }
}
