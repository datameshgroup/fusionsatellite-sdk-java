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

package au.com.dmg.fusion;

import au.com.dmg.fusion.data.*;
import au.com.dmg.fusion.request.SaleToPOIRequest;
import au.com.dmg.fusion.request.paymentrequest.*;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

public class MessageTest {

    @Test
    public void testCreate() {
        PaymentRequest paymentRequest = new PaymentRequest.Builder()
                .saleData(new SaleData.Builder()
                        .saleReferenceID("saleref")
                        .operatorID("operatorID")
                        .operatorLanguage("en")
                        .shiftNumber("shiftno")
                        .tokenRequestedType("todo")
                        .saleTransactionID(
                                new SaleTransactionID.Builder()
                                        .transactionID("x")
                                        .timestamp(Instant.ofEpochMilli(System.currentTimeMillis()))
                                        .build()
                        )
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
                                        .addCustomField(new CustomField.Builder()
                                                .key("SampleProductCustomFieldKey")
                                                .type(CustomFieldType.integer)
                                                .value("21")
                                                .build()
                                        )
                                        .build()
                        )
                        .build()
                )
                .paymentData(new PaymentData.Builder().paymentType(PaymentType.Normal).build())
                .addCustomField(new CustomField.Builder()
                        .key("testCustomFieldKey")
                        .type(CustomFieldType.object)
                        .value("{\"TransitData\":{\"DriverID\":123,\"OperatorID\":456,\"ContractID\":\"0f9653cc-a68b-11ed-afa1-0242ac120002\",\"VehicleID\":789,\"RouteVariant\":\"X\",\"TransactionLocation\":{\"Lattitude\":33.8688,\"Longitude\":151.2093},\"Trip\":{\"Boarding\":{\"StopID\":\"\",\"StopName\":\"\",\"ZoneID\":\"\"},\"Destination\":{\"StopID\":\"\",\"StopName\":\"\",\"ZoneID\":\"\"}},\"Ticket\":[{\"Type\":\"Adult\",\"Price\":1.1,\"ID\":\"9fe0e990-a68d-11ed-afa1-0242ac120002\"}]}}")
                        .build()
                )
                .addCustomField(new CustomField.Builder()
                        .key("testCustomFieldKey2")
                        .type(CustomFieldType.object)
                        .value("{\"TransitData2\":{\"DriverID\":123,\"OperatorID\":456,\"ContractID\":\"0f9653cc-a68b-11ed-afa1-0242ac120002\",\"VehicleID\":789,\"RouteVariant\":\"X\",\"TransactionLocation\":{\"Lattitude\":33.8688,\"Longitude\":151.2093},\"Trip\":{\"Boarding\":{\"StopID\":\"\",\"StopName\":\"\",\"ZoneID\":\"\"},\"Destination\":{\"StopID\":\"\",\"StopName\":\"\",\"ZoneID\":\"\"}},\"Ticket\":[{\"Type\":\"Adult\",\"Price\":1.1,\"ID\":\"9fe0e990-a68d-11ed-afa1-0242ac120002\"}]}}")
                        .build()
                )
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

        Message message = new Message(request);

