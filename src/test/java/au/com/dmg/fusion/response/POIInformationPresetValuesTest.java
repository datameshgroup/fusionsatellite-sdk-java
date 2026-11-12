package au.com.dmg.fusion.response;

import au.com.dmg.fusion.response.responseextensiondata.POIInformation;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/** Covers the PresetValues array added to POIInformation (TTF-234). */
public class POIInformationPresetValuesTest {

    private final JsonAdapter<POIInformation> adapter = new Moshi.Builder().build().adapter(POIInformation.class);

    @Test
    public void presetValues_nullByDefault() {
        assertNull(new POIInformation.Builder().tid("xxtid").build().getPresetValues());
    }

    @Test
    public void presetValues_roundTripsThroughJson() throws IOException {
        POIInformation poiInformation = new POIInformation.Builder()
                .tid("xxtid")
                .presetValues(Arrays.asList(10.0, 20.5, 30.0))
                .build();

        POIInformation deserialized = adapter.fromJson(adapter.toJson(poiInformation));

        assertEquals(Arrays.asList(10.0, 20.5, 30.0), deserialized.getPresetValues());
    }

    @Test
    public void presetValues_parsesIntegerJsonNumbers() throws IOException {
        POIInformation deserialized = adapter.fromJson("{\"TID\":\"xxtid\",\"PresetValues\":[25,50,100,200]}");

        assertEquals(Arrays.asList(25.0, 50.0, 100.0, 200.0), deserialized.getPresetValues());
    }
}
