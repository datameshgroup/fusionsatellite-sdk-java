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
import com.squareup.moshi.Json;

import java.util.ArrayList;
import java.util.List;

public class POITerminalData {

    @Json(name = "TerminalEnvironment")
    private final String terminalEnvironment;
    @Json(name = "POICapabilities")
    private final List<POICapability> poiCapabilities;
    @Json(name = "GenericProfile")
    private final String genericProfile;
    @Json(name = "POISerialNumber")
    private final String poiSerialNumber;

    public String getTerminalEnvironment() {
        return terminalEnvironment;
    }

    public List<POICapability> getPoiCapabilities() {
        return poiCapabilities;
    }

    public String getGenericProfile() {
        return genericProfile;
    }

    public String getPoiSerialNumber() {
        return poiSerialNumber;
    }

    public static class Builder {

        private String terminalEnvironment;
        private List<POICapability> poiCapabilities = new ArrayList<POICapability>();
        private String genericProfile;
        private String poiSerialNumber;

        public Builder() {
        }

        Builder(String terminalEnvironment, List<POICapability> poiCapabilities, String genericProfile, String poiSerialNumber) {
            this.terminalEnvironment = terminalEnvironment;
            this.poiCapabilities = poiCapabilities;
            this.genericProfile = genericProfile;
            this.poiSerialNumber = poiSerialNumber;
        }

        public Builder terminalEnvironment(String terminalEnvironment) {
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

        public Builder genericProfile(String genericProfile) {
            this.genericProfile = genericProfile;
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
                        + "The properties \"terminalEnvironment\", \"poiCapabilities\", \"genericProfile\" and \"poiSerialNumber\" are required.");
            }
            if (this.poiCapabilities == null) {
                throw new NullPointerException("The property \"poiCapabilities\" is null. "
                        + "Please set the value by \"poiCapabilities()\". "
                        + "The properties \"terminalEnvironment\", \"poiCapabilities\", \"genericProfile\" and \"poiSerialNumber\" are required.");
            }
            if (this.genericProfile == null) {
                throw new NullPointerException("The property \"genericProfile\" is null. "
                        + "Please set the value by \"genericProfile()\". "
                        + "The properties \"terminalEnvironment\", \"poiCapabilities\", \"genericProfile\" and \"poiSerialNumber\" are required.");
            }
            if (this.poiSerialNumber == null) {
                throw new NullPointerException("The property \"poiSerialNumber\" is null. "
                        + "Please set the value by \"poiSerialNumber()\". "
                        + "The properties \"terminalEnvironment\", \"poiCapabilities\", \"genericProfile\" and \"poiSerialNumber\" are required.");
            }

            return new POITerminalData(this);
        }
    }

    private POITerminalData(Builder builder) {
        this.terminalEnvironment = builder.terminalEnvironment;
        this.poiCapabilities = builder.poiCapabilities;
        this.genericProfile = builder.genericProfile;
        this.poiSerialNumber = builder.poiSerialNumber;
    }
}


/*
package au.com.dmg.fusionsatellite.response
class POITerminalData
@Required String terminalEnvironment
@Required List<POICapability> poiCapabilities
@Required String genericProfile
@Required String poiSerialNumber
* */