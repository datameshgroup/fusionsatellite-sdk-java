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

import au.com.dmg.fusion.data.PaymentType;
import com.squareup.moshi.Json;

public class PaymentData {

    @Json(name = "PaymentType")
    private final PaymentType paymentType;
    @Json(name = "PaymentInstrumentData")
    private final PaymentInstrumentData paymentInstrumentData;
    @Json(name = "SplitPaymentFlag")
    private final Boolean splitPaymentFlag;

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public PaymentInstrumentData getPaymentInstrumentData() {
        return paymentInstrumentData;
    }

    public Boolean getSplitPaymentFlag(){ return splitPaymentFlag; }

    public static class Builder {
        private PaymentType paymentType = PaymentType.Normal;
        private PaymentInstrumentData paymentInstrumentData;
        private Boolean splitPaymentFlag = false;

        public Builder() {
        }

        Builder(PaymentType paymentType, PaymentInstrumentData paymentInstrumentData) {
            this.paymentType = paymentType;
            this.paymentInstrumentData = paymentInstrumentData;
        }

        Builder(PaymentType paymentType, PaymentInstrumentData paymentInstrumentData, Boolean splitPaymentFlag) {
            this.paymentType = paymentType;
            this.paymentInstrumentData = paymentInstrumentData;
            this.splitPaymentFlag = splitPaymentFlag;
        }

        public Builder paymentType(PaymentType paymentType) {
            this.paymentType = paymentType;
            return Builder.this;
        }

        public Builder paymentInstrumentData(PaymentInstrumentData paymentInstrumentData) {
            this.paymentInstrumentData = paymentInstrumentData;
            return Builder.this;
        }

        public Builder splitPaymentFlag(Boolean splitPaymentFlag) {
            this.splitPaymentFlag = splitPaymentFlag;
            return Builder.this;
        }

        public PaymentData build() {
            if (this.paymentType == null) {
                throw new NullPointerException("The property \"paymentType\" is null. "
                        + "Please set the value by \"paymentType()\". "
                        + "The property \"paymentType\" is required.");
            }

            return new PaymentData(this);
        }
    }

    private PaymentData(Builder builder) {
        this.paymentType = builder.paymentType;
        this.paymentInstrumentData = builder.paymentInstrumentData;
        this.splitPaymentFlag = builder.splitPaymentFlag;
    }
}


/*
package au.com.dmg.fusionsatellite.PaymentRequest
class PaymentData
@Required PaymentType paymentType
PaymentInstrumentData paymentInstrumentData
* */

