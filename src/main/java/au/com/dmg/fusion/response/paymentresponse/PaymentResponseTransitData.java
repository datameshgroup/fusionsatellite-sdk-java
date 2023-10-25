package au.com.dmg.fusion.response.paymentresponse;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PaymentResponseTransitData {
    @Json(name = "Tags")
    private final List<String> tags;

    public List<String> getTags() {
        return tags;
    }

    public static class Builder {
        List<String> tags = new ArrayList<>();

        public Builder() {
        }

        Builder(List<String> tags){
            this.tags = tags;
        }

        public Builder tags(List<String> tags){
            this.tags = tags;
            return Builder.this;
        }

        public Builder addTag(String tag) {
            if(tag!=null){
                if(this.tags==null){
                    this.tags = Collections.singletonList(tag);
                }else{
                    this.tags.add(tag);
                }
            }
            return Builder.this;
        }

        public PaymentResponseTransitData build(){
            return new PaymentResponseTransitData(this);
        }
    }

    private PaymentResponseTransitData(Builder builder){
        this.tags = builder.tags;
    }

    public String toJsonString() {
        Moshi moshi = new Moshi.Builder()
                .build();
        JsonAdapter<PaymentResponseTransitData> jsonAdapter = moshi.adapter(PaymentResponseTransitData.class);
        return jsonAdapter.toJson(this);
    }

    public JSONObject toJsonObject(){
        return new JSONObject(toJsonString());
    }
}
