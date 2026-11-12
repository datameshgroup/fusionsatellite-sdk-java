package au.com.dmg.fusion.response;

import au.com.dmg.fusion.response.responseextensiondata.EncryptedSecret;
import au.com.dmg.fusion.response.responseextensiondata.POIInformation;
import au.com.dmg.fusion.response.responseextensiondata.ReceiptPlatformConfig;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Covers the new plaintext `Secret` field added to ReceiptPlatformConfig (TTF-123), alongside
 * the pre-existing Url/ClientId/EncryptedSecret fields.
 */
public class ReceiptPlatformConfigTest {

    @Test
    public void builder_roundTrip_includesPlaintextSecret() {
        ReceiptPlatformConfig config = new ReceiptPlatformConfig.Builder()
                .url("https://receipts.example.com")
                .clientId("client-123")
                .secret("plaintext-secret")
                .encryptedSecret(new EncryptedSecret.Builder()
                        .iv("iv-value")
                        .data("encrypted-data-value")
                        .build())
                .build();

        assertEquals("https://receipts.example.com", config.getUrl());
        assertEquals("client-123", config.getClientId());
        assertEquals("plaintext-secret", config.getSecret());
        assertEquals("iv-value", config.getEncryptedSecret().getIv());
        assertEquals("encrypted-data-value", config.getEncryptedSecret().getData());
    }

    @Test
    public void builder_withoutEncryptedSecret_secretStillSet() {
        ReceiptPlatformConfig config = new ReceiptPlatformConfig.Builder()
                .url("https://receipts.example.com")
                .clientId("client-123")
                .secret("plaintext-secret")
                .build();

        assertEquals("plaintext-secret", config.getSecret());
        assertNull(config.getEncryptedSecret());
    }

    @Test
    public void json_serializesAndDeserializesPlaintextSecretField() throws IOException {
        POIInformation poiInformation = new POIInformation.Builder()
                .tid("xxtid")
                .mid("xxmid")
                .receiptPlatformConfig(new ReceiptPlatformConfig.Builder()
                        .url("https://receipts.example.com")
                        .clientId("client-123")
                        .secret("plaintext-secret")
                        .build())
                .build();

        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<POIInformation> jsonAdapter = moshi.adapter(POIInformation.class);
        String json = jsonAdapter.toJson(poiInformation);

        // The wire field name is "Secret" - confirm it round-trips through JSON, not just the
        // in-memory builder/getter pair.
        assert (json.contains("\"Secret\":\"plaintext-secret\""));

        POIInformation deserialized = jsonAdapter.fromJson(json);
        assertEquals("plaintext-secret", deserialized.getReceiptPlatformConfig().getSecret());
        assertEquals("https://receipts.example.com", deserialized.getReceiptPlatformConfig().getUrl());
        assertEquals("client-123", deserialized.getReceiptPlatformConfig().getClientId());
    }
}
