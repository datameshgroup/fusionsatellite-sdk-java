package au.com.dmg.fusion.request.storedvaluerequest;

import au.com.dmg.fusion.data.StoredValueInformation;
import au.com.dmg.fusion.data.StoredValueTransactionType;
import au.com.dmg.fusion.request.paymentrequest.OriginalPOITransaction;
import com.squareup.moshi.Json;

import java.math.BigDecimal;

public class StoredValueData extends StoredValueInformation {
    @Json(name = "StoredValueProvider")
    private final String storedValueProvider;
//    @Json(name = "StoredValueTransactionType") //TODO
//    private final StoredValueTransactionType storedValueTransactionType;
    @Json(name = "StoredValueAccountID")
    private final StoredValueAccountID storedValueAccountID;
    @Json(name = "OriginalPOITransaction")
    private final OriginalPOITransaction originalPOITransaction;
//    @Json(name = "ProductCode") //TODO
//    private final String productCode;
//    @Json(name = "EanUpc") //TODO
//    private final String eanUpc; // A standard unique identifier for the product. Either the UPC, EAN, or ISBN. Required for products with a UPC, EAN, or ISBN
//    @Json(name = "ItemAmount")
//    private final BigDecimal itemAmount; // Indicates the amount to be loaded onto the account. Exclusive of fees.
//    @Json(name = "TotalFeesAmount")
//    private final BigDecimal totalFeesAmount; // Total of fees associated with the transaction
//    @Json(name = "Currency")
//    private final String currency; //Three character(ISO 4217 formatted) currency code.

    public String getStoredValueProvider() {
        return storedValueProvider;
    }

//    public StoredValueTransactionType getStoredValueTransactionType() {
//        return storedValueTransactionType;
//    }

    public StoredValueAccountID getStoredValueAccountID() {
        return storedValueAccountID;
    }

    public OriginalPOITransaction getOriginalPOITransaction() {
        return originalPOITransaction;
    }

//    public String getProductCode() {
//        return productCode;
//    }
//
//    public String getEanUpc() {
//        return eanUpc;
//    }
//
//    public BigDecimal getItemAmount() {
//        return itemAmount;
//    }
//
//    public BigDecimal getTotalFeesAmount() {
//        return totalFeesAmount;
//    }
//
//    public String getCurrency() {
//        return currency;
//    }

    public static class Builder extends StoredValueInformation.Builder {
        private String storedValueProvider;
//        private StoredValueTransactionType storedValueTransactionType;
        private StoredValueAccountID storedValueAccountID;
        private OriginalPOITransaction originalPOITransaction;
//        private String productCode;
//        private String eanUpc;
//        private BigDecimal itemAmount;
//        private BigDecimal totalFeesAmount;
//        private String currency;

        public Builder() {
        }

//        Builder(String storedValueProvider, StoredValueTransactionType storedValueTransactionType, StoredValueAccountID storedValueAccountID, OriginalPOITransaction originalPOITransaction, String productCode, String eanUpc, BigDecimal itemAmount, BigDecimal totalFeesAmount, String currency){
Builder(String storedValueProvider, StoredValueAccountID storedValueAccountID, OriginalPOITransaction originalPOITransaction){
            this.storedValueProvider = storedValueProvider;
//            this.storedValueTransactionType = storedValueTransactionType;
            this.storedValueAccountID = storedValueAccountID;
            this.originalPOITransaction = originalPOITransaction;
//            this.productCode = productCode;
//            this.eanUpc = eanUpc;
//            this.itemAmount = itemAmount;
//            this.totalFeesAmount = totalFeesAmount;
//            this.currency = currency;
        }

        public Builder storedValueProvider(String storedValueProvider) {
            this.storedValueProvider = storedValueProvider;
            return Builder.this;
        }

//        public Builder storedValueTransactionType(StoredValueTransactionType storedValueTransactionType){
//            this.storedValueTransactionType = storedValueTransactionType;
//            return Builder.this;
//        }

        public Builder storedValueAccountID(StoredValueAccountID storedValueAccountID) {
            this.storedValueAccountID = storedValueAccountID;
            return Builder.this;
        }

        public Builder originalPOITransaction(OriginalPOITransaction originalPOITransaction) {
            this.originalPOITransaction = originalPOITransaction;
            return Builder.this;
        }

//        public Builder productCode(String productCode){
//            this.productCode = productCode;
//            return Builder.this;
//        }
//
//        public Builder eanUpc(String eanUpc){
//            this.eanUpc = eanUpc;
//            return Builder.this;
//        }
//
//        public Builder itemAmount(BigDecimal itemAmount){
//            this.itemAmount = itemAmount;
//            return Builder.this;
//        }
//
//        public Builder totalFeesAmount(BigDecimal totalFeesAmount){
//            this.totalFeesAmount = totalFeesAmount;
//            return Builder.this;
//        }
//
//        public Builder currency(String currency){
//            this.currency = currency;
//            return Builder.this;
//        }

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
//        this.storedValueTransactionType = builder.storedValueTransactionType;
        this.storedValueProvider = builder.storedValueProvider;
        this.storedValueAccountID = builder.storedValueAccountID;
        this.originalPOITransaction = builder.originalPOITransaction;
//        this.productCode = builder.productCode;
//        this.eanUpc = builder.eanUpc;
//        this.itemAmount = builder.itemAmount;
//        this.totalFeesAmount = builder.totalFeesAmount;
//        this.currency = builder.currency;
    }
}