        System.out.println(message.toJson());
    }

    @Test
    public void fromJson() {
        Message message = null;
        try {
            message = Message.fromJson("{\"SaleToPOIRequest\":{\"MessageHeader\":{\"MessageCategory\":\"Display\",\"MessageClass\":\"Device\",\"MessageType\":\"Notification\",\"ServiceID\":\"ServiceID\"},\"PaymentRequest\":{\"PaymentTransaction\":{\"AmountsReq\":{\"Currency\":\"AUD\",\"RequestedAmount\":\"5.0\"},\"OriginalPOITransactionObject\":{\"POIID\":\"POIID\",\"POITransactionID\":{\"TimeStamp\":\"2021-09-22T01:10:21.073Z\",\"TransactionID\":\"id\"},\"SaleID\":\"saleID\"},\"PaymentData\":{\"PaymentType\":\"Normal\"},\"SaleItem\":[{\"EanUpc\":\"xxx\",\"ImageUrls\":[],\"ItemAmount\":\"1.0\",\"ItemID\":1,\"ProductCode\":\"X\",\"ProductLabel\":\"xx\",\"Quantity\":\"1.0\",\"Restricted\":false,\"SaleChannel\":\"Unknown\",\"Tags\":[],\"TaxCode\":\"GST\",\"UnitOfMeasure\":\"Centilitre\",\"UnitPrice\":\"1\"}],\"TransactionConditions\":{\"AcquirerID\":[],\"AllowedPaymentBrands\":[]}},\"SaleData\":{\"OperatorID\":\"operatorID\",\"OperatorLanguage\":\"en\",\"SaleReferenceID\":\"saleref\",\"SaleTransactionID\":{\"TimeStamp\":\"2021-09-22T01:10:21.057Z\",\"TransactionID\":\"x\"},\"ShiftNumber\":\"shiftno\",\"TokenRequestedType\":\"todo\"}}}}");
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert (message.getRequest() != null);
        assert (message.getResponse() == null);
        assert (message.getRequest().getPaymentRequest().getPaymentTransaction().getAmountsReq().getCurrency().equals("AUD"));
    }

    @Test
    public void fromJsonTestBadEnums() {
        Message message = null;
        try {
//            message = Message.fromJson("{\"SaleToPOIRequest\":{\"MessageHeader\":{\"MessageCategory\":\"Display\",\"MessageClass\":\"Device\",\"MessageType\":\"Notification\",\"ServiceID\":\"ServiceID\"},\"PaymentRequest\":{\"PaymentTransaction\":{\"AmountsReq\":{\"Currency\":\"AUD\",\"RequestedAmount\":\"5.0\"},\"OriginalPOITransactionObject\":{\"POIID\":\"POIID\",\"POITransactionID\":{\"TimeStamp\":\"2021-09-22T01:10:21.073Z\",\"TransactionID\":\"id\"},\"SaleID\":\"saleID\"},\"PaymentData\":{\"PaymentType\":\"Normal\"},\"SaleItem\":[{\"EanUpc\":\"xxx\",\"ImageUrls\":[],\"ItemAmount\":\"1.0\",\"ItemID\":1,\"ProductCode\":\"X\",\"ProductLabel\":\"xx\",\"Quantity\":\"1.0\",\"Restricted\":false,\"SaleChannel\":\"Unknown\",\"Tags\":[],\"TaxCode\":\"GST\",\"UnitOfMeasure\":\"3f3f23hf83f\",\"UnitPrice\":\"1\"}],\"TransactionConditions\":{\"AcquirerID\":[],\"AllowedPaymentBrands\":[]}},\"SaleData\":{\"OperatorID\":\"operatorID\",\"OperatorLanguage\":\"en\",\"SaleReferenceID\":\"saleref\",\"SaleTransactionID\":{\"TimeStamp\":\"2021-09-22T01:10:21.057Z\",\"TransactionID\":\"x\"},\"ShiftNumber\":\"shiftno\",\"TokenRequestedType\":\"todo\"}}}}");
            message = Message.fromJson("{\"SaleToPOIRequest\":{\"MessageHeader\":{\"ProtocolVersion\":\"3.1\",\"MessageClass\":\"Service\",\"MessageCategory\":\"Payment\",\"MessageType\":\"Request\",\"ServiceID\":\"09f58793-8f91-4aab-953f-bed4c8770a02\",\"SaleID\":\"VA POS\",\"POIID\":\"DMGVA001\"},\"PaymentRequest\":{\"CustomFields\":[{\"key\":\"testCustomFieldKey\",\"type\":\"object\",\"value\":\"{\\\"TransitData\\\":{\\\"DriverID\\\":123,\\\"OperatorID\\\":456,\\\"ContractID\\\":\\\"0f9653cc-a68b-11ed-afa1-0242ac120002\\\",\\\"VehicleID\\\":789,\\\"RouteVariant\\\":\\\"X\\\",\\\"TransactionLocation\\\":{\\\"Lattitude\\\":33.8688,\\\"Longitude\\\":151.2093},\\\"Trip\\\":{\\\"Boarding\\\":{\\\"StopID\\\":\\\"\\\",\\\"StopName\\\":\\\"\\\",\\\"ZoneID\\\":\\\"\\\"},\\\"Destination\\\":{\\\"StopID\\\":\\\"\\\",\\\"StopName\\\":\\\"\\\",\\\"ZoneID\\\":\\\"\\\"}},\\\"Ticket\\\":[{\\\"Type\\\":\\\"Adult\\\",\\\"Price\\\":1.1,\\\"ID\\\":\\\"9fe0e990-a68d-11ed-afa1-0242ac120002\\\"}]}}\"},{\"key\":\"testCustomFieldKey2\",\"type\":\"object\",\"value\":\"{\\\"TransitData2\\\":{\\\"DriverID\\\":123,\\\"OperatorID\\\":456,\\\"ContractID\\\":\\\"0f9653cc-a68b-11ed-afa1-0242ac120002\\\",\\\"VehicleID\\\":789,\\\"RouteVariant\\\":\\\"X\\\",\\\"TransactionLocation\\\":{\\\"Lattitude\\\":33.8688,\\\"Longitude\\\":151.2093},\\\"Trip\\\":{\\\"Boarding\\\":{\\\"StopID\\\":\\\"\\\",\\\"StopName\\\":\\\"\\\",\\\"ZoneID\\\":\\\"\\\"},\\\"Destination\\\":{\\\"StopID\\\":\\\"\\\",\\\"StopName\\\":\\\"\\\",\\\"ZoneID\\\":\\\"\\\"}},\\\"Ticket\\\":[{\\\"Type\\\":\\\"Adult\\\",\\\"Price\\\":1.1,\\\"ID\\\":\\\"9fe0e990-a68d-11ed-afa1-0242ac120002\\\"}]}}\"}],\"SaleData\":{\"OperatorID\":\"OperatorID\",\"OperatorLanguage\":\"en-us\",\"ShiftNumber\":\"1\",\"SaleTransactionID\":{\"TransactionID\":\"8ea678a7-eeb0-4977-9f8d-011897a6eda7\",\"TimeStamp\":\"2023-02-11T01:24:04.165Z\"},\"SaleReferenceID\":\"pos\",\"SaleTerminalData\":{\"TerminalEnvironment\":\"Attended\",\"SaleCapabilities\":[\"CashierStatus\",\"CashierError\",\"CashierInput\",\"CustomerAssistance\",\"PrinterReceipt\"]},\"TokenRequestedType\":\"Transaction\"},\"PaymentTransaction\":{\"AmountsReq\":{\"Currency\":\"AUD\",\"RequestedAmount\":5.95,\"CashBackAmount\":0},\"SaleItem\":[{\"CustomFields\":[{\"key\":\"SampleProductCustomFieldKey\",\"type\":\"integer\",\"value\":\"21\"}],\"ProductCode\":\"9300675079655\",\"UnitOfMeasure\":\"ea\",\"Quantity\":\"1\",\"UnitPrice\":\"3.95\",\"ItemAmount\":3.95,\"ProductLabel\":\"Coke\"}]},\"PaymentData\":{\"PaymentType\":\"Normal\",\"PaymentInstrumentData\":{\"PaymentInstrumentType\":\"Card\"}}},\"SecurityTrailer\":{\"ContentType\":\"id-ct-authData\",\"AuthenticatedData\":{\"Version\":\"v0\",\"Recipient\":{\"KEK\":{\"Version\":\"v4\",\"KEKIdentifier\":{\"KeyIdentifier\":\"SpecV1TestMACKey\",\"KeyVersion\":\"20191122164326.594\"},\"KeyEncryptionAlgorithm\":{\"Algorithm\":\"des-ede3-cbc\"},\"EncryptedKey\":\"9ECF3D39C698C43944E3C41D25D63BCE\"},\"MACAlgorithm\":{\"Algorithm\":\"id-retail-cbc-mac-sha-256\"},\"EncapsulatedContent\":{\"ContentType\":\"id-data\"},\"MAC\":\"07B337E17467B44A\"}}}}}");
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert (message.getRequest() != null);
        assert (message.getResponse() == null);
        assert (message.getRequest().getPaymentRequest().getPaymentTransaction().getSaleItems().get(0).getUnitOfMeasure() == UnitOfMeasure.Other);

        message = null;
        try {
            message = Message.fromJson("{\"SaleToPOIRequest\":{\"MessageHeader\":{\"MessageCategory\":\"Display\",\"MessageClass\":\"Device\",\"MessageType\":\"Notification\",\"ServiceID\":\"ServiceID\"},\"PaymentRequest\":{\"PaymentTransaction\":{\"AmountsReq\":{\"Currency\":\"AUD\",\"RequestedAmount\":\"5.0\"},\"OriginalPOITransactionObject\":{\"POIID\":\"POIID\",\"POITransactionID\":{\"TimeStamp\":\"2021-09-22T01:10:21.073Z\",\"TransactionID\":\"id\"},\"SaleID\":\"saleID\"},\"PaymentData\":{\"PaymentType\":\"Normal\"},\"SaleItem\":[{\"EanUpc\":\"xxx\",\"ImageUrls\":[],\"ItemAmount\":\"1.0\",\"ItemID\":1,\"ProductCode\":\"X\",\"ProductLabel\":\"xx\",\"Quantity\":\"1.0\",\"Restricted\":false,\"SaleChannel\":\"Unknown\",\"Tags\":[],\"TaxCode\":\"GST\",\"UnitOfMeasure\":\"Centimetre\",\"UnitPrice\":\"1\"}],\"TransactionConditions\":{\"AcquirerID\":[],\"AllowedPaymentBrands\":[]}},\"SaleData\":{\"OperatorID\":\"operatorID\",\"OperatorLanguage\":\"en\",\"SaleReferenceID\":\"saleref\",\"SaleTransactionID\":{\"TimeStamp\":\"2021-09-22T01:10:21.057Z\",\"TransactionID\":\"x\"},\"ShiftNumber\":\"shiftno\",\"TokenRequestedType\":\"todo\"}}}}");
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert (message.getRequest() != null);
        assert (message.getResponse() == null);
        assert (message.getRequest().getPaymentRequest().getPaymentTransaction().getSaleItems().get(0).getUnitOfMeasure() == UnitOfMeasure.Centimetre);

        message = null;
        try {
            message = Message.fromJson("{\"SaleToPOIRequest\":{\"MessageHeader\":{\"ProtocolVersion\":\"3.1\",\"MessageClass\":\"Service\",\"MessageCategory\":\"Payment\",\"MessageType\":\"Request\",\"ServiceID\":\"09f58793-8f91-4aab-953f-bed4c8770a02\",\"SaleID\":\"VA POS\",\"POIID\":\"DMGVA001\"},\"PaymentRequest\":{\"CustomFields\":[{\"key\":\"testCustomFieldKey\",\"type\":\"object\",\"value\":\"{\\\"TransitData\\\":{\\\"DriverID\\\":123,\\\"OperatorID\\\":456,\\\"ContractID\\\":\\\"0f9653cc-a68b-11ed-afa1-0242ac120002\\\",\\\"VehicleID\\\":789,\\\"RouteVariant\\\":\\\"X\\\",\\\"TransactionLocation\\\":{\\\"Lattitude\\\":33.8688,\\\"Longitude\\\":151.2093},\\\"Trip\\\":{\\\"Boarding\\\":{\\\"StopID\\\":\\\"\\\",\\\"StopName\\\":\\\"\\\",\\\"ZoneID\\\":\\\"\\\"},\\\"Destination\\\":{\\\"StopID\\\":\\\"\\\",\\\"StopName\\\":\\\"\\\",\\\"ZoneID\\\":\\\"\\\"}},\\\"Ticket\\\":[{\\\"Type\\\":\\\"Adult\\\",\\\"Price\\\":1.1,\\\"ID\\\":\\\"9fe0e990-a68d-11ed-afa1-0242ac120002\\\"}]}}\"},{\"key\":\"testCustomFieldKey2\",\"type\":\"object\",\"value\":\"{\\\"TransitData2\\\":{\\\"DriverID\\\":123,\\\"OperatorID\\\":456,\\\"ContractID\\\":\\\"0f9653cc-a68b-11ed-afa1-0242ac120002\\\",\\\"VehicleID\\\":789,\\\"RouteVariant\\\":\\\"X\\\",\\\"TransactionLocation\\\":{\\\"Lattitude\\\":33.8688,\\\"Longitude\\\":151.2093},\\\"Trip\\\":{\\\"Boarding\\\":{\\\"StopID\\\":\\\"\\\",\\\"StopName\\\":\\\"\\\",\\\"ZoneID\\\":\\\"\\\"},\\\"Destination\\\":{\\\"StopID\\\":\\\"\\\",\\\"StopName\\\":\\\"\\\",\\\"ZoneID\\\":\\\"\\\"}},\\\"Ticket\\\":[{\\\"Type\\\":\\\"Adult\\\",\\\"Price\\\":1.1,\\\"ID\\\":\\\"9fe0e990-a68d-11ed-afa1-0242ac120002\\\"}]}}\"}],\"SaleData\":{\"OperatorID\":\"OperatorID\",\"OperatorLanguage\":\"en-us\",\"ShiftNumber\":\"1\",\"SaleTransactionID\":{\"TransactionID\":\"8ea678a7-eeb0-4977-9f8d-011897a6eda7\",\"TimeStamp\":\"2023-02-11T01:24:04.165Z\"},\"SaleReferenceID\":\"pos\",\"SaleTerminalData\":{\"TerminalEnvironment\":\"Attended\",\"SaleCapabilities\":[\"CashierStatus\",\"CashierError\",\"CashierInput\",\"CustomerAssistance\",\"PrinterReceipt\"]},\"TokenRequestedType\":\"Transaction\"},\"PaymentTransaction\":{\"AmountsReq\":{\"Currency\":\"AUD\",\"RequestedAmount\":5.95,\"CashBackAmount\":0},\"SaleItem\":[{\"CustomFields\":[{\"key\":\"SampleProductCustomFieldKey\",\"type\":\"integer\",\"value\":\"21\"}],\"ProductCode\":\"9300675079655\",\"UnitOfMeasure\":\"ea\",\"Quantity\":\"1\",\"UnitPrice\":\"3.95\",\"ItemAmount\":3.95,\"ProductLabel\":\"Coke\"}]},\"PaymentData\":{\"PaymentType\":\"Normal\",\"PaymentInstrumentData\":{\"PaymentInstrumentType\":\"Card\"}}},\"SecurityTrailer\":{\"ContentType\":\"id-ct-authData\",\"AuthenticatedData\":{\"Version\":\"v0\",\"Recipient\":{\"KEK\":{\"Version\":\"v4\",\"KEKIdentifier\":{\"KeyIdentifier\":\"SpecV1TestMACKey\",\"KeyVersion\":\"20191122164326.594\"},\"KeyEncryptionAlgorithm\":{\"Algorithm\":\"des-ede3-cbc\"},\"EncryptedKey\":\"9ECF3D39C698C43944E3C41D25D63BCE\"},\"MACAlgorithm\":{\"Algorithm\":\"id-retail-cbc-mac-sha-256\"},\"EncapsulatedContent\":{\"ContentType\":\"id-data\"},\"MAC\":\"07B337E17467B44A\"}}}}}");
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert (message.getRequest() != null);
        assert (message.getResponse() == null);
        assert (message.getRequest().getPaymentRequest().getCustomFields().get(0).getType() == CustomFieldType.object);
    }

    @Test
    public void testExtraJson() {
        Message message = null;
        try {
//            message = Message.fromJson("{\"SaleToPOIRequest\":{\"MessageHeader\":{\"MessageCategory\":\"Display\",\"MessageClass\":\"Device\",\"MessageType\":\"Notification\",\"ServiceID\":\"ServiceID\"},\"PaymentRequest\":{\"PaymentTransaction\":{\"AmountsReq\":{\"Currency\":\"AUD\",\"RequestedAmount\":\"5.0\"},\"OriginalPOITransactionObject\":{\"POIID\":\"POIID\",\"POITransactionID\":{\"TimeStamp\":\"2021-09-22T01:10:21.073Z\",\"TransactionID\":\"id\"},\"SaleID\":\"saleID\"},\"PaymentData\":{\"PaymentType\":\"Normal\"},\"SaleItem\":[{\"EanUpc\":\"xxx\",\"ImageUrls\":[],\"ItemAmount\":\"1.0\",\"ItemID\":1,\"ProductCode\":\"X\",\"ProductLabel\":\"xx\",\"Quantity\":\"1.0\",\"Restricted\":false,\"SaleChannel\":\"Unknown\",\"Tags\":[],\"TaxCode\":\"GST\",\"UnitOfMeasure\":\"3f3f23hf83f\",\"UnitPrice\":\"1\"}],\"TransactionConditions\":{\"AcquirerID\":[],\"AllowedPaymentBrands\":[]}},\"SaleData\":{\"OperatorID\":\"operatorID\",\"OperatorLanguage\":\"en\",\"SaleReferenceID\":\"saleref\",\"SaleTransactionID\":{\"TimeStamp\":\"2021-09-22T01:10:21.057Z\",\"TransactionID\":\"x\", \"ExtraField\":\"Value\"},\"ShiftNumber\":\"shiftno\",\"TokenRequestedType\":\"todo\"}}}}");
            message = Message.fromJson("{\"SaleToPOIRequest\":{\"MessageHeader\":{\"ProtocolVersion\":\"3.1\",\"MessageClass\":\"Service\",\"MessageCategory\":\"Payment\",\"MessageType\":\"Request\",\"ServiceID\":\"059748aa-863d-4b92-a2d4-2538317d1ad8\",\"SaleID\":\"VA POS\",\"POIID\":\"DMGVA001\"},\"PaymentRequest\":{\"CustomFields\":[{\"key\":\"testCustomFieldKey\",\"type\":\"object\",\"value\":\"{\\\"TransitData\\\":{\\\"DriverID\\\":123,\\\"OperatorID\\\":456,\\\"ContractID\\\":\\\"0f9653cc-a68b-11ed-afa1-0242ac120002\\\",\\\"VehicleID\\\":789,\\\"RouteVariant\\\":\\\"X\\\",\\\"TransactionLocation\\\":{\\\"Lattitude\\\":33.8688,\\\"Longitude\\\":151.2093},\\\"Trip\\\":{\\\"Boarding\\\":{\\\"StopID\\\":\\\"\\\",\\\"StopName\\\":\\\"\\\",\\\"ZoneID\\\":\\\"\\\"},\\\"Destination\\\":{\\\"StopID\\\":\\\"\\\",\\\"StopName\\\":\\\"\\\",\\\"ZoneID\\\":\\\"\\\"}},\\\"Ticket\\\":[{\\\"Type\\\":\\\"Adult\\\",\\\"Price\\\":1.1,\\\"ID\\\":\\\"9fe0e990-a68d-11ed-afa1-0242ac120002\\\"}]}}\"},{\"key\":\"testCustomFieldKey2\",\"type\":\"object\",\"value\":\"{\\\"TransitData2\\\":{\\\"DriverID\\\":123,\\\"OperatorID\\\":456,\\\"ContractID\\\":\\\"0f9653cc-a68b-11ed-afa1-0242ac120002\\\",\\\"VehicleID\\\":789,\\\"RouteVariant\\\":\\\"X\\\",\\\"TransactionLocation\\\":{\\\"Lattitude\\\":33.8688,\\\"Longitude\\\":151.2093},\\\"Trip\\\":{\\\"Boarding\\\":{\\\"StopID\\\":\\\"\\\",\\\"StopName\\\":\\\"\\\",\\\"ZoneID\\\":\\\"\\\"},\\\"Destination\\\":{\\\"StopID\\\":\\\"\\\",\\\"StopName\\\":\\\"\\\",\\\"ZoneID\\\":\\\"\\\"}},\\\"Ticket\\\":[{\\\"Type\\\":\\\"Adult\\\",\\\"Price\\\":1.1,\\\"ID\\\":\\\"9fe0e990-a68d-11ed-afa1-0242ac120002\\\"}]}}\",\"ExtraField\":\"Value\"}],\"SaleData\":{\"OperatorID\":\"OperatorID\",\"OperatorLanguage\":\"en-us\",\"ShiftNumber\":\"1\",\"SaleTransactionID\":{\"TransactionID\":\"8ea678a7-eeb0-4977-9f8d-011897a6eda7\",\"TimeStamp\":\"2023-02-11T01:24:04.165Z\",\"ExtraField\":\"Value\"},\"SaleReferenceID\":\"pos\",\"SaleTerminalData\":{\"TerminalEnvironment\":\"Attended\",\"SaleCapabilities\":[\"CashierStatus\",\"CashierError\",\"CashierInput\",\"CustomerAssistance\",\"PrinterReceipt\"]},\"TokenRequestedType\":\"Transaction\"},\"PaymentTransaction\":{\"AmountsReq\":{\"Currency\":\"AUD\",\"RequestedAmount\":5.95,\"CashBackAmount\":0},\"SaleItem\":[{\"CustomFields\":[{\"key\":\"SampleProductCustomFieldKey\",\"type\":\"integer\",\"value\":\"21\"}],\"ProductCode\":\"9300675079655\",\"UnitOfMeasure\":\"ea\",\"Quantity\":\"1\",\"UnitPrice\":\"3.95\",\"ItemAmount\":3.95,\"ProductLabel\":\"Coke\"}]},\"PaymentData\":{\"PaymentType\":\"Normal\",\"PaymentInstrumentData\":{\"PaymentInstrumentType\":\"Card\"}}},\"SecurityTrailer\":{\"ContentType\":\"id-ct-authData\",\"AuthenticatedData\":{\"Version\":\"v0\",\"Recipient\":{\"KEK\":{\"Version\":\"v4\",\"KEKIdentifier\":{\"KeyIdentifier\":\"SpecV1TestMACKey\",\"KeyVersion\":\"20191122164326.594\"},\"KeyEncryptionAlgorithm\":{\"Algorithm\":\"des-ede3-cbc\"},\"EncryptedKey\":\"EC25EFD24F95357D35B1D59856F8919E\"},\"MACAlgorithm\":{\"Algorithm\":\"id-retail-cbc-mac-sha-256\"},\"EncapsulatedContent\":{\"ContentType\":\"id-data\"},\"MAC\":\"1CDC806083250C6E\"}}}}}");
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert (message.getRequest() != null);
        assert (message.getResponse() == null);
        assert (message.getRequest().getPaymentRequest().getPaymentTransaction().getSaleItems().get(0).getUnitOfMeasure() == UnitOfMeasure.Other);

    }
}