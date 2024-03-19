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

package au.com.dmg.fusion.request;

import au.com.dmg.fusion.MessageHeader;
import au.com.dmg.fusion.SaleToPOI;
import au.com.dmg.fusion.request.aborttransactionrequest.AbortTransactionRequest;
import au.com.dmg.fusion.request.adminrequest.AdminRequest;
import au.com.dmg.fusion.request.balanceinquiryrequest.BalanceInquiryRequest;
import au.com.dmg.fusion.request.cardacquisitionrequest.CardAcquisitionRequest;
import au.com.dmg.fusion.request.displayrequest.DisplayRequest;
import au.com.dmg.fusion.request.gettotalsrequest.GetTotalsRequest;
import au.com.dmg.fusion.request.inputrequest.InputRequest;
import au.com.dmg.fusion.request.loginrequest.LoginRequest;
import au.com.dmg.fusion.request.logoutrequest.LogoutRequest;
import au.com.dmg.fusion.request.paymentrequest.PaymentRequest;
import au.com.dmg.fusion.request.printrequest.PrintRequest;
import au.com.dmg.fusion.request.reconciliationrequest.ReconciliationRequest;
import au.com.dmg.fusion.request.reversalrequest.ReversalRequest;
import au.com.dmg.fusion.request.diagnosisrequest.DiagnosisRequest;
import au.com.dmg.fusion.request.storedvaluerequest.StoredValueRequest;
import au.com.dmg.fusion.request.transactionstatusrequest.TransactionStatusRequest;
import au.com.dmg.fusion.securitytrailer.SecurityTrailer;
import au.com.dmg.fusion.util.BigDecimalAdapter;
import au.com.dmg.fusion.util.InstantAdapter;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

public class SaleToPOIRequest implements SaleToPOI {

    @Json(name = "MessageHeader")
    private MessageHeader messageHeader;
    @Json(name = "AbortRequest")
    private AbortTransactionRequest abortTransactionRequest;
    @Json(name = "AdminRequest")
    private AdminRequest adminRequest;
    @Json(name = "DiagnosisRequest")
    private DiagnosisRequest diagnosisRequest;
    @Json(name = "PaymentRequest")
    private PaymentRequest paymentRequest;
    @Json(name = "LoginRequest")
    private LoginRequest loginRequest;
    @Json(name = "CardAcquisitionRequest")
    private CardAcquisitionRequest cardAcquisitionRequest;
    @Json(name = "DisplayRequest")
    private DisplayRequest displayRequest;
    @Json(name = "InputRequest")
    private InputRequest inputRequest;
    @Json(name = "LogoutRequest")
    private LogoutRequest logoutRequest;
    @Json(name = "PrintRequest")
    private PrintRequest printRequest;
    @Json(name = "ReconciliationRequest")
    private ReconciliationRequest reconciliationRequest;
    @Json(name = "TransactionStatusRequest")
    private TransactionStatusRequest transactionStatusRequest;
    @Json(name = "ReversalRequest")
    private ReversalRequest reversalRequest;
    @Json(name = "GetTotalsRequest")
    private GetTotalsRequest getGetTotalsRequest;
    @Json(name = "SecurityTrailer")
    private SecurityTrailer securityTrailer;
    @Json(name = "StoredValueRequest")
    private StoredValueRequest storedValueRequest;
    @Json(name = "BalanceInquiryRequest")
    private BalanceInquiryRequest balanceInquiryRequest;

    @Override
    public MessageHeader getMessageHeader() {
        return messageHeader;
    }

    public PaymentRequest getPaymentRequest() {
        return paymentRequest;
    }

    public LoginRequest getLoginRequest() {
        return loginRequest;
    }

    public CardAcquisitionRequest getCardAcquisitionRequest() {
        return cardAcquisitionRequest;
    }

    public DisplayRequest getDisplayRequest() {
        return displayRequest;
    }

    public InputRequest getInputRequest() {
        return inputRequest;
    }

    public LogoutRequest getLogoutRequest() {
        return logoutRequest;
    }

    public PrintRequest getPrintRequest() {
        return printRequest;
    }

    public ReconciliationRequest getReconciliationRequest() {
        return reconciliationRequest;
    }

    public TransactionStatusRequest getTransactionStatusRequest() {
        return transactionStatusRequest;
    }

