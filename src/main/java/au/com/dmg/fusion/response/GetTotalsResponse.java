package au.com.dmg.fusion.response;

import com.squareup.moshi.Json;

public class GetTotalsResponse {
    @Json(name = "Response")
    private final Response response;
    @Json(name = "TransactionTotals")
    private final String transactionTotals;

    public Response getResponse(){ return response; }
    public String getTransactionTotals(){ return transactionTotals; }

    public static class Builder{
        private Response response;
        private String transactionTotals;

        public Builder(){
        }
        Builder(Response response, String transactionTotals){
            this.response = response;
            this.transactionTotals = transactionTotals;
        }
        public Builder response(Response response){
            this.response = response;
            return Builder.this;
        }
        public Builder transactionTotals(String transactionTotals){
            this.transactionTotals = transactionTotals;
            return Builder.this;
        }
        public GetTotalsResponse build(){
            return new GetTotalsResponse(this);
        }
    }
    private GetTotalsResponse(Builder builder){
        this.response = builder.response;
        this.transactionTotals = builder.transactionTotals;
    }
}
