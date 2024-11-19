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

package au.com.dmg.fusion.response.inputresponse;

import au.com.dmg.fusion.response.OutputResult;
import au.com.dmg.fusion.response.ResponseType;
import au.com.dmg.fusion.response.TransactionStatusResponse;
import au.com.dmg.fusion.util.BigDecimalAdapter;
import au.com.dmg.fusion.util.InstantAdapter;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

public class InputResponse implements ResponseType {

    @Json(name = "OutputResult")
    private final OutputResult outputResult;
    @Json(name = "InputResult")
    private final InputResult inputResult;

    public OutputResult getOutputResult() {
        return outputResult;
    }

    public InputResult getInputResult() {
        return inputResult;
    }

    public static class Builder {

        private OutputResult outputResult;
        private InputResult inputResult;

        public Builder() {
        }

        Builder(OutputResult outputResult, InputResult inputResult) {
            this.outputResult = outputResult;
            this.inputResult = inputResult;
        }

        public Builder outputResult(OutputResult outputResult) {
            this.outputResult = outputResult;
            return Builder.this;
        }

        public Builder inputResult(InputResult inputResult) {
            this.inputResult = inputResult;
            return Builder.this;
        }

        public InputResponse build() {
            if (this.inputResult == null) {
                throw new NullPointerException("The property \"inputResult\" is null. "
                        + "Please set the value by \"inputResult()\". "
                        + "The property \"inputResult\" is required.");
            }

            return new InputResponse(this);
        }
    }

    private InputResponse(Builder builder) {
        this.outputResult = builder.outputResult;
        this.inputResult = builder.inputResult;
    }

    @Override
    public String toJson() {
        Moshi moshi = new Moshi.Builder()
                .add(new BigDecimalAdapter())
                .add(new InstantAdapter())
                .build();
        JsonAdapter<InputResponse> jsonAdapter = moshi.adapter(InputResponse.class);
        return jsonAdapter.toJson(this);
    }
}


/*
package com.example
class InputResponse
OutputResult outputResult
@Required InputResult inputResult
* */