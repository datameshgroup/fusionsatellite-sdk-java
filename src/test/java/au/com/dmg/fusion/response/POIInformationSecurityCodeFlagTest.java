package au.com.dmg.fusion.response;

import au.com.dmg.fusion.response.responseextensiondata.POIInformation;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Covers the ComplianceRequiresSecurityCode flag added to POIInformation (TTF-228), alongside the
 * pre-existing DiscountRequiresSecurityCode.
 */
public class POIInformationSecurityCodeFlagTest {

    private final JsonAdapter<POIInformation> adapter = new Moshi.Builder().build().adapter(POIInformation.class);

    @Test
    public void complianceRequiresSecurityCode_defaultsToFalse() {
        POIInformation poiInformation = new POIInformation.Builder().tid("xxtid").build();

        assertFalse(poiInformation.isComplianceRequiresSecurityCode());
    }

    @Test
    public void complianceRequiresSecurityCode_builderSetsValue() {
        POIInformation poiInformation = new POIInformation.Builder()
                .tid("xxtid")
                .complianceRequiresSecurityCode(true)
                .build();

        assertTrue(poiInformation.isComplianceRequiresSecurityCode());
    }

    @Test
    public void complianceRequiresSecurityCode_roundTripsThroughJsonIndependentlyOfDiscountFlag() throws IOException {
        POIInformation poiInformation = new POIInformation.Builder()
                .tid("xxtid")
                .complianceRequiresSecurityCode(true)
                .discountRequiresSecurityCode(false)
                .build();

        String json = adapter.toJson(poiInformation);

        assertTrue(json.contains("\"ComplianceRequiresSecurityCode\":true"));
        POIInformation deserialized = adapter.fromJson(json);
        assertTrue(deserialized.isComplianceRequiresSecurityCode());
        assertFalse(deserialized.isDiscountRequiresSecurityCode());
    }

    @Test
    public void complianceRequiresSecurityCode_absentFromJsonIsFalse() throws IOException {
        POIInformation deserialized = adapter.fromJson("{\"TID\":\"xxtid\",\"DiscountRequiresSecurityCode\":true}");

        assertFalse(deserialized.isComplianceRequiresSecurityCode());
        assertTrue(deserialized.isDiscountRequiresSecurityCode());
    }
}
