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

package au.com.dmg.fusion.request.inputrequest;

import au.com.dmg.fusion.data.InfoQualify;
import au.com.dmg.fusion.data.InputCommand;
import com.squareup.moshi.Json;

public class InputData {

    @Json(name = "Device")
    private final String device;
    @Json(name = "InfoQuality")
    private final InfoQualify infoQuality;
    @Json(name = "InputCommand")
    private final InputCommand inputCommand;
    @Json(name = "MaxInputTime")
    private final Integer maxInputTime;
    @Json(name = "MinLength")
    private final Integer minLength;
    @Json(name = "MaxLength")
    private final Integer maxLength;
    @Json(name = "MaskCharactersFlag")
    private final Boolean maskCharactersFlag;

    public static class Builder {

        private String device;
        private InfoQualify infoQuality;
        private InputCommand inputCommand;
        private Integer maxInputTime;
        private Integer minLength;
        private Integer maxLength;
        private Boolean maskCharactersFlag;

        public Builder() {
        }

        Builder(String device, InfoQualify infoQuality, InputCommand inputCommand, Integer maxInputTime, Integer minLength, Integer maxLength, Boolean maskCharactersFlag) {
            this.device = device;
            this.infoQuality = infoQuality;
            this.inputCommand = inputCommand;
            this.maxInputTime = maxInputTime;
            this.minLength = minLength;
            this.maxLength = maxLength;
            this.maskCharactersFlag = maskCharactersFlag;
        }

        public Builder device(String device) {
            this.device = device;
            return Builder.this;
        }

        public Builder infoQuality(InfoQualify infoQuality) {
            this.infoQuality = infoQuality;
            return Builder.this;
        }

        public Builder inputCommand(InputCommand inputCommand) {
            this.inputCommand = inputCommand;
            return Builder.this;
        }

        public Builder maxInputTime(Integer maxInputTime) {
            this.maxInputTime = maxInputTime;
            return Builder.this;
        }

        public Builder minLength(Integer minLength) {
            this.minLength = minLength;
            return Builder.this;
        }

        public Builder maxLength(Integer maxLength) {
            this.maxLength = maxLength;
            return Builder.this;
        }

        public Builder maskCharactersFlag(Boolean maskCharactersFlag) {
            this.maskCharactersFlag = maskCharactersFlag;
            return Builder.this;
        }

        public InputData build() {
            if (this.device == null) {
                throw new NullPointerException("The property \"device\" is null. "
                        + "Please set the value by \"device()\". "
                        + "The properties \"device\", \"infoQuality\" and \"inputCommand\" are required.");
            }
            if (this.infoQuality == null) {
                throw new NullPointerException("The property \"infoQuality\" is null. "
                        + "Please set the value by \"infoQuality()\". "
                        + "The properties \"device\", \"infoQuality\" and \"inputCommand\" are required.");
            }
            if (this.inputCommand == null) {
                throw new NullPointerException("The property \"inputCommand\" is null. "
                        + "Please set the value by \"inputCommand()\". "
                        + "The properties \"device\", \"infoQuality\" and \"inputCommand\" are required.");
            }

            return new InputData(this);
        }
    }

    private InputData(Builder builder) {
        this.device = builder.device;
        this.infoQuality = builder.infoQuality;
        this.inputCommand = builder.inputCommand;
        this.maxInputTime = builder.maxInputTime;
        this.minLength = builder.minLength;
        this.maxLength = builder.maxLength;
        this.maskCharactersFlag = builder.maskCharactersFlag;
    }
}


/*
package au.com.dmg.fusionsatellite.request.inputrequest
class InputData
@Required String device
@Required InfoQualify infoQuality
@Required InputCommand inputCommand
Integer maxInputTime
Integer minLength
Integer maxLength
Boolean maskCharactersFlag
* */