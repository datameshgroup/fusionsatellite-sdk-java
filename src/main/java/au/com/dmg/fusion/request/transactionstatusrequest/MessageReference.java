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

package au.com.dmg.fusion.request.transactionstatusrequest;

import au.com.dmg.fusion.data.MessageCategory;
import com.squareup.moshi.Json;
import org.jetbrains.annotations.Nullable;

public class MessageReference {

    @Json(name = "MessageCategory")
    private final MessageCategory messageCategory;
    @Json(name = "ServiceID")
    private final String serviceID;
    @Json(name = "SaleID")
    private final String saleID;
    @Json(name = "POIID")
    private final String POIID;

    @Nullable
    public MessageCategory getMessageCategory() {
        return messageCategory;
    }

    @Nullable
    public String getServiceID() {
        return serviceID;
    }

    @Nullable
    public String getSaleID() {
        return saleID;
    }

    @Nullable
    public String getPOIID() {
        return POIID;
    }

    public static class Builder {

        private MessageCategory messageCategory;
        private String serviceID;
        private String saleID;
        private String POIID;

        public Builder() {
        }

        Builder(MessageCategory messageCategory, String serviceID, String saleID, String POIID) {
            this.messageCategory = messageCategory;
            this.serviceID = serviceID;
            this.saleID = saleID;
            this.POIID = POIID;
        }

        public Builder messageCategory(MessageCategory messageCategory) {
            this.messageCategory = messageCategory;
            return Builder.this;
        }

        public Builder serviceID(String serviceID) {
            this.serviceID = serviceID;
            return Builder.this;
        }

        public Builder saleID(String saleID) {
            this.saleID = saleID;
            return Builder.this;
        }

        public Builder POIID(String POIID) {
            this.POIID = POIID;
            return Builder.this;
        }

        public MessageReference build() {

            return new MessageReference(this);
        }
    }

    private MessageReference(Builder builder) {
        this.messageCategory = builder.messageCategory;
        this.serviceID = builder.serviceID;
        this.saleID = builder.saleID;
        this.POIID = builder.POIID;
    }
}

/*
class MessageReference
MessageCategory messageCategory
String serviceID
String saleID
String POIID
* */