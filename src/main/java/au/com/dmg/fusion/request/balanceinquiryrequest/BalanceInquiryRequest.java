package au.com.dmg.fusion.request.balanceinquiryrequest;

import au.com.dmg.fusion.request.Request;
import au.com.dmg.fusion.request.adminrequest.AdminRequest;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

public class BalanceInquiryRequest implements Request {

    public BalanceInquiryRequest() {
    }

    @Override
    public String toJson() {
        Moshi moshi = new Moshi.Builder()
                .build();
        JsonAdapter<BalanceInquiryRequest> jsonAdapter = moshi.adapter(BalanceInquiryRequest.class);
        return jsonAdapter.toJson(this);
    }
}
