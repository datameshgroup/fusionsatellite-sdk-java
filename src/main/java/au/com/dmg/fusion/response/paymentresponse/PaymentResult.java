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

package au.com.dmg.fusion.response.paymentresponse;

import au.com.dmg.fusion.data.PaymentType;
import com.squareup.moshi.Json;
import org.jetbrains.annotations.Nullable;

public class PaymentResult {

    @Json(name = "PaymentType")
    private final PaymentType paymentType;
    @Json(name = "PaymentInstrumentData")
    private final PaymentInstrumentData paymentInstrumentData;
    @Json(name = "AmountsResp")
    private final AmountsResp amountsResp;
    @Json(name = "OnlineFlag")
    private final Boolean onlineFlag;
    @Json(name = "PaymentAcquirerData")
    private final PaymentAcquirerData paymentAcquirerData;

    @Nullable
    public PaymentType getPaymentType() {
        return paymentType;
    }

    @Nullable
    public PaymentInstrumentData getPaymentInstrumentData() {
        return paymentInstrumentData;
    }

    @Nullable
    public AmountsResp getAmountsResp() {
        return amountsResp;
    }

    @Nullable
    public Boolean getOnlineFlag() {
        return onlineFlag;
    }

    @Nullable
    public PaymentAcquirerData getPaymentAcquirerData() {
        return paymentAcquirerData;
    }

    public static class Builder {

        private PaymentType paymentType;
        private PaymentInstrumentData paymentInstrumentData;
        private AmountsResp amountsResp;
        private Boolean onlineFlag;
        private PaymentAcquirerData paymentAcquirerData;

        public Builder() {
        }

        Builder(PaymentType paymentType, PaymentInstrumentData paymentInstrumentData, AmountsResp amountsResp, Boolean onlineFlag, PaymentAcquirerData paymentAcquirerData) {
            this.paymentType = paymentType;
            this.paymentInstrumentData = paymentInstrumentData;
            this.amountsResp = amountsResp;
            this.onlineFlag = onlineFlag;
            this.paymentAcquirerData = paymentAcquirerData;
        }

        public Builder paymentType(PaymentType paymentType) {
            this.paymentType = paymentType;
            return Builder.this;
        }

        public Builder paymentInstrumentData(PaymentInstrumentData paymentInstrumentData) {
            this.paymentInstrumentData = paymentInstrumentData;
            return Builder.this;
        }

        public Builder amountsResp(AmountsResp amountsResp) {
            this.amountsResp = amountsResp;
            return Builder.this;
        }

        public Builder onlineFlag(Boolean onlineFlag) {
            this.onlineFlag = onlineFlag;
            return Builder.this;
        }

        public Builder paymentAcquirerData(PaymentAcquirerData paymentAcquirerData) {
            this.paymentAcquirerData = paymentAcquirerData;
            return Builder.this;
        }

        public PaymentResult build() {
            if (this.onlineFlag == null) {
                throw new NullPointerException("The property \"onlineFlag\" is null. "
                        + "Please set the value by \"onlineFlag()\". "
                        + "The property \"onlineFlag\" is required.");
            }

            return new PaymentResult(this);
        }
    }

    private PaymentResult(Builder builder) {
        this.paymentType = builder.paymentType;
        this.paymentInstrumentData = builder.paymentInstrumentData;
        this.amountsResp = builder.amountsResp;
        this.onlineFlag = builder.onlineFlag;
        this.paymentAcquirerData = builder.paymentAcquirerData;
    }
}


/*
package au.com.dmg.fusionsatellite.response
class PaymentResult
PaymentType paymentType
PaymentInstrumentData paymentInstrumentData
AmountsResp amountsResp
@Required Boolean onlineFlag
PaymentAcquirerData paymentAcquirerData
* */