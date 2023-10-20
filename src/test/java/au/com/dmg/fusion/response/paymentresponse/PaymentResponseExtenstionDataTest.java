package au.com.dmg.fusion.response.paymentresponse;

import au.com.dmg.fusion.MessageHeader;
import au.com.dmg.fusion.data.MessageCategory;
import au.com.dmg.fusion.data.MessageClass;
import au.com.dmg.fusion.data.MessageType;
import au.com.dmg.fusion.request.paymentrequest.POIData;
import au.com.dmg.fusion.request.paymentrequest.POITransactionID;
import au.com.dmg.fusion.request.paymentrequest.SaleTransactionID;
import au.com.dmg.fusion.response.Response;
import au.com.dmg.fusion.response.ResponseResult;
import au.com.dmg.fusion.response.SaleToPOIResponse;
import org.junit.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

public class PaymentResponseExtenstionDataTest {
@Test
public void testResponseTagsAddStrings() {
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
                    .extensionData(new PaymentResponseExtensionData.Builder()
                            .transitData(new PaymentResponseTransitData.Builder()
//                                    .tags(Arrays.asList("PaymentResponseTransitDataTag1", "PaymentResponseTransitDataTag2"))
                                    .addTag("PaymentResponseTransitDataTag1")
                                    .addTag("PaymentResponseTransitDataTag2")
                                    .build())
                            .build())
                    .build())
            .build();

    System.out.println(response.toJson());
    System.out.println(response.getPaymentResponse().getExtensionData().getTransitData().getTags());

    assert (response.getPaymentResponse().getExtensionData().getTransitData().getTags().equals(new ArrayList<>(Arrays.asList("PaymentResponseTransitDataTag1", "PaymentResponseTransitDataTag2"))));
    assert (response.getPaymentResponse().getExtensionData().getTransitData().getTags().contains("PaymentResponseTransitDataTag1"));
    assert (response.getPaymentResponse().getExtensionData().getTransitData().getTags().contains("PaymentResponseTransitDataTag2"));
}

    @Test
    public void testResponseTagsAddArray() {
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
                        .extensionData(new PaymentResponseExtensionData.Builder()
                                .transitData(new PaymentResponseTransitData.Builder()
                                    .tags(Arrays.asList("PaymentResponseTransitDataTag1", "PaymentResponseTransitDataTag2"))
                                        .build())
                                .build())
                        .build())
                .build();

        System.out.println(response.toJson());
        System.out.println(response.getPaymentResponse().getExtensionData().getTransitData().getTags());

        assert (response.getPaymentResponse().getExtensionData().getTransitData().getTags().equals(new ArrayList<>(Arrays.asList("PaymentResponseTransitDataTag1", "PaymentResponseTransitDataTag2"))));
        assert (response.getPaymentResponse().getExtensionData().getTransitData().getTags().contains("PaymentResponseTransitDataTag1"));
        assert (response.getPaymentResponse().getExtensionData().getTransitData().getTags().contains("PaymentResponseTransitDataTag2"));
    }
}
