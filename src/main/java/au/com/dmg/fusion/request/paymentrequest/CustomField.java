package au.com.dmg.fusion.request.paymentrequest;

import au.com.dmg.fusion.data.CustomFieldType;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.Moshi;
import okio.Buffer;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;


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

        Builder(String key, CustomFieldType type, String value) {
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

        /**
         * @param value the value should be valid JSON, serialized as a String.
         *              e.g [1,2,3,4] should be "[1,2,3,4]", with a type of Array
         *              true should be "true" with a type of Boolean
         *              321.5 should be "321.5" with a type of Number
         *              {a:"hello world"} should be "{a:\"hello world\"}"
         * @return
         */
        public Builder value(String value) {
            this.value = value;
            return Builder.this;
        }

        public Builder value(int value) {
            this.value = Integer.toString(value);
            this.type = CustomFieldType.Integer;
            return Builder.this;
        }

        public Builder value(double value) {
            this.value = Double.toString(value);
            this.type = CustomFieldType.Number;
            return Builder.this;
        }

        public Builder value(boolean value) {
            this.value = Boolean.toString(value);
            this.type = CustomFieldType.Boolean;
            return Builder.this;
        }

        public CustomField build() {
            if (this.key == null) {
                throw new NullPointerException("The property \"Key\" is null. "
                        + "Please set the Value by \"Key()\". "
                        + "the properties \"Key\", \"Type\", and \"Value\" are required.");
            }
            if (this.type == null) {
                throw new NullPointerException("The property \"Type\" is null. "
                        + "Please set the Value by \"Type(CustomFieldType.<Type>)\". "
                        + "the properties \"Key\", \"Type\", and \"Value\" are required.");
            }
            if (this.value == null) {
                throw new NullPointerException("The property \"Value\" is null. "
                        + "Please set the Value by \"Value()\". "
                        + "the properties \"Key\", \"Type\", and \"Value\" are required.");
            }

            if (this.type == CustomFieldType.Array) {
                if(!isValidJsonArray(this.value)){
                    throw new IllegalArgumentException("Error " + this.value + " is not a valid JSON array");
                }
            } else if (this.type == CustomFieldType.Boolean) {
                if (!this.value.equals("true") && !this.value.equals("false")) {
                    throw new IllegalArgumentException("Error " + this.value + " must either be 'true' or 'false'");
                }
            } else if (this.type == CustomFieldType.Integer) {
                try {
                    Integer i = Integer.valueOf(this.value);
                } catch (NumberFormatException err) {
                    throw new IllegalArgumentException("Error " + this.value + " is not a valid integer.");
                }
            } else if (this.type == CustomFieldType.Number) {
                try {
                    Double d = Double.valueOf(this.value);
                } catch (NumberFormatException err) {
                    throw new IllegalArgumentException("Error " + this.value + " is not a valid decimal point number");
                }
            } else if (this.type == CustomFieldType.Object) {
                if (!isValidJsonObject(this.value)) {
                    throw new IllegalArgumentException("Error " + this.value + " is not a valid JSON Object");
                }
            } else if (this.type == CustomFieldType.Unknown) {
                throw new IllegalArgumentException("Error unknown type used for data. do not used this.");
            }

            return new CustomField(this);
        }
    }

    private CustomField(Builder builder) {
        this.key = builder.key;
        this.type = builder.type;
        this.value = builder.value;
    }

    private static boolean isValidJsonArray(String jsonString) {
        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<Object> jsonAdapter = moshi.adapter(Object.class).lenient();
        BufferedSource source = new Buffer().writeUtf8(jsonString);
        JsonReader jsonReader = JsonReader.of(source);
        try {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                jsonAdapter.fromJson(jsonReader);
            }
            jsonReader.endArray();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isValidJsonObject(String jsonString) {
        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<Object> jsonAdapter = moshi.adapter(Object.class).lenient();
        try {
            BufferedSource source = new Buffer().writeUtf8(jsonString);
            JsonReader jsonReader = JsonReader.of(source);

            if (jsonReader.peek() != JsonReader.Token.BEGIN_OBJECT) {
                return false;
            }
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                jsonReader.nextName();
                jsonAdapter.fromJson(jsonReader);
            }
            jsonReader.endObject();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
