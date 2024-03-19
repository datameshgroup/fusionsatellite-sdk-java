package au.com.dmg.fusion.response.balanceinquiryresponse;

import au.com.dmg.fusion.response.paymentresponse.PaymentAcquirerData;
import au.com.dmg.fusion.response.paymentresponse.PaymentInstrumentData;
import com.squareup.moshi.Json;

import java.math.BigDecimal;

public class PaymentAccountStatus {
    @Json(name = "PaymentInstrumentData")
    private final PaymentInstrumentData paymentInstrumentData;
    @Json(name = "Currency")
    private final String currency;
    @Json(name = "CurrentBalance")
    private final BigDecimal currentBalance;
    @Json(name = "PaymentAcquirerData")
    private final PaymentAcquirerData paymentAcquirerData;

    public PaymentInstrumentData getPaymentInstrumentData() { return  paymentInstrumentData; }
    public String getCurrency(){ return currency; }
    public BigDecimal getCurrentBalance() { return currentBalance; }
    public PaymentAcquirerData getPaymentAcquirerData() { return paymentAcquirerData; }

    public static class Builder {
        private PaymentInstrumentData paymentInstrumentData;
        private String currency;
        private BigDecimal currentBalance;
        private PaymentAcquirerData paymentAcquirerData;

        public Builder() {
        }

        Builder(PaymentInstrumentData paymentInstrumentData, String currency, BigDecimal currentBalance, PaymentAcquirerData paymentAcquirerData) {
            this.paymentInstrumentData = paymentInstrumentData;
            this.currency = currency;
            this.currentBalance = currentBalance;
            this.paymentAcquirerData = paymentAcquirerData;
        }

        public Builder paymentInstrumentData(PaymentInstrumentData paymentInstrumentData){
            this.paymentInstrumentData = paymentInstrumentData;
            return Builder.this;
        }
        public Builder currency(String currency){
            this.currency = currency;
            return Builder.this;
        }
        public Builder currentBalance(BigDecimal currentBalance){
            this.currentBalance = currentBalance;
            return Builder.this;
        }
        public Builder paymentAcquirerData(PaymentAcquirerData paymentAcquirerData){
            this.paymentAcquirerData = paymentAcquirerData;
            return Builder.this;
        }
        public PaymentAccountStatus build() {
            if(this.currentBalance==null){
                throw new NullPointerException("The property \"currentBalance\" is null. "
                        + "Please set the value by \"currentBalance()\". "
                        + "The property \"currentBalance\" is required.");
            }
            if(this.currency==null || this.currency.isEmpty()){
                throw new NullPointerException("The property \"currency\" is null or empty. "
                        + "Please set the value by \"currency()\". "
                        + "The property \"currency\" is required.");
            }
            if(this.paymentInstrumentData != null){
                if(this.paymentInstrumentData.getCardData().getEntryMode() == null){
                    throw new NullPointerException("The property \"entryMode\" is null. "
                            + "Please set the value by \"entryMode()\" under paymentInstrumentData.cardData. "
                            + "The properties \"entryMode\", \"paymentBrand\", \"paymentBrandId\", \"paymentBrandLabel\", and \"maskedPAN\" are required.");
                }
                if(this.paymentInstrumentData.getCardData().getPaymentBrand() == null){
                    throw new NullPointerException("The property \"paymentBrand\" is null. "
                            + "Please set the value by \"paymentBrand()\" under paymentInstrumentData.cardData. "
                            + "The properties \"entryMode\", \"paymentBrand\", \"paymentBrandId\", \"paymentBrandLabel\", and \"maskedPAN\" are required.");
                }
                if(this.paymentInstrumentData.getCardData().getPaymentBrandId() == null){
                    throw new NullPointerException("The property \"paymentBrandId\" is null. "
                            + "Please set the value by \"paymentBrandId()\" under paymentInstrumentData.cardData. "
                            + "The properties \"entryMode\", \"paymentBrand\", \"paymentBrandId\", \"paymentBrandLabel\", and \"maskedPAN\" are required.");
                }
                if(this.paymentInstrumentData.getCardData().getPaymentBrandLabel() == null){
                    throw new NullPointerException("The property \"paymentBrandLabel\" is null. "
                            + "Please set the value by \"paymentBrandLabel()\" under paymentInstrumentData.cardData. "
                            + "The properties \"entryMode\", \"paymentBrand\", \"paymentBrandId\", \"paymentBrandLabel\", and \"maskedPAN\" are required.");
                }
                if(this.paymentInstrumentData.getCardData().getMaskedPAN() == null){
                    throw new NullPointerException("The property \"getMaskedPAN\" is null. "
                            + "Please set the value by \"getMaskedPAN()\" under paymentInstrumentData.cardData. "
                            + "The properties \"entryMode\", \"paymentBrand\", \"paymentBrandId\", \"paymentBrandLabel\", and \"maskedPAN\" are required.");
                }
            }
            return new PaymentAccountStatus(this);
        }

    }
    private PaymentAccountStatus(Builder builder) {
        this.paymentInstrumentData = builder.paymentInstrumentData;
        this.currency = builder.currency;
        this.currentBalance = builder.currentBalance;
        this.paymentAcquirerData = builder.paymentAcquirerData;
    }
}
