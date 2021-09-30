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

package au.com.dmg.fusion.request.paymentrequest;

import au.com.dmg.fusion.Message;
import au.com.dmg.fusion.MessageHeader;
import au.com.dmg.fusion.data.*;
import au.com.dmg.fusion.request.SaleTerminalData;
import au.com.dmg.fusion.request.SaleToPOIRequest;
import au.com.dmg.fusion.request.aborttransactionrequest.AbortTransactionRequest;
import au.com.dmg.fusion.request.loginrequest.LoginRequest;
import au.com.dmg.fusion.request.loginrequest.SaleSoftware;
import au.com.dmg.fusion.request.transactionstatusrequest.MessageReference;
import junit.framework.TestCase;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedList;

public class SaleToPOIRequestTest extends TestCase {


    public void testToJson() {
        PaymentRequest paymentRequest = new PaymentRequest.Builder()
                .saleData(new SaleData.Builder()
                        .saleReferenceID("saleref")
                        .operatorID("operatorID")
                        .operatorLanguage("en")
                        .shiftNumber("shiftno")
                        .tokenRequestedType("todo")
                        .saleTransactionID(new SaleTransactionID.Builder("x", Instant.ofEpochMilli(System.currentTimeMillis())).build())
                        .build()
                )
                .paymentTransaction(new PaymentTransaction.Builder()
                        .amountsReq(new AmountsReq.Builder()
                                .currency("AUD")
                                .requestedAmount(new BigDecimal("5.0"))
                                .build()
                        )
                        .originalPOITransactionObject(new OriginalPOITransaction.Builder()
                                .saleID("saleID")
                                .POIID("POIID")
                                .POITransactionID(
                                        new POITransactionID("id", Instant.ofEpochMilli(System.currentTimeMillis()))
                                )
                                .build()
                        )
                        .transactionConditions(new TransactionConditions.Builder()
                                .allowedPaymentBrands(new LinkedList<PaymentBrand>())
                                .build()
                        )
                        .addSaleItem(
                                new SaleItem.Builder()
                                        .itemID(1)
                                        .productCode("X")
                                        .eanUpc("xxx")
                                        .unitOfMeasure(UnitOfMeasure.Centilitre)
                                        .quantity(new BigDecimal("1.0"))
                                        .unitPrice(new BigDecimal(1.0))
                                        .itemAmount(new BigDecimal("1.0"))
                                        .productLabel("xx")
                                        .build()
                        )
                        .paymentData(new PaymentData.Builder().paymentType(PaymentType.Normal).build())
                        .build()
                ).build();

        SaleToPOIRequest request = new SaleToPOIRequest.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .messageCategory(MessageCategory.Display)
                        .messageClass(MessageClass.Device)
                        .messageType(MessageType.Notification)
                        .serviceID("ServiceID")
                        .build())
                .request(paymentRequest)
                .build();

        String json = new Message(request).toJson();
        System.out.println(json);
        assert (json != null && json != "");
    }

    public void testFromJson() {
        String jsonString = "{\"SaleToPOIRequest\":{\"MessageHeader\":{\"MessageCategory\":\"Display\",\"MessageClass\":\"Device\",\"MessageType\":\"Notification\",\"ServiceID\":\"ServiceID\"},\"PaymentRequest\":{\"PaymentTransaction\":{\"AmountsReq\":{\"Currency\":\"AUD\",\"RequestedAmount\":\"5.0\"},\"OriginalPOITransactionObject\":{\"POIID\":\"POIID\",\"POITransactionID\":{\"TimeStamp\":\"2021-09-28T01:32:51.262Z\",\"TransactionID\":\"id\"},\"SaleID\":\"saleID\"},\"PaymentData\":{\"PaymentType\":\"Normal\"},\"SaleItem\":[{\"EanUpc\":\"xxx\",\"ImageUrls\":[],\"ItemAmount\":\"1.0\",\"ItemID\":1,\"ProductCode\":\"X\",\"ProductLabel\":\"xx\",\"Quantity\":\"1.0\",\"Restricted\":false,\"SaleChannel\":\"Unknown\",\"Tags\":[],\"TaxCode\":\"GST\",\"UnitOfMeasure\":\"Centilitre\",\"UnitPrice\":\"1\"}],\"TransactionConditions\":{\"AcquirerID\":[],\"AllowedPaymentBrands\":[]}},\"SaleData\":{\"OperatorID\":\"operatorID\",\"OperatorLanguage\":\"en\",\"SaleReferenceID\":\"saleref\",\"SaleTransactionID\":{\"TimeStamp\":\"2021-09-28T01:32:51.257Z\",\"TransactionID\":\"x\"},\"ShiftNumber\":\"shiftno\",\"TokenRequestedType\":\"todo\"}}}}";
        SaleToPOIRequest request = null;
        try {
            request = Message.fromJson(jsonString).getRequest();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert (request != null);
        assert (request.getMessageHeader().getMessageClass() == MessageClass.Device);
    }

    public void testAbortTransactionRequest() {
        SaleToPOIRequest request = new SaleToPOIRequest.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .messageCategory(MessageCategory.Payment)
                        .messageClass(MessageClass.Device)
                        .messageType(MessageType.Request)
                        .serviceID("ServiceID")
                        .protocolVersion("1")
                        .build())
                .request(new AbortTransactionRequest(new MessageReference.Builder()
                        .messageCategory(MessageCategory.TransactionStatus)
                        .POIID("POIID")
                        .saleID("SaLEID")
                        .serviceID("SerVICE ID")
                        .build(),
                        "myreason"))
                .build();

        System.out.println(request.toJson());
    }

    public void testLoginRequest() {
        MessageHeader header = new MessageHeader.Builder()
                .protocolVersion("3.1-dmg")
                .messageClass(MessageClass.Service)
                .messageCategory(MessageCategory.Login)
                .messageType(MessageType.Request)
                .serviceID("myserviceid")
                .saleID("mysaleid")
                .POIID("mypoid")
                .build();
        LoginRequest loginRequest = new LoginRequest.Builder()
                .dateTime("date")
                .saleSoftware(new SaleSoftware.Builder()
                        .providerIdentification("provider")
                        .applicationName("appname")
                        .softwareVersion("fef")
                        .certificationCode("efe")
                        .build()
                )
                .saleTerminalData(new SaleTerminalData.Builder()
                        .terminalEnvironment(TerminalEnvironment.Unknown)
                        .addSaleCapabilities(SaleCapability.Unknown)
                        .totalsGroupID("totalgroup").build())
                .operatorLanguage("lang")
                .operatorID("wd")
                .shiftNumber("x")
                .POISerialNumber("POISERIALNUMBER")
                .build();

        SaleToPOIRequest request = new SaleToPOIRequest.Builder()
                .messageHeader(header)
                .request(loginRequest)
                .build();

        System.out.println(request.toJson());
    }


}