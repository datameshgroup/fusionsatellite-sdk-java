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

import com.squareup.moshi.Json;

public class SaleSoftware {

    @Json(name = "ProviderIdentification")
    private final String providerIdentification;
    @Json(name = "ApplicationName")
    private final String applicationName;
    @Json(name = "SoftwareVersion")
    private final String softwareVersion;
    @Json(name = "CertificationCode")
    private final String certificationCode;

    public String getProviderIdentification() {
        return providerIdentification;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public String getCertificationCode() {
        return certificationCode;
    }

    public static class Builder {
        private String providerIdentification;
        private String applicationName;
        private String softwareVersion;
        private String certificationCode;

        public Builder() {
        }

        Builder(String providerIdentification, String applicationName, String softwareVersion, String certificationCode) {
            this.providerIdentification = providerIdentification;
            this.applicationName = applicationName;
            this.softwareVersion = softwareVersion;
            this.certificationCode = certificationCode;
        }

        public Builder providerIdentification(String providerIdentification) {
            this.providerIdentification = providerIdentification;
            return Builder.this;
        }

        public Builder applicationName(String applicationName) {
            this.applicationName = applicationName;
            return Builder.this;
        }

        public Builder softwareVersion(String softwareVersion) {
            this.softwareVersion = softwareVersion;
            return Builder.this;
        }

        public Builder certificationCode(String certificationCode) {
            this.certificationCode = certificationCode;
            return Builder.this;
        }

        public SaleSoftware build() {
            if (this.providerIdentification == null) {
                throw new NullPointerException("The property \"providerIdentification\" is null. "
                        + "Please set the value by \"providerIdentification()\". "
                        + "The properties \"providerIdentification\", \"applicationName\", \"softwareVersion\" and \"certificationCode\" are required.");
            }
            if (this.applicationName == null) {
                throw new NullPointerException("The property \"applicationName\" is null. "
                        + "Please set the value by \"applicationName()\". "
                        + "The properties \"providerIdentification\", \"applicationName\", \"softwareVersion\" and \"certificationCode\" are required.");
            }
            if (this.softwareVersion == null) {
                throw new NullPointerException("The property \"softwareVersion\" is null. "
                        + "Please set the value by \"softwareVersion()\". "
                        + "The properties \"providerIdentification\", \"applicationName\", \"softwareVersion\" and \"certificationCode\" are required.");
            }
            if (this.certificationCode == null) {
                throw new NullPointerException("The property \"certificationCode\" is null. "
                        + "Please set the value by \"certificationCode()\". "
                        + "The properties \"providerIdentification\", \"applicationName\", \"softwareVersion\" and \"certificationCode\" are required.");
            }

            return new SaleSoftware(this);
        }
    }

    private SaleSoftware(Builder builder) {
        this.providerIdentification = builder.providerIdentification;
        this.applicationName = builder.applicationName;
        this.softwareVersion = builder.softwareVersion;
        this.certificationCode = builder.certificationCode;
    }
}


/*
package au.com.dmg.fusionsatellite.request.loginrequest
class SaleSoftware
@Required String providerIdentification
@Required String applicationName
@Required String softwareVersion
@Required String certificationCode
* */