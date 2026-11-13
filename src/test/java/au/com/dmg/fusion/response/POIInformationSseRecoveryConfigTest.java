package au.com.dmg.fusion.response;

import au.com.dmg.fusion.response.responseextensiondata.POIInformation;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/** Covers the SSE recovery timing values added to POIInformation (TTF-236). */
public class POIInformationSseRecoveryConfigTest {

    private final JsonAdapter<POIInformation> adapter = new Moshi.Builder().build().adapter(POIInformation.class);

    @Test
    public void sseValues_nullByDefaultAndOmittedFromJson() {
        POIInformation poi = new POIInformation.Builder().tid("xxtid").build();

        assertNull(poi.getSseHeartbeatTimeoutSeconds());
        assertNull(poi.getSseFallbackDeadlineMinutes());
        assertFalse(adapter.toJson(poi).contains("Sse"));
    }

    @Test
    public void sseValues_roundTripThroughJson() throws IOException {
        POIInformation poi = new POIInformation.Builder()
                .tid("xxtid")
                .sseHeartbeatTimeoutSeconds(30)
                .sseMaintenanceAfterSeconds(90)
                .sseReconnectIntervalSeconds(5)
                .sseMaintenanceProbeSeconds(60)
                .sseFallbackDeadlineMinutes(30)
                .build();

        String json = adapter.toJson(poi);
        assertTrue(json.contains("\"SseMaintenanceAfterSeconds\":90"));
        POIInformation back = adapter.fromJson(json);

        assertEquals(Integer.valueOf(30), back.getSseHeartbeatTimeoutSeconds());
        assertEquals(Integer.valueOf(90), back.getSseMaintenanceAfterSeconds());
        assertEquals(Integer.valueOf(5), back.getSseReconnectIntervalSeconds());
        assertEquals(Integer.valueOf(60), back.getSseMaintenanceProbeSeconds());
        assertEquals(Integer.valueOf(30), back.getSseFallbackDeadlineMinutes());
    }
}
