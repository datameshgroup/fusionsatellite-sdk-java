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

import au.com.dmg.fusion.data.ErrorCondition;
import com.squareup.moshi.Json;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Response {
    @Json(name = "Result")
    private final ResponseResult result;
    @Json(name = "ErrorCondition")
    private final ErrorCondition errorCondition;
    @Json(name = "AdditionalResponse")
    private final String additionalResponse;

    public ResponseResult getResult() {
        return result;
    }

    public ErrorCondition getErrorCondition() {
        return errorCondition;
    }

    public String getAdditionalResponse() {
        return additionalResponse;
    }

    public static class Builder {

        @Json(name = "Result")
        private ResponseResult result;
        @Json(name = "ErrorCondition")
        private ErrorCondition errorCondition;
        @Json(name = "AdditionalResponse")
        private String additionalResponse;

        @NotNull
        public ResponseResult getResult() {
            return result;
        }

        @Nullable
        public ErrorCondition getErrorCondition() {
            return errorCondition;
        }

        @Nullable
        public String getAdditionalResponse() {
            return additionalResponse;
        }

        public Builder() {
        }

        Builder(ResponseResult result, ErrorCondition errorCondition, String additionalResponse) {
            this.result = result;
            this.errorCondition = errorCondition;
            this.additionalResponse = additionalResponse;
        }

        public Builder result(ResponseResult Result) {
            this.result = Result;
            return Builder.this;
        }

        public Builder errorCondition(ErrorCondition errorCondition) {
            this.errorCondition = errorCondition;
            return Builder.this;
        }

        public Builder additionalResponse(String additionalResponse) {
            this.additionalResponse = additionalResponse;
            return Builder.this;
        }

        public Response build() {
            if (this.result == null) {
                throw new NullPointerException("The property \"Result\" is null. "
                        + "Please set the value by \"Result()\". "
                        + "The property \"Result\" is required.");
            }

            return new Response(this);
        }
    }

    private Response(Builder builder) {
        this.result = builder.result;
        this.errorCondition = builder.errorCondition;
        this.additionalResponse = builder.additionalResponse;
    }
}

/*
package au.com.dmg.fusionsatellite.PaymentResponse
class Response
@Required ResponseResult result
ErrorCondition errorCondition
String additionalResponse
* */
