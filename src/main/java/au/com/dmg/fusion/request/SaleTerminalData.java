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

package au.com.dmg.fusion.request;

import java.util.ArrayList;
import java.util.List;

import com.squareup.moshi.Json;

import au.com.dmg.fusion.data.SaleCapability;
import au.com.dmg.fusion.data.TerminalEnvironment;

public class SaleTerminalData {

    @Json(name = "TerminalEnvironment")
    private final TerminalEnvironment terminalEnvironment;
    @Json(name = "SaleCapabilities")
    private final List<SaleCapability> saleCapabilities;
    @Json(name = "TotalsGroupID")
    private final String totalsGroupID;
    @Json(name = "DeviceID")
    private final String deviceID;

    public TerminalEnvironment getTerminalEnvironment() {
        return terminalEnvironment;
    }

    public List<SaleCapability> getSaleCapabilities() {
        return saleCapabilities;
    }

    public String getTotalsGroupID() {
        return totalsGroupID;
    }

    public String getDeviceID() { return deviceID; }

    public static class Builder {

        private TerminalEnvironment terminalEnvironment;
        private List<SaleCapability> saleCapabilities = new ArrayList<>();
        private String totalsGroupID;
        private String deviceID;

        public Builder() {
        }

        Builder(TerminalEnvironment terminalEnvironment, List<SaleCapability> saleCapabilities, String totalsGroupID, String deviceID) {
            this.terminalEnvironment = terminalEnvironment;
            this.saleCapabilities = saleCapabilities;
            this.totalsGroupID = totalsGroupID;
            this.deviceID = deviceID;
        }

        public Builder terminalEnvironment(TerminalEnvironment terminalEnvironment) {
            this.terminalEnvironment = terminalEnvironment;
            return Builder.this;
        }

        public Builder saleCapabilities(List<SaleCapability> saleCapabilities) {
            this.saleCapabilities = saleCapabilities;
            return Builder.this;
        }

        public Builder addSaleCapabilities(SaleCapability saleCapabilities) {
            this.saleCapabilities.add(saleCapabilities);
            return Builder.this;
        }

        public Builder totalsGroupID(String totalsGroupID) {
            this.totalsGroupID = totalsGroupID;
            return Builder.this;
        }

        public Builder deviceID(String deviceId){
            this.deviceID = deviceId;
            return Builder.this;
        }

        public SaleTerminalData build() {

            return new SaleTerminalData(this);
        }
    }

    private SaleTerminalData(Builder builder) {
        this.terminalEnvironment = builder.terminalEnvironment;
        this.saleCapabilities = builder.saleCapabilities;
        this.totalsGroupID = builder.totalsGroupID;
        this.deviceID = builder.deviceID;;
    }
}

/*
package au.com.dmg.fusionsatellite.PaymentRequest
class SaleTerminalData
TerminalEnvironment terminalEnvironment
List<SaleCapability> saleCapabilities
String totalsGroupID
String deviceID
* */