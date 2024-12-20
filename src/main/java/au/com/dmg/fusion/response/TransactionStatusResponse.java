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

import au.com.dmg.fusion.request.transactionstatusrequest.MessageReference;
import au.com.dmg.fusion.util.BigDecimalAdapter;
import au.com.dmg.fusion.util.InstantAdapter;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

public class TransactionStatusResponse implements ResponseType {
    @Json(name = "Response")
    private Response response;
    @Json(name = "MessageReference")
    private MessageReference messageReference;
    @Json(name = "RepeatedMessageResponse")
    private RepeatedMessageResponse repeatedMessageResponse;

    public Response getResponse() {
        return response;
    }

    public MessageReference getMessageReference() {
        return messageReference;
    }

    public RepeatedMessageResponse getRepeatedMessageResponse() {
        return repeatedMessageResponse;
    }

    public static class Builder {

        private Response response;
        private MessageReference messageReference;
        private RepeatedMessageResponse repeatedMessageResponse;

        public Builder() {
        }

        Builder(Response response, MessageReference messageReference, RepeatedMessageResponse repeatedMessageResponse) {
            this.response = response;
            this.messageReference = messageReference;
            this.repeatedMessageResponse = repeatedMessageResponse;
        }

        public Builder response(Response response) {
            this.response = response;
            return Builder.this;
        }

        public Builder messageReference(MessageReference messageReference) {
            this.messageReference = messageReference;
            return Builder.this;
        }

        public Builder repeatedMessageResponse(RepeatedMessageResponse repeatedMessageResponse) {
            this.repeatedMessageResponse = repeatedMessageResponse;
            return Builder.this;
        }

        public TransactionStatusResponse build() {
            if (this.response == null) {
                throw new NullPointerException("The property \"response\" is null. "
                        + "Please set the value by \"response()\". "
                        + "The property \"response\" is required.");
            }

            return new TransactionStatusResponse(this);
        }
    }

    private TransactionStatusResponse(Builder builder) {
        this.response = builder.response;
        this.messageReference = builder.messageReference;
        this.repeatedMessageResponse = builder.repeatedMessageResponse;
    }

    @Override
    public String toJson() {
        Moshi moshi = new Moshi.Builder()
                .add(new BigDecimalAdapter())
                .add(new InstantAdapter())
                .build();
        JsonAdapter<TransactionStatusResponse> jsonAdapter = moshi.adapter(TransactionStatusResponse.class);
        return jsonAdapter.toJson(this);
    }
}


/*
package com.example
class TransactionStatusResponse
@Required Response response
MessageReference messageReference
RepeatedMessageResponse repeatedMessageResponse
* */