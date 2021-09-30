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

import org.jetbrains.annotations.Nullable;

import com.squareup.moshi.Json;

import au.com.dmg.fusion.data.InfoQualify;

public class OutputResult {
    @Json(name = "Device")
    private final String device;
    @Json(name = "InfoQualify")
    private final InfoQualify infoQualify;
    @Json(name = "Result")
    private final String result;
    @Json(name = "ErrorCondition")
    private final String errorCondition;
    @Json(name = "AdditionalResponse")
    private final String additionalResponse;

    public OutputResult(String device, InfoQualify infoQualify, String result, String errorCondition, String additionalResponse) {
        if (device == null || infoQualify == null || result == null) {
            throw new NullPointerException("Error device, infoQualify and result cannot be null.");
        }

        this.device = device;
        this.infoQualify = infoQualify;
        this.result = result;
        this.errorCondition = errorCondition;
        this.additionalResponse = additionalResponse;
    }

    public String getDevice() {
        return device;
    }

    public InfoQualify getInfoQualify() {
        return infoQualify;
    }

    public String getResult() {
        return result;
    }

    @Nullable
    public String getErrorCondition() {
        return errorCondition;
    }

    @Nullable
    public String getAdditionalResponse() {
        return additionalResponse;
    }
}