package au.com.dmg.fusion.request.paymentrequest;

import au.com.dmg.fusion.data.CustomFieldType;
import com.squareup.moshi.Json;
import org.jetbrains.annotations.NotNull;

public class CustomField {
    @Json(name = "Key")
    private final String Key;
    @Json(name = "Type")
    private final CustomFieldType Type;
    @Json(name = "Value")
    private final String Value;

    @NotNull
    public String getKey() {
        return Key;
    }

    @NotNull
    public CustomFieldType getType() {
        return Type;
    }

    @NotNull
    public String getValue() {
        return Value;
    }

    public static class Builder {
        private String Key;
        private CustomFieldType Type;
        private String Value;

        public Builder() {
        }

        Builder(String Key, CustomFieldType Type, String Value){
            this.Key = Key;
            this.Type = Type;
            this.Value = Value;
        }

        public Builder Key(String Key) {
            this.Key = Key;
            return Builder.this;
        }

        public Builder Type(CustomFieldType Type) {
            this.Type = Type;
            return Builder.this;
        }

        public Builder Value(String Value) {
            this.Value = Value;
            return Builder.this;
        }

        public CustomField build() {
            if(this.Key == null){
                throw new NullPointerException("The property \"Key\" is null. "
                        + "Please set the Value by \"Key()\". "
                        + "the properties \"Key\", \"Type\", and \"Value\" are required.");
            }
            if(this.Type == null){
                throw new NullPointerException("The property \"Type\" is null. "
                        + "Please set the Value by \"Type(CustomFieldType.<Type>)\". "
                        + "the properties \"Key\", \"Type\", and \"Value\" are required.");
            }
            if(this.Value == null){
                throw new NullPointerException("The property \"Value\" is null. "
                        + "Please set the Value by \"Value()\". "
                        + "the properties \"Key\", \"Type\", and \"Value\" are required.");
            }
            
            return new CustomField(this);
        }
    }
    private CustomField(Builder builder) {
        this.Key = builder.Key;
        this.Type = builder.Type;
        this.Value = builder.Value;
    }
}
