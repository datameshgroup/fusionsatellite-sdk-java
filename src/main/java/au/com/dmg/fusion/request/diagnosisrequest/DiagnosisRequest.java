package au.com.dmg.fusion.request.diagnosisrequest;


import au.com.dmg.fusion.request.Request;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

public class DiagnosisRequest implements Request {

    public DiagnosisRequest() {
    }

    @Override
    public String toJson() {
        Moshi moshi = new Moshi.Builder()
                .build();
        JsonAdapter<DiagnosisRequest> jsonAdapter = moshi.adapter(DiagnosisRequest.class);
        return jsonAdapter.toJson(this);
    }
}
