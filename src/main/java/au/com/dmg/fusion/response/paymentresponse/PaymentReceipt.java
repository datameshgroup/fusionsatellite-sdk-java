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

package au.com.dmg.fusion.response.paymentresponse;

import au.com.dmg.fusion.request.printrequest.OutputContent;
import au.com.dmg.fusion.util.Base64;
import com.squareup.moshi.Json;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

import java.nio.charset.StandardCharsets;


public class PaymentReceipt {

    @Json(name = "DocumentQualifier")
    private String documentQualifier;
    @Json(name = "IntegratedPrintFlag")
    private Boolean integratedPrintFlag;
    @Json(name = "RequiredSignatureFlag")
    private Boolean requiredSignatureFlag;
    @Json(name = "OutputContent")
    private OutputContent outputContent;

    @NotNull
    public String getDocumentQualifier() {
        return documentQualifier;
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

        private String documentQualifier;
        private Boolean integratedPrintFlag;
        private Boolean requiredSignatureFlag;
        private OutputContent outputContent;

        public Builder() {
        }

        Builder(String documentQualifier, Boolean integratedPrintFlag, Boolean requiredSignatureFlag, OutputContent outputContent) {
            this.documentQualifier = documentQualifier;
            this.integratedPrintFlag = integratedPrintFlag;
            this.requiredSignatureFlag = requiredSignatureFlag;
            this.outputContent = outputContent;
        }

        public Builder documentQualifier(String documentQualifier){
            this.documentQualifier = documentQualifier;
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

        public PaymentReceipt build() {
            if(this.documentQualifier == null){
                throw new NullPointerException("The property \"documentQualifier\" is null. "
                        + "Please set the value by \"documentQualifier()\". "
                        + "The properties \"documentQualifier\", \"requiredSignatureFlag\" are required.");
            }
            if(this.requiredSignatureFlag == null){
                throw new NullPointerException("The property \"requiredSignatureFlag\" is null. "
                        + "Please set the value by \"requiredSignatureFlag()\". "
                        + "The properties \"documentQualifier\", \"requiredSignatureFlag\" are required.");
            }

            return new PaymentReceipt(this);
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

        return Jsoup.clean(content, "", Whitelist.none(), outputSettings).trim();
    }

    public String getReceiptContentAsHtml(){
        if(this.outputContent == null || this.outputContent.getOutputXHTML() == null){
            return null;
        }
        return base64Decode(this.outputContent.getOutputXHTML());
    }

//    public String getReceiptContent2AsString(){
//        if(this.outputContent == null || this.outputContent.getOutputXHTML() == null){
//            return null;
//        }
//        String content = base64Decode(this.outputContent.getOutputXHTML());
//
//        content = content.replace("<br />", "\n").replace("<br/>", "\n");
//        content = content.replace("<p/>", "\n");
//
//        return content;
//    }

    private PaymentReceipt(Builder builder) {
        this.documentQualifier = builder.documentQualifier;
        this.integratedPrintFlag = builder.integratedPrintFlag;
        this.requiredSignatureFlag = builder.requiredSignatureFlag;
        this.outputContent = builder.outputContent;
    }
}

/*
package au.com.dmg.fusionsatellite.response
class PaymentReceipt
@Required String documentQualifier
Boolean integratedPrintFlag
@Required Boolean requiredSignatureFlag
OutputContent outputContent
* */