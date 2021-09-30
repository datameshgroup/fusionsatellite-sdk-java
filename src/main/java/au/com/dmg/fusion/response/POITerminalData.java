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

import au.com.dmg.fusion.data.POICapability;
import au.com.dmg.fusion.data.TerminalEnvironment;

import com.squareup.moshi.Json;

import java.util.ArrayList;
import java.util.List;

public class POITerminalData {

    @Json(name = "TerminalEnvironment")
    private final TerminalEnvironment terminalEnvironment;
    @Json(name = "POICapabilities")
    private final List<POICapability> poiCapabilities;
    @Json(name = "POIProfile")
    private final POIProfile poiProfile;
    @Json(name = "POISerialNumber")
    private final String poiSerialNumber;

    public TerminalEnvironment getTerminalEnvironment() {
        return terminalEnvironment;
    }

    public List<POICapability> getPoiCapabilities() {
        return poiCapabilities;
    }

    public POIProfile getPoiProfile() {
        return poiProfile;
    }

    public String getPoiSerialNumber() {
        return poiSerialNumber;
    }

    public static class Builder {

        private TerminalEnvironment terminalEnvironment;
        private List<POICapability> poiCapabilities = new ArrayList<POICapability>();
        private POIProfile poiProfile;
        private String poiSerialNumber;

        public Builder() {
        }

        Builder(TerminalEnvironment terminalEnvironment, List<POICapability> poiCapabilities, POIProfile poiProfile, String poiSerialNumber) {
            this.terminalEnvironment = terminalEnvironment;
            this.poiCapabilities = poiCapabilities;
            this.poiProfile = poiProfile;
            this.poiSerialNumber = poiSerialNumber;
        }

        public Builder terminalEnvironment(TerminalEnvironment terminalEnvironment) {
            this.terminalEnvironment = terminalEnvironment;
            return Builder.this;
        }

        public Builder poiCapabilities(List<POICapability> poiCapabilities) {
            this.poiCapabilities = poiCapabilities;
            return Builder.this;
        }

        public Builder addPoiCapabilities(POICapability poiCapabilities) {
            this.poiCapabilities.add(poiCapabilities);
            return Builder.this;
        }

        public Builder poiProfile(POIProfile poiProfile) {
            this.poiProfile = poiProfile;
            return Builder.this;
        }

        public Builder poiSerialNumber(String poiSerialNumber) {
            this.poiSerialNumber = poiSerialNumber;
            return Builder.this;
        }

        public POITerminalData build() {
            if (this.terminalEnvironment == null) {
                throw new NullPointerException("The property \"terminalEnvironment\" is null. "
                        + "Please set the value by \"terminalEnvironment()\". "
                        + "The properties \"terminalEnvironment\", \"poiCapabilities\", \"poiProfile\" and \"poiSerialNumber\" are required.");
            }
            if (this.poiCapabilities == null) {
                throw new NullPointerException("The property \"poiCapabilities\" is null. "
                        + "Please set the value by \"poiCapabilities()\". "
                        + "The properties \"terminalEnvironment\", \"poiCapabilities\", \"poiProfile\" and \"poiSerialNumber\" are required.");
            }
            if (this.poiProfile == null) {
                throw new NullPointerException("The property \"poiProfile\" is null. "
                        + "Please set the value by \"poiProfile()\". "
                        + "The properties \"terminalEnvironment\", \"poiCapabilities\", \"poiProfile\" and \"poiSerialNumber\" are required.");
            }
            if (this.poiSerialNumber == null) {
                throw new NullPointerException("The property \"poiSerialNumber\" is null. "
                        + "Please set the value by \"poiSerialNumber()\". "
                        + "The properties \"terminalEnvironment\", \"poiCapabilities\", \"poiProfile\" and \"poiSerialNumber\" are required.");
            }

            return new POITerminalData(this);
        }
    }

    private POITerminalData(Builder builder) {
        this.terminalEnvironment = builder.terminalEnvironment;
        this.poiCapabilities = builder.poiCapabilities;
        this.poiProfile = builder.poiProfile;
        this.poiSerialNumber = builder.poiSerialNumber;
    }
}


/*
package au.com.dmg.fusionsatellite.response
class POITerminalData
@Required TerminalEnvironment terminalEnvironment
@Required List<POICapability> poiCapabilities
@Required POIProfile poiProfile
@Required String poiSerialNumber
* */