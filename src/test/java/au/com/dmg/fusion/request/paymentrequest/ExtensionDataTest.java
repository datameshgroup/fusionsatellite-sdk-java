/*
 * Copyright (c) 2023. DatameshGroup
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

import au.com.dmg.fusion.data.CustomFieldType;
import au.com.dmg.fusion.data.PaymentBrand;
import au.com.dmg.fusion.data.PaymentType;
import au.com.dmg.fusion.data.UnitOfMeasure;
import au.com.dmg.fusion.request.paymentrequest.extenstiondata.ExtensionData;
import au.com.dmg.fusion.request.paymentrequest.extenstiondata.Stop;
import au.com.dmg.fusion.request.paymentrequest.extenstiondata.TransitData;
import au.com.dmg.fusion.request.paymentrequest.extenstiondata.Trip;
import au.com.dmg.fusion.util.BigDecimalAdapter;
import au.com.dmg.fusion.util.InstantAdapter;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class ExtensionDataTest {

    @Test
    public void testValid(){
        Trip trip = new Trip.Builder()
                .totalDistanceTravelled(BigDecimal.valueOf(5.00))
                .addStop(new Stop.Builder()
                        .stopIndex(0)
                        .stopName("stop0")
                        .latitude(BigDecimal.valueOf(68.88))
                        .longitude(BigDecimal.valueOf(88.88))
                        .timestamp(Instant.ofEpochMilli(System.currentTimeMillis()))
                        .build()
                ).addStop(new Stop.Builder()
                        .stopIndex(1)
                        .stopName("stop1")
                        .latitude(BigDecimal.valueOf(77.77))
                        .longitude(BigDecimal.valueOf(66.66))
                        .timestamp(Instant.ofEpochMilli(System.currentTimeMillis()))
                        .build())
                .build();
        TransitData transitData = new TransitData.Builder()
                .nswAllowTSSSubsidy(true)
                .nswAllowTSSLift(false)
                .isWheelchairEnabled(true)
                .trip(trip)
                .build();
        ExtensionData extensionData = new ExtensionData.Builder()
                .transitData(transitData)
                .build();
    }

    @Test
    public void testPaymentRequestJson(){
        PaymentRequest request = new PaymentRequest.Builder()
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
                                .allowedPaymentBrands(new LinkedList<PaymentBrand>())
                                .build()
                        )
                        .addSaleItem(
                                new SaleItem.Builder()
                                        .itemID(1)
                                        .productCode("X")
                                        .eanUpc("xxx")
                                        .parentItemID(1)
                                        .unitOfMeasure(UnitOfMeasure.Centilitre)
                                        .quantity(new BigDecimal("1.0"))
                                        .unitPrice(new BigDecimal(1.0))
                                        .itemAmount(new BigDecimal("1.0"))
                                        .productLabel("xx")
                                        .build()
                        )
                        .build()
                )
                .paymentData(new PaymentData.Builder().paymentType(PaymentType.Normal).build())
                .extensionData(new ExtensionData.Builder().transitData(
                        new TransitData.Builder()
                                .isWheelchairEnabled(false)
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
                                .build())
                        .build())
                .build();

        Moshi moshi = new Moshi.Builder()
                .add(new BigDecimalAdapter())
                .add(new InstantAdapter())
                .build();
        JsonAdapter<PaymentRequest> jsonAdapter = moshi.adapter(PaymentRequest.class);
        String json = jsonAdapter.toJson(request);
        System.out.println(json);

        PaymentRequest serializedRequest = null;
        try {
            serializedRequest = jsonAdapter.fromJson(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert (serializedRequest.getSaleData().getOperatorID().equals("operatorID"));
    }

    @Test //(expected=NullPointerException.class)
    public void testMinimumStop(){
        NullPointerException exception =
        assertThrows(NullPointerException.class,
                ()->{
                    PaymentRequest request = new PaymentRequest.Builder()
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
                                            .allowedPaymentBrands(new LinkedList<PaymentBrand>())
                                            .build()
                                    )
                                    .addSaleItem(
                                            new SaleItem.Builder()
                                                    .itemID(1)
                                                    .productCode("X")
                                                    .eanUpc("xxx")
                                                    .parentItemID(1)
                                                    .unitOfMeasure(UnitOfMeasure.Centilitre)
                                                    .quantity(new BigDecimal("1.0"))
                                                    .unitPrice(new BigDecimal(1.0))
                                                    .itemAmount(new BigDecimal("1.0"))
                                                    .productLabel("xx")
                                                    .build()
                                    )
                                    .build()
                            )
                            .paymentData(new PaymentData.Builder().paymentType(PaymentType.Normal).build())
                            .extensionData(new ExtensionData.Builder().transitData(
                                            new TransitData.Builder()
                                                    .isWheelchairEnabled(false)
                                                    .trip(new Trip.Builder()
                                                            .totalDistanceTravelled(new BigDecimal(222.22))
                                                            .addStop(new Stop.Builder()
                                                                    .stopIndex(0)
                                                                    .stopName("test0")
                                                                    .latitude(new BigDecimal(3432423))
                                                                    .longitude(new BigDecimal(-3432423))
                                                                    .timestamp(Instant.ofEpochMilli(System.currentTimeMillis()))
                                                                    .build())
                                                            .build())
                                                    .build())
                                    .build())
                            .build();

                    Moshi moshi = new Moshi.Builder()
                            .add(new BigDecimalAdapter())
                            .add(new InstantAdapter())
                            .build();


                    PaymentRequest serializedRequest = null;
                    try {
                        JsonAdapter<PaymentRequest> jsonAdapter = moshi.adapter(PaymentRequest.class);
                        String json = jsonAdapter.toJson(request);
                        serializedRequest = jsonAdapter.fromJson(json);
                    } catch (NullPointerException | IOException e) {
                        e.printStackTrace();
                    }
                    assert (serializedRequest.getSaleData().getOperatorID().equals("operatorID"));
                });
        assertEquals("The property \"Stops\" is invalid. Please set the Value by \"stops()\". the properties \"Stops\" should contain a minimum of two entries which indicate start and end of the trip.", exception.getMessage());
    }
}