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


import au.com.dmg.fusion.MessageHeader;
import au.com.dmg.fusion.data.*;
import au.com.dmg.fusion.request.SaleTerminalData;
import au.com.dmg.fusion.request.paymentrequest.POIData;
import au.com.dmg.fusion.request.paymentrequest.POITransactionID;
import au.com.dmg.fusion.request.paymentrequest.SaleTransactionID;
import au.com.dmg.fusion.response.adminresponse.AdminResponse;
import au.com.dmg.fusion.response.inputresponse.Input;
import au.com.dmg.fusion.response.inputresponse.InputResponse;
import au.com.dmg.fusion.response.inputresponse.InputResult;
import au.com.dmg.fusion.response.paymentresponse.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThrows;

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
                        .inputResult(new InputResult.Builder().device("device").infoQualify("d").response(new Response.Builder()
                                .additionalResponse("x")
                                .result(ResponseResult.Success)
                                .build()).input(new Input.Builder()
                                .inputCommand(InputCommand.GetConfirmation)
                                .confirmedFlag(true)
                                .build()).build())
                        .build())
                .build();

        System.out.println(response.toJson());
    }

    @Test
    public void testResponseSuccessMissingInput() {
        NullPointerException exceptionMissingInput =
                assertThrows(NullPointerException.class,
                        () -> new SaleToPOIResponse.Builder()
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
                                        .inputResult(new InputResult.Builder().device("device").infoQualify("d").response(new Response.Builder()
                                                .additionalResponse("x")
                                                .result(ResponseResult.Success)
                                                .build()).build())
                                        .build())
                                .build());
        System.out.println("SaleToPOIResponseTest - testResponseSuccessMissingInput");
        assertEquals("The property \"input\" is null. "
                + "Please set the value by \"input()\". "
                + "The property \"input\" is required when result is not failure.", exceptionMissingInput.getMessage());
    }

    @Test
    public void testResponseFaiureMissingInput() {
        SaleToPOIResponse response =
                new SaleToPOIResponse.Builder()
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
                                .inputResult(new InputResult.Builder().device("device").infoQualify("d").response(new Response.Builder()
                                        .additionalResponse("x")
                                        .result(ResponseResult.Failure)
                                        .build()).build())
                                .build())
                        .build();
        System.out.println(response.toJson());
    }


    @Test
    public void testInvalidInput() {
        NullPointerException exceptionInvalidInput =
                assertThrows(NullPointerException.class,
                        () -> new SaleToPOIResponse.Builder()
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
                                        .inputResult(new InputResult.Builder().device("device").infoQualify("d").response(new Response.Builder()
                                                .additionalResponse("x")
                                                .result(ResponseResult.Success)
                                                .build()).input(new Input.Builder()
                                                .build()).build())
                                        .build())
                                .build());
        System.out.println("SaleToPOIResponseTest - testInvalidInput - Missing InputCommand");
        assertEquals("The property \"inputCommand\" is null. "
                + "Please set the value by \"inputCommand()\". "
                + "The property \"inputCommand\" is required.", exceptionInvalidInput.getMessage());
    }

    @Test
    public void testInvalidGetConfirmationInput() {
        NullPointerException exceptionInvalidInput =
                assertThrows(NullPointerException.class,
                        () -> new SaleToPOIResponse.Builder()
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
                                        .inputResult(new InputResult.Builder().device("device").infoQualify("d").response(new Response.Builder()
                                                .additionalResponse("x")
                                                .result(ResponseResult.Success)
                                                .build()).input(new Input.Builder()
                                                .inputCommand(InputCommand.GetConfirmation)
                                                .build()).build())
                                        .build())
                                .build());
        System.out.println("SaleToPOIResponseTest - testInvalidGetConfirmationInput");
        assertEquals("The property \"confirmedFlag\" is null. "
                + "Please set the value by \"confirmedFlag()\". "
                + "The property \"confirmedFlag\" is required for inputCommand=\"GetConfirmation\".", exceptionInvalidInput.getMessage());
    }

    @Test
    public void testInvalidTextStringInput() {
        NullPointerException exceptionInvalidInput =
                assertThrows(NullPointerException.class,
                        () -> new SaleToPOIResponse.Builder()
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
                                        .inputResult(new InputResult.Builder().device("device").infoQualify("d").response(new Response.Builder()
                                                .additionalResponse("x")
                                                .result(ResponseResult.Success)
                                                .build()).input(new Input.Builder()
                                                .inputCommand(InputCommand.TextString)
                                                .build()).build())
                                        .build())
                                .build());
        System.out.println("SaleToPOIResponseTest - testInvalidTextStringInput");
        assertEquals("The property \"textInput\" is null. "
                + "Please set the value by \"textInput()\". "
                + "The property \"textInput\" is required for inputCommand=\"TextString\".", exceptionInvalidInput.getMessage());
    }

    @Test
    public void testInvalidDigitStringInput() {
        NullPointerException exceptionInvalidInput =
                assertThrows(NullPointerException.class,
                        () -> new SaleToPOIResponse.Builder()
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
                                        .inputResult(new InputResult.Builder().device("device").infoQualify("d").response(new Response.Builder()
                                                .additionalResponse("x")
                                                .result(ResponseResult.Success)
                                                .build()).input(new Input.Builder()
                                                .inputCommand(InputCommand.DigitString)
                                                .build()).build())
                                        .build())
                                .build());
        System.out.println("SaleToPOIResponseTest - testInvalidDigitStringInput");
        assertEquals("The property \"digitInput\" is null. "
                + "Please set the value by \"digitInput()\". "
                + "The property \"digitInput\" is required for inputCommand=\"DigitString\".", exceptionInvalidInput.getMessage());
    }

    @Test
    public void testInvalidGetMenuEntryInput() {
        NullPointerException exceptionInvalidInput =
                assertThrows(NullPointerException.class,
                        () -> new SaleToPOIResponse.Builder()
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
                                        .inputResult(new InputResult.Builder().device("device").infoQualify("d").response(new Response.Builder()
                                                .additionalResponse("x")
                                                .result(ResponseResult.Success)
                                                .build()).input(new Input.Builder()
                                                .inputCommand(InputCommand.GetMenuEntry)
                                                .build()).build())
                                        .build())
                                .build());
        System.out.println("SaleToPOIResponseTest - testInvalidGetMenuEntryInput");
        assertEquals("The property \"menuEntryNumber\" is null. "
                + "Please set the value by \"menuEntryNumber()\". "
                + "The property \"menuEntryNumber\" is required for inputCommand=\"GetMenuEntry\".", exceptionInvalidInput.getMessage());
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
                        .isPartialCompatibilityMode(true)
                        .build())
                .build();

        System.out.println(response.toJson());
        if ((!response.getPaymentResponse().getResponse().getResult().equals(ResponseResult.Partial)))
            throw new AssertionError();
    }

    @Test
    public void testSuccessfulPaymentWithPartialAuthorizeAmountResponse(){

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
        if ((!response.getPaymentResponse().getResponse().getResult().equals(ResponseResult.Success)))
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
                        .isPartialCompatibilityMode(true)
                        .build())
                .build();

        System.out.println(response.toJson());

        if ((!response.getPaymentResponse().getResponse().getResult().equals(ResponseResult.Partial)))
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
                        .isPartialCompatibilityMode(true)
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
                                                        .productId("0204") //PaymentBrand.ACTTSS when mapped
                                                        .productName("Test ProductName")
                                                        .productLabel("Test Product label")
                                                        .method("Swipe")
                                                        .account("Cheque")
                                                        .countryCode("036")
                                                        .build())
                                                .build())
                                        .build())
                                .amountsResp(amountsResp)
                                .onlineFlag(true)
                                .rrn("12345")
                                .build())
                        .paymentReceipt(receipts)
                        .build())
                .build();

        System.out.println(response.toJson());

        assert (response.getPaymentResponse().getPaymentResult().getPaymentInstrumentData().getCardData().getPaymentBrand().equals(PaymentBrand.ACTTSS));
        assert (response.getPaymentResponse().getPaymentResult().getPaymentInstrumentData().getCardData().getEntryMode().equals(EntryMode.MagStripe));
        assert (response.getPaymentResponse().getPaymentResult().getPaymentInstrumentData().getCardData().getAccount().equals("Cheque"));
        assert (response.getPaymentResponse().getPaymentResult().getRrn().equals("12345"));
    }

    @Test
    public void testSplitPaymentResponseFinal(){

        AmountsResp amountsResp = new AmountsResp.Builder()
                .currency("AUD")
                .authorizedAmount(new BigDecimal(53))
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

    @Test
    public void testPaymentPOITransactionID() {
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
                                        .POITransactionID(new POITransactionID("id", Instant.parse("2024-05-08T04:52:21.125Z")))
                                        .POIReconciliationID("x")
                                        .build()
                        )
                        .paymentReceipt(receipts)
                        .build())
                .build();

        String jsonString = response.toJson();
        System.out.println(jsonString);
        assert(jsonString.contains("\"POITransactionID\":{\"TimeStamp\":\"2024-05-08T14:52:21.125+10:00\""));
    }
}

