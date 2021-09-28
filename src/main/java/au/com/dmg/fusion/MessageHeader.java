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

package au.com.dmg.fusion;

import au.com.dmg.fusion.data.MessageCategory;
import au.com.dmg.fusion.data.MessageClass;
import au.com.dmg.fusion.data.MessageType;
import com.squareup.moshi.Json;

public class MessageHeader {

    @Json(name = "MessageClass")
    private final MessageClass messageClass;
    @Json(name = "MessageCategory")
    private final MessageCategory messageCategory;
    @Json(name = "MessageType")
    private final MessageType messageType;
    @Json(name = "ServiceID")
    private final String serviceID;
    @Json(name = "DeviceID")
    private final String deviceID;

    // these fields are required for cloud POS
    @Json(name = "ProtocolVersion")
    private final String protocolVersion;
    @Json(name = "SaleID")
    private final String saleID;
    @Json(name = "POIID")
    private final String POIID;


    public MessageClass getMessageClass() {
        return messageClass;
    }

    public MessageCategory getMessageCategory() {
        return messageCategory;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public String getServiceID() {
        return serviceID;
    }

    public String getProtocolVersion() {
        return protocolVersion;
    }

    public String getSaleID() {
        return saleID;
    }

    public String getPoiID() {
        return POIID;
    }

    public static class Builder {

        private MessageClass messageClass;
        private MessageCategory messageCategory;
        private MessageType messageType;
        private String serviceID;
        private String protocolVersion;
        private String saleID;
        private String POIID;
        private String deviceID;

        public Builder() {
        }

        Builder(MessageClass messageClass, MessageCategory messageCategory, MessageType messageType, String serviceID) {
            this.messageClass = messageClass;
            this.messageCategory = messageCategory;
            this.messageType = messageType;
            this.serviceID = serviceID;
        }

        Builder(String protocolVersion, MessageClass messageClass, MessageCategory messageCategory, MessageType messageType, String serviceID, String saleID, String POIID, String deviceID) {
            this.protocolVersion = protocolVersion;
            this.messageClass = messageClass;
            this.messageCategory = messageCategory;
            this.messageType = messageType;
            this.serviceID = serviceID;
            this.saleID = saleID;
            this.POIID = POIID;
            this.deviceID = deviceID;
        }

        public Builder messageClass(MessageClass messageClass) {
            this.messageClass = messageClass;
            return Builder.this;
        }

        public Builder messageCategory(MessageCategory messageCategory) {
            this.messageCategory = messageCategory;
            return Builder.this;
        }

        public Builder messageType(MessageType messageType) {
            this.messageType = messageType;
            return Builder.this;
        }

        public Builder serviceID(String serviceID) {
            this.serviceID = serviceID;
            return Builder.this;
        }

        public Builder protocolVersion(String protocolVersion) {
            this.protocolVersion = protocolVersion;
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
        
        public Builder deviceID(String deviceID) {
            this.deviceID = deviceID;
            return Builder.this;
        }

        public MessageHeader build() {
            if (this.messageClass == null) {
                throw new NullPointerException("The property \"messageClass\" is null. "
                        + "Please set the value by \"messageClass()\". "
                        + "The properties \"messageClass\", \"messageCategory\", \"messageType\" and \"serviceID\" are required.");
            }
            if (this.messageCategory == null) {
                throw new NullPointerException("The property \"messageCategory\" is null. "
                        + "Please set the value by \"messageCategory()\". "
                        + "The properties \"messageClass\", \"messageCategory\", \"messageType\" and \"serviceID\" are required.");
            }
            if (this.messageType == null) {
                throw new NullPointerException("The property \"messageType\" is null. "
                        + "Please set the value by \"messageType()\". "
                        + "The properties \"messageClass\", \"messageCategory\", \"messageType\" and \"serviceID\" are required.");
            }
            if (this.serviceID == null) {
                throw new NullPointerException("The property \"serviceID\" is null. "
                        + "Please set the value by \"serviceID()\". "
                        + "The properties \"messageClass\", \"messageCategory\", \"messageType\" and \"serviceID\" are required.");
            }

            // todo need to write logic to check for different fields depending on the request type.

            return new MessageHeader(this);
        }
    }

    private MessageHeader(Builder builder) {
        this.messageClass = builder.messageClass;
        this.messageCategory = builder.messageCategory;
        this.messageType = builder.messageType;
        this.serviceID = builder.serviceID;
        this.protocolVersion = builder.protocolVersion;
        this.saleID = builder.saleID;
        this.POIID = builder.POIID;
        this.deviceID = builder.deviceID;
    }
}


/*
@Required MessageClass messageClass
@Required String messageCategory
@Required MessageType messageType
@Required String serviceID
* */