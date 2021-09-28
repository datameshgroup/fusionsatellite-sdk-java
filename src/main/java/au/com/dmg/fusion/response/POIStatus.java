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
    @Json(name = "SecurityOkFlag")
    private final boolean securityOkFlag;
    @Json(name = "PEDOKFlag")
    private final boolean pedOkFlag;
    @Json(name = "CardReaderOkFlag")
    private final boolean cardReaderOkFlag;
    @Json(name = "PrinterStatus")
    private final String printerStatus;
    @Json(name = "CommunicationOkFlag")
    private final Boolean communicationOkFlag;
    @Json(name = "FraudPreventionFlag")
    private final Boolean fraudPreventionFlag;

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

    public Boolean getCommunicationOkFlag() {
        return communicationOkFlag;
    }

    public Boolean getFraudPreventionFlag() {
        return fraudPreventionFlag;
    }
}
