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
import com.squareup.moshi.Json;

public class Input {

    @Json(name = "InputCommand")
    private final InputCommand inputCommand;
    @Json(name = "ConfirmedFlag")
    private final Boolean confirmedFlag;
    @Json(name = "FunctionKey")
    private final Integer functionKey;
    @Json(name = "TextInput")
    private final String textInput;
    @Json(name = "DigitInput")
    private final Integer digitInput;
    @Json(name = "MenuEntryNumber")
    private final Integer menuEntryNumber;

    public InputCommand getInputCommand() {
        return inputCommand;
    }
    public Boolean getConfirmedFlag() {
        return confirmedFlag;
    }
    public Integer getFunctionKey() {
        return functionKey;
    }
    public String getTextInput() {
        return textInput;
    }
    public Integer getDigitInput() {
        return digitInput;
    }
    public Integer getMenuEntryNumber() {
        return menuEntryNumber;
    }

    public static class Builder {
        private InputCommand inputCommand;
        private Boolean confirmedFlag;
        private Integer functionKey;
        private String textInput;
        private Integer digitInput;
        private Integer menuEntryNumber;

        public Builder() {
        }

        Builder(InputCommand inputCommand, Boolean confirmedFlag, Integer functionKey, String textInput, Integer digitInput, Integer menuEntryNumber) {
            this.inputCommand = inputCommand;
            this.confirmedFlag = confirmedFlag;
            this.functionKey = functionKey;
            this.textInput = textInput;
            this.digitInput = digitInput;
            this.menuEntryNumber = menuEntryNumber;
        }

        public Builder inputCommand(InputCommand inputCommand) {
            this.inputCommand = inputCommand;
            return Builder.this;
        }

        public Builder confirmedFlag(Boolean confirmedFlag) {
            this.confirmedFlag = confirmedFlag;
            return Builder.this;
        }

        public Builder functionKey(Integer functionKey) {
            this.functionKey = functionKey;
            return Builder.this;
        }

        public Builder textInput(String textInput) {
            this.textInput = textInput;
            return Builder.this;
        }

        public Builder digitInput(Integer digitInput) {
            this.digitInput = digitInput;
            return Builder.this;
        }

        public Builder menuEntryNumber(Integer menuEntryNumber) {
            this.menuEntryNumber = menuEntryNumber;
            return Builder.this;
        }

        public Input build() {
            if (this.inputCommand == null) {
                throw new NullPointerException("The property \"inputCommand\" is null. "
                        + "Please set the value by \"inputCommand()\". "
                        + "The property \"inputCommand\" is required.");
            }
            if((this.inputCommand == InputCommand.GetConfirmation) && (this.confirmedFlag == null)){
                throw new NullPointerException("The property \"confirmedFlag\" is null. "
                        + "Please set the value by \"confirmedFlag()\". "
                        + "The property \"confirmedFlag\" is required for inputCommand=\"GetConfirmation\".");
            }
            if((this.inputCommand == InputCommand.TextString) && (this.textInput == null)){
                throw new NullPointerException("The property \"textInput\" is null. "
                        + "Please set the value by \"textInput()\". "
                        + "The property \"textInput\" is required for inputCommand=\"TextString\".");
            }
            if((this.inputCommand == InputCommand.DigitString) && (this.digitInput == null)){
                throw new NullPointerException("The property \"digitInput\" is null. "
                        + "Please set the value by \"digitInput()\". "
                        + "The property \"digitInput\" is required for inputCommand=\"DigitString\".");
            }
            if((this.inputCommand == InputCommand.GetMenuEntry) && (this.menuEntryNumber == null)){
                throw new NullPointerException("The property \"menuEntryNumber\" is null. "
                        + "Please set the value by \"menuEntryNumber()\". "
                        + "The property \"menuEntryNumber\" is required for inputCommand=\"GetMenuEntry\".");
            }

            return new Input(this);
        }
    }

    private Input(Builder builder) {
        this.inputCommand = builder.inputCommand;
        this.confirmedFlag = builder.confirmedFlag;
        this.functionKey = builder.functionKey;
        this.textInput = builder.textInput;
        this.digitInput = builder.digitInput;
        this.menuEntryNumber = builder.menuEntryNumber;
    }
}


/*
package au.com.dmg.fusionsatellite.response.inputresponse
class Input
@Required InputCommand inputCommand
InputCommand inputCommand
Boolean confirmedFlag
Integer functionKey
String textInput
Integer digitInput
Integer menuEntryNumber
* */