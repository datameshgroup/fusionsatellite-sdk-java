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

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

import au.com.dmg.fusion.request.paymentrequest.extenstiondata.ExtensionData;
import au.com.dmg.fusion.request.paymentrequest.extenstiondata.Stop;
import au.com.dmg.fusion.request.paymentrequest.extenstiondata.TransitData;
import au.com.dmg.fusion.request.paymentrequest.extenstiondata.Trip;
import au.com.dmg.fusion.request.printrequest.OutputContent;
import au.com.dmg.fusion.response.paymentresponse.PaymentReceipt;
import au.com.dmg.fusion.util.Base64;
import org.junit.Test;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import au.com.dmg.fusion.data.PaymentBrand;
import au.com.dmg.fusion.data.PaymentType;
import au.com.dmg.fusion.data.UnitOfMeasure;
import au.com.dmg.fusion.util.BigDecimalAdapter;
import au.com.dmg.fusion.util.InstantAdapter;

public class PaymentRequestTest {

    @Test
    public void testJson() {
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
                                .allowedPaymentBrand(new LinkedList<String>())
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
                                        .weightUnitOfMeasure(100)
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
        assert (serializedRequest.getPaymentTransaction().getSaleItems().get(0).getWeightUnitOfMeasure().equals("100"));
    }
    @Test
    public void testJsonwithReceipt() throws UnsupportedEncodingException {
        String receipt = "<p id=\"receipt-info\">\n" +
                "  16/09/2021 14:46:04<br/>\n" +
                "  Merchant ID: M00000021<br/>\n" +
                "  Terminal ID: WR000002\n" +
                "</p>\n" +
                "<p id=\"receipt-details\">\n" +
                "  <b>Purchase Transaction</b><br/>\n" +
                "  Amount: $1.00<br/>\n" +
                "  Surcharge: $0.01<br/>\n" +
                "  Total: $1.01<br/>\n" +
                "  VISA: 000000XXXXXX0000 (T)<br/>\n" +
                "  Credit Account\n" +
                "</p>\n" +
                "<p id=\"receipt-result\">\n" +
                "  <b>Approved</b><br/>\n" +
                "  Reference: 0000 0000 0911<br/>\n" +
                "  Auth Code: 696744<br/>\n" +
                "  AID: A0000000031010<br/>\n" +
                "  ATC: 0016<br/>\n" +
                "  TVR: 0000000000<br/>\n" +
                "  ARQC: 62262DE32EFBBC91\n" +
                "</p>";
        PaymentReceipt pr = new PaymentReceipt.Builder()
                .documentQualifier("x")
                .requiredSignatureFlag(false)
                .integratedPrintFlag(false)
                .outputContent(new OutputContent("XHTML", Base64.encode(receipt.getBytes("UTF-8"))))
                .build();
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
                                .allowedPaymentBrand(new LinkedList<String>())
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
                                        .weightUnitOfMeasure(100)
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
                .addPaymentReceipt(pr)
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
        assert (serializedRequest.getPaymentTransaction().getSaleItems().get(0).getWeightUnitOfMeasure().equals("100"));
    }
}