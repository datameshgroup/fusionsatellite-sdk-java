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

import com.squareup.moshi.Json;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Safelist;

import java.nio.charset.StandardCharsets;

import au.com.dmg.fusion.data.DocumentQualifier;
import au.com.dmg.fusion.data.ResponseMode;
import au.com.dmg.fusion.util.Base64;

public class PrintOutput {

    @Json(name = "DocumentQualifier")
    private final DocumentQualifier documentQualifier;

    @Json(name = "ResponseMode")
    private final ResponseMode responseMode;

    @Json(name = "IntegratedPrintFlag")
    private final Boolean integratedPrintFlag;

    @Json(name = "RequiredSignatureFlag")
    private final Boolean requiredSignatureFlag;

    @Json(name = "OutputContent")
    private final OutputContent outputContent;

    @NotNull
    public DocumentQualifier getDocumentQualifier() {
        return documentQualifier;
    }

    @Nullable
    public ResponseMode getResponseMode() {
        return responseMode;
    }

    @Nullable
    public Boolean getIntegratedPrintFlag() {
        return integratedPrintFlag;
    }

    @NotNull
    public Boolean getRequiredSignatureFlag() {
        return requiredSignatureFlag;
    }

    @Nullable
    public OutputContent getOutputContent() {
        return outputContent;
    }

    public static class Builder {

        private DocumentQualifier documentQualifier;
        private ResponseMode responseMode;
        private Boolean integratedPrintFlag;
        private Boolean requiredSignatureFlag;
        private OutputContent outputContent;

        public Builder() {
        }

        Builder(DocumentQualifier documentQualifier, Boolean integratedPrintFlag, Boolean requiredSignatureFlag, OutputContent outputContent) {
            this.documentQualifier = documentQualifier;
            this.integratedPrintFlag = integratedPrintFlag;
            this.requiredSignatureFlag = requiredSignatureFlag;
            this.outputContent = outputContent;
        }

        Builder(DocumentQualifier documentQualifier, Boolean integratedPrintFlag, Boolean requiredSignatureFlag, OutputContent outputContent, ResponseMode responseMode) {
            this.documentQualifier = documentQualifier;
            this.integratedPrintFlag = integratedPrintFlag;
            this.requiredSignatureFlag = requiredSignatureFlag;
            this.outputContent = outputContent;
            this.responseMode = responseMode;
        }

        public Builder documentQualifier(DocumentQualifier documentQualifier){
            this.documentQualifier = documentQualifier;
            return Builder.this;
        }

        public Builder responseMode(ResponseMode responseMode){
            this.responseMode = responseMode;
            return Builder.this;
        }

        public Builder integratedPrintFlag(Boolean integratedPrintFlag){
            this.integratedPrintFlag = integratedPrintFlag;
            return Builder.this;
        }

        public Builder requiredSignatureFlag(Boolean requiredSignatureFlag){
            this.requiredSignatureFlag = requiredSignatureFlag;
            return Builder.this;
        }

        public Builder outputContent(OutputContent outputContent){
            this.outputContent = outputContent;
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

    private String base64Decode(String input){
        byte[] decoded = Base64.decode(input);
        return new String(decoded, StandardCharsets.UTF_8);
    }

    public String getReceiptContentAsString(){
        if(this.outputContent == null || this.outputContent.getOutputXHTML() == null){
            return null;
        }
        String content = base64Decode(this.outputContent.getOutputXHTML());

        Document.OutputSettings outputSettings = new Document.OutputSettings();
        outputSettings.prettyPrint(false);

        return Jsoup.clean(content, "", Safelist.none(), outputSettings).trim();
    }

    public String getReceiptContentAsHtml(){
        if(this.outputContent == null || this.outputContent.getOutputXHTML() == null){
            return null;
        }
        return base64Decode(this.outputContent.getOutputXHTML());
    }

    private PrintOutput(Builder builder) {
        this.documentQualifier = builder.documentQualifier;
        this.integratedPrintFlag = builder.integratedPrintFlag;
        this.requiredSignatureFlag = builder.requiredSignatureFlag;
        this.outputContent = builder.outputContent;
        this.responseMode = builder.responseMode;
    }
}


/*
package au.com.dmg.fusionsatellite.PaymentRequest
class PrintOutput
@Required DocumentQualifier documentQualifier
ResponseMode responseMode
Boolean integratedPrintFlag
@Required Boolean requiredSignatureFlag
OutputContent outputContent
 */
