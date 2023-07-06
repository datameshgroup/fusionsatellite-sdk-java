package au.com.dmg.fusion.request.paymentrequest.extenstiondata;

import com.squareup.moshi.Json;
import org.jetbrains.annotations.NotNull;

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

}
