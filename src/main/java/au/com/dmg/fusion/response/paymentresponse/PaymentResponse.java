/*
 * Copyright (c) 2021. DatameshGroup
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package au.com.dmg.fusion.response.paymentresponse;

import au.com.dmg.fusion.data.PaymentInstrumentType;
import au.com.dmg.fusion.request.paymentrequest.POIData;
import au.com.dmg.fusion.request.paymentrequest.SaleData;
import au.com.dmg.fusion.response.Response;
import au.com.dmg.fusion.response.ResponseResult;
import au.com.dmg.fusion.response.ResponseType;
import com.squareup.moshi.Json;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class PaymentResponse implements ResponseType {

    @Json(name = "Response")
    private final Response response;
    @Json(name = "SaleData")
    private final PaymentResponseSaleData saleData;
    @Json(name = "POIData")
    private final POIData poiData;
    @Json(name = "PaymentResult")
    private final PaymentResult paymentResult;
    @Json(name = "AllowedProductCodes")
    private final List<String> allowedProductCodes;
    @Json(name = "PaymentReceipt")
    private final List<PaymentReceipt> paymentReceipt;
    @Json(name = "LoyaltyResult")
    @Nullable
    private final List<LoyaltyResult> loyaltyResult;
    @Json(name = "ExtensionData")
    private final PaymentResponseExtensionData extensionData;
    @Json(name = "IsSplitPayment")
    private final Boolean isSplitPayment;


    @NotNull
    public Response getResponse() {
        return response;
    }

    @NotNull
    public PaymentResponseSaleData getSaleData() {
        return saleData;
    }

    @NotNull
    public POIData getPoiData() {
        return poiData;
    }

    @Nullable
    public PaymentResult getPaymentResult() {
        return paymentResult;
    }

    @Nullable
    public List<String> getAllowedProductCodes() {
        return allowedProductCodes;
    }

    @Nullable
    public List<PaymentReceipt> getPaymentReceipt() {
        return paymentReceipt;
    }

    @Nullable
    public List<LoyaltyResult> getLoyaltyResult() {
        return loyaltyResult;
    }

    @Nullable
    public PaymentResponseExtensionData getExtensionData() {return extensionData; }

    @Nullable Boolean getIsSplitPayment(){ return isSplitPayment; }

    public static class Builder {

        private Response response;
        private PaymentResponseSaleData saleData;
        private POIData poiData;
        private PaymentResult paymentResult;
        private List<String> allowedProductCodes;
        private List<PaymentReceipt> paymentReceipt;
        private List<LoyaltyResult> loyaltyResult;
        private PaymentResponseExtensionData extensionData;
        private Boolean isSplitPayment;

        public Builder() {
        }

        Builder(Response response, PaymentResponseSaleData saleData, POIData poiData, PaymentResult paymentResult, List<String> allowedProductCodes, List<PaymentReceipt> paymentReceipt, List<LoyaltyResult> loyaltyResult, PaymentResponseExtensionData extensionData) {
            this.response = response;
            this.saleData = saleData;
            this.poiData = poiData;
            this.paymentResult = paymentResult;
            this.allowedProductCodes = allowedProductCodes;
            this.paymentReceipt = paymentReceipt;
            this.loyaltyResult = loyaltyResult;
            this.extensionData = extensionData;
        }

        public Builder response(Response response) {
            this.response = response;
            return Builder.this;
        }

        public Builder saleData(SaleData saleData) {
            this.saleData = (PaymentResponseSaleData) saleData;
            return Builder.this;
        }

        public Builder POIData(POIData poiData) {
            this.poiData = poiData;
            return Builder.this;
        }

        public Builder paymentResult(PaymentResult paymentResult) {
            this.paymentResult = paymentResult;
            return Builder.this;
        }

        public Builder allowedProductCodes(List<String> allowedProductCodes) {
            if(allowedProductCodes == null){
                this.allowedProductCodes = new ArrayList<>();
            } else {
                this.allowedProductCodes = allowedProductCodes;
            }
            return Builder.this;
        }

        public Builder addAllowedProductCodes(String allowedProductCodes) {
            if(this.allowedProductCodes == null){
                this.allowedProductCodes = new LinkedList<>();
            }
            this.allowedProductCodes.add(allowedProductCodes);
            return Builder.this;
        }

        public Builder paymentReceipt(List<PaymentReceipt> paymentReceipt) {
            this.paymentReceipt = paymentReceipt;
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

        public Builder loyaltyResult(List<LoyaltyResult> loyaltyResult) {
            this.loyaltyResult = loyaltyResult;
            return Builder.this;
        }

        public Builder addLoyaltyResult(LoyaltyResult loyaltyResult){
            if (this.loyaltyResult == null){
                this.loyaltyResult = new LinkedList<>();
            }

            if(loyaltyResult != null){
                this.loyaltyResult.add(loyaltyResult);
            }
            return Builder.this;
        }

        public Builder extensionData(PaymentResponseExtensionData extensionData){
            this.extensionData = extensionData;
            return Builder.this;
        }

        public Builder isSplitPayment(Boolean isSplitPayment){
            this.isSplitPayment = isSplitPayment;
            return Builder.this;
        }

        public PaymentResponse build() {
            if (this.response == null) {
                throw new NullPointerException("The property \"response\" is null. "
                        + "Please set the value by \"response()\". "
                        + "The properties \"response\", \"saleData\" and \"poiData\" are required.");
            }
            if (this.saleData == null) {
                throw new NullPointerException("The property \"saleData\" is null. "
                        + "Please set the value by \"saleData()\". "
                        + "The properties \"response\", \"saleData\" and \"poiData\" are required.");
            }
            if (this.poiData == null) {
                throw new NullPointerException("The property \"poiData\" is null. "
                        + "Please set the value by \"poiData()\". "
                        + "The properties \"response\", \"saleData\" and \"poiData\" are required.");
            }
            //PartialPayment Logic
            if (this.response.getResult() == ResponseResult.Success
            && !(this.paymentResult == null)
            && !(this.paymentResult.getAmountsResp() == null)){
                AmountsResp amountsResp = this.paymentResult.getAmountsResp();

                // Check for nulls, there's logic for some amounts being null, we don't want to change that
                BigDecimal surcharge = Optional.ofNullable(amountsResp.getSurchargeAmount())
                        .orElse(BigDecimal.ZERO);
                BigDecimal tip = Optional.ofNullable(amountsResp.getTipAmount())
                        .orElse(BigDecimal.ZERO);
                BigDecimal cashback = Optional.ofNullable(amountsResp.getCashBackAmount())
                        .orElse(BigDecimal.ZERO);
                BigDecimal reqAmt = Optional.ofNullable(amountsResp.getRequestedAmount())
                        .orElse(BigDecimal.ZERO);
                BigDecimal authPartialAmt = Optional.ofNullable(amountsResp.getPartialAuthorizedAmount())
                        .orElse(BigDecimal.ZERO);

                if((surcharge.intValue() == 0)
                        && (tip.intValue() == 0)
                        && (cashback.intValue() == 0)
                        && (this.paymentResult.getPaymentInstrumentData().getPaymentInstrumentType() == PaymentInstrumentType.Card || isSplitPayment)
                        && (reqAmt.intValue() > 0)
                        && (authPartialAmt.intValue() > 0)
                        && (reqAmt.compareTo(authPartialAmt) > 0 )
                ){
                    this.response = new Response.Builder()
                            .result(ResponseResult.Partial)
                            .additionalResponse(this.response.getAdditionalResponse())
                            .errorCondition(this.response.getErrorCondition())
                            .build();
                }
            }

            return new PaymentResponse(this);
        }
    }

    private PaymentResponse(Builder builder) {
        this.response = builder.response;
        this.saleData = builder.saleData;
        this.poiData = builder.poiData;
        this.paymentResult = builder.paymentResult;
        this.allowedProductCodes = builder.allowedProductCodes;
        this.paymentReceipt = builder.paymentReceipt;
        this.loyaltyResult = builder.loyaltyResult;
        this.extensionData = builder.extensionData;
        this.isSplitPayment = builder.isSplitPayment;
    }
}


/*
package au.com.dmg.fusionsatellite.response
class PaymentResponse
@Required Response response
@Required PaymentResponseSaleData saleData
@Required POIData poiData
PaymentResult paymentResult
List<String> allowedProductCodes
List<PaymentReceipt> paymentReceipt
List<LoyaltyResult> loyaltyResult
* */

