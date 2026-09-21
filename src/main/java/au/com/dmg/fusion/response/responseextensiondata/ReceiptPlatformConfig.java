package au.com.dmg.fusion.response.responseextensiondata;

import com.squareup.moshi.Json;

public class ReceiptPlatformConfig {
    @Json(name = "Url")
    private final String url;
    @Json(name = "ClientId")
    private final String clientId;
    @Json(name = "EncryptedSecret")
    private final EncryptedSecret encryptedSecret;

    public ReceiptPlatformConfig(Builder builder) {
        this.url = builder.url;
        this.clientId = builder.clientId;
        this.encryptedSecret = builder.encryptedSecret;
    }

    public String getUrl() {
        return url;
    }

    public String getClientId() {
        return clientId;
    }

    public EncryptedSecret getEncryptedSecret() {
        return encryptedSecret;
    }

    public static class Builder {
        private String url;
        private String clientId;
        private EncryptedSecret encryptedSecret;

        public Builder() {
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder encryptedSecret(EncryptedSecret encryptedSecret) {
            this.encryptedSecret = encryptedSecret;
            return this;
        }

        public ReceiptPlatformConfig build() {
            return new ReceiptPlatformConfig(this);
        }
    }
}
