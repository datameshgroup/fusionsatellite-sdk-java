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

import au.com.dmg.fusion.Message;
import au.com.dmg.fusion.MessageHeader;
import au.com.dmg.fusion.data.*;
import au.com.dmg.fusion.request.SaleTerminalData;
import au.com.dmg.fusion.request.paymentrequest.POIData;
import au.com.dmg.fusion.request.paymentrequest.POITransactionID;
import au.com.dmg.fusion.request.paymentrequest.PaymentRequestTest;
import au.com.dmg.fusion.request.paymentrequest.SaleTransactionID;
import au.com.dmg.fusion.response.adminresponse.AdminResponse;
import au.com.dmg.fusion.response.inputresponse.InputResponse;
import au.com.dmg.fusion.response.inputresponse.InputResult;
import au.com.dmg.fusion.response.paymentresponse.*;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

public class SaleToPOIResponseTest {
    @Test
    public void testLogin() {
        SaleToPOIResponse response = new SaleToPOIResponse.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .protocolVersion("3.1")
                        .messageClass(MessageClass.Service)
                        .messageCategory(MessageCategory.Login)
                        .messageType(MessageType.Request)
                        .serviceID("X")
                        .saleID("X")
                        .POIID("x")
                        .build())
                .response(new LoginResponse.Builder()
                        .response(new Response.Builder()
                                .result(ResponseResult.Success)
                                .build())
                        .POISystemData(new POISystemData.Builder()
                                .dateTime("x")
                                .tokenRequestStatus(true)
                                .POITerminalData(new POITerminalData.Builder()
                                        .poiCapabilities(new LinkedList<>())
                                        .terminalEnvironment(TerminalEnvironment.Unknown)
                                        .poiProfile(new POIProfile("profile"))
                                        .poiSerialNumber("x")
                                        .build())
                                .poiStatus(new POIStatus("globalstatus", true, true, true, PrinterStatus.OK, true, true))
                                .build()
                        )
                        .build()
                )
                .build();

