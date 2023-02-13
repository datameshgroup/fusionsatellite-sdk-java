package au.com.dmg.fusion.request.paymentrequest;

import au.com.dmg.fusion.data.CustomFieldType;
import com.squareup.moshi.Json;

public class CustomField {
    @Json(name = "key")
    private final String key;
    @Json(name = "type")
    private final CustomFieldType type;
    @Json(name = "value")
    private final String value;

    public String getKey() {
        return key;
    }
    public CustomFieldType getType() {
        return type;
    }
    public String getValue() {
        return value;
    }

    public static class Builder {
        private String key;
        private CustomFieldType type;
        private String value;

        public Builder() {
        }

        Builder(String key, CustomFieldType type, String value){
            this.key = key;
            this.type = type;
            this.value = value;
        }

        public Builder key(String key) {
            this.key = key;
            return Builder.this;
        }

        public Builder type(CustomFieldType type) {
            this.type = type;
            return Builder.this;
        }

        public Builder value(String value) {
            this.value = value;
            return Builder.this;
        }

        public CustomField build() {
            if(this.key == null){
                throw new NullPointerException("The property \"key\" is null. "
                        + "Please set the value by \"key()\". "
                        + "the properties \"key\", \"type\", and \"value\" are required.");
            }
            if(this.type == null){
                throw new NullPointerException("The property \"type\" is null. "
                        + "Please set the value by \"type(CustomFieldType.<type>)\". "
                        + "the properties \"key\", \"type\", and \"value\" are required.");
            }
            if(this.value == null){
                throw new NullPointerException("The property \"value\" is null. "
                        + "Please set the value by \"value()\". "
                        + "the properties \"key\", \"type\", and \"value\" are required.");
            }
            
            return new CustomField(this);
        }
    }
    private CustomField(Builder builder) {
        this.key = builder.key;
        this.type = builder.type;
        this.value = builder.value;
    }
}
