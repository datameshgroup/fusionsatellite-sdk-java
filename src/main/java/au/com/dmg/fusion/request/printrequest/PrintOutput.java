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

package au.com.dmg.fusion.request.printrequest;

import java.util.ArrayList;
import java.util.List;

public class PrintOutput {

    private final String documentQualifier;
    private final Boolean integratedPrintFlag;
    private final Boolean requiredSignatureFlag;
    private final List<OutputContent> outputContent;

    public static class Builder {

        private String documentQualifier;
        private Boolean integratedPrintFlag;
        private Boolean requiredSignatureFlag;
        private List<OutputContent> outputContent = new ArrayList<>();

        public Builder() {
        }

        Builder(String documentQualifier, Boolean integratedPrintFlag, Boolean requiredSignatureFlag, List<OutputContent> outputContent) {
            this.documentQualifier = documentQualifier;
            this.integratedPrintFlag = integratedPrintFlag;
            this.requiredSignatureFlag = requiredSignatureFlag;
            this.outputContent = outputContent;
        }

        public Builder documentQualifier(String documentQualifier) {
            this.documentQualifier = documentQualifier;
            return Builder.this;
        }

        public Builder integratedPrintFlag(Boolean integratedPrintFlag) {
            this.integratedPrintFlag = integratedPrintFlag;
            return Builder.this;
        }

        public Builder requiredSignatureFlag(Boolean requiredSignatureFlag) {
            this.requiredSignatureFlag = requiredSignatureFlag;
            return Builder.this;
        }

        public Builder outputContent(List<OutputContent> outputContent) {
            this.outputContent = outputContent;
            return Builder.this;
        }

        public Builder addOutputContent(OutputContent outputContent) {
            this.outputContent.add(outputContent);
            return Builder.this;
        }

        public PrintOutput build() {
            if (this.documentQualifier == null) {
                throw new NullPointerException("The property \"documentQualifier\" is null. "
                        + "Please set the value by \"documentQualifier()\". "
                        + "The properties \"documentQualifier\", \"requiredSignatureFlag\" are required.");
            }
            if (this.requiredSignatureFlag == null) {
                throw new NullPointerException("The property \"requiredSignatureFlag\" is null. "
                        + "Please set the value by \"requiredSignatureFlag()\". "
                        + "The properties \"documentQualifier\", \"requiredSignatureFlag\" are required.");
            }

            return new PrintOutput(this);
        }
    }

    private PrintOutput(Builder builder) {
        this.documentQualifier = builder.documentQualifier;
        this.integratedPrintFlag = builder.integratedPrintFlag;
        this.requiredSignatureFlag = builder.requiredSignatureFlag;
        this.outputContent = builder.outputContent;
    }
}


/*
package au.com.dmg.fusionsatellite.PaymentRequest
class PrintOutput
@Required String documentQualifier
Boolean integratedPrintFlag
@Required Boolean requiredSignatureFlag
List<OutputContent> outputContent
 */
