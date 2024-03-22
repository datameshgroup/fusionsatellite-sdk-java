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

import au.com.dmg.fusion.data.InputCommand;
import au.com.dmg.fusion.response.OutputResult;
import au.com.dmg.fusion.response.Response;
import au.com.dmg.fusion.response.ResponseResult;
import com.squareup.moshi.Json;

public class InputResult {
    @Json(name = "Device")
    private final String device;
    @Json(name = "InfoQualify")
    private final String infoQualify;
    @Json(name = "Response")
    private final Response response;
    @Json(name = "Input")
    private final Input input;

    public String getDevice() {
        return device;
    }

    public String getInfoQualify() {
        return infoQualify;
    }

    public Response getResponse() {
        return response;
    }

    public Input getInput() {return input; }

    public static class Builder {

        private String device;
        private String infoQualify;
        private Response response;
        private Input input;

        public Builder() {
        }

        Builder(String device, String infoQualify, Response response, Input input) {
            this.device = device;
            this.infoQualify = infoQualify;
            this.response = response;
            this.input = input;
        }

        public Builder device(String device) {
            this.device = device;
            return Builder.this;
        }

        public Builder infoQualify(String infoQualify) {
            this.infoQualify = infoQualify;
            return Builder.this;
        }

        public Builder response(Response response) {
            this.response = response;
            return Builder.this;
        }

        public Builder input(Input input) {
            this.input = input;
            return Builder.this;
        }

        public InputResult build() {
            if (this.device == null) {
                throw new NullPointerException("The property \"device\" is null. "
                        + "Please set the value by \"device()\". "
                        + "The property \"device\" is required.");
            }
            if (this.infoQualify == null) {
                throw new NullPointerException("The property \"infoQualify\" is null. "
                        + "Please set the value by \"infoQualify()\". "
                        + "The property \"infoQualify\" is required.");
            }
            if (this.response == null) {
                throw new NullPointerException("The property \"response\" is null. "
                        + "Please set the value by \"response()\". "
                        + "The property \"response\" is required.");
            }
            if ((this.input == null) && (this.response.getResult() != ResponseResult.Failure)) {
                throw new NullPointerException("The property \"input\" is null. "
                        + "Please set the value by \"input()\". "
                        + "The property \"input\" is required when result is not failure.");
            }

            return new InputResult(this);
        }
    }

    private InputResult(Builder builder) {
        this.device = builder.device;
        this.infoQualify = builder.infoQualify;
        this.response = builder.response;
        this.input = builder.input;
    }
}

/*
package au.com.dmg.fusionsatellite.response.inputresponse
class InputResult
@Required String device
@Required String infoQualify
@Required Response response
Input input
* */