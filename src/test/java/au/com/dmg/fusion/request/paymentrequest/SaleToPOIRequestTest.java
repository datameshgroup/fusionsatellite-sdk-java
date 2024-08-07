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
import au.com.dmg.fusion.request.paymentrequest.extenstiondata.ExtensionData;
import au.com.dmg.fusion.request.paymentrequest.extenstiondata.Stop;
import au.com.dmg.fusion.request.paymentrequest.extenstiondata.TransitData;
import au.com.dmg.fusion.request.paymentrequest.extenstiondata.Trip;
import au.com.dmg.fusion.request.transactionstatusrequest.MessageReference;
import au.com.dmg.fusion.util.PairingData;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

public class SaleToPOIRequestTest extends TestCase {


    public void testPaymentRequestToJson() {
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
                        .originalPOITransaction(new OriginalPOITransaction.Builder()
                                .saleID("saleID")
                                .POIID("POIID")
                                .POITransactionID(
                                        new POITransactionID("id", Instant.ofEpochMilli(System.currentTimeMillis()))
                                )
                                .build()
                        )
                        .transactionConditions(new TransactionConditions.Builder()
                                .allowedPaymentBrand(new LinkedList<String>())
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
                                        .addCustomField(new CustomField.Builder()
                                                .key("testSaleItemCustomFieldBuild")
                                                .type(CustomFieldType.String)
                                                .value("1")
                                                .build())
                                        .build()
                        )
                        .build()
                )
                .extensionData(new ExtensionData.Builder().transitData(
                                new TransitData.Builder()
                                        .isWheelchairEnabled(false)
                                        .tags(Arrays.asList("TransitDataTag1", "TransitDataTag2"))
                                        .odbs("testodbs")
                                        .trip(new Trip.Builder()
                                                .totalDistanceTravelled(new BigDecimal(222.22))
                                                .addStop(new Stop.Builder()
                                                        .stopIndex(0)
                                                        .stopName("test0")
                                                        .latitude(new BigDecimal(3432423))
                                                        .longitude(new BigDecimal(-3432423))
                                                        .timestamp(Instant.ofEpochMilli(System.currentTimeMillis()))
                                                        .build())
                                                .addStop(new Stop.Builder()
                                                        .stopIndex(1)
                                                        .stopName("test1")
                                                        .latitude(new BigDecimal(3432423))
                                                        .longitude(new BigDecimal(-3432423))
                                                        .timestamp(Instant.ofEpochMilli(System.currentTimeMillis()))
                                                        .build())
                                                .build())
                                        .tags(Arrays.asList("TransitDataTag1", "TransitDataTag2"))
                                        .build())
                        .build())
                .paymentData(new PaymentData.Builder().paymentType(PaymentType.Normal).build())
                .build();

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

