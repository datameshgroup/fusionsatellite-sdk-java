package au.com.dmg.fusion.response.responseextensiondata;

import com.squareup.moshi.Json;

public class EncryptedSecret {
    @Json(name = "iv")
    private final String iv;
    @Json(name = "data")
    private final String data;

    public EncryptedSecret(Builder builder) {
        this.iv = builder.iv;
        this.data = builder.data;
    }

    public String getIv() {
        return iv;
    }

    public String getData() {
        return data;
    }

    public static class Builder {
        private String iv;
        private String data;

        public Builder() {
        }

        public Builder iv(String iv) {
            this.iv = iv;
            return this;
        }

        public Builder data(String data) {
            this.data = data;
            return this;
        }

        public EncryptedSecret build() {
            return new EncryptedSecret(this);
        }
    }
}
