package au.com.dmg.fusion.request;

import au.com.dmg.fusion.data.ServiceIdentification;
import au.com.dmg.fusion.request.adminrequest.AdminRequest;
import au.com.dmg.fusion.request.gettotalsrequest.GetTotalsRequest;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.junit.Test;

import java.io.IOException;

public class AdminRequestTest {
    @Test
    public void testValid(){
        AdminRequest adminRequest = new AdminRequest.Builder()
                .serviceIdentification(ServiceIdentification.PrintLastCustomerReceipt)
                .build();
        Moshi moshi = new Moshi.Builder()
                .build();
        JsonAdapter<AdminRequest> jsonAdapter = moshi.adapter(AdminRequest.class);
        String json = jsonAdapter.toJson(adminRequest);
        System.out.println(json);

        AdminRequest serializedRequest = null;
        try {
            serializedRequest = jsonAdapter.fromJson(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert (serializedRequest.getServiceIdentification().toString().equals("PrintLastCustomerReceipt"));
    }
}
