package au.com.dmg.fusion.request.storedvaluerequest;

import au.com.dmg.fusion.data.EntryMode;
import au.com.dmg.fusion.data.IdentificationType;
import au.com.dmg.fusion.data.StoredValueAccountType;
import au.com.dmg.fusion.request.Request;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

public class StoredValueAccountID implements Request {
    @Json(name = "StoredValueAccountType")
    private final StoredValueAccountType storedValueAccountType;
    @Json(name = "StoredValueProvider")
    private final String storedValueProvider;
    @Json(name = "OwnerName")
    private final String ownerName;
    @Json(name = "ExpiryDate")
    private final String expiryDate;
    @Json(name = "EntryMode")
    private final EntryMode entryMode;
    @Json(name = "IdentificationType")
    private final IdentificationType identificationType;
    @Json(name = "StoredValueID")
    private final String storedValueID;

    public StoredValueAccountType getStoredValueTransactionType() {
        return storedValueAccountType;
    }

    public String getStoredValueProvider() {
        return storedValueProvider;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public EntryMode getEntryMode() {
        return entryMode;
    }

    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    public String getStoredValueID() {
        return storedValueID;
    }

    public static class Builder{
        private StoredValueAccountType storedValueAccountType;
        private String storedValueProvider;
        private String ownerName;
        private String expiryDate;
        private EntryMode entryMode;
        private IdentificationType identificationType;
        private String storedValueID;

        public Builder(){}

        public Builder(StoredValueAccountType storedValueAccountType, String storedValueProvider, String ownerName, String expiryDate, EntryMode entryMode, IdentificationType identificationType, String storedValueID) {
            this.storedValueAccountType = storedValueAccountType;
            this.storedValueProvider = storedValueProvider;
            this.ownerName = ownerName;
            this.expiryDate = expiryDate;
            this.entryMode = entryMode;
            this.identificationType = identificationType;
            this.storedValueID = storedValueID;
        }

        public Builder storedValueAccountType(StoredValueAccountType storedValueAccountType){
            this.storedValueAccountType = storedValueAccountType;
            return Builder.this;
        }

        public Builder storedValueProvider(String storedValueProvider){
            this.storedValueProvider = storedValueProvider;
            return Builder.this;
        }

        public Builder ownerName(String ownerName){
            this.ownerName = ownerName;
            return Builder.this;
        }

        public Builder expiryDate(String expiryDate){
            this.expiryDate = expiryDate;
            return Builder.this;
        }

        public Builder entryMode(EntryMode entryMode){
            this.entryMode = entryMode;
            return Builder.this;
        }

        public Builder identificationType(IdentificationType identificationType) {
            this.identificationType = identificationType;
            return Builder.this;
        }

        public Builder storedValueID(String storedValueID) {
            this.storedValueID = storedValueID;
            return Builder.this;
        }

        public StoredValueAccountID build(){
            if(this.storedValueAccountType == null){
                throw new NullPointerException("The property \"storedValueAccountType\" is null. "
                        + "Please set the value by \"storedValueAccountType()\" under StoredValueAccountID. "
                        + "The properties \"storedValueAccountType\", \"identificationType\", and \"storedValueID\" are required.");
            }
            if(this.identificationType == null){
                throw new NullPointerException("The property \"identificationType\" is null. "
                        + "Please set the value by \"identificationType()\" under StoredValueAccountID. "
                        + "The properties \"storedValueAccountType\", \"identificationType\", and \"storedValueID\" are required.");
            }
            if(this.storedValueID == null || this.storedValueID.isEmpty()){
                throw new NullPointerException("The property \"storedValueID\" is null or empty. "
                        + "Please set the value by \"storedValueID()\" under StoredValueAccountID. "
                        + "The properties \"storedValueAccountType\", \"identificationType\", and \"storedValueID\" are required.");
            }
            return new StoredValueAccountID(this);
        }
    }
    public StoredValueAccountID(Builder builder) {
        this.storedValueAccountType = builder.storedValueAccountType;
        this.storedValueProvider = builder.storedValueProvider;
        this.ownerName = builder.ownerName;
        this.expiryDate = builder.expiryDate;
        this.entryMode = builder.entryMode;
        this.identificationType = builder.identificationType;
        this.storedValueID = builder.storedValueID;
    }


    @Override
    public String toJson() {
        Moshi moshi = new Moshi.Builder()
                .build();
        JsonAdapter<StoredValueAccountID> jsonAdapter = moshi.adapter(StoredValueAccountID.class);
        return jsonAdapter.toJson(this);
    }
}
