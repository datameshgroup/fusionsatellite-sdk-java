package au.com.dmg.fusion.request.paymentrequest;

import au.com.dmg.fusion.data.CustomFieldType;
import com.squareup.moshi.Json;
import org.jetbrains.annotations.NotNull;
import java.lang.reflect.Array;


public class CustomField {
    @Json(name = "Key")
    private final String key;
    @Json(name = "Type")
    private final CustomFieldType type;
    @Json(name = "Value")
    private final String value;

    @NotNull
    public String getKey() {
        return key;
    }

    @NotNull
    public CustomFieldType getType() {
        return type;
    }

    @NotNull
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

        public Builder value(Integer value) {
            this.value = value.toString();
            this.type = CustomFieldType.Integer;
            return Builder.this;
        }
        public Builder value(Array value) {
            this.value = value.toString();
            this.type = CustomFieldType.Array;
            return Builder.this;
        }
        public Builder value(Number value) {
            this.value = value.toString();
            this.type = CustomFieldType.Number;
            return Builder.this;
        }
        public Builder value(Object value) {
            this.value = value.toString();
            this.type = CustomFieldType.Object;
            return Builder.this;
        }

        public Builder value(Boolean value) {
            this.value = value.toString();
            this.type = CustomFieldType.Boolean;
            return Builder.this;
        }

        public CustomField build() {
            if(this.key == null){
                throw new NullPointerException("The property \"Key\" is null. "
                        + "Please set the Value by \"Key()\". "
                        + "the properties \"Key\", \"Type\", and \"Value\" are required.");
            }
            if(this.type == null){
                throw new NullPointerException("The property \"Type\" is null. "
                        + "Please set the Value by \"Type(CustomFieldType.<Type>)\". "
                        + "the properties \"Key\", \"Type\", and \"Value\" are required.");
            }
            if(this.value == null){
                throw new NullPointerException("The property \"Value\" is null. "
                        + "Please set the Value by \"Value()\". "
                        + "the properties \"Key\", \"Type\", and \"Value\" are required.");
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
