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

public class POIStatus {
    @Json(name = "GlobalStatus")
    private final String globalStatus;
    @Json(name = "SecurityOKFlag")
    private final boolean securityOkFlag;
    @Json(name = "PEDOKFlag")
    private final boolean pedOkFlag;
    @Json(name = "CardReaderOKFlag")
    private final boolean cardReaderOkFlag;
    @Json(name = "PrinterStatus")
    private final String printerStatus;
    @Json(name = "CommunicationOKFlag")
    private final boolean communicationOkFlag;
    @Json(name = "FraudPreventionFlag")
    private final boolean fraudPreventionFlag;

    public POIStatus(String globalStatus, boolean securityOkFlag, boolean pedOkFlag, boolean cardReaderOkFlag, String printerStatus, Boolean communicationOkFlag, Boolean fraudPreventionFlag) {
        this.globalStatus = globalStatus;
        this.securityOkFlag = securityOkFlag;
        this.pedOkFlag = pedOkFlag;
        this.cardReaderOkFlag = cardReaderOkFlag;
        this.printerStatus = printerStatus;
        this.communicationOkFlag = communicationOkFlag;
        this.fraudPreventionFlag = fraudPreventionFlag;
    }

    public String getGlobalStatus() {
        return globalStatus;
    }

    public boolean isSecurityOkFlag() {
        return securityOkFlag;
    }

    public boolean isPedOkFlag() {
        return pedOkFlag;
    }

    public boolean isCardReaderOkFlag() {
        return cardReaderOkFlag;
    }

    public String getPrinterStatus() {
        return printerStatus;
    }

    public boolean getCommunicationOkFlag() {
        return communicationOkFlag;
    }

    public boolean getFraudPreventionFlag() {
        return fraudPreventionFlag;
    }

    public static class Builder {
        private String globalStatus;
        private boolean securityOkFlag;
        private boolean pedOkFlag;
        private boolean cardReaderOkFlag;
        private String printerStatus;
        private boolean communicationOkFlag;
        private boolean fraudPreventionFlag;

        public Builder() {
        }

        Builder(String globalStatus, boolean securityOkFlag, boolean pedOkFlag, boolean cardReaderOkFlag, String printerStatus, boolean communicationOkFlag, boolean fraudPreventionFlag){
            this.globalStatus = globalStatus;
            this.securityOkFlag = securityOkFlag;
            this.pedOkFlag = pedOkFlag;
            this.cardReaderOkFlag = cardReaderOkFlag;
            this.printerStatus = printerStatus;
            this.communicationOkFlag = communicationOkFlag;
            this.fraudPreventionFlag = fraudPreventionFlag;
        }

        public Builder globalStatus(String globalStatus){
            this.globalStatus = globalStatus;
            return Builder.this;
        }

        public Builder securityOkFlag(boolean securityOkFlag){
            this.securityOkFlag = securityOkFlag;
            return Builder.this;
        }

        public Builder pedOkFlag(boolean pedOkFlag){
            this.pedOkFlag = pedOkFlag;
            return Builder.this;
        }

        public Builder cardReaderOkFlag(boolean cardReaderOkFlag){
            this.cardReaderOkFlag = cardReaderOkFlag;
            return Builder.this;
        }

        public Builder printerStatus(String printerStatus){
            this.printerStatus = printerStatus;
            return Builder.this;
        }

        public Builder communicationOkFlag(boolean communicationOkFlag){
            this.communicationOkFlag = communicationOkFlag;
            return Builder.this;
        }

        public Builder fraudPreventionFlag(boolean fraudPreventionFlag){
            this.fraudPreventionFlag = fraudPreventionFlag;
            return Builder.this;
        }

        public POIStatus build() {
            return new POIStatus(this);
        }
    }
    private POIStatus(Builder builder){
        this.globalStatus = builder.globalStatus;
        this.securityOkFlag = builder.securityOkFlag;
        this.pedOkFlag = builder.pedOkFlag;
        this.cardReaderOkFlag = builder.cardReaderOkFlag;
        this.printerStatus = builder.printerStatus;
        this.communicationOkFlag = builder.communicationOkFlag;
        this.fraudPreventionFlag = builder.fraudPreventionFlag;
    }
}