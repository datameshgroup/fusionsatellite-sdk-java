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

package au.com.dmg.fusion.request.loginrequest;

import au.com.dmg.fusion.util.BigDecimalAdapter;
import au.com.dmg.fusion.request.Request;
import au.com.dmg.fusion.request.SaleTerminalData;
import au.com.dmg.fusion.util.InstantAdapter;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

public class LoginRequest implements Request {

    @Json(name = "DateTime")
    private final String dateTime;
    @Json(name = "SaleSoftware")
    private final SaleSoftware saleSoftware;
    @Json(name = "SaleTerminalData")
    private final SaleTerminalData saleTerminalData;
    @Json(name = "OperatorLanguage")
    private final String operatorLanguage;
    @Json(name = "OperatorID")
    private final String operatorID;
    @Json(name = "ShiftNumber")
    private final String shiftNumber;
    @Json(name = "POISerialNumber")
    private final String POISerialNumber;

    public String getDateTime() {
        return dateTime;
    }

    public SaleSoftware getSaleSoftware() {
        return saleSoftware;
    }

    public SaleTerminalData getSaleTerminalData() {
        return saleTerminalData;
    }

    public String getOperatorLanguage() {
        return operatorLanguage;
    }

    public String getOperatorID() {
        return operatorID;
    }

    public String getShiftNumber() {
        return shiftNumber;
    }

    public String getPOISerialNumber() {
        return POISerialNumber;
    }

    public static class Builder {

        private String dateTime;
        private SaleSoftware saleSoftware;
        private SaleTerminalData saleTerminalData;
        private String operatorLanguage;
        private String operatorID;
        private String shiftNumber;
        private String POISerialNumber;

        public Builder() {
        }

        Builder(String dateTime, SaleSoftware saleSoftware, SaleTerminalData saleTerminalData, String operatorLanguage, String operatorID, String shiftNumber, String POISerialNumber) {
            this.dateTime = dateTime;
            this.saleSoftware = saleSoftware;
            this.saleTerminalData = saleTerminalData;
            this.operatorLanguage = operatorLanguage;
            this.operatorID = operatorID;
            this.shiftNumber = shiftNumber;
            this.POISerialNumber = POISerialNumber;
        }

        public Builder dateTime(String dateTime) {
            this.dateTime = dateTime;
            return Builder.this;
        }

        public Builder saleSoftware(SaleSoftware saleSoftware) {
            this.saleSoftware = saleSoftware;
            return Builder.this;
        }

        public Builder saleTerminalData(SaleTerminalData saleTerminalData) {
            this.saleTerminalData = saleTerminalData;
            return Builder.this;
        }

        public Builder operatorLanguage(String operatorLanguage) {
            this.operatorLanguage = operatorLanguage;
            return Builder.this;
        }

        public Builder operatorID(String operatorID) {
            this.operatorID = operatorID;
            return Builder.this;
        }

        public Builder shiftNumber(String shiftNumber) {
            this.shiftNumber = shiftNumber;
            return Builder.this;
        }

        public Builder POISerialNumber(String POISerialNumber) {
            this.POISerialNumber = POISerialNumber;
            return Builder.this;
        }

        public LoginRequest build() {
            if (this.dateTime == null) {
                throw new NullPointerException("The property \"dateTime\" is null. "
                        + "Please set the value by \"dateTime()\". "
                        + "The properties \"dateTime\", \"saleSoftware\", \"saleTerminalData\" and \"operatorLanguage\" are required.");
            }
            if (this.saleSoftware == null) {
                throw new NullPointerException("The property \"saleSoftware\" is null. "
                        + "Please set the value by \"saleSoftware()\". "
                        + "The properties \"dateTime\", \"saleSoftware\", \"saleTerminalData\" and \"operatorLanguage\" are required.");
            }
            if (this.saleTerminalData == null) {
                throw new NullPointerException("The property \"saleTerminalData\" is null. "
                        + "Please set the value by \"saleTerminalData()\". "
                        + "The properties \"dateTime\", \"saleSoftware\", \"saleTerminalData\" and \"operatorLanguage\" are required.");
            }
            if (this.operatorLanguage == null) {
                throw new NullPointerException("The property \"operatorLanguage\" is null. "
                        + "Please set the value by \"operatorLanguage()\". "
                        + "The properties \"dateTime\", \"saleSoftware\", \"saleTerminalData\" and \"operatorLanguage\" are required.");
            }

            return new LoginRequest(this);
        }
    }

    private LoginRequest(Builder builder) {
        this.dateTime = builder.dateTime;
        this.saleSoftware = builder.saleSoftware;
        this.saleTerminalData = builder.saleTerminalData;
        this.operatorLanguage = builder.operatorLanguage;
        this.operatorID = builder.operatorID;
        this.shiftNumber = builder.shiftNumber;
        this.POISerialNumber = builder.POISerialNumber;
    }

    @Override
    public String toJson() {
        Moshi moshi = new Moshi.Builder()
                .add(new BigDecimalAdapter())
                .add(new InstantAdapter())
                .build();
        JsonAdapter<LoginRequest> jsonAdapter = moshi.adapter(LoginRequest.class);
        return jsonAdapter.toJson(this);
    }
}


/*
package au.com.dmg.fusionsatellite.request.loginrequest
class LoginRequest
@Required String dateTime
@Required SaleSoftware saleSoftware
@Required SaleTerminalData saleTerminalData
@Required String operatorLanguage
String operatorID
String shiftNumber
String POISerialNumber
* */