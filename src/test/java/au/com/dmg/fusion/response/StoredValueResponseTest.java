package au.com.dmg.fusion.response;

import au.com.dmg.fusion.Message;
import au.com.dmg.fusion.MessageHeader;
import au.com.dmg.fusion.data.*;
import au.com.dmg.fusion.request.SaleTerminalData;
import au.com.dmg.fusion.request.paymentrequest.POIData;
import au.com.dmg.fusion.request.paymentrequest.POITransactionID;
import au.com.dmg.fusion.request.paymentrequest.SaleData;
import au.com.dmg.fusion.request.paymentrequest.SaleTransactionID;
import au.com.dmg.fusion.request.storedvaluerequest.StoredValueAccountID;
import au.com.dmg.fusion.response.paymentresponse.PaymentResponseSaleData;
import au.com.dmg.fusion.response.storevalueresponse.StoredValueAccountStatus;
import au.com.dmg.fusion.response.storevalueresponse.StoredValueResponse;
import au.com.dmg.fusion.response.storevalueresponse.StoredValueResult;
import junit.framework.TestCase;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;

import static org.junit.Assert.assertThrows;

public class StoredValueResponseTest extends TestCase {
    Message message = null;
    MessageHeader messageHeader = new MessageHeader.Builder()
            .messageCategory(MessageCategory.Other)
            .messageClass(MessageClass.Service)
            .messageType(MessageType.Request)
            .serviceID("ServiceID")
            .build();

    POIData validPOIData = new POIData.Builder()
            .POITransactionID(
                    new POITransactionID("id", Instant.ofEpochMilli(System.currentTimeMillis()))
            )
            .POIReconciliationID("xx")
            .build();