    public void testPaymentRequestFromJson() {
      String jsonString = "{\"SaleToPOIRequest\":{\"MessageHeader\":{\"MessageCategory\":\"Service\",\"MessageClass\":\"Device\",\"MessageType\":\"Request\",\"ServiceID\":\"ServiceID\"},\"PaymentRequest\":{\"PaymentTransaction\":{\"AmountsReq\":{\"Currency\":\"AUD\",\"RequestedAmount\":\"5.0\"},\"OriginalPOITransactionObject\":{\"POIID\":\"POIID\",\"POITransactionID\":{\"TimeStamp\":\"2021-09-28T01:32:51.262Z\",\"TransactionID\":\"id\"},\"SaleID\":\"saleID\"},\"PaymentData\":{\"PaymentType\":\"Normal\"},\"SaleItem\":[{\"EanUpc\":\"xxx\",\"ImageUrls\":[],\"ItemAmount\":\"1.0\",\"ItemID\":1,\"ProductCode\":\"X\",\"ProductLabel\":\"xx\",\"Quantity\":\"1.0\",\"Restricted\":false,\"SaleChannel\":\"Unknown\",\"Tags\":[],\"TaxCode\":\"GST\",\"UnitOfMeasure\":\"Centilitre\",\"UnitPrice\":\"1\"}],\"TransactionConditions\":{\"AcquirerID\":[],\"AllowedPaymentBrand\":[]}},\"ExtensionData\":{\"TransitData\":{\"IsWheelchairEnabled\":false,\"ODBS\":\"test odbs\",\"Trip\":{\"Stops\":[{\"Latitude\":\"3432423\",\"Longitude\":\"-3432423\",\"StopIndex\":0,\"StopName\":\"test0\",\"Timestamp\":\"2023-06-22T01:52:39.625Z\"},{\"Latitude\":\"3432423\",\"Longitude\":\"-3432423\",\"StopIndex\":1,\"StopName\":\"test1\",\"Timestamp\":\"2023-06-22T01:52:39.625Z\"}],\"TotalDistanceTravelled\":\"222.219999999999998863131622783839702606201171875\"}}},\"SaleData\":{\"OperatorID\":\"operatorID\",\"OperatorLanguage\":\"en\",\"SaleReferenceID\":\"saleref\",\"SaleTransactionID\":{\"TimeStamp\":\"2021-09-28T01:32:51.257Z\",\"TransactionID\":\"x\"},\"ShiftNumber\":\"shiftno\",\"TokenRequestedType\":\"todo\"}}}}";
        SaleToPOIRequest request = null;
        try {
            request = Message.fromJson(jsonString).getRequest();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert (request != null);
        assert (request.getMessageHeader().getMessageClass() == MessageClass.Device);
        assert (Objects.equals(request.getPaymentRequest().getExtensionData().getTransitData().getODBS(), "test odbs"));
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

    @Test
    public void testLoginRequestwithPairingFalse() {
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
                .pairing(false)
                .build();

        SaleToPOIRequest request = new SaleToPOIRequest.Builder()
                .messageHeader(header)
                .request(loginRequest)
                .build();

        System.out.println(request.toJson());
        assert(!request.getLoginRequest().getPairing());
    }

    @Test
    public void testLoginRequestwithPairingTrue() {
        MessageHeader header = new MessageHeader.Builder()
                .protocolVersion("3.1-dmg")
                .messageClass(MessageClass.Service)
                .messageCategory(MessageCategory.Login)
                .messageType(MessageType.Request)
                .serviceID("myserviceid")
                .saleID("mysaleid")
                .POIID("PairingPOIID")
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
                .pairing(true)
                .build();

        SaleToPOIRequest request = new SaleToPOIRequest.Builder()
                .messageHeader(header)
                .request(loginRequest)
                .build();

        System.out.println(request.toJson());
        System.out.println(request.getLoginRequest().getPairing());
        assert(request.getLoginRequest().getPairing());
    }

    @Test
    public void testLoginRequestwithPairingNotSet() {
        MessageHeader header = new MessageHeader.Builder()
                .protocolVersion("3.1-dmg")
                .messageClass(MessageClass.Service)
                .messageCategory(MessageCategory.Login)
                .messageType(MessageType.Request)
                .serviceID("myserviceid")
                .saleID("mysaleid")
                .POIID("PairingPOIID")
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
                .build();

        SaleToPOIRequest request = new SaleToPOIRequest.Builder()
                .messageHeader(header)
                .request(loginRequest)
                .build();
        System.out.println(request.toJson());
        System.out.println(request.getLoginRequest().getPairing());
        assert(!request.getLoginRequest().getPairing());
    }

    @Test
    public void testCreateKEK() {
        String kek = PairingData.CreateKEK();
        System.out.println(kek);
        assert(kek.length() == 48);
    }

    @Test
    public void testLibVersion(){
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
                        .originalPOITransaction(new OriginalPOITransaction.Builder()
                                .saleID("saleID")
                                .POIID("POIID")
                                .POITransactionID(
                                        new POITransactionID("id", Instant.ofEpochMilli(System.currentTimeMillis()))
                                )
                                .build()
                        )
                        .transactionConditions(new TransactionConditions.Builder()
                                .allowedPaymentBrand(new LinkedList<String>())
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
                                        .addCustomField(new CustomField.Builder()
                                                .key("testSaleItemCustomFieldBuild")
                                                .type(CustomFieldType.String)
                                                .value("1")
                                                .build())
                                        .build()
                        )
                        .build()
                )
                .extensionData(new ExtensionData.Builder().transitData(
                                new TransitData.Builder()
                                        .isWheelchairEnabled(false)
                                        .tags(Arrays.asList("TransitDataTag1", "TransitDataTag2"))
                                        .trip(new Trip.Builder()
                                                .totalDistanceTravelled(new BigDecimal(222.22))
                                                .addStop(new Stop.Builder()
                                                        .stopIndex(0)
                                                        .stopName("test0")
                                                        .latitude(new BigDecimal(3432423))
                                                        .longitude(new BigDecimal(-3432423))
                                                        .timestamp(Instant.ofEpochMilli(System.currentTimeMillis()))
                                                        .build())
                                                .addStop(new Stop.Builder()
                                                        .stopIndex(1)
                                                        .stopName("test1")
                                                        .latitude(new BigDecimal(3432423))
                                                        .longitude(new BigDecimal(-3432423))
                                                        .timestamp(Instant.ofEpochMilli(System.currentTimeMillis()))
                                                        .build())
                                                .build())
                                        .tags(Arrays.asList("TransitDataTag1", "TransitDataTag2"))
                                        .build())
                        .build())
                .paymentData(new PaymentData.Builder().paymentType(PaymentType.Normal).build())
                .build();

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
        assert(request.getMessageHeader().getLibVersion() == 2);
    }
}