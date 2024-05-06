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

package au.com.dmg.fusion.response;

import com.squareup.moshi.Json;

public class POISystemData {

    @Json(name = "DateTime")
    private final String dateTime;
    @Json(name = "TokenRequestStatus")
    private final Boolean tokenRequestStatus;
    @Json(name = "POITerminalData")
    private final POITerminalData poiTerminalData;
    @Json(name = "POIStatus")
    private final POIStatus poiStatus;
    @Json(name = "POISoftware")
    private final POISoftware poiSoftware;

    public String getDateTime() {
        return dateTime;
    }

    public Boolean getTokenRequestStatus() {
        return tokenRequestStatus;
    }

    public POITerminalData getPoiTerminalData() {
        return poiTerminalData;
    }

    public POIStatus getPoiStatus() {
        return poiStatus;
    }

    public POISoftware getPoiSoftware() { return poiSoftware; }

    public static class Builder {

        private String dateTime;
        private Boolean tokenRequestStatus;
        private POITerminalData poiTerminalData;
        private POIStatus poiStatus;
        private POISoftware poiSoftware;

        public Builder() {
        }

        Builder(String dateTime, Boolean tokenRequestStatus, POITerminalData poiTerminalData, POIStatus poiStatus) {
            this.dateTime = dateTime;
            this.tokenRequestStatus = tokenRequestStatus;
            this.poiTerminalData = poiTerminalData;
            this.poiStatus = poiStatus;
        }

        Builder(String dateTime, Boolean tokenRequestStatus, POITerminalData poiTerminalData, POIStatus poiStatus, POISoftware poiSoftware) {
            this.dateTime = dateTime;
            this.tokenRequestStatus = tokenRequestStatus;
            this.poiTerminalData = poiTerminalData;
            this.poiStatus = poiStatus;
            this.poiSoftware = poiSoftware;
        }

        public Builder dateTime(String dateTime) {
            this.dateTime = dateTime;
            return Builder.this;
        }

        public Builder tokenRequestStatus(Boolean tokenRequestStatus) {
            this.tokenRequestStatus = tokenRequestStatus;
            return Builder.this;
        }

        public Builder POITerminalData(POITerminalData poiTerminalData) {
            this.poiTerminalData = poiTerminalData;
            return Builder.this;
        }

        public Builder poiStatus(POIStatus poiStatus) {
            this.poiStatus = poiStatus;
            return Builder.this;
        }

        public Builder poiSoftware(POISoftware poiSoftware){
            this.poiSoftware = poiSoftware;
            return Builder.this;
        }

        public POISystemData build() {
            if (this.dateTime == null) {
                throw new NullPointerException("The property \"dateTime\" is null. "
                        + "Please set the value by \"dateTime()\". "
                        + "The properties \"dateTime\", \"tokenRequestStatus\", \"poiTerminalData\" and \"poiStatus\" are required.");
            }
            if (this.tokenRequestStatus == null) {
                throw new NullPointerException("The property \"tokenRequestStatus\" is null. "
                        + "Please set the value by \"tokenRequestStatus()\". "
                        + "The properties \"dateTime\", \"tokenRequestStatus\", \"poiTerminalData\" and \"poiStatus\" are required.");
            }
            if (this.poiTerminalData == null) {
                throw new NullPointerException("The property \"poiTerminalData\" is null. "
                        + "Please set the value by \"poiTerminalData()\". "
                        + "The properties \"dateTime\", \"tokenRequestStatus\", \"poiTerminalData\" and \"poiStatus\" are required.");
            }
            if (this.poiStatus == null) {
                throw new NullPointerException("The property \"poiStatus\" is null. "
                        + "Please set the value by \"poiStatus()\". "
                        + "The properties \"dateTime\", \"tokenRequestStatus\", \"poiTerminalData\" and \"poiStatus\" are required.");
            }

            return new POISystemData(this);
        }
    }

    private POISystemData(Builder builder) {
        this.dateTime = builder.dateTime;
        this.tokenRequestStatus = builder.tokenRequestStatus;
        this.poiTerminalData = builder.poiTerminalData;
        this.poiStatus = builder.poiStatus;
        this.poiSoftware = builder.poiSoftware;
    }
}


/*
package au.com.dmg.fusionsatellite.response
class POISystemData
@Required String dateTime
@Required Boolean tokenRequestStatus
@Required POITerminalData poiTerminalData
@Required POIStatus poiStatus
POISoftware poiSoftware
* */