    SaleData validSaleData =  new PaymentResponseSaleData.Builder()
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
            ).build();

    Response successResponse = new Response.Builder().result(ResponseResult.Success).build();

    Response failureResponse = new Response.Builder()
            .result(ResponseResult.Failure)
            .additionalResponse("additionalResponse")
            .errorCondition(ErrorCondition.Aborted)
            .build();

    StoredValueResult validStoredValueResult =
            (StoredValueResult) new StoredValueResult.Builder()
            .storedValueAccountStatus(new StoredValueAccountStatus.Builder()
                            .storedValueAccountID(new StoredValueAccountID.Builder()
                            .storedValueAccountType(StoredValueAccountType.GiftCard)
                            .storedValueProvider("testProvider")
                            .ownerName("testOwnerName")
                            .expiryDate("MMYY")
                            .entryMode(EntryMode.Tapped)
                            .identificationType(IdentificationType.ISOTrack2)
                            .storedValueID("testID")
                            .build())
                            .currentBalance(BigDecimal.valueOf(0))
                            .build())
            .storedValueTransactionType(StoredValueTransactionType.Activate)
            .productCode("xxx")
            .eanUpc("XXX")
            .itemAmount(new BigDecimal(100))
            .totalFeesAmount(new BigDecimal(101))
            .currency("AUD")
            .build();

    public void testInvalidStoredValueResult() {
        NullPointerException exception =
                assertThrows(NullPointerException.class,
                        ()-> new StoredValueResult.Builder()
                                .productCode("xxx")
                                .eanUpc("XXX")
                                .itemAmount(new BigDecimal(100))
                                .totalFeesAmount(new BigDecimal(101))
                                .currency("AUD")
                                .build());
        System.out.println("StoredValueResponseTest - testInvalidStoredValueResponse - storedValueTransactionType");
        assertEquals("The property \"storedValueTransactionType\" is null. "
                + "Please set the value by \"storedValueTransactionType()\". "
                + "The property \"storedValueTransactionType\" is required.", exception.getMessage());
    }

    public void testValidStoredValueResponse(){
        StoredValueResponse storedValueResponse =
                new StoredValueResponse.Builder()
                        .response(successResponse)
                        .saleData(validSaleData)
                        .poiData(validPOIData)
                        .storedValueResult(validStoredValueResult)
                        .build();

        SaleToPOIResponse res = new SaleToPOIResponse.Builder()
                .messageHeader(messageHeader)
                .response(storedValueResponse)
                .build();

        String json = new Message(res).toJson();

        System.out.println("StoredValueResponseTest - testValidStoredValueResponse");
        System.out.println(json);

        try {
            message = Message.fromJson(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert (message.getResponse().getStoredValueResponse().getSaleData().getOperatorID().equals("opID"));
    }

    public void testInvalidStoredValueResponse(){
        NullPointerException exceptionResponse =
                assertThrows(NullPointerException.class,
                        ()-> new StoredValueResponse.Builder()
                                .saleData(validSaleData)
                                .poiData(validPOIData)
                                .storedValueResult(validStoredValueResult)
                                .build());
        System.out.println("StoredValueResponseTest - testInvalidStoredValueResponse - response");
        assertEquals("The property \"response\" is null. "
                + "Please set the value by \"response()\". "
                + "The properties \"response\", \"saleData\" and \"poiData\" are required.", exceptionResponse.getMessage());

        NullPointerException exceptionSaleData =
                assertThrows(NullPointerException.class,
                        ()-> new StoredValueResponse.Builder()
                                .response(successResponse)
                                .poiData(validPOIData)
                                .storedValueResult(validStoredValueResult)
                                .build());
        System.out.println("StoredValueResponseTest - testInvalidStoredValueResponse - saleData");
        assertEquals("The property \"saleData\" is null. "
                + "Please set the value by \"saleData()\". "
                + "The properties \"response\", \"saleData\" and \"poiData\" are required.", exceptionSaleData.getMessage());

        NullPointerException exceptionPOIData =
                assertThrows(NullPointerException.class,
                        ()-> new StoredValueResponse.Builder()
                                .response(successResponse)
                                .saleData(validSaleData)
                                .storedValueResult(validStoredValueResult)
                                .build());
        System.out.println("StoredValueResponseTest - testInvalidStoredValueResponse - poiData");
        assertEquals("The property \"poiData\" is null. "
                + "Please set the value by \"poiData()\". "
                + "The properties \"response\", \"saleData\" and \"poiData\" are required.", exceptionPOIData.getMessage());

        NullPointerException exceptionIdentificationType =
                assertThrows(NullPointerException.class,
                        ()-> new StoredValueResponse.Builder()
                                .response(successResponse)
                                .poiData(validPOIData)
                                .saleData(validSaleData)
                                .storedValueResult((StoredValueResult) new StoredValueResult.Builder()
                                                .storedValueAccountStatus(new StoredValueAccountStatus.Builder()
                                                        .storedValueAccountID(new StoredValueAccountID.Builder()
                                                        .storedValueAccountType(StoredValueAccountType.GiftCard)
                                                        .storedValueProvider("testProvider")
                                                        .ownerName("testOwnerName")
                                                        .expiryDate("MMYY")
                                                        .entryMode(EntryMode.Tapped)
                                                        .storedValueID("testID")
                                                        .build())
                                                        .currentBalance(BigDecimal.valueOf(0))
                                                        .build())
                                                .storedValueTransactionType(StoredValueTransactionType.Activate)
                                                .productCode("xxx")
                                                .eanUpc("XXX")
                                                .itemAmount(new BigDecimal(100))
                                                .totalFeesAmount(new BigDecimal(101))
                                                .currency("AUD")
                                                .build()
                                )
                                .build());
        System.out.println("StoredValueResponseTest - testInvalidStoredValueResponse - poiData");
        assertEquals("The property \"identificationType\" is null. "
                + "Please set the value by \"identificationType()\" under StoredValueAccountID. "
                + "The properties \"storedValueAccountType\", \"identificationType\", and \"storedValueID\" are required.", exceptionIdentificationType.getMessage());

        NullPointerException exStoredValueAccountType =
                assertThrows(NullPointerException.class,
                        ()-> new StoredValueResponse.Builder()
                                .response(successResponse)
                                .poiData(validPOIData)
                                .saleData(validSaleData)
                                .storedValueResult((StoredValueResult) new StoredValueResult.Builder()
                                                .storedValueAccountStatus(new StoredValueAccountStatus.Builder()
                                                        .storedValueAccountID(new StoredValueAccountID.Builder()
                                                                .storedValueProvider("testProvider")
                                                                .ownerName("testOwnerName")
                                                                .expiryDate("MMYY")
                                                                .entryMode(EntryMode.Tapped)
                                                                .identificationType(IdentificationType.ISOTrack2)
                                                                .storedValueID("testID")
                                                                .build())
                                                        .currentBalance(BigDecimal.valueOf(0))
                                                        .build())
                                                .storedValueTransactionType(StoredValueTransactionType.Activate)
                                                .productCode("xxx")
                                                .eanUpc("XXX")
                                                .itemAmount(new BigDecimal(100))
                                                .totalFeesAmount(new BigDecimal(101))
                                                .currency("AUD")
                                                .build()
                                )
                                .build());
        System.out.println("StoredValueResponseTest - testInvalidStoredValueResponse - storedValueAccountType");
        assertEquals("The property \"storedValueAccountType\" is null. "
                + "Please set the value by \"storedValueAccountType()\" under StoredValueAccountID. "
                + "The properties \"storedValueAccountType\", \"identificationType\", and \"storedValueID\" are required.", exStoredValueAccountType.getMessage());

        NullPointerException exStoredValueID =
                assertThrows(NullPointerException.class,
                        ()-> new StoredValueResponse.Builder()
                                .response(successResponse)
                                .poiData(validPOIData)
                                .saleData(validSaleData)
                                .storedValueResult((StoredValueResult) new StoredValueResult.Builder()
                                        .storedValueAccountStatus(new StoredValueAccountStatus.Builder()
                                                .storedValueAccountID(new StoredValueAccountID.Builder()
                                                        .storedValueAccountType(StoredValueAccountType.GiftCard)
                                                        .storedValueProvider("testProvider")
                                                        .ownerName("testOwnerName")
                                                        .expiryDate("MMYY")
                                                        .entryMode(EntryMode.Tapped)
                                                        .identificationType(IdentificationType.ISOTrack2)
                                                        .build())
                                                .currentBalance(BigDecimal.valueOf(0))
                                                .build())
                                        .storedValueTransactionType(StoredValueTransactionType.Activate)
                                        .productCode("xxx")
                                        .eanUpc("XXX")
                                        .itemAmount(new BigDecimal(100))
                                        .totalFeesAmount(new BigDecimal(101))
                                        .currency("AUD")
                                        .build()
                                )
                                .build());
        System.out.println("StoredValueResponseTest - testInvalidStoredValueResponse - poiData");
        assertEquals("The property \"storedValueID\" is null or empty. "
                + "Please set the value by \"storedValueID()\" under StoredValueAccountID. "
                + "The properties \"storedValueAccountType\", \"identificationType\", and \"storedValueID\" are required.", exStoredValueID.getMessage());

    }

    public void testFailureNullStoredValueResult(){
        StoredValueResponse storedValueResponse =
                new StoredValueResponse.Builder()
                        .response(failureResponse)
                        .saleData(validSaleData)
                        .poiData(validPOIData)
                        .build();

        SaleToPOIResponse res = new SaleToPOIResponse.Builder()
                .messageHeader(messageHeader)
                .response(storedValueResponse)
                .build();

        String json = new Message(res).toJson();

        System.out.println("StoredValueResponseTest - testFailureNullStoredValueResult");
        System.out.println(json);

        try {
            message = Message.fromJson(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert (message.getResponse().getStoredValueResponse().getSaleData().getOperatorID().equals("opID"));
    }

    public void testSuccessNullStoredValueResult(){
        NullPointerException exceptionResponse =
                assertThrows(NullPointerException.class,
                        ()-> new StoredValueResponse.Builder()
                                .response(successResponse)
                                .saleData(validSaleData)
                                .poiData(validPOIData)
                                .build());
        System.out.println("StoredValueResponseTest - testSuccessNullStoredValueResult");
        assertEquals("The property \"storedValueResult\" is required if \"response.getResult() == Success\".", exceptionResponse.getMessage());

        NullPointerException exceptionSaleData =
                assertThrows(NullPointerException.class,
                        ()-> new StoredValueResponse.Builder()
                                .response(successResponse)
                                .poiData(validPOIData)
                                .storedValueResult(validStoredValueResult)
                                .build());
        System.out.println("StoredValueResponseTest - testInvalidStoredValueResponse - saleData");
        assertEquals("The property \"saleData\" is null. "
                + "Please set the value by \"saleData()\". "
                + "The properties \"response\", \"saleData\" and \"poiData\" are required.", exceptionSaleData.getMessage());

        NullPointerException exceptionPOIData =
                assertThrows(NullPointerException.class,
                        ()-> new StoredValueResponse.Builder()
                                .response(successResponse)
                                .saleData(validSaleData)
                                .storedValueResult(validStoredValueResult)
                                .build());
        System.out.println("StoredValueResponseTest - testInvalidStoredValueResponse - poiData");
        assertEquals("The property \"poiData\" is null. "
                + "Please set the value by \"poiData()\". "
                + "The properties \"response\", \"saleData\" and \"poiData\" are required.", exceptionPOIData.getMessage());


    }
    public void testSuccessWithStoredValueResult(){
        StoredValueResponse storedValueResponse =
                new StoredValueResponse.Builder()
                        .response(failureResponse)
                        .saleData(validSaleData)
                        .poiData(validPOIData)
                        .storedValueResult(validStoredValueResult)
                        .build();

        SaleToPOIResponse res = new SaleToPOIResponse.Builder()
                .messageHeader(messageHeader)
                .response(storedValueResponse)
                .build();

        String json = new Message(res).toJson();

        System.out.println("StoredValueResponseTest - testFailureNullStoredValueResult");
        System.out.println(json);

        try {
            message = Message.fromJson(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert (message.getResponse().getStoredValueResponse().getSaleData().getOperatorID().equals("opID"));
    }
}
