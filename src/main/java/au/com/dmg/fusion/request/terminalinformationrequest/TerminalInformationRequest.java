package au.com.dmg.fusion.request.terminalinformationrequest;


import au.com.dmg.fusion.request.Request;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

public class TerminalInformationRequest implements Request {

    public TerminalInformationRequest() {
    }

    @Override
    public String toJson() {
        Moshi moshi = new Moshi.Builder()
                .build();
        JsonAdapter<TerminalInformationRequest> jsonAdapter = moshi.adapter(TerminalInformationRequest.class);
        return jsonAdapter.toJson(this);
    }
}
