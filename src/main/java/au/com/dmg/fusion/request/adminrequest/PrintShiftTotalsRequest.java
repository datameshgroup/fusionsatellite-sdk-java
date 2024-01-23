package au.com.dmg.fusion.request.adminrequest;

import au.com.dmg.fusion.request.Request;
import au.com.dmg.fusion.util.InstantAdapter;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.time.Instant;

public class PrintShiftTotalsRequest implements Request {

    @Json(name = "ShiftNumber")
    private final String shiftNumber;
    @Json(name = "ShiftStartTime")
    private final Instant shiftStartTime;
    @Json(name = "ShiftEndTime")
    private final Instant shiftEndTime;

    public String getShiftNumber(){ return shiftNumber; }
    public Instant getShiftStartTime(){ return shiftStartTime; }
    public Instant getShiftEndTime(){ return shiftEndTime; }

    public static class Builder{
        private String shiftNumber;
        private Instant shiftStartTime;
        private Instant shiftEndTime;

        public Builder(){}

        Builder(String shiftNumber, Instant shiftStartTime, Instant shiftEndTime){
            this.shiftNumber = shiftNumber;
            this.shiftStartTime = shiftStartTime;
            this.shiftEndTime = shiftEndTime;
        }

        public Builder shiftNumber(String shiftNumber){
            this.shiftNumber = shiftNumber;
            return Builder.this;
        }

        public Builder shiftStartTime(Instant shiftStartTime){
            this.shiftStartTime = shiftStartTime;
            return Builder.this;
        }

        public Builder shiftEndTime(Instant shiftEndTime){
            this.shiftEndTime = shiftEndTime;
            return Builder.this;
        }

        public PrintShiftTotalsRequest build(){
            if(this.shiftNumber == null || this.shiftNumber.isEmpty()){
                throw new NullPointerException("The property \"shiftNumber\" is null or empty. "
                        + "Please set the value by \"shiftNumber()\" under PrintShiftTotalsRequest. "
                        + "The properties \"shiftNumber\", \"shiftStartTime\", and \"shiftEndTime\" are required.");
            }
            if(this.shiftStartTime == null){
                throw new NullPointerException("The property \"shiftNumber\" is null. "
                        + "Please set the value by \"shiftNumber()\" under PrintShiftTotalsRequest. "
                        + "The properties \"shiftNumber\", \"shiftStartTime\", and \"shiftEndTime\" are required.");
            }
            if(this.shiftEndTime == null){
                throw new NullPointerException("The property \"shiftEndTime\" is null. "
                        + "Please set the value by \"shiftEndTime()\" under PrintShiftTotalsRequest. "
                        + "The properties \"shiftNumber\", \"shiftStartTime\", and \"shiftEndTime\" are required.");
            }

            return new PrintShiftTotalsRequest(this);
        }
    }

    public PrintShiftTotalsRequest(Builder builder){
        this.shiftNumber = builder.shiftNumber;
        this.shiftStartTime = builder.shiftStartTime;
        this.shiftEndTime = builder.shiftEndTime;
    }

    @Override
    public String toJson() {
        Moshi moshi = new Moshi.Builder()
                .add(new InstantAdapter())
                .build();
        JsonAdapter<PrintShiftTotalsRequest> jsonAdapter = moshi.adapter(PrintShiftTotalsRequest.class);
        return jsonAdapter.toJson(this);
    }
}
