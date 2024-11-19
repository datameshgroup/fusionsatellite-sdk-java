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

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.NotNull;

import au.com.dmg.fusion.util.BigDecimalAdapter;
import au.com.dmg.fusion.util.InstantAdapter;

public class LoginResponse implements ResponseType {

    @Json(name = "Response")
    private final Response response;
    @Json(name = "POISystemData")
    private final POISystemData poiSystemData;

    @NotNull
    public Response getResponse() {
        return response;
    }

    @NotNull
    public POISystemData getPoiSystemData() {
        return poiSystemData;
    }

    public static class Builder {

        private Response response;
        private POISystemData poiSystemData;

        public Builder() {
        }

        Builder(Response response, POISystemData poiSystemData) {
            this.response = response;
            this.poiSystemData = poiSystemData;
        }

        public Builder response(Response response) {
            this.response = response;
            return Builder.this;
        }

        public Builder POISystemData(POISystemData poiSystemData) {
            this.poiSystemData = poiSystemData;
            return Builder.this;
        }

        public LoginResponse build() {
            if (this.response == null) {
                throw new NullPointerException("The property \"response\" is null. "
                        + "Please set the value by \"response()\". "
                        + "The property \"response\" is required.");
            }

            return new LoginResponse(this);
        }
    }

    private LoginResponse(Builder builder) {
        this.response = builder.response;
        this.poiSystemData = builder.poiSystemData;
    }

    @Override
    public String toJson() {
        Moshi moshi = new Moshi.Builder()
                .add(new BigDecimalAdapter())
                .add(new InstantAdapter())
                .build();
        JsonAdapter<LoginResponse> jsonAdapter = moshi.adapter(LoginResponse.class);
        return jsonAdapter.toJson(this);
    }
}


/*
package au.com.dmg.fusionsatellite.response
class LoginResponse
@Required Response response
POISystemData poiSystemData
* */