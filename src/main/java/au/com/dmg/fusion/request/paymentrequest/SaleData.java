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

import com.squareup.moshi.Json;
import org.jetbrains.annotations.NotNull;

public class SaleData {

    @Json(name = "OperatorID")
    private final String operatorID;
    @Json(name = "OperatorLanguage")
    private final String operatorLanguage;
    @Json(name = "ShiftNumber")
    private final String shiftNumber;
    @Json(name = "SaleReferenceID")
    private final String saleReferenceID;
    @Json(name = "TokenRequestedType")
    private final String tokenRequestedType;
    @Json(name = "SaleTransactionID")
    private SaleTransactionID saleTransactionID;

    public String getOperatorID() {
        return operatorID;
    }

    public String getOperatorLanguage() {
        return operatorLanguage;
    }

    public String getShiftNumber() {
        return shiftNumber;
    }

    public String getSaleReferenceID() {
        return saleReferenceID;
    }

    public String getTokenRequestedType() {
        return tokenRequestedType;
    }

    @NotNull
    public SaleTransactionID getSaleTransactionID() {
        return saleTransactionID;
    }

    public static class Builder {

        private String operatorID;
        private String operatorLanguage;
        private String shiftNumber;
        private String saleReferenceID;
        private String tokenRequestedType;
        private SaleTransactionID saleTransactionID;

        public Builder() {
        }

        Builder(String operatorID, String operatorLanguage, String shiftNumber, String saleReferenceID, String tokenRequestedType, SaleTransactionID saleTransactionID) {
            this.operatorID = operatorID;
            this.operatorLanguage = operatorLanguage;
            this.shiftNumber = shiftNumber;
            this.saleReferenceID = saleReferenceID;
            this.tokenRequestedType = tokenRequestedType;
            this.saleTransactionID = saleTransactionID;
        }

        public Builder operatorID(String operatorID) {
            this.operatorID = operatorID;
            return Builder.this;
        }

        public Builder operatorLanguage(String operatorLanguage) {
            this.operatorLanguage = operatorLanguage;
            return Builder.this;
        }

        public Builder shiftNumber(String shiftNumber) {
            this.shiftNumber = shiftNumber;
            return Builder.this;
        }

        public Builder saleReferenceID(String saleReferenceID) {
            this.saleReferenceID = saleReferenceID;
            return Builder.this;
        }

        public Builder tokenRequestedType(String tokenRequestedType) {
            this.tokenRequestedType = tokenRequestedType;
            return Builder.this;
        }

        public Builder saleTransactionID(SaleTransactionID saleTransactionID) {
            this.saleTransactionID = saleTransactionID;
            return Builder.this;
        }

        public SaleData build() {
            if (this.operatorLanguage == null) {
                operatorLanguage = "en";
            }
            if (this.saleTransactionID == null) {
                throw new NullPointerException("The property \"saleTransactionID\" is null. "
                        + "Please set the value by \"saleTransactionID()\". "
                        + "The property \"saleTransactionID\" is required.");
            }


            return new SaleData(this);
        }
    }

    private SaleData(Builder builder) {
        this.operatorID = builder.operatorID;
        this.operatorLanguage = builder.operatorLanguage;
        this.shiftNumber = builder.shiftNumber;
        this.saleReferenceID = builder.saleReferenceID;
        this.saleTransactionID = builder.saleTransactionID;
        this.tokenRequestedType = builder.tokenRequestedType;
    }
}


/*
package au.com.dmg.fusionsatellite.PaymentRequest
class SaleData
String operatorID
@Required String operatorLanguage
String shiftNumber
String saleReferenceID
String tokenRequestedType
@Required SaleTransactionID saleTransactionID
* */