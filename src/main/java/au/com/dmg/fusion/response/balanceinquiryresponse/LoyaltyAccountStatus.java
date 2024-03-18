package au.com.dmg.fusion.response.balanceinquiryresponse;

import au.com.dmg.fusion.data.LoyaltyUnit;
import au.com.dmg.fusion.response.paymentresponse.LoyaltyAccount;
import au.com.dmg.fusion.response.paymentresponse.PaymentAcquirerData;
import au.com.dmg.fusion.response.paymentresponse.PaymentInstrumentData;
import com.squareup.moshi.Json;

import java.math.BigDecimal;

public class LoyaltyAccountStatus {
    @Json(name = "LoyaltyAccount")
    private final LoyaltyAccount loyaltyAccount;
    @Json(name = "CurrentBalance")
    private final BigDecimal currentBalance;
    @Json(name = "LoyaltyUnit")
    private final LoyaltyUnit loyaltyUnit;
    @Json(name = "Currency")
    private final String currency;

    public LoyaltyAccount getLoyaltyAccount(){ return loyaltyAccount; }
    public BigDecimal getCurrentBalance() { return currentBalance; }
    public LoyaltyUnit getLoyaltyUnit(){ return loyaltyUnit; }
    public String getCurrency() { return currency; }

    public static class Builder {
        private LoyaltyAccount loyaltyAccount;
        private BigDecimal currentBalance;
        private LoyaltyUnit loyaltyUnit;
        private String currency;

        public Builder() {
        }

        Builder(LoyaltyAccount loyaltyAccount, BigDecimal currentBalance, LoyaltyUnit loyaltyUnit, String currency) {
            this.loyaltyAccount = loyaltyAccount;
            this.currentBalance = currentBalance;
            this.loyaltyUnit = loyaltyUnit;
            this.currency = currency;
        }

        public Builder loyaltyAccount(LoyaltyAccount loyaltyAccount){
            this.loyaltyAccount = loyaltyAccount;
            return Builder.this;
        }
        public Builder currentBalance(BigDecimal currentBalance){
            this.currentBalance = currentBalance;
            return Builder.this;
        }
        public Builder loyaltyUnit(LoyaltyUnit loyaltyUnit){
            this.loyaltyUnit = loyaltyUnit;
            return Builder.this;
        }
        public Builder currency(String currency){
            this.currency = currency;
            return Builder.this;
        }

        public LoyaltyAccountStatus build() {
            return new LoyaltyAccountStatus(this);
        }
    }

    private LoyaltyAccountStatus(Builder builder){
        this.loyaltyAccount = builder.loyaltyAccount;
        this.currentBalance = builder.currentBalance;
        this.loyaltyUnit = builder.loyaltyUnit;
        this.currency = builder.currency;
    }

}
