/*
 * Copyright (c) 2022. DatameshGroup
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

import com.squareup.moshi.Json;

import org.jetbrains.annotations.NotNull;;

public class LoyaltyTransactionID {

    @Json(name = "TransactionID")
    private String transactionID;

    @Json(name = "TimeStamp")
    private String timeStamp;

    @NotNull
    public String getTransactionID() {
        return transactionID;
    }

    @NotNull
    public String getTimeStamp() {
        return timeStamp;
    }

    public static class Builder {
        private String transactionID;
        private String timeStamp;

        public Builder() {
        }

        Builder(String transactionID, String timeStamp) {
            this.transactionID = transactionID;
            this.timeStamp = timeStamp;
        }

        public Builder transactionID(String transactionID){
            this.transactionID = transactionID;
            return Builder.this;
        }
        
        public Builder timeStamp(String timeStamp){
            this.timeStamp = timeStamp;
            return Builder.this;
        }

        public LoyaltyTransactionID build() {
            if (this.transactionID == null) {
                throw new NullPointerException("The property \"transactionID\" is null. "
                        + "Please set the value by \"transactionID()\""
                );
            }            
            if (this.timeStamp == null) {
                throw new NullPointerException("The property \"timeStamp\" is null. "
                        + "Please set the value by \"timeStamp()\""
                );
            }
            return new LoyaltyTransactionID(this);
        }
    }

    private LoyaltyTransactionID(Builder builder) {
        this.transactionID = builder.transactionID;
        this.timeStamp = builder.timeStamp;
    }
}

/*
package au.com.dmg.fusionsatellite.PaymentRequest
class LoyaltyTransactionID
String transactionID
String timeStamp
* */