        System.out.println(response.toJson());
    }

    @Test
    public void testPayment() {
        List<PaymentReceipt> receipts = new LinkedList<PaymentReceipt>();
        receipts.add(new PaymentReceipt.Builder()
                        .integratedPrintFlag(false)
                        .documentQualifier("Title")
                        .requiredSignatureFlag(true)
                .build());

        SaleToPOIResponse response = new SaleToPOIResponse.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .protocolVersion("3.1")
                        .messageClass(MessageClass.Service)
                        .messageCategory(MessageCategory.Login)
                        .messageType(MessageType.Request)
                        .serviceID("X")
                        .saleID("X")
                        .POIID("x")
                        .build())
                .response(new PaymentResponse.Builder()
                        .response(new Response.Builder().result(ResponseResult.Success).build())
                        .saleData(
                                new PaymentResponseSaleData.Builder()
                                        .operatorID("opID")
                                        .operatorLanguage("en")
                                        .shiftNumber("shift1")
                                        .saleReferenceID("salesref1")
                                        .saleTerminalData(new SaleTerminalData.Builder()
                                                .deviceID("deviceId1")
                                                .build())
                                        .saleTransactionID(new SaleTransactionID.Builder()
                                                .transactionID("x")
                                                .timestamp(Instant.ofEpochMilli(System.currentTimeMillis()))
                                                .build()
                                        ).build()
                        )
                        .POIData(
                                new POIData.Builder()
                                        .POITransactionID(new POITransactionID("id", Instant.ofEpochMilli(System.currentTimeMillis())))
                                        .POIReconciliationID("x")
                                        .build()
                        )
                        .paymentReceipt(receipts)
                        .build())
                .build();

        System.out.println(response.toJson());
    }

    @Test
    public void testPaymentLoyalty() {
        List<PaymentReceipt> receipts = new LinkedList<PaymentReceipt>();
        receipts.add(new PaymentReceipt.Builder()
                .integratedPrintFlag(false)
                .documentQualifier("Title")
                .requiredSignatureFlag(true)
                .build());

        LoyaltyAccountID loyaltyAccountID =  new LoyaltyAccountID.Builder()
                .entryMode(EntryMode.Scanned)
                .identificationType(IdentificationType.AccountNumber)
                .identificationSupport(IdentificationSupport.LoyaltyCard)
                .loyaltyID("XXXXXXXXXX")
                .build();
    
        LoyaltyAccount loyaltyAccount = new LoyaltyAccount.Builder()
                .loyaltyAccountID(loyaltyAccountID)
                .loyaltyBrand(LoyaltyBrand.Qantas)
                .build();

        LoyaltyAmount loyaltyAmount = new LoyaltyAmount.Builder()
                .amountValue(new BigDecimal("100.0")).build();
        
        List<LoyaltyResult> loyaltyResults = new LinkedList<LoyaltyResult>();
        loyaltyResults.add(new LoyaltyResult.Builder()
        .loyaltyAccount(loyaltyAccount)
        .loyaltyAmount(loyaltyAmount)
        .build());

        SaleToPOIResponse response = new SaleToPOIResponse.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .protocolVersion("3.1")
                        .messageClass(MessageClass.Service)
                        .messageCategory(MessageCategory.Payment)
                        .messageType(MessageType.Request)
                        .serviceID("X")
                        .saleID("X")
                        .POIID("x")
                        .build())
                .response(new PaymentResponse.Builder()
                        .response(new Response.Builder().result(ResponseResult.Success).build())
                        .saleData(
                                new PaymentResponseSaleData.Builder()
                                        .operatorID("opID")
                                        .operatorLanguage("en")
                                        .shiftNumber("shift1")
                                        .saleReferenceID("salesref1")
                                        .saleTerminalData(new SaleTerminalData.Builder()
                                                .deviceID("deviceId1")
                                                .build())
                                        .saleTransactionID(new SaleTransactionID.Builder()
                                                .transactionID("x")
                                                .timestamp(Instant.ofEpochMilli(System.currentTimeMillis()))
                                                .build()
                                        ).build()
                        )
                        .POIData(
                                new POIData.Builder()
                                        .POITransactionID(new POITransactionID("id", Instant.ofEpochMilli(System.currentTimeMillis())))
                                        .POIReconciliationID("x")
                                        .build()
                        )
                        .paymentResult(
                                new PaymentResult.Builder()
                                        .paymentType(PaymentType.Normal)
                                        .paymentInstrumentData(new PaymentInstrumentData.Builder()
                                                .paymentInstrumentType(PaymentInstrumentType.Card)
                                                .cardData(new PaymentResponseCardData.Builder()
                                                .entryMode(EntryMode.Tapped)
                                                .paymentBrand(PaymentBrand.VISA)
                                                .maskedPAN("464516XXXXXX1111")
                                                .build())
                                                .build())
                                        .amountsResp(new AmountsResp.Builder()
                                                .authorizedAmount(new BigDecimal("100.0"))
                                                .build()
                                        )
                                        .onlineFlag(true)
                                        .build()
                        )
                        .paymentReceipt(receipts)
                        .loyaltyResult(loyaltyResults)
                        .build())
                .build();

        System.out.println(response.toJson());
    }

    @Test
    public void testLogout() {
        SaleToPOIResponse response = new SaleToPOIResponse.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .protocolVersion("3.1")
                        .messageClass(MessageClass.Service)
                        .messageCategory(MessageCategory.Login)
                        .messageType(MessageType.Request)
                        .serviceID("X")
                        .saleID("X")
                        .POIID("x")
                        .build())
                .response(new LogoutResponse(new Response.Builder().result(ResponseResult.Success).build()))
                .build();

        System.out.println(response.toJson());
    }

    @Test
    public void testDisplay() {
        List<OutputResult> output = new LinkedList<>();
        output.add(new OutputResult("d", InfoQualify.Input, "", "", ""));
        SaleToPOIResponse response = new SaleToPOIResponse.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .protocolVersion("3.1")
                        .messageClass(MessageClass.Service)
                        .messageCategory(MessageCategory.Login)
                        .messageType(MessageType.Request)
                        .serviceID("X")
                        .saleID("X")
                        .POIID("x")
                        .build())
                .response(new DisplayResponse(output))
                .build();

        System.out.println(response.toJson());
    }

    @Test
    public void testInput() {
        SaleToPOIResponse response = new SaleToPOIResponse.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .protocolVersion("3.1")
                        .messageClass(MessageClass.Service)
                        .messageCategory(MessageCategory.Login)
                        .messageType(MessageType.Request)
                        .serviceID("X")
                        .saleID("X")
                        .POIID("x")
                        .build())
                .response(new InputResponse.Builder()
                        .inputResult(new InputResult("device", "d", new Response.Builder()
                                .additionalResponse("x")
                                .result(ResponseResult.Success)
                                .build()))
                        .build())
                .build();

        System.out.println(response.toJson());
    }

    @Test
    public void testPrint() {
        SaleToPOIResponse response = new SaleToPOIResponse.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .protocolVersion("3.1")
                        .messageClass(MessageClass.Service)
                        .messageCategory(MessageCategory.Login)
                        .messageType(MessageType.Request)
                        .serviceID("X")
                        .saleID("X")
                        .POIID("x")
                        .build())
                .response(new PrintResponse(new DocumentQualifier(new Response.Builder()
                        .result(ResponseResult.Success)
                        .additionalResponse("x")
                        .build())))
                .build();

        System.out.println(response.toJson());
    }

    @Test
    public void testTransactionStatus() {
        SaleToPOIResponse response = new SaleToPOIResponse.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .protocolVersion("3.1")
                        .messageClass(MessageClass.Service)
                        .messageCategory(MessageCategory.Login)
                        .messageType(MessageType.Request)
                        .serviceID("X")
                        .saleID("X")
                        .POIID("x")
                        .build())
                .response(new TransactionStatusResponse.Builder()
                        .response(new Response.Builder()
                                .additionalResponse("x")
                                .result(ResponseResult.Success)
                                .build())
                        .build())
                .build();

        System.out.println(response.toJson());
    }

    @Test
    public void testAbort() {
        SaleToPOIResponse response = new SaleToPOIResponse.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .protocolVersion("3.1")
                        .messageClass(MessageClass.Service)
                        .messageCategory(MessageCategory.Login)
                        .messageType(MessageType.Request)
                        .serviceID("X")
                        .saleID("X")
                        .POIID("x")
                        .build())
                .response(new AbortTransactionResponse(Instant.ofEpochMilli(System.currentTimeMillis()), "eventToNOt", "eventdetails"))
                .build();

        System.out.println(response.toJson());
    }

    @Test
    public void testAdminResponse(){
        SaleToPOIResponse response = new SaleToPOIResponse.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .protocolVersion("3.1")
                        .messageClass(MessageClass.Service)
                        .messageCategory(MessageCategory.Admin)
                        .messageType(MessageType.Request)
                        .serviceID("X")
                        .saleID("X")
                        .POIID("x")
                        .build())
                .response(new AdminResponse.Builder()
                        .response(new Response.Builder()
                                .result(ResponseResult.Failure)
                                .additionalResponse(PrinterStatus.NoPaper.toString())
                                .errorCondition(ErrorCondition.Aborted)
                                        .build()
                                )
                        .build())
                .build();

        System.out.println(response.toJson());
    }



    @Test
    public void testPaymentResponseWithCardDataExpiry(){
        List<PaymentReceipt> receipts = new LinkedList<PaymentReceipt>();
        receipts.add(new PaymentReceipt.Builder()
                .integratedPrintFlag(false)
                .documentQualifier("Title")
                .requiredSignatureFlag(true)
                .build());

        PaymentResult paymentResult = new PaymentResult.Builder()
                .paymentType(PaymentType.Normal)
                .paymentInstrumentData(new PaymentInstrumentData.Builder()
                        .paymentInstrumentType(PaymentInstrumentType.Card)
                        .cardData(new PaymentResponseCardData.Builder()
                                .expiry("20/07/2027")
                                .paymentBrand(PaymentBrand.Card)
                                .entryMode(EntryMode.Tapped)
                                .maskedPAN("TestMaskedPAN")
                                .build())
                        .build())
                .onlineFlag(true)
                .build();

        SaleToPOIResponse response = new SaleToPOIResponse.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .protocolVersion("3.1")
                        .messageClass(MessageClass.Service)
                        .messageCategory(MessageCategory.Login)
                        .messageType(MessageType.Request)
                        .serviceID("X")
                        .saleID("X")
                        .POIID("x")
                        .build())
                .response(new PaymentResponse.Builder()
                        .response(new Response.Builder().result(ResponseResult.Success).build())
                        .saleData(
                                new PaymentResponseSaleData.Builder()
                                        .operatorID("opID")
                                        .operatorLanguage("en")
                                        .shiftNumber("shift1")
                                        .saleReferenceID("salesref1")
                                        .saleTerminalData(new SaleTerminalData.Builder()
                                                .deviceID("deviceId1")
                                                .build())
                                        .saleTransactionID(new SaleTransactionID.Builder()
                                                .transactionID("x")
                                                .timestamp(Instant.ofEpochMilli(System.currentTimeMillis()))
                                                .build()
                                        ).build()
                        )
                        .POIData(
                                new POIData.Builder()
                                        .POITransactionID(new POITransactionID("id", Instant.ofEpochMilli(System.currentTimeMillis())))
                                        .POIReconciliationID("x")
                                        .build()
                        )
                        .paymentReceipt(receipts)
                        .paymentResult(paymentResult)
                        .build())
                .build();

        System.out.println(response.toJson());
    }
    @Test
    public void testPaymentResponseWitAdditionalAmounts(){
        List<PaymentReceipt> receipts = new LinkedList<PaymentReceipt>();
        receipts.add(new PaymentReceipt.Builder()
                .integratedPrintFlag(false)
                .documentQualifier("Title")
                .requiredSignatureFlag(true)
                .build());

        AdditionalAmount additionalAmount = new AdditionalAmount.Builder()
                .name("SurchargeTax")
                .value(new BigDecimal(123))
                .build();

        AmountsResp amountsResp = new AmountsResp.Builder()
                .currency("AUD")
                .authorizedAmount(new BigDecimal(123))
                .additionalAmount(additionalAmount)
                .build();

        SaleToPOIResponse response = new SaleToPOIResponse.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .protocolVersion("3.1")
                        .messageClass(MessageClass.Service)
                        .messageCategory(MessageCategory.Login)
                        .messageType(MessageType.Request)
                        .serviceID("X")
                        .saleID("X")
                        .POIID("x")
                        .build())
                .response(new PaymentResponse.Builder()
                        .response(new Response.Builder().result(ResponseResult.Success).build())
                        .saleData(
                                new PaymentResponseSaleData(new SaleTransactionID.Builder()
                                        .transactionID("x")
                                        .timestamp(Instant.ofEpochMilli(System.currentTimeMillis()))
                                        .build())
                        )
                        .POIData(
                                new POIData.Builder()
                                        .POITransactionID(new POITransactionID("id", Instant.ofEpochMilli(System.currentTimeMillis())))
                                        .POIReconciliationID("x")
                                        .build()
                        )
                        .paymentResult(new PaymentResult.Builder()
                                .paymentType(PaymentType.Normal)
                                .paymentInstrumentData(new PaymentInstrumentData.Builder()
                                        .paymentInstrumentType(PaymentInstrumentType.Card)
                                        .cardData(new PaymentResponseCardData.Builder()
                                                .entryMode(EntryMode.Tapped)
                                                .paymentBrand(PaymentBrand.VISA)
                                                .maskedPAN("464516XXXXXX1111")
                                                .build())
                                        .build())
                                .amountsResp(amountsResp)
                                .onlineFlag(true)
                                .build())
                        .paymentReceipt(receipts)
                        .build())
                .build();

        System.out.println(response.toJson());
    }

    @Test
    public void testPartialPaymentResponse(){

        AmountsResp amountsResp = new AmountsResp.Builder()
                .currency("AUD")
                .authorizedAmount(new BigDecimal(2))
                .partialAuthorizedAmount(new BigDecimal(2))
                .requestedAmount(new BigDecimal(5))
                .surchargeAmount(new BigDecimal(0))
                .cashBackAmount(new BigDecimal(0))
                .tipAmount(new BigDecimal(0))
                .build();

        SaleToPOIResponse response = new SaleToPOIResponse.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .protocolVersion("3.1")
                        .messageClass(MessageClass.Service)
                        .messageCategory(MessageCategory.Payment)
                        .messageType(MessageType.Request)
                        .serviceID("X")
                        .saleID("X")
                        .POIID("x")
                        .build())
                .response(new PaymentResponse.Builder()
                        .response(new Response.Builder().result(ResponseResult.Success).build())
                        .saleData(
                                new PaymentResponseSaleData(new SaleTransactionID.Builder()
                                        .transactionID("x")
                                        .timestamp(Instant.ofEpochMilli(System.currentTimeMillis()))
                                        .build())
                        )
                        .POIData(
                                new POIData.Builder()
                                        .POITransactionID(new POITransactionID("id", Instant.ofEpochMilli(System.currentTimeMillis())))
                                        .POIReconciliationID("x")
                                        .build()
                        )
                        .paymentResult(new PaymentResult.Builder()
                                .paymentType(PaymentType.Normal)
                                .paymentInstrumentData(new PaymentInstrumentData.Builder()
                                        .paymentInstrumentType(PaymentInstrumentType.Card)
                                        .cardData(new PaymentResponseCardData.Builder()
                                                .entryMode(EntryMode.Tapped)
                                                .paymentBrand(PaymentBrand.VISA)
                                                .maskedPAN("464516XXXXXX1111")
                                                .build())
                                        .build())
                                .amountsResp(amountsResp)
                                .onlineFlag(true)
                                .build())
                        .build())
                .build();

        System.out.println(response.toJson());
        if ((!response.getPaymentResponse().getResponse().getResult().equals(ResponseResult.Partial)))
            throw new AssertionError();

    }

    @Test
    public void testPartialPaymentResponseWithTip(){ //TODO test null amounts and other amounts

        AmountsResp amountsResp = new AmountsResp.Builder()
                .currency("AUD")
                .authorizedAmount(new BigDecimal(2))
                .partialAuthorizedAmount(new BigDecimal(2))
                .requestedAmount(new BigDecimal(5))
                .tipAmount(new BigDecimal(1))
                .build();

        SaleToPOIResponse response = new SaleToPOIResponse.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .protocolVersion("3.1")
                        .messageClass(MessageClass.Service)
                        .messageCategory(MessageCategory.Payment)
                        .messageType(MessageType.Request)
                        .serviceID("X")
                        .saleID("X")
                        .POIID("x")
                        .build())
                .response(new PaymentResponse.Builder()
                        .response(new Response.Builder().result(ResponseResult.Success).build())
                        .saleData(
                                new PaymentResponseSaleData(new SaleTransactionID.Builder()
                                        .transactionID("x")
                                        .timestamp(Instant.ofEpochMilli(System.currentTimeMillis()))
                                        .build())
                        )
                        .POIData(
                                new POIData.Builder()
                                        .POITransactionID(new POITransactionID("id", Instant.ofEpochMilli(System.currentTimeMillis())))
                                        .POIReconciliationID("x")
                                        .build()
                        )
                        .paymentResult(new PaymentResult.Builder()
                                .paymentType(PaymentType.Normal)
                                .paymentInstrumentData(new PaymentInstrumentData.Builder()
                                        .paymentInstrumentType(PaymentInstrumentType.Card)
                                        .cardData(new PaymentResponseCardData.Builder()
                                                .entryMode(EntryMode.Tapped)
                                                .paymentBrand(PaymentBrand.VISA)
                                                .maskedPAN("464516XXXXXX1111")
                                                .build())
                                        .build())
                                .amountsResp(amountsResp)
                                .onlineFlag(true)
                                .build())
                        .build())
                .build();

        System.out.println(response.toJson());

        if ((!response.getPaymentResponse().getResponse().getResult().equals(ResponseResult.Success)))
            throw new AssertionError();
    }

    @Test
    public void testPartialPaymentResponseWithNulls(){ //TODO test null amounts and other amounts

        AmountsResp amountsResp = new AmountsResp.Builder()
                .currency("AUD")
                .authorizedAmount(new BigDecimal(2))
                .partialAuthorizedAmount(new BigDecimal(2))
                .requestedAmount(new BigDecimal(5))
                .build();

        SaleToPOIResponse response = new SaleToPOIResponse.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .protocolVersion("3.1")
                        .messageClass(MessageClass.Service)
                        .messageCategory(MessageCategory.Payment)
                        .messageType(MessageType.Request)
                        .serviceID("X")
                        .saleID("X")
                        .POIID("x")
                        .build())
                .response(new PaymentResponse.Builder()
                        .response(new Response.Builder().result(ResponseResult.Success).build())
                        .saleData(
                                new PaymentResponseSaleData(new SaleTransactionID.Builder()
                                        .transactionID("x")
                                        .timestamp(Instant.ofEpochMilli(System.currentTimeMillis()))
                                        .build())
                        )
                        .POIData(
                                new POIData.Builder()
                                        .POITransactionID(new POITransactionID("id", Instant.ofEpochMilli(System.currentTimeMillis())))
                                        .POIReconciliationID("x")
                                        .build()
                        )
                        .paymentResult(new PaymentResult.Builder()
                                .paymentType(PaymentType.Normal)
                                .paymentInstrumentData(new PaymentInstrumentData.Builder()
                                        .paymentInstrumentType(PaymentInstrumentType.Card)
                                        .cardData(new PaymentResponseCardData.Builder()
                                                .entryMode(EntryMode.Tapped)
                                                .paymentBrand(PaymentBrand.VISA)
                                                .maskedPAN("464516XXXXXX1111")
                                                .build())
                                        .build())
                                .amountsResp(amountsResp)
                                .onlineFlag(true)
                                .build())
                        .build())
                .build();

        System.out.println(response.toJson());

        if ((!response.getPaymentResponse().getResponse().getResult().equals(ResponseResult.Partial)))
            throw new AssertionError();
    }

    @Test
    public void testPaymentResponseClosedLoopPaymentBrand(){
        List<PaymentReceipt> receipts = new LinkedList<PaymentReceipt>();
        receipts.add(new PaymentReceipt.Builder()
                .integratedPrintFlag(false)
                .documentQualifier("Title")
                .requiredSignatureFlag(true)
                .build());

        AdditionalAmount additionalAmount = new AdditionalAmount.Builder()
                .name("SurchargeTax")
                .value(new BigDecimal(123))
                .build();

        AmountsResp amountsResp = new AmountsResp.Builder()
                .currency("AUD")
                .authorizedAmount(new BigDecimal(123))
                .additionalAmount(additionalAmount)
                .build();

        SaleToPOIResponse response = new SaleToPOIResponse.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .protocolVersion("3.1")
                        .messageClass(MessageClass.Service)
                        .messageCategory(MessageCategory.Login)
                        .messageType(MessageType.Request)
                        .serviceID("X")
                        .saleID("X")
                        .POIID("x")
                        .build())
                .response(new PaymentResponse.Builder()
                        .response(new Response.Builder().result(ResponseResult.Success).build())
                        .saleData(
                                new PaymentResponseSaleData(new SaleTransactionID.Builder()
                                        .transactionID("x")
                                        .timestamp(Instant.ofEpochMilli(System.currentTimeMillis()))
                                        .build())
                        )
                        .POIData(
                                new POIData.Builder()
                                        .POITransactionID(new POITransactionID("id", Instant.ofEpochMilli(System.currentTimeMillis())))
                                        .POIReconciliationID("x")
                                        .build()
                        )
                        .paymentResult(new PaymentResult.Builder()
                                .paymentType(PaymentType.Normal)
                                .paymentInstrumentData(new PaymentInstrumentData.Builder()
                                        .paymentInstrumentType(PaymentInstrumentType.Card)
                                        .cardData(new PaymentResponseCardData.Builder()
                                                .entryMode(EntryMode.Tapped)
                                                .paymentBrand(PaymentBrand.ACTTSS)
                                                .maskedPAN("464516XXXXXX1111")
                                                .build())
                                        .build())
                                .amountsResp(amountsResp)
                                .onlineFlag(true)
                                .build())
                        .paymentReceipt(receipts)
                        .build())
                .build();

        System.out.println(response.toJson());
    }

    @Test
    public void testPaymentPaymentClassificationWithEnumValues(){
        List<PaymentReceipt> receipts = new LinkedList<PaymentReceipt>();
        receipts.add(new PaymentReceipt.Builder()
                .integratedPrintFlag(false)
                .documentQualifier("Title")
                .requiredSignatureFlag(true)
                .build());

        AdditionalAmount additionalAmount = new AdditionalAmount.Builder()
                .name("SurchargeTax")
                .value(new BigDecimal(123))
                .build();

        AmountsResp amountsResp = new AmountsResp.Builder()
                .currency("AUD")
                .authorizedAmount(new BigDecimal(123))
                .additionalAmount(additionalAmount)
                .build();

        SaleToPOIResponse response = new SaleToPOIResponse.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .protocolVersion("3.1")
                        .messageClass(MessageClass.Service)
                        .messageCategory(MessageCategory.Payment)
                        .messageType(MessageType.Request)
                        .serviceID("X")
                        .saleID("X")
                        .POIID("x")
                        .build())
                .response(new PaymentResponse.Builder()
                        .response(new Response.Builder().result(ResponseResult.Success).build())
                        .saleData(
                                new PaymentResponseSaleData(new SaleTransactionID.Builder()
                                        .transactionID("x")
                                        .timestamp(Instant.ofEpochMilli(System.currentTimeMillis()))
                                        .build())
                        )
                        .POIData(
                                new POIData.Builder()
                                        .POITransactionID(new POITransactionID("id", Instant.ofEpochMilli(System.currentTimeMillis())))
                                        .POIReconciliationID("x")
                                        .build()
                        )
                        .paymentResult(new PaymentResult.Builder()
                                .paymentType(PaymentType.Normal)
                                .paymentInstrumentData(new PaymentInstrumentData.Builder()
                                        .paymentInstrumentType(PaymentInstrumentType.Card)
                                        .cardData(new PaymentResponseCardData.Builder()
                                                .entryMode(EntryMode.Tapped)
                                                .maskedPAN("464516XXXXXX1111")
                                                .paymentBrand(PaymentBrand.DinersClub)
                                                .account("Savings")
                                                .mapPaymentClassification(new PaymentClassification.Builder()
                                                        .productId("0204")
                                                        .productName("ACT TSS")
                                                        .productLabel("ACT TSS label")
                                                        .method("Swipe")
                                                        .account("Cheque")
                                                        .countryCode("036")
                                                        .build())
                                                .build())
                                        .build())
                                .amountsResp(amountsResp)
                                .onlineFlag(true)
                                .build())
                        .paymentReceipt(receipts)
                        .build())
                .build();

        System.out.println(response.toJson());

        assert (response.getPaymentResponse().getPaymentResult().getPaymentInstrumentData().getCardData().getPaymentBrand().equals(PaymentBrand.DinersClub));
        assert (response.getPaymentResponse().getPaymentResult().getPaymentInstrumentData().getCardData().getEntryMode().equals(EntryMode.Tapped));
        assert (response.getPaymentResponse().getPaymentResult().getPaymentInstrumentData().getCardData().getAccount().equals("Savings"));
    }

    @Test
    public void testPaymentPaymentClassificationWithoutEnumValues(){
        List<PaymentReceipt> receipts = new LinkedList<PaymentReceipt>();
        receipts.add(new PaymentReceipt.Builder()
                .integratedPrintFlag(false)
                .documentQualifier("Title")
                .requiredSignatureFlag(true)
                .build());

        AdditionalAmount additionalAmount = new AdditionalAmount.Builder()
                .name("SurchargeTax")
                .value(new BigDecimal(123))
                .build();

        AmountsResp amountsResp = new AmountsResp.Builder()
                .currency("AUD")
                .authorizedAmount(new BigDecimal(123))
                .additionalAmount(additionalAmount)
                .build();

        SaleToPOIResponse response = new SaleToPOIResponse.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .protocolVersion("3.1")
                        .messageClass(MessageClass.Service)
                        .messageCategory(MessageCategory.Payment)
                        .messageType(MessageType.Request)
                        .serviceID("X")
                        .saleID("X")
                        .POIID("x")
                        .build())
                .response(new PaymentResponse.Builder()
                        .response(new Response.Builder().result(ResponseResult.Success).build())
                        .saleData(
                                new PaymentResponseSaleData(new SaleTransactionID.Builder()
                                        .transactionID("x")
                                        .timestamp(Instant.ofEpochMilli(System.currentTimeMillis()))
                                        .build())
                        )
                        .POIData(
                                new POIData.Builder()
                                        .POITransactionID(new POITransactionID("id", Instant.ofEpochMilli(System.currentTimeMillis())))
                                        .POIReconciliationID("x")
                                        .build()
                        )
                        .paymentResult(new PaymentResult.Builder()
                                .paymentType(PaymentType.Normal)
                                .paymentInstrumentData(new PaymentInstrumentData.Builder()
                                        .paymentInstrumentType(PaymentInstrumentType.Card)
                                        .cardData(new PaymentResponseCardData.Builder()
                                                .maskedPAN("464516XXXXXX1111")
                                                .mapPaymentClassification(new PaymentClassification.Builder()
                                                        .productId("0204")
                                                        .productName("ACT TSS")
                                                        .productLabel("ACT TSS label")
                                                        .method("Swipe")
                                                        .account("Cheque")
                                                        .countryCode("036")
                                                        .build())
                                                .build())
                                        .build())
                                .amountsResp(amountsResp)
                                .onlineFlag(true)
                                .build())
                        .paymentReceipt(receipts)
                        .build())
                .build();

        System.out.println(response.toJson());

        assert (response.getPaymentResponse().getPaymentResult().getPaymentInstrumentData().getCardData().getPaymentBrand().equals(PaymentBrand.ACTTSS));
        assert (response.getPaymentResponse().getPaymentResult().getPaymentInstrumentData().getCardData().getEntryMode().equals(EntryMode.MagStripe));
        assert (response.getPaymentResponse().getPaymentResult().getPaymentInstrumentData().getCardData().getAccount().equals("Cheque"));
    }

    @Test
    public void testSplitPaymentResponseCard(){

        AmountsResp amountsResp = new AmountsResp.Builder()
                .currency("AUD")
                .authorizedAmount(new BigDecimal(53))
                .partialAuthorizedAmount(new BigDecimal(50))
                .requestedAmount(new BigDecimal(100))
                .surchargeAmount(new BigDecimal(1))
                .cashBackAmount(new BigDecimal(0))
                .tipAmount(new BigDecimal(2))
                .build();

        SaleToPOIResponse response = new SaleToPOIResponse.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .protocolVersion("3.1")
                        .messageClass(MessageClass.Service)
                        .messageCategory(MessageCategory.Payment)
                        .messageType(MessageType.Request)
                        .serviceID("X")
                        .saleID("X")
                        .POIID("x")
                        .build())
                .response(new PaymentResponse.Builder()
                        .response(new Response.Builder().result(ResponseResult.Success).build())
                        .saleData(
                                new PaymentResponseSaleData(new SaleTransactionID.Builder()
                                        .transactionID("x")
                                        .timestamp(Instant.ofEpochMilli(System.currentTimeMillis()))
                                        .build())
                        )
                        .POIData(
                                new POIData.Builder()
                                        .POITransactionID(new POITransactionID("id", Instant.ofEpochMilli(System.currentTimeMillis())))
                                        .POIReconciliationID("x")
                                        .build()
                        )
                        .paymentResult(new PaymentResult.Builder()
                                .paymentType(PaymentType.Normal)
                                .paymentInstrumentData(new PaymentInstrumentData.Builder()
                                        .paymentInstrumentType(PaymentInstrumentType.Card)
                                        .cardData(new PaymentResponseCardData.Builder()
                                                .entryMode(EntryMode.Tapped)
                                                .paymentBrand(PaymentBrand.VISA)
                                                .maskedPAN("464516XXXXXX1111")
                                                .build())
                                        .build())
                                .splitPaymentFlag(true)
                                .amountsResp(amountsResp)
                                .onlineFlag(true)
                                .build())
                        .build())
                .build();

        System.out.println(response.toJson());
        if ((!response.getPaymentResponse().getResponse().getResult().equals(ResponseResult.Partial)))
            throw new AssertionError();

    }

    @Test
    public void testSplitPaymentResponseCash(){

        AmountsResp amountsResp = new AmountsResp.Builder()
                .currency("AUD")
                .authorizedAmount(new BigDecimal(53))
                .partialAuthorizedAmount(new BigDecimal(50))
                .requestedAmount(new BigDecimal(100))
                .surchargeAmount(new BigDecimal(1))
                .cashBackAmount(new BigDecimal(0))
                .tipAmount(new BigDecimal(2))
                .build();

        SaleToPOIResponse response = new SaleToPOIResponse.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .protocolVersion("3.1")
                        .messageClass(MessageClass.Service)
                        .messageCategory(MessageCategory.Payment)
                        .messageType(MessageType.Request)
                        .serviceID("X")
                        .saleID("X")
                        .POIID("x")
                        .build())
                .response(new PaymentResponse.Builder()
                        .response(new Response.Builder().result(ResponseResult.Success).build())
                        .saleData(
                                new PaymentResponseSaleData(new SaleTransactionID.Builder()
                                        .transactionID("x")
                                        .timestamp(Instant.ofEpochMilli(System.currentTimeMillis()))
                                        .build())
                        )
                        .POIData(
                                new POIData.Builder()
                                        .POITransactionID(new POITransactionID("id", Instant.ofEpochMilli(System.currentTimeMillis())))
                                        .POIReconciliationID("x")
                                        .build()
                        )
                        .paymentResult(new PaymentResult.Builder()
                                .paymentType(PaymentType.Normal)
                                .paymentInstrumentData(new PaymentInstrumentData.Builder()
                                        .paymentInstrumentType(PaymentInstrumentType.Cash)
                                        .build())
                                .splitPaymentFlag(true)
                                .amountsResp(amountsResp)
                                .onlineFlag(true)
                                .build())
                        .build())
                .build();

        System.out.println(response.toJson());
        if ((!response.getPaymentResponse().getResponse().getResult().equals(ResponseResult.Partial)))
            throw new AssertionError();

    }

    @Test
    public void testSplitPaymentResponseFinal(){

        AmountsResp amountsResp = new AmountsResp.Builder()
                .currency("AUD")
                .authorizedAmount(new BigDecimal(53))
                .partialAuthorizedAmount(new BigDecimal(50))
                .requestedAmount(new BigDecimal(50))
                .surchargeAmount(new BigDecimal(1))
                .cashBackAmount(new BigDecimal(0))
                .tipAmount(new BigDecimal(2))
                .build();

        SaleToPOIResponse response = new SaleToPOIResponse.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .protocolVersion("3.1")
                        .messageClass(MessageClass.Service)
                        .messageCategory(MessageCategory.Payment)
                        .messageType(MessageType.Request)
                        .serviceID("X")
                        .saleID("X")
                        .POIID("x")
                        .build())
                .response(new PaymentResponse.Builder()
                        .response(new Response.Builder().result(ResponseResult.Success).build())
                        .saleData(
                                new PaymentResponseSaleData(new SaleTransactionID.Builder()
                                        .transactionID("x")
                                        .timestamp(Instant.ofEpochMilli(System.currentTimeMillis()))
                                        .build())
                        )
                        .POIData(
                                new POIData.Builder()
                                        .POITransactionID(new POITransactionID("id", Instant.ofEpochMilli(System.currentTimeMillis())))
                                        .POIReconciliationID("x")
                                        .build()
                        )
                        .paymentResult(new PaymentResult.Builder()
                                .paymentType(PaymentType.Normal)
                                .paymentInstrumentData(new PaymentInstrumentData.Builder()
                                        .paymentInstrumentType(PaymentInstrumentType.Cash)
                                        .build())
                                .splitPaymentFlag(true)
                                .amountsResp(amountsResp)
                                .onlineFlag(true)
                                .build())
                        .build())
                .build();

        System.out.println(response.toJson());
        if ((!response.getPaymentResponse().getResponse().getResult().equals(ResponseResult.Success)))
            throw new AssertionError();

    }
}

