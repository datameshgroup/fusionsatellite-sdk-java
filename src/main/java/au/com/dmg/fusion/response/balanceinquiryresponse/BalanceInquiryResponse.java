package au.com.dmg.fusion.response.balanceinquiryresponse;

import au.com.dmg.fusion.response.Response;
import au.com.dmg.fusion.response.ResponseType;
import au.com.dmg.fusion.response.paymentresponse.PaymentReceipt;
import com.squareup.moshi.Json;

import java.util.LinkedList;
import java.util.List;

public class BalanceInquiryResponse implements ResponseType {
    @Json(name = "Response")
    private final Response response;
    @Json(name = "PaymentAccountStatus")
    private final PaymentAccountStatus paymentAccountStatus;
    @Json(name = "LoyaltyAccountStatus")
    private final LoyaltyAccountStatus loyaltyAccountStatus;
    @Json(name = "PaymentReceipt")
    private final List<PaymentReceipt> paymentReceipt;


    public Response getResponse(){ return response; }
    public PaymentAccountStatus getPaymentAccountStatus(){ return paymentAccountStatus; }
    public LoyaltyAccountStatus getLoyaltyAccountStatus(){ return loyaltyAccountStatus; }
    public List<PaymentReceipt> getPaymentReceipt() { return  paymentReceipt; }

    public static class Builder{
        private Response response;
        private PaymentAccountStatus paymentAccountStatus;
        private LoyaltyAccountStatus loyaltyAccountStatus;
        private List<PaymentReceipt> paymentReceipt;

        public Builder() {
        }

        Builder(Response response, PaymentAccountStatus paymentAccountStatus, List<PaymentReceipt> paymentReceipt) {
            this.response = response;
            this.paymentAccountStatus = paymentAccountStatus;
            this.paymentReceipt = paymentReceipt;
        }

        Builder(Response response, PaymentAccountStatus paymentAccountStatus, LoyaltyAccountStatus loyaltyAccountStatus, List<PaymentReceipt> paymentReceipt) {
            this.response = response;
            this.paymentAccountStatus = paymentAccountStatus;
            this.loyaltyAccountStatus = loyaltyAccountStatus;
            this.paymentReceipt = paymentReceipt;
        }

        public Builder response(Response response) {
            this.response = response;
            return Builder.this;
        }

        public Builder paymentAccountStatus(PaymentAccountStatus paymentAccountStatus) {
            this.paymentAccountStatus = paymentAccountStatus;
            return Builder.this;
        }

        public Builder loyaltyAccountStatus(LoyaltyAccountStatus loyaltyAccountStatus){
            this.loyaltyAccountStatus = loyaltyAccountStatus;
            return Builder.this;
        }

        public Builder paymentReceipt(List<PaymentReceipt> paymentReceipt) {
            this.paymentReceipt = paymentReceipt;
            return Builder.this;
        }

        public Builder paymentReceipt(PaymentReceipt paymentReceipt){
            if (this.paymentReceipt == null){
                this.paymentReceipt = new LinkedList<>();
            }

            if(paymentReceipt != null){
                this.paymentReceipt.add(paymentReceipt);
            }
            return Builder.this;
        }

        public Builder addPaymentReceipt(PaymentReceipt paymentReceipt){
            if (this.paymentReceipt == null){
                this.paymentReceipt = new LinkedList<>();
            }

            if(paymentReceipt != null){
                this.paymentReceipt.add(paymentReceipt);
            }
            return Builder.this;
        }

        public BalanceInquiryResponse build() {
            if (this.response == null) {
                throw new NullPointerException("The property \"response\" is null. "
                        + "Please set the value by \"response()\". "
                        + "The property \"response\" is required.");
            }
            if(!(this.paymentReceipt ==null) && this.paymentReceipt.size()>0){
                for (int i = 1; i < this.paymentReceipt.size(); i++) {
                    if(this.paymentReceipt.get(i).getOutputContent().getOutputFormat() == null){
                        throw new NullPointerException("The property \"outputFormat\" is null. "
                                + "Please set the value by \"outputFormat()\" under paymentReceipt. "
                                + "The properties \"outputFormat\" and \"outputXHTML\" is required.");
                    }
                    if(this.paymentReceipt.get(i).getOutputContent().getOutputXHTML() == null){
                        throw new NullPointerException("The property \"outputXHTML\" is null. "
                                + "Please set the value by \"outputXHTML()\" under paymentReceipt. "
                                + "The properties \"outputFormat\" and \"outputXHTML\" is required.");
                    }
                }
            }


            return new BalanceInquiryResponse(this);
        }
    }
    private BalanceInquiryResponse(Builder builder){
        this.response = builder.response;
        this.paymentAccountStatus = builder.paymentAccountStatus;
        this.loyaltyAccountStatus = builder.loyaltyAccountStatus;
        this.paymentReceipt = builder.paymentReceipt;
    }
}
