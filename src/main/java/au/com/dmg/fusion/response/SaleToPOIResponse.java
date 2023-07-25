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

package au.com.dmg.fusion.response;

import au.com.dmg.fusion.response.reversalresponse.ReversalResponse;
import au.com.dmg.fusion.util.BigDecimalAdapter;
import au.com.dmg.fusion.MessageHeader;
import au.com.dmg.fusion.SaleToPOI;
import au.com.dmg.fusion.response.inputresponse.InputResponse;
import au.com.dmg.fusion.response.paymentresponse.PaymentResponse;
import au.com.dmg.fusion.securitytrailer.SecurityTrailer;
import au.com.dmg.fusion.util.InstantAdapter;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SaleToPOIResponse implements SaleToPOI {
    @Json(name = "MessageHeader")
    private MessageHeader messageHeader;
    @Json(name = "AbortTransactionResponse")
    private AbortTransactionResponse abortTransactionResponse;
    @Json(name = "PaymentResponse")
    private PaymentResponse paymentResponse;
    @Json(name = "LoginResponse")
    private LoginResponse loginResponse;
    @Json(name = "CardAcquisitionResponse")
    private CardAcquisitionResponse cardAcquisitionResponse;
    @Json(name = "DisplayResponse")
    private DisplayResponse displayResponse;
    @Json(name = "InputResponse")
    private InputResponse inputResponse;
    @Json(name = "LogoutResponse")
    private LogoutResponse logoutResponse;
    @Json(name = "PrintResponse")
    private PrintResponse printResponse;
    @Json(name = "ReconciliationResponse")
    private ReconciliationResponse reconciliationResponse;
    @Json(name = "TransactionStatusResponse")
    private TransactionStatusResponse transactionStatusResponse;
    @Json(name = "ReversalResponse")
    private ReversalResponse reversalResponse;
    @Json(name = "GetTotalsResponse")
    private GetTotalsResponse getTotalsResponse;
    @Json(name = "EventNotification")
    private EventNotification eventNotification;    
    @Json(name = "SecurityTrailer")
    private SecurityTrailer securityTrailer;

    @NotNull
    @Override
    public MessageHeader getMessageHeader() {
        return messageHeader;
    }

    @Nullable
    public AbortTransactionResponse getAbortTransactionResponse() {
        return abortTransactionResponse;
    }

    @Nullable
    public PaymentResponse getPaymentResponse() {
        return paymentResponse;
    }

    @Nullable
    public LoginResponse getLoginResponse() {
        return loginResponse;
    }

    @Nullable
    public CardAcquisitionResponse getCardAcquisitionResponse() {
        return cardAcquisitionResponse;
    }

    @Nullable
    public DisplayResponse getDisplayResponse() {
        return displayResponse;
    }

    @Nullable
    public InputResponse getInputResponse() {
        return inputResponse;
    }

    @Nullable
    public LogoutResponse getLogoutResponse() {
        return logoutResponse;
    }

    @Nullable
    public PrintResponse getPrintResponse() {
        return printResponse;
    }

    @Nullable
    public ReconciliationResponse getReconciliationResponse() {
        return reconciliationResponse;
    }

    @Nullable
    public TransactionStatusResponse getTransactionStatusResponse() {
        return transactionStatusResponse;
    }

    @Nullable
    public ReversalResponse getReversalResponse() {
        return reversalResponse;
    }

    @Nullable
    public EventNotification getEventNotification() {
        return eventNotification;
    }

    @Nullable
    public GetTotalsResponse getGetTotalsResponse(){ return getTotalsResponse; }

    @Nullable
    @Override
    public SecurityTrailer getSecurityTrailer() {
        return securityTrailer;
    }

    public static class Builder {

        private MessageHeader messageHeader;
        private PaymentResponse paymentResponse;
        private LoginResponse loginResponse;
        private LogoutResponse logoutResponse;
        private AbortTransactionResponse abortTransactionResponse;
        private CardAcquisitionResponse cardAcquisitionResponse;
        private DisplayResponse displayResponse;
        private InputResponse inputResponse;
        private PrintResponse printResponse;
        private ReconciliationResponse reconciliationResponse;
        private TransactionStatusResponse transactionStatusResponse;
        private ReversalResponse reversalResponse;
        private GetTotalsResponse getTotalsResponse;
        private EventNotification eventNotification;
        private SecurityTrailer securityTrailer;

        public MessageHeader getMessageHeader() {
            return messageHeader;
        }

        public PaymentResponse getPaymentResponse() {
            return paymentResponse;
        }
        public GetTotalsResponse getTotalsResponse(){
            return getTotalsResponse;
        }

        public SecurityTrailer getSecurityTrailer() {
            return securityTrailer;
        }

        public Builder() {
        }

        Builder(MessageHeader messageHeader, PaymentResponse paymentResponse, SecurityTrailer securityTrailer) {
            this.messageHeader = messageHeader;
            this.paymentResponse = paymentResponse;
            this.securityTrailer = securityTrailer;
        }

        Builder(MessageHeader messageHeader, GetTotalsResponse getTotalsResponse){
            this.messageHeader = messageHeader;
            this.getTotalsResponse = getTotalsResponse;
        }

        public Builder messageHeader(MessageHeader messageHeader) {
            this.messageHeader = messageHeader;
            return Builder.this;
        }

        public Builder response(ResponseType response) {
            if (response instanceof PaymentResponse) {
                this.paymentResponse = (PaymentResponse) response;
            } else if (response instanceof AbortTransactionResponse) {
                this.abortTransactionResponse = (AbortTransactionResponse) response;
            } else if (response instanceof CardAcquisitionResponse) {
                this.cardAcquisitionResponse = (CardAcquisitionResponse) response;
            } else if (response instanceof DisplayResponse) {
                this.displayResponse = (DisplayResponse) response;
            } else if (response instanceof InputResponse) {
                this.inputResponse = (InputResponse) response;
            } else if (response instanceof LoginResponse) {
                this.loginResponse = (LoginResponse) response;
            } else if (response instanceof LogoutResponse) {
                this.logoutResponse = (LogoutResponse) response;
            } else if (response instanceof PrintResponse) {
                this.printResponse = (PrintResponse) response;
            } else if (response instanceof ReconciliationResponse) {
                this.reconciliationResponse = (ReconciliationResponse) response;
            } else if (response instanceof TransactionStatusResponse) {
                this.transactionStatusResponse = (TransactionStatusResponse) response;
            } else if (response instanceof ReversalResponse){
                this.reversalResponse = (ReversalResponse) response;
            } else if (response instanceof GetTotalsResponse) {
                this.getTotalsResponse = (GetTotalsResponse) response;
            } else if (response instanceof EventNotification){
                this.eventNotification = (EventNotification) response;
            } else {
                throw new IllegalArgumentException("Error Response not identified.");
            }

            return Builder.this;
        }

        public Builder securityTrailer(SecurityTrailer securityTrailer) {
            this.securityTrailer = securityTrailer;
            return Builder.this;
        }

        public SaleToPOIResponse build() {
            if (this.messageHeader == null) {
                throw new NullPointerException("The property \"messageHeader\" is null. "
                        + "Please set the value by \"messageHeader()\". "
                        + "The properties \"messageHeader\", \"paymentResponse\" are required.");
            }

            return new SaleToPOIResponse(this);
        }
    }

    private SaleToPOIResponse(Builder builder) {
        this.messageHeader = builder.messageHeader;
        this.abortTransactionResponse = builder.abortTransactionResponse;
        this.paymentResponse = builder.paymentResponse;
        this.cardAcquisitionResponse = builder.cardAcquisitionResponse;
        this.displayResponse = builder.displayResponse;
        this.inputResponse = builder.inputResponse;
        this.loginResponse = builder.loginResponse;
        this.logoutResponse = builder.logoutResponse;
        this.printResponse = builder.printResponse;
        this.reconciliationResponse = builder.reconciliationResponse;
        this.transactionStatusResponse = builder.transactionStatusResponse;
        this.reversalResponse = builder.reversalResponse;
        this.eventNotification = builder.eventNotification;
        this.securityTrailer = builder.securityTrailer;
    }

    @Override
    public String toJson() {
        Moshi moshi = new Moshi.Builder()
                .add(new BigDecimalAdapter())
                .add(new InstantAdapter())
                .build();
        JsonAdapter<SaleToPOIResponse> jsonAdapter = moshi.adapter(SaleToPOIResponse.class);
        return jsonAdapter.toJson(this);
    }

    @Override
    public String toString() {
        return toJson();
    }
}


/*
package au.com.dmg.fusionsatellite.response
class SaleToPOIResponse
@Required MessageHeader messageHeader
@Required PaymentResponse paymentResponse
SecurityTrailer securityTrailer
* */