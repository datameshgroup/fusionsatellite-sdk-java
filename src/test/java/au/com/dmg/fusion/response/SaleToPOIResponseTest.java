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

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

import au.com.dmg.fusion.data.*;
import au.com.dmg.fusion.response.paymentresponse.*;
import org.junit.Test;

import au.com.dmg.fusion.MessageHeader;
import au.com.dmg.fusion.request.paymentrequest.POIData;
import au.com.dmg.fusion.request.paymentrequest.POITransactionID;
import au.com.dmg.fusion.request.paymentrequest.SaleTransactionID;
import au.com.dmg.fusion.response.inputresponse.InputResponse;
import au.com.dmg.fusion.response.inputresponse.InputResult;

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
                                .poiStatus(new POIStatus("globalstatus", true, true, true, "status", true, true))
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
                                new PaymentResponseSaleData(new SaleTransactionID.Builder()
                                        .transactionID("x")
                                        .timestamp(Instant.ofEpochMilli(System.currentTimeMillis()))
                                        .build(), "reference")
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
                                        .build(), "reference")
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
                                        .amountsResp(new AmountsResp.Builder()
                                                .loyaltyAmount(new BigDecimal("50.0"))
                                                .authorizedAmount(new BigDecimal("100.0"))
                                                .build()
                                        )
                                        .paymentInstrumentData(new PaymentInstrumentData.Builder()
                                                .loyaltyData(new LoyaltyData.Builder()
                                                        .loyaltyBrand("Qantas")
                                                        .build())
                                                .build())
                                        .onlineFlag(true)
                                        .build()
                        )
                        .paymentReceipt(receipts)
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
}