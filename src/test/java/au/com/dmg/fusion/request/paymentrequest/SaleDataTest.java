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

import au.com.dmg.fusion.data.SaleCapability;
import au.com.dmg.fusion.data.TerminalEnvironment;
import au.com.dmg.fusion.request.SaleTerminalData;
import au.com.dmg.fusion.util.InstantAdapter;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import org.junit.Test;

import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;

public class SaleDataTest {

    @Test
    public void testSaleData() throws IOException {
        SaleData data = new SaleData.Builder()
                .operatorID("x")
                .operatorLanguage("en")
                .shiftNumber("ShiftNumber123")
                .saleReferenceID("xx")
                .shiftNumber("f3f")
                .saleTerminalData(new SaleTerminalData.Builder()
                        .terminalEnvironment(TerminalEnvironment.Attended)
                        .saleCapabilities(Arrays.asList(SaleCapability.CashierStatus, SaleCapability.CustomerAssistance))
                        .totalsGroupID("TotalsGroupID123")
                        .deviceID("TestDeviceID123")
                        .build())
                .tokenRequestedType("ffff")
                .saleTransactionID(new SaleTransactionID.Builder("x", Instant.ofEpochMilli(System.currentTimeMillis())).build())
                .build();

        Moshi moshi = new Moshi.Builder()
                .add(new InstantAdapter())
                .build();
        JsonAdapter<SaleData> jsonAdapter = moshi.adapter(SaleData.class);
        String json = jsonAdapter.toJson(data);
        System.out.println(json);

        SaleData sd = jsonAdapter.fromJson(json);
        assert(sd.getOperatorID().equals("x"));
    }

    @Test
    public void testSaleDataWithSponsoredMerchant() throws IOException {
        SponsoredMerchant sponsoredMerchant = new SponsoredMerchant.Builder()
                .siteID("SiteID123")
                .businessID("BusinessID123")
                .registeredIdentifier("RegisteredIdentifier123")
                .build();
        SaleData data = new SaleData.Builder()
                .operatorID("x")
                .operatorLanguage("en")
                .shiftNumber("ShiftNumber123")
                .saleReferenceID("xx")
                .shiftNumber("f3f")
                .saleTerminalData(new SaleTerminalData.Builder()
                        .terminalEnvironment(TerminalEnvironment.Attended)
                        .saleCapabilities(Arrays.asList(SaleCapability.CashierStatus, SaleCapability.CustomerAssistance))
                        .totalsGroupID("TotalsGroupID123")
                        .deviceID("TestDeviceID123")
                        .build())
                .tokenRequestedType("ffff")
                .saleTransactionID(new SaleTransactionID.Builder("x", Instant.ofEpochMilli(System.currentTimeMillis())).build())
                .sponsoredMerchant(sponsoredMerchant)
                .build();

        Moshi moshi = new Moshi.Builder()
                .add(new InstantAdapter())
                .build();
        JsonAdapter<SaleData> jsonAdapter = moshi.adapter(SaleData.class);
        String json = jsonAdapter.toJson(data);
        System.out.println(json);

        SaleData sd = jsonAdapter.fromJson(json);
        assert(sd.getOperatorID().equals("x"));
    }
}