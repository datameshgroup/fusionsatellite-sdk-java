package au.com.dmg.fusion.request;

import au.com.dmg.fusion.Message;
import au.com.dmg.fusion.MessageHeader;
import au.com.dmg.fusion.data.*;
import au.com.dmg.fusion.request.paymentrequest.OriginalPOITransaction;
import au.com.dmg.fusion.request.paymentrequest.POITransactionID;
import au.com.dmg.fusion.request.paymentrequest.SaleData;
import au.com.dmg.fusion.request.paymentrequest.SaleTransactionID;
import au.com.dmg.fusion.request.storedvaluerequest.StoredValueAccountID;
import au.com.dmg.fusion.request.storedvaluerequest.StoredValueData;
import au.com.dmg.fusion.request.storedvaluerequest.StoredValueRequest;
import junit.framework.TestCase;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThrows;

public class StoredValueRequestTest extends TestCase {
    Message message = null;
    MessageHeader messageHeader = new MessageHeader.Builder()
            .messageCategory(MessageCategory.Other)
            .messageClass(MessageClass.Service)
            .messageType(MessageType.Request)
            .serviceID("ServiceID")
            .build();

    SaleData validSaleData = new SaleData.Builder()
            .operatorID("xxx")
            .operatorLanguage("en")
            .shiftNumber("xxx")
            .saleTransactionID(new SaleTransactionID.Builder()
                    .transactionID("x")
                    .timestamp(Instant.ofEpochMilli(System.currentTimeMillis()))
                    .build())
            .saleReferenceID("xxx")
            .saleTerminalData(new SaleTerminalData.Builder()
                    .terminalEnvironment(TerminalEnvironment.Attended)
                    .saleCapabilities(Arrays.asList(SaleCapability.CashierStatus, SaleCapability.CustomerAssistance))
                    .totalsGroupID("xxx")
                    .build())
            .tokenRequestedType("Customer")
            .build();

    OriginalPOITransaction originalPOITransaction = new OriginalPOITransaction.Builder()
            .saleID("saleID")
            .POIID("POIID")
            .POITransactionID(
                    new POITransactionID("id", Instant.ofEpochMilli(System.currentTimeMillis()))
            )
            .build();

    StoredValueAccountID storedValueAccountID = new StoredValueAccountID.Builder()
            .storedValueAccountType(StoredValueAccountType.GiftCard)
            .ownerName("xx")
            .expiryDate("0224")
            .entryMode(EntryMode.Scanned)
            .identificationType(IdentificationType.BarCode)
            .storedValueID("x")
            .build();

    StoredValueData validStoredValueData = (StoredValueData) new StoredValueData.Builder()
            .storedValueProvider("x")
            .storedValueAccountID(storedValueAccountID)
            .originalPOITransaction(originalPOITransaction)
            .storedValueTransactionType(StoredValueTransactionType.Activate)
            .productCode("xxx")
            .eanUpc("XXX")
            .itemAmount(new BigDecimal(100))
            .totalFeesAmount(new BigDecimal(101))
            .currency("AUD")
            .build();

