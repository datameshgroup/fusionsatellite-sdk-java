package au.com.dmg.fusion.response.paymentresponse;

import com.squareup.moshi.Json;

import java.math.BigDecimal;

public class AdditionalAmount {
    @Json(name = "Name")
    final private String name;
    @Json(name = "Value")
    final private BigDecimal value;

    public String getName(){ return name; }
    public BigDecimal getValue() { return value; }

    public static class Builder{
        private String name;
        private BigDecimal value;

        public Builder() {
        }
        Builder(String name, BigDecimal value){
            this.name = name;
            this.value = value;
        }
        public Builder name(String name){
            this.name = name;
            return Builder.this;
        }
        public Builder value(BigDecimal value){
            this.value = value;
            return Builder.this;
        }
        public AdditionalAmount build(){
            if (this.name == null) {
                throw new NullPointerException("The property \"AdditionalAmounts.name\" is null. "
                        + "Please set the value by \"AdditionalAmounts.name()\". "
                        + "The AdditionalAmounts properties \"name\" and \"value\" are required.");
            }
            if (this.value == null) {
                throw new NullPointerException("The property \"AdditionalAmounts.value\" is null. "
                        + "Please set the value by \"AdditionalAmounts.value()\". "
                        + "The AdditionalAmounts properties \"name\" and \"value\" are required.");
            }
            return new AdditionalAmount(this);
        }
    }

    public AdditionalAmount(Builder builder) {
        this.name = builder.name;
        this.value = builder.value;
    }
}