    public AbortTransactionRequest getAbortTransactionRequest() {
        return abortTransactionRequest;
    }

    public ReversalRequest getReversalRequest() {
        return reversalRequest;
    }

    public GetTotalsRequest getGetTotalsRequest(){ return getGetTotalsRequest; }

    public DiagnosisRequest getDiagnosisRequest(){ return diagnosisRequest; }

    public AdminRequest getAdminRequest(){ return adminRequest; }

    public BalanceInquiryRequest getBalanceInquiryRequest(){ return balanceInquiryRequest; }

    @Override
    public SecurityTrailer getSecurityTrailer() {
        return securityTrailer;
    }

    public StoredValueRequest getStoredValueRequest(){
        return storedValueRequest;
    }

    public static class Builder {

        private MessageHeader messageHeader;
        private PaymentRequest paymentRequest;
        private LoginRequest loginRequest;
        private LogoutRequest logoutRequest;
        private AbortTransactionRequest abortTransactionRequest;
        private ReversalRequest reversalRequest;
        private CardAcquisitionRequest cardAcquisitionRequest;
        private DisplayRequest displayRequest;
        private InputRequest inputRequest;
        private PrintRequest printRequest;
        private ReconciliationRequest reconciliationRequest;
        private TransactionStatusRequest transactionStatusRequest;
        private GetTotalsRequest getTotalsRequest;
        private DiagnosisRequest diagnosisRequest;
        private AdminRequest adminRequest;
        private SecurityTrailer securityTrailer;
        private StoredValueRequest storedValueRequest;
        private BalanceInquiryRequest balanceInquiryRequest;

        public Builder() {
        }

        Builder(MessageHeader messageHeader, PaymentRequest paymentRequest) {
            this.messageHeader = messageHeader;
            this.paymentRequest = paymentRequest;
        }

        Builder(MessageHeader messageHeader, LoginRequest loginRequest) {
            this.messageHeader = messageHeader;
            this.loginRequest = loginRequest;
        }
        Builder(MessageHeader messageHeader, GetTotalsRequest getTotalsRequest) {
            this.messageHeader = messageHeader;
            this.getTotalsRequest = getTotalsRequest;
        }

        Builder(MessageHeader messageHeader, DiagnosisRequest diagnosisRequest) {
            this.messageHeader = messageHeader;
            this.diagnosisRequest = diagnosisRequest;
        }

        Builder(MessageHeader messageHeader, AdminRequest adminRequest) {
            this.messageHeader = messageHeader;
            this.adminRequest = adminRequest;
        }

        public Builder messageHeader(MessageHeader messageHeader) {
            this.messageHeader = messageHeader;
            return Builder.this;
        }

        public Builder securityTrailer(SecurityTrailer securityTrailer) {
            this.securityTrailer = securityTrailer;
            return Builder.this;
        }

        public Builder storedValueRequest(StoredValueRequest storedValueRequest){
            this.storedValueRequest = storedValueRequest;
            return Builder.this;
        }

        public Builder balanceInquiryRequest(BalanceInquiryRequest balanceInquiryRequest){
            this.balanceInquiryRequest = balanceInquiryRequest;
            return Builder.this;
        }

