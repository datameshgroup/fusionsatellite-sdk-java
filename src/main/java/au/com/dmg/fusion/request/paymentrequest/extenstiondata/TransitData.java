package au.com.dmg.fusion.request.paymentrequest.extenstiondata;

import au.com.dmg.fusion.util.BigDecimalAdapter;
import au.com.dmg.fusion.util.InstantAdapter;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class TransitData {
    @Json(name = "IsWheelchairEnabled")
    private final Boolean isWheelchairEnabled;
    @Json(name = "Trip")
    private final Trip trip;

    @NotNull
    public Boolean getIsWheelchairEnabled() { return isWheelchairEnabled; }

    @NotNull
    public Trip getTrip() { return trip; }

    public static class Builder {
        Boolean isWheelchairEnabled;
        Trip trip;

        public Builder() {
        }

        Builder(Boolean isWheelchairEnabled, Trip trip){
            this.isWheelchairEnabled = isWheelchairEnabled;
            this.trip = trip;
        }

        public Builder isWheelchairEnabled(Boolean isWheelchairEnabled){
            this.isWheelchairEnabled = isWheelchairEnabled;
            return Builder.this;
        }

        public Builder trip(Trip trip){
            this.trip = trip;
            return Builder.this;
        }

        public TransitData build(){
            if(this.isWheelchairEnabled==null){
                throw new NullPointerException("The property \"isWheelchairEnabled\" is null. "
                        + "Please set the Value by \"isWheelchairEnabled()\". "
                        + "This properties \"isWheelchairEnabled\", and \"trip\" are required.");
            }

            if(this.trip==null){
                throw new NullPointerException("The property \"trip\" is null. "
                        + "Please set the Value by \"trip()\". "
                        + "This properties \"isWheelchairEnabled\", and \"trip\" are required.");
            }
            return new TransitData(this);
        }
    }

    private TransitData(Builder builder){
        this.isWheelchairEnabled = builder.isWheelchairEnabled;
        this.trip = builder.trip;
    }

    public String toJsonString() {
        Moshi moshi = new Moshi.Builder()
                .add(new BigDecimalAdapter())
                .add(new InstantAdapter())
                .build();
        JsonAdapter<TransitData> jsonAdapter = moshi.adapter(TransitData.class);
        return jsonAdapter.toJson(this);
    }

    public JSONObject toJsonObject(){
        return new JSONObject(toJsonString());
    }
}