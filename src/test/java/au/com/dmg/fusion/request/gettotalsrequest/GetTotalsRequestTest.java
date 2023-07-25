package au.com.dmg.fusion.request.gettotalsrequest;

import au.com.dmg.fusion.data.SaleCapability;
import au.com.dmg.fusion.data.TotalDetail;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class GetTotalsRequestTest {
    public String shiftNumberValue = "ShiftNumber123";
    GetTotalsRequest getTotalsRequest;
    @Test
    public void testValid(){
        getTotalsRequest = new GetTotalsRequest.Builder()
                .totalDetail(TotalDetail.ShiftTotals)
                .totalFilter(new TotalFilter.Builder()
                        .operatorID("OperatorID123")
                        .shiftNumber("ShiftNumber123")
                        .build())
                .build();
    }
    @Test
    public void testGetTotalsRequestJson(){
        getTotalsRequest = new GetTotalsRequest.Builder()
                .totalDetails(Arrays.asList(TotalDetail.ShiftTotals, TotalDetail.Unknown))
                .totalFilter(new TotalFilter.Builder()
                        .operatorID("OperatorID123")
                        .shiftNumber(shiftNumberValue)
                        .build())
                .build();

        Moshi moshi = new Moshi.Builder()
                .build();
        JsonAdapter<GetTotalsRequest> jsonAdapter = moshi.adapter(GetTotalsRequest.class);
        String json = jsonAdapter.toJson(getTotalsRequest);
        System.out.println(json);

        GetTotalsRequest serializedRequest = null;
        try {
            serializedRequest = jsonAdapter.fromJson(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert (serializedRequest.getTotalFilter().getShiftNumber().equals(shiftNumberValue));
    }
}
