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

import com.squareup.moshi.Json;

import java.util.ArrayList;
import java.util.List;

public class SaleTerminalData {

    @Json(name = "TerminalEnvironment")
    private final String terminalEnvironment;
    @Json(name = "SaleCapabilities")
    private final List<String> saleCapabilities;
    @Json(name = "TotalsGroupID")
    private final String totalsGroupID;

    public String getTerminalEnvironment() {
        return terminalEnvironment;
    }

    public List<String> getSaleCapabilities() {
        return saleCapabilities;
    }

    public String getTotalsGroupID() {
        return totalsGroupID;
    }

    public static class Builder {

        private String terminalEnvironment;
        private List<String> saleCapabilities = new ArrayList<>();
        private String totalsGroupID;

        public Builder() {
        }

        Builder(String terminalEnvironment, List<String> saleCapabilities, String totalsGroupID) {
            this.terminalEnvironment = terminalEnvironment;
            this.saleCapabilities = saleCapabilities;
            this.totalsGroupID = totalsGroupID;
        }

        public Builder terminalEnvironment(String terminalEnvironment) {
            this.terminalEnvironment = terminalEnvironment;
            return Builder.this;
        }

        public Builder saleCapabilities(List<String> saleCapabilities) {
            this.saleCapabilities = saleCapabilities;
            return Builder.this;
        }

        public Builder addSaleCapabilities(String saleCapabilities) {
            this.saleCapabilities.add(saleCapabilities);
            return Builder.this;
        }

        public Builder totalsGroupID(String totalsGroupID) {
            this.totalsGroupID = totalsGroupID;
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
    }
}

/*
package au.com.dmg.fusionsatellite.PaymentRequest
class SaleTerminalData
String terminalEnvironment
List<String> saleCapabilities
String totalsGroupID
* */