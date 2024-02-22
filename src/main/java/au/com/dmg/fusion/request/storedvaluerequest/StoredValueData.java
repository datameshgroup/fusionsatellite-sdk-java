package au.com.dmg.fusion.request.storedvaluerequest;

import au.com.dmg.fusion.data.StoredValueInformation;
import au.com.dmg.fusion.request.paymentrequest.OriginalPOITransaction;
import com.squareup.moshi.Json;

public class StoredValueData extends StoredValueInformation {
    @Json(name = "StoredValueProvider")
    private final String storedValueProvider;
    private final StoredValueAccountID storedValueAccountID;
    @Json(name = "OriginalPOITransaction")
    private final OriginalPOITransaction originalPOITransaction;

    public String getStoredValueProvider() {
        return storedValueProvider;
    }

    public StoredValueAccountID getStoredValueAccountID() {
        return storedValueAccountID;
    }

    public OriginalPOITransaction getOriginalPOITransaction() {
        return originalPOITransaction;
    }


    public static class Builder extends StoredValueInformation.Builder {
        private String storedValueProvider;
        private StoredValueAccountID storedValueAccountID;
        private OriginalPOITransaction originalPOITransaction;

        public Builder() {
        }

        Builder(String storedValueProvider, StoredValueAccountID storedValueAccountID, OriginalPOITransaction originalPOITransaction){
            this.storedValueProvider = storedValueProvider;
            this.storedValueAccountID = storedValueAccountID;
            this.originalPOITransaction = originalPOITransaction;
        }

        public Builder storedValueProvider(String storedValueProvider) {
            this.storedValueProvider = storedValueProvider;
            return Builder.this;
        }

        public Builder storedValueAccountID(StoredValueAccountID storedValueAccountID) {
            this.storedValueAccountID = storedValueAccountID;
            return Builder.this;
        }

        public Builder originalPOITransaction(OriginalPOITransaction originalPOITransaction) {
            this.originalPOITransaction = originalPOITransaction;
            return Builder.this;
        }

        public StoredValueData build() {
            if (this.storedValueTransactionType == null) {
                throw new NullPointerException("The property \"storedValueTransactionType\" is null. "
                        + "Please set the value by \"storedValueTransactionType()\". "
                        + "The property \"storedValueTransactionType\" is required.");
            }
            return new StoredValueData(this);
        }
    }

    public StoredValueData(Builder builder) {
        super(builder);
        this.storedValueProvider = builder.storedValueProvider;
        this.storedValueAccountID = builder.storedValueAccountID;
        this.originalPOITransaction = builder.originalPOITransaction;
    }
}