    public void testInvalidStoredValueAccountID(){
        NullPointerException exceptionStoredValueAccountType =
                assertThrows(NullPointerException.class,
                        ()-> new StoredValueAccountID.Builder()
                                .ownerName("xx")
                                .expiryDate("0224")
                                .entryMode(EntryMode.Scanned)
                                .identificationType(IdentificationType.BarCode)
                                .storedValueID("x")
                                .build());
        System.out.println("StoredValueRequestTest - testInvalidStoredValueAccountID - storedValueAccountType");
        assertEquals("The property \"storedValueAccountType\" is null. "
                + "Please set the value by \"storedValueAccountType()\" under StoredValueAccountID. "
                + "The properties \"storedValueAccountType\", \"identificationType\", and \"storedValueID\" are required.", exceptionStoredValueAccountType.getMessage());

        NullPointerException exceptionIdentificationType =
                assertThrows(NullPointerException.class,
                        ()-> new StoredValueAccountID.Builder()
                                .storedValueAccountType(StoredValueAccountType.GiftCard)
                                .ownerName("xx")
                                .expiryDate("0224")
                                .entryMode(EntryMode.Scanned)
                                .storedValueID("x")
                                .build());
        System.out.println("StoredValueRequestTest - testInvalidStoredValueAccountID - identificationType");
        assertEquals("The property \"identificationType\" is null. "
                + "Please set the value by \"identificationType()\" under StoredValueAccountID. "
                + "The properties \"storedValueAccountType\", \"identificationType\", and \"storedValueID\" are required.", exceptionIdentificationType.getMessage());

        NullPointerException exceptionStoredValueID =
                assertThrows(NullPointerException.class,
                        ()-> new StoredValueAccountID.Builder()
                                .storedValueAccountType(StoredValueAccountType.GiftCard)
                                .ownerName("xx")
                                .expiryDate("0224")
                                .entryMode(EntryMode.Scanned)
                                .identificationType(IdentificationType.BarCode)
                                .build());
        System.out.println("StoredValueRequestTest - testInvalidStoredValueAccountID - storedValueID");
        assertEquals("The property \"storedValueID\" is null or empty. "
                + "Please set the value by \"storedValueID()\" under StoredValueAccountID. "
                + "The properties \"storedValueAccountType\", \"identificationType\", and \"storedValueID\" are required.", exceptionStoredValueID.getMessage());
    }

    public void testInvalidStoredValueData() {
        NullPointerException exception =
                assertThrows(NullPointerException.class,
                        ()-> new StoredValueRequest.Builder()
                                .saleData(validSaleData)
                                .storedValueData((StoredValueData) new StoredValueData.Builder()
                                        .storedValueProvider("x")
                                        .storedValueAccountID(storedValueAccountID)
                                        .originalPOITransaction(originalPOITransaction)
                                        .productCode("xxx")
                                        .eanUpc("XXX")
                                        .itemAmount(new BigDecimal(100))
                                        .totalFeesAmount(new BigDecimal(101))
                                        .currency("AUD")
                                        .build())
                                .build());
        System.out.println("StoredValueRequestTest - testInvalidStoredValueData");
        assertEquals("The property \"storedValueTransactionType\" is null. Please set the value by \"storedValueTransactionType()\". The property \"storedValueTransactionType\" is required.", exception.getMessage());
    }

    public void testValidStoredValueRequest() {
        StoredValueRequest storedValueRequest =
                new StoredValueRequest.Builder()
                .saleData(validSaleData)
                .addStoredValueData(validStoredValueData)
                .build();

        SaleToPOIRequest request = new SaleToPOIRequest.Builder()
                .messageHeader(messageHeader)
                .request(storedValueRequest)
                .build();

        String json = new Message(request).toJson();

        System.out.println("StoredValueRequestTest - testValidStoredValueRequest");
        System.out.println(json);

        try {
            message = Message.fromJson(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert (message.getRequest().getStoredValueRequest().getSaleData().getOperatorID().equals("xxx"));
    }

    public void testInvalidStoredValueRequest() {
        NullPointerException exceptionSaleData =
                assertThrows(NullPointerException.class,
                        ()-> new StoredValueRequest.Builder()
                                .storedValueData(validStoredValueData)
                                .build());
        System.out.println("StoredValueRequestTest - testInvalidStoredValueData");
        assertEquals("The property \"saleData\" is null. "
                + "Please set the value by \"saleData()\". "
                + "The properties \"saleData\" and \"storedValueData\" are required.", exceptionSaleData.getMessage());

        NullPointerException exceptionStoredValueData =
                assertThrows(NullPointerException.class,
                        ()-> new StoredValueRequest.Builder()
                                .saleData(validSaleData)
                                .build());
        System.out.println("StoredValueRequestTest - testInvalidStoredValueData");
        assertEquals("The property \"storedValueData\" is null. "
                + "Please set the value by \"storedValueData() or addStoredValueData()\". "
                + "The properties \"saleData\" and \"storedValueData\" are required.", exceptionStoredValueData.getMessage());
    }


}
