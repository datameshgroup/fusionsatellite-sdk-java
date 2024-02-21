package au.com.dmg.fusion.data;

import com.squareup.moshi.Json;

import java.math.BigDecimal;

public class StoredValueInformation {
    @Json(name = "StoredValueTransactionType")
    private final StoredValueTransactionType storedValueTransactionType;
    @Json(name = "ProductCode")
    private final String productCode;
    @Json(name = "EanUpc")
    private final String eanUpc; // A standard unique identifier for the product. Either the UPC, EAN, or ISBN. Required for products with a UPC, EAN, or ISBN
    @Json(name = "ItemAmount")
    private final BigDecimal itemAmount; // Indicates the amount to be loaded onto the account. Exclusive of fees.
    @Json(name = "TotalFeesAmount")
    private final BigDecimal totalFeesAmount; // Total of fees associated with the transaction
    @Json(name = "Currency")
    private final String currency; //Three character(ISO 4217 formatted) currency code.

//    public StoredValueInformation(StoredValueTransactionType storedValueTransactionType, String productCode, String eanUpc, BigDecimal itemAmount, BigDecimal totalFeesAmount, String currency) {
//        this.storedValueTransactionType = storedValueTransactionType;
//        this.productCode = productCode;
//        this.eanUpc = eanUpc;
//        this.itemAmount = itemAmount;
//        this.totalFeesAmount = totalFeesAmount;
//        this.currency = currency;
//    }


    public StoredValueTransactionType getStoredValueTransactionType() {
        return storedValueTransactionType;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getEanUpc() {
        return eanUpc;
    }

    public BigDecimal getItemAmount() {
        return itemAmount;
    }

    public BigDecimal getTotalFeesAmount() {
        return totalFeesAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public static class Builder{
        protected StoredValueTransactionType storedValueTransactionType;
        private String productCode;
        private String eanUpc;
        private BigDecimal itemAmount;
        private BigDecimal totalFeesAmount;
        private String currency;

        public Builder(){
        }

        Builder(StoredValueTransactionType storedValueTransactionType, String productCode, String eanUpc, BigDecimal itemAmount, BigDecimal totalFeesAmount, String currency){
            this.storedValueTransactionType = storedValueTransactionType;
            this.productCode = productCode;
            this.eanUpc = eanUpc;
            this.itemAmount = itemAmount;
            this.totalFeesAmount = totalFeesAmount;
            this.currency = currency;
        }

        public Builder storedValueTransactionType(StoredValueTransactionType storedValueTransactionType){
            this.storedValueTransactionType = storedValueTransactionType;
            return Builder.this;
        }

        public Builder productCode(String productCode){
            this.productCode = productCode;
            return Builder.this;
        }

        public Builder eanUpc(String eanUpc){
            this.eanUpc = eanUpc;
            return Builder.this;
        }

        public Builder itemAmount(BigDecimal itemAmount){
            this.itemAmount = itemAmount;
            return Builder.this;
        }

        public Builder totalFeesAmount(BigDecimal totalFeesAmount){
            this.totalFeesAmount = totalFeesAmount;
            return Builder.this;
        }

        public Builder currency(String currency){
            this.currency = currency;
            return Builder.this;
        }

//        protected StoredValueResult buildResult(){
//            return new StoredValueResult((StoredValueResult.Builder) this);
//        }
//
//        public StoredValueData build(){
//            return new StoredValueData((StoredValueData.Builder) this);
//        }
    public StoredValueInformation build() {
        return new StoredValueInformation(this);
    }
    }

    protected StoredValueInformation(Builder builder) {
        this.storedValueTransactionType = builder.storedValueTransactionType;
        this.productCode = builder.productCode;
        this.eanUpc = builder.eanUpc;
        this.itemAmount = builder.itemAmount;
        this.totalFeesAmount = builder.totalFeesAmount;
        this.currency = builder.currency;

    }
}
