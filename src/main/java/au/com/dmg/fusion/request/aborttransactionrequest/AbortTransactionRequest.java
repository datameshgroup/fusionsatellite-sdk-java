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

package au.com.dmg.fusion.request.aborttransactionrequest;

import au.com.dmg.fusion.util.BigDecimalAdapter;
import au.com.dmg.fusion.request.Request;
import au.com.dmg.fusion.request.transactionstatusrequest.MessageReference;
import au.com.dmg.fusion.util.InstantAdapter;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.jetbrains.annotations.NotNull;

public class AbortTransactionRequest implements Request {

    @Json(name = "MessageReference")
    private final MessageReference messageReference;
    @Json(name = "AbortReason")
    private final String abortReason;

    @NotNull
    public MessageReference getMessageReference() {
        return messageReference;
    }

    @NotNull
    public String getAbortReason() {
        return abortReason;
    }

    public AbortTransactionRequest(MessageReference messageReference, String abortReason) {
        if (messageReference == null) {
            throw new NullPointerException("message reference cannot be null");
        }
        if (messageReference.getMessageCategory() == null) {
            throw new NullPointerException("message reference missing message category.");
        }
        if (messageReference.getServiceID() == null) {
            throw new NullPointerException("message reference missing message category.");
        }
        if (abortReason == null) {
            abortReason = "";
        }
        this.messageReference = messageReference;
        this.abortReason = abortReason;
    }

    @Override
    public String toJson() {
        Moshi moshi = new Moshi.Builder()
                .add(new BigDecimalAdapter())
                .add(new InstantAdapter())
                .build();
        JsonAdapter<AbortTransactionRequest> jsonAdapter = moshi.adapter(AbortTransactionRequest.class);
        return jsonAdapter.toJson(this);
    }
}
