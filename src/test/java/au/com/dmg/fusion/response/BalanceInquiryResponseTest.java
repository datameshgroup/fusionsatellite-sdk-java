package au.com.dmg.fusion.response;

import au.com.dmg.fusion.Message;
import au.com.dmg.fusion.MessageHeader;
import au.com.dmg.fusion.data.*;
import au.com.dmg.fusion.request.printrequest.OutputContent;
import au.com.dmg.fusion.request.storedvaluerequest.StoredValueAccountID;
import au.com.dmg.fusion.response.balanceinquiryresponse.BalanceInquiryResponse;
import au.com.dmg.fusion.response.balanceinquiryresponse.PaymentAccountStatus;
import au.com.dmg.fusion.response.paymentresponse.*;
import junit.framework.TestCase;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;

import static org.junit.Assert.assertThrows;

public class BalanceInquiryResponseTest extends TestCase {
    Message message = null;

    MessageHeader validMessageHeader = new MessageHeader.Builder()
            .messageCategory(MessageCategory.Other)
            .messageClass(MessageClass.Service)
            .messageType(MessageType.Request)
            .serviceID("ServiceID")
            .build();

    Response successResponse = new Response.Builder()
            .result(ResponseResult.Success)
            .build();

    AcquirerTransactionID validAcquirerTransactionID = new AcquirerTransactionID("xxx", Instant.ofEpochMilli(System.currentTimeMillis()));

    PaymentResponseCardData validCardData = new PaymentResponseCardData.Builder()
            .entryMode(EntryMode.Tapped)
            .paymentBrand(PaymentBrand.VISA)
            .paymentBrandId("xxx")
            .paymentBrandLabel("xxx")
            .maskedPAN("464516XXXXXX1111")
            .build();

    PaymentAcquirerData validPaymentAcquirerData = new PaymentAcquirerData.Builder()
            .acquirerID("xxx")
            .merchantID("xxx")
            .acquirerPOIID("xxx")
            .acquirerTransactionID(validAcquirerTransactionID)
            .approvalCode("xxx")
            .responseCode("xxx")
            .stan("xxx")
            .rrn("xxx")
            .hostReconciliationID("xxx")
            .build();

    StoredValueAccountID validStoredValueAccountID = new StoredValueAccountID.Builder()
            .storedValueAccountType(StoredValueAccountType.GiftCard)
            .storedValueProvider("testProvider")
            .ownerName("testOwnerName")
            .expiryDate("MMYY")
            .entryMode(EntryMode.Tapped)
            .identificationType(IdentificationType.ISOTrack2)
            .storedValueID("testID")
            .build();

    PaymentInstrumentData validPaymentInstrumentData = new PaymentInstrumentData.Builder()
            .paymentInstrumentType(PaymentInstrumentType.Card)
            .cardData(validCardData)
            .storedValueAccountID(validStoredValueAccountID)
            .build();

    PaymentAccountStatus validPaymentAccountStatus = new PaymentAccountStatus.Builder()
            .paymentInstrumentData(validPaymentInstrumentData)
            .currency("AUD")
            .currentBalance(new BigDecimal(100))
            .paymentAcquirerData(validPaymentAcquirerData)
            .build();

    OutputContent validOutputContent = new OutputContent("xxx", "xxx");

    PaymentReceipt validPaymentReceipt = new PaymentReceipt.Builder()
            .documentQualifier("Title")
            .requiredSignatureFlag(true)
            .outputContent(validOutputContent)
            .build();

