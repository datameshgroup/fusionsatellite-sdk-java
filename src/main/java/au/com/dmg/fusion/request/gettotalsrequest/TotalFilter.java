package au.com.dmg.fusion.request.gettotalsrequest;

import com.squareup.moshi.Json;

public class TotalFilter {
    @Json(name = "OperatorID")
    private final String operatorID;
    @Json(name = "ShiftNumber")
    private final String shiftNumber;

    public String getOperatorID(){ return operatorID; }
    public String getShiftNumber(){ return shiftNumber; }

    public static class Builder{
        private String operatorID;
        private String shiftNumber;

        public Builder() {
        }

        Builder(String operatorID, String shiftNumber){
            this.operatorID = operatorID;
            this.shiftNumber = shiftNumber;
        }
        public Builder operatorID(String operatorID){
            this.operatorID = operatorID;
            return Builder.this;
        }
        public Builder shiftNumber(String shiftNumber){
            this.shiftNumber = shiftNumber;
            return Builder.this;
        }

        public TotalFilter build(){
            return new TotalFilter(this);
        }
    }

    private TotalFilter(Builder builder) {
        this.operatorID = builder.operatorID;
        this.shiftNumber = builder.shiftNumber;
    }
}