        public Builder request(Request request) {
            if (request instanceof PaymentRequest) {
                this.paymentRequest = (PaymentRequest) request;
            } else if (request instanceof AbortTransactionRequest) {
                this.abortTransactionRequest = (AbortTransactionRequest) request;
            } else if (request instanceof CardAcquisitionRequest) {
                this.cardAcquisitionRequest = (CardAcquisitionRequest) request;
            } else if (request instanceof DisplayRequest) {
                this.displayRequest = (DisplayRequest) request;
            } else if (request instanceof InputRequest) {
                this.inputRequest = (InputRequest) request;
            } else if (request instanceof LoginRequest) {
                this.loginRequest = (LoginRequest) request;
            } else if (request instanceof LogoutRequest) {
                this.logoutRequest = (LogoutRequest) request;
            } else if (request instanceof PrintRequest) {
                this.printRequest = (PrintRequest) request;
            } else if (request instanceof ReconciliationRequest) {
                this.reconciliationRequest = (ReconciliationRequest) request;
            } else if (request instanceof TransactionStatusRequest) {
                this.transactionStatusRequest = (TransactionStatusRequest) request;
            } else if(request instanceof  ReversalRequest){
                this.reversalRequest = (ReversalRequest) request;
            } else if (request instanceof GetTotalsRequest) {
                this.getTotalsRequest = (GetTotalsRequest) request;
            } else if (request instanceof DiagnosisRequest) {
                this.diagnosisRequest = (DiagnosisRequest) request;
            } else if (request instanceof AdminRequest) {
                this.adminRequest = (AdminRequest) request;
            } else if (request instanceof StoredValueRequest) {
                this.storedValueRequest = (StoredValueRequest) request;
            } else if (request instanceof BalanceInquiryRequest) {
                this.balanceInquiryRequest = (BalanceInquiryRequest) request;
            }
            else {
                throw new IllegalArgumentException("Error Request not identified.");
            }

            // Need to check the header. DDifferent Requests have different requirements for the header.
            if (this.loginRequest != null){
                if(messageHeader.getProtocolVersion() == null){
                    throw new NullPointerException("With a LoginRequest, MessageHeader.ProtocolVersion cannot be null.");
                }
                if(messageHeader.getServiceID() == null){
                    throw new NullPointerException("With a LoginRequest, MessageHeader.ServiceID cannot be null.");
                }
                if(messageHeader.getSaleID() == null){
                    throw new NullPointerException("With a LoginRequest, MessageHeader.SaleID cannot be null.");
                }
                if(messageHeader.getPoiID() == null){
                    throw new NullPointerException("With a LoginRequest, MessageHeader.POIID cannot be null.");
                }
            }
            if (this.logoutRequest != null){
                if(messageHeader.getProtocolVersion() == null){
                    throw new NullPointerException("With a LogOut, MessageHeader.ProtocolVersion cannot be null.");
                }
                if(messageHeader.getServiceID() == null){
                    throw new NullPointerException("With a LogOut, MessageHeader.ServiceID cannot be null.");
                }
                if(messageHeader.getSaleID() == null){
                    throw new NullPointerException("With a LogOut, MessageHeader.SaleID cannot be null.");
                }
                if(messageHeader.getPoiID() == null){
                    throw new NullPointerException("With a LogOut, MessageHeader.POIID cannot be null.");
                }
            }

            return Builder.this;
        }

        public SaleToPOIRequest build() {
            if (this.messageHeader == null) {
                throw new NullPointerException("The property \"messageHeader\" is null. "
                        + "Please set the value by \"messageHeader()\". "
                        + "The properties \"messageHeader\", \"paymentRequest\" are required.");
            }

            return new SaleToPOIRequest(this);
        }
    }

    private SaleToPOIRequest(Builder builder) {
        this.messageHeader = builder.messageHeader;
        this.abortTransactionRequest = builder.abortTransactionRequest;
        this.reversalRequest = builder.reversalRequest;
        this.paymentRequest = builder.paymentRequest;
        this.cardAcquisitionRequest = builder.cardAcquisitionRequest;
        this.displayRequest = builder.displayRequest;
        this.inputRequest = builder.inputRequest;
        this.loginRequest = builder.loginRequest;
        this.logoutRequest = builder.logoutRequest;
        this.printRequest = builder.printRequest;
        this.reconciliationRequest = builder.reconciliationRequest;
        this.transactionStatusRequest = builder.transactionStatusRequest;
        this.getGetTotalsRequest = builder.getTotalsRequest;
        this.diagnosisRequest = builder.diagnosisRequest;
        this.adminRequest = builder.adminRequest;
        this.securityTrailer = builder.securityTrailer;
        this.storedValueRequest = builder.storedValueRequest;
        this.balanceInquiryRequest = builder.balanceInquiryRequest;
    }

    public String toJson() {
        Moshi moshi = new Moshi.Builder()
                .add(new BigDecimalAdapter())
                .add(new InstantAdapter())
                .build();
        JsonAdapter<SaleToPOIRequest> jsonAdapter = moshi.adapter(SaleToPOIRequest.class);
        return jsonAdapter.toJson(this);
    }

    @Override
    public String toString() {
        return toJson();
    }
}

/*
package au.com.dmg.fusionsatellite.PaymentRequest
class SaleToPOIRequest
@Required MessageHeader messageHeader
@Required PaymentRequest paymentRequest
* */