    public void testValidBalanceInquiryResponse(){
        BalanceInquiryResponse balanceInquiryResponse = new BalanceInquiryResponse.Builder()
                .response(successResponse)
                .paymentAccountStatus(validPaymentAccountStatus)
                .loyaltyAccountStatus(null)
                .paymentReceipt(validPaymentReceipt)
                .build();

        SaleToPOIResponse res = new SaleToPOIResponse.Builder()
                .messageHeader(validMessageHeader)
                .response(balanceInquiryResponse)
                .build();

        String json = new Message(res).toJson();

        System.out.println("BalanceInquiryResponseTest - testValidBalanceInquiryResponse");
        System.out.println(json);

        try {
            message = Message.fromJson(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert (message.getResponse().getBalanceInquiryResponse().getPaymentAccountStatus().getCurrentBalance().equals(new BigDecimal(100)));
    }


    public void testBalanceInquiryResponseNulls() {
        NullPointerException exceptionEntryMode =
                assertThrows(NullPointerException.class,
                        () -> new BalanceInquiryResponse.Builder()
                                .response(successResponse)
                                .paymentAccountStatus(new PaymentAccountStatus.Builder()
                                        .paymentInstrumentData(new PaymentInstrumentData.Builder()
                                                .paymentInstrumentType(PaymentInstrumentType.Card)
                                                .cardData(new PaymentResponseCardData.Builder()
                                                        .paymentBrand(PaymentBrand.VISA)
                                                        .paymentBrandId("xxx")
                                                        .paymentBrandLabel("xxx")
                                                        .maskedPAN("464516XXXXXX1111")
                                                        .build())
                                                .storedValueAccountID(validStoredValueAccountID)
                                                .build())
                                        .currency("AUD")
                                        .currentBalance(new BigDecimal(100))
                                        .paymentAcquirerData(validPaymentAcquirerData)
                                        .build())
                                .paymentReceipt(validPaymentReceipt)
                                .build());
        System.out.println("BalanceInquiryResponseTest - testBalanceInquiryResponseNulls - entryMode");
        assertEquals("The property \"entryMode\" is null. "
                + "Please set the value by \"entryMode()\" under paymentInstrumentData.cardData. "
                + "The properties \"entryMode\", \"paymentBrand\", \"paymentBrandId\", \"paymentBrandLabel\", and \"maskedPAN\" are required.", exceptionEntryMode.getMessage());

        NullPointerException exceptionPaymentBrand =
                assertThrows(NullPointerException.class,
                        () -> new BalanceInquiryResponse.Builder()
                                .response(successResponse)
                                .paymentAccountStatus(new PaymentAccountStatus.Builder()
                                        .paymentInstrumentData(new PaymentInstrumentData.Builder()
                                                .paymentInstrumentType(PaymentInstrumentType.Card)
                                                .cardData(new PaymentResponseCardData.Builder()
                                                        .entryMode(EntryMode.Tapped)
                                                        .paymentBrandId("xxx")
                                                        .paymentBrandLabel("xxx")
                                                        .maskedPAN("464516XXXXXX1111")
                                                        .build())
                                                .storedValueAccountID(validStoredValueAccountID)
                                                .build())
                                        .currency("AUD")
                                        .currentBalance(new BigDecimal(100))
                                        .paymentAcquirerData(validPaymentAcquirerData)
                                        .build())
                                .paymentReceipt(validPaymentReceipt)
                                .build());
        System.out.println("BalanceInquiryResponseTest - testBalanceInquiryResponseNulls - paymentBrand");
        assertEquals("The property \"paymentBrand\" is null. "
                + "Please set the value by \"paymentBrand()\" under paymentInstrumentData.cardData. "
                + "The properties \"entryMode\", \"paymentBrand\", \"paymentBrandId\", \"paymentBrandLabel\", and \"maskedPAN\" are required.", exceptionPaymentBrand.getMessage());

        NullPointerException exceptionPaymentBrandId =
                assertThrows(NullPointerException.class,
                        () -> new BalanceInquiryResponse.Builder()
                                .response(successResponse)
                                .paymentAccountStatus(new PaymentAccountStatus.Builder()
                                        .paymentInstrumentData(new PaymentInstrumentData.Builder()
                                                .paymentInstrumentType(PaymentInstrumentType.Card)
                                                .cardData(new PaymentResponseCardData.Builder()
                                                        .entryMode(EntryMode.Tapped)
                                                        .paymentBrand(PaymentBrand.VISA)
                                                        .paymentBrandLabel("xxx")
                                                        .maskedPAN("464516XXXXXX1111")
                                                        .build())
                                                .storedValueAccountID(validStoredValueAccountID)
                                                .build())
                                        .currency("AUD")
                                        .currentBalance(new BigDecimal(100))
                                        .paymentAcquirerData(validPaymentAcquirerData)
                                        .build())
                                .paymentReceipt(validPaymentReceipt)
                                .build());
        System.out.println("BalanceInquiryResponseTest - testBalanceInquiryResponseNulls - paymentBrandId");
        assertEquals("The property \"paymentBrandId\" is null. "
                + "Please set the value by \"paymentBrandId()\" under paymentInstrumentData.cardData. "
                + "The properties \"entryMode\", \"paymentBrand\", \"paymentBrandId\", \"paymentBrandLabel\", and \"maskedPAN\" are required.", exceptionPaymentBrandId.getMessage());

        NullPointerException exceptionPaymentBrandLabel =
                assertThrows(NullPointerException.class,
                        () -> new BalanceInquiryResponse.Builder()
                                .response(successResponse)
                                .paymentAccountStatus(new PaymentAccountStatus.Builder()
                                        .paymentInstrumentData(new PaymentInstrumentData.Builder()
                                                .paymentInstrumentType(PaymentInstrumentType.Card)
                                                .cardData(new PaymentResponseCardData.Builder()
                                                        .entryMode(EntryMode.Tapped)
                                                        .paymentBrand(PaymentBrand.VISA)
                                                        .paymentBrandId("xxx")
                                                        .maskedPAN("464516XXXXXX1111")
                                                        .build())
                                                .storedValueAccountID(validStoredValueAccountID)
                                                .build())
                                        .currency("AUD")
                                        .currentBalance(new BigDecimal(100))
                                        .paymentAcquirerData(validPaymentAcquirerData)
                                        .build())
                                .paymentReceipt(validPaymentReceipt)
                                .build());
        System.out.println("BalanceInquiryResponseTest - testBalanceInquiryResponseNulls - paymentBrandLabel");
        assertEquals("The property \"paymentBrandLabel\" is null. "
                + "Please set the value by \"paymentBrandLabel()\" under paymentInstrumentData.cardData. "
                + "The properties \"entryMode\", \"paymentBrand\", \"paymentBrandId\", \"paymentBrandLabel\", and \"maskedPAN\" are required.", exceptionPaymentBrandLabel.getMessage());

        NullPointerException exceptionMaskedPAN =
                assertThrows(NullPointerException.class,
                        () -> new BalanceInquiryResponse.Builder()
                                .response(successResponse)
                                .paymentAccountStatus(new PaymentAccountStatus.Builder()
                                        .paymentInstrumentData(new PaymentInstrumentData.Builder()
                                                .paymentInstrumentType(PaymentInstrumentType.Card)
                                                .cardData(new PaymentResponseCardData.Builder()
                                                        .entryMode(EntryMode.Tapped)
                                                        .paymentBrand(PaymentBrand.VISA)
                                                        .paymentBrandId("xxx")
                                                        .paymentBrandLabel("xxx")
                                                        .build())
                                                .storedValueAccountID(validStoredValueAccountID)
                                                .build())
                                        .currency("AUD")
                                        .currentBalance(new BigDecimal(100))
                                        .paymentAcquirerData(validPaymentAcquirerData)
                                        .build())
                                .paymentReceipt(validPaymentReceipt)
                                .build());
        System.out.println("BalanceInquiryResponseTest - testBalanceInquiryResponseNulls - maskedPAN");
        assertEquals("The property \"maskedPAN\" is null. "
                + "Please set the value by \"maskedPAN()\". "
                + "The property \"maskedPAN\" is required.", exceptionMaskedPAN.getMessage());

        NullPointerException exceptionStoredValueAccountType =
                assertThrows(NullPointerException.class,
                        () -> new BalanceInquiryResponse.Builder()
                                .response(successResponse)
                                .paymentAccountStatus(new PaymentAccountStatus.Builder()
                                        .paymentInstrumentData(new PaymentInstrumentData.Builder()
                                                .paymentInstrumentType(PaymentInstrumentType.Card)
                                                .cardData(validCardData)
                                                .storedValueAccountID(new StoredValueAccountID.Builder()
//                                                        .storedValueAccountType(StoredValueAccountType.GiftCard)
                                                        .storedValueProvider("testProvider")
                                                        .ownerName("testOwnerName")
                                                        .expiryDate("MMYY")
                                                        .entryMode(EntryMode.Tapped)
                                                        .identificationType(IdentificationType.ISOTrack2)
                                                        .storedValueID("testID")
                                                        .build())
                                                .build())
                                        .currency("AUD")
                                        .currentBalance(new BigDecimal(100))
                                        .paymentAcquirerData(validPaymentAcquirerData)
                                        .build())
                                .paymentReceipt(validPaymentReceipt)
                                .build());
        System.out.println("BalanceInquiryResponseTest - testBalanceInquiryResponseNulls - storedValueAccountType");
        assertEquals("The property \"storedValueAccountType\" is null. "
                + "Please set the value by \"storedValueAccountType()\" under StoredValueAccountID. "
                + "The properties \"storedValueAccountType\", \"identificationType\", and \"storedValueID\" are required.", exceptionStoredValueAccountType.getMessage());
    }
}