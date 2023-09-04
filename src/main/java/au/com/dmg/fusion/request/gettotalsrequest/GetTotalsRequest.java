package au.com.dmg.fusion.request.gettotalsrequest;

import au.com.dmg.fusion.data.TotalDetail;
import com.squareup.moshi.Json;

import java.util.Collections;
import java.util.List;

public class GetTotalsRequest {
    @Json(name = "TotalDetails")
    private final List<TotalDetail> totalDetails;
    @Json(name = "TotalFilter")
    private final TotalFilter totalFilter;

    public List<TotalDetail> getTotalDetails(){ return totalDetails; }
    public TotalFilter getTotalFilter(){ return totalFilter; }

    public static class Builder{
        private List<TotalDetail> totalDetails;
        private TotalFilter totalFilter;

        public Builder() {
        }

        Builder(List<TotalDetail> totalDetails, TotalFilter totalFilter) {
            this.totalDetails = totalDetails;
            this.totalFilter = totalFilter;
        }

        public Builder totalDetails(List<TotalDetail> totalDetails){
            this.totalDetails = totalDetails;
            return Builder.this;
        }
        public Builder addTotalDetail(TotalDetail totalDetail){
            this.totalDetails.add(totalDetail);
            return Builder.this;
        }

        public Builder totalDetail(TotalDetail totalDetail){
            if(totalDetails==null){
                this.totalDetails = Collections.singletonList(totalDetail);
            }else{
                this.totalDetails.add(totalDetail);
            }
            return Builder.this;
        }

        public Builder totalFilter(TotalFilter totalFilter){
            this.totalFilter = totalFilter;
            return Builder.this;
        }

        public GetTotalsRequest build(){
            if(this.totalDetails == null){
                throw new NullPointerException("The property \"totalDetails\" is null. "
                        + "Please set the value by \"totalDetails()\". "
                        + "The properties \"totalDetails\" and \"totalFilter\" are required.");
            }
            if(this.totalFilter == null){
                throw new NullPointerException("The property \"totalFilter\" is null. "
                        + "Please set the value by \"totalDetails()\". "
                        + "The properties \"totalDetails\" and \"totalFilter\" are required.");
            }
            return new GetTotalsRequest(this);
        }

    }

    public GetTotalsRequest(Builder builder) {
        this.totalDetails = builder.totalDetails;
        this.totalFilter =  builder.totalFilter;
    }
}
