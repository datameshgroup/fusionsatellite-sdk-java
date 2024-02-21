package au.com.dmg.fusion.response.storevalueresponse;

import au.com.dmg.fusion.data.StoredValueInformation;


public class StoredValueResult extends StoredValueInformation {


    public static class Builder extends StoredValueInformation.Builder {
        public Builder() {
            super();
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
    }
}
