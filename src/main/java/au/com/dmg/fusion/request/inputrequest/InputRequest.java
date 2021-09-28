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

import au.com.dmg.fusion.util.BigDecimalAdapter;
import au.com.dmg.fusion.request.Request;
import au.com.dmg.fusion.request.displayrequest.DisplayOutput;
import au.com.dmg.fusion.util.InstantAdapter;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class InputRequest implements Request {

    @Json(name = "DisplayOutput")
    private final DisplayOutput displayOutput;
    @Json(name = "MenuEntry")
    private final MenuEntry menuEntry;
    @Json(name = "InputData")
    private final InputData inputData;

    @Nullable
    public DisplayOutput getDisplayOutput() {
        return displayOutput;
    }

    @Nullable
    public MenuEntry getMenuEntry() {
        return menuEntry;
    }

    @NotNull
    public InputData getInputData() {
        return inputData;
    }

    public static class Builder {

        @Json(name = "DisplayOutput")
        private DisplayOutput displayOutput;
        @Json(name = "MenuEntry")
        private MenuEntry menuEntry;
        @Json(name = "InputData")
        private InputData inputData;

        public DisplayOutput getDisplayOutput() {
            return displayOutput;
        }

        public MenuEntry getMenuEntry() {
            return menuEntry;
        }

        public InputData getInputData() {
            return inputData;
        }

        public Builder() {
        }

        Builder(DisplayOutput displayOutput, MenuEntry menuEntry, InputData inputData) {
            this.displayOutput = displayOutput;
            this.menuEntry = menuEntry;
            this.inputData = inputData;
        }

        public Builder displayOutput(DisplayOutput displayOutput) {
            this.displayOutput = displayOutput;
            return Builder.this;
        }

        public Builder menuEntry(MenuEntry menuEntry) {
            this.menuEntry = menuEntry;
            return Builder.this;
        }

        public Builder inputData(InputData inputData) {
            this.inputData = inputData;
            return Builder.this;
        }

        public InputRequest build() {
            if (this.inputData == null) {
                throw new NullPointerException("The property \"inputData\" is null. "
                        + "Please set the value by \"inputData()\". "
                        + "The property \"inputData\" is required.");
            }

            return new InputRequest(this);
        }
    }

    private InputRequest(Builder builder) {
        this.displayOutput = builder.displayOutput;
        this.menuEntry = builder.menuEntry;
        this.inputData = builder.inputData;
    }

    @Override
    public String toJson() {
        Moshi moshi = new Moshi.Builder()
                .add(new BigDecimalAdapter())
                .add(new InstantAdapter())
                .build();
        JsonAdapter<InputRequest> jsonAdapter = moshi.adapter(InputRequest.class);
        return jsonAdapter.toJson(this);
    }
}


/*
package au.com.dmg.fusionsatellite.request.inputrequest
class InputRequest
DisplayOutput displayOutput
MenuEntry menuEntry
@Required InputData inputData
* */
