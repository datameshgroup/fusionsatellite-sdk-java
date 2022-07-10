/*
 * Copyright (c) 2022. DatameshGroup
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

import com.squareup.moshi.Json;
import org.jetbrains.annotations.NotNull;

public class LoyaltyAccount {

    @Json(name = "EntryMode")
    private String entryMode;
    @Json(name = "IdentificationType")
    private String identificationType;
    @Json(name = "IdentificationSupport")
    private String identificationSupport;
    @Json(name = "LoyaltyID")
    private String loyaltyID;
    @Json(name = "LoyaltyBrand")
    private String loyaltyBrand;

    @NotNull
    public String getEntryMode() {
        return entryMode;
    }

    @NotNull
    public String getIdentificationType() {
        return identificationType;
    }

    @NotNull
    public String getIdentificationSupport() {
        return identificationSupport;
    }

    @NotNull
    public String getLoyaltyID() {
        return loyaltyID;
    }

    @NotNull
    public String getLoyaltyBrand() {
        return loyaltyBrand;
    }

    public static class Builder {

        private String entryMode;
        private String identificationType;
        private String identificationSupport;
        private String loyaltyID;
        private String loyaltyBrand;

        public Builder() {
        }

        Builder(String entryMode, String identificationType, String identificationSupport, String loyaltyID, String loyaltyBrand) {
            this.entryMode = entryMode;
            this.identificationSupport = identificationSupport;
            this.loyaltyID = loyaltyID;
            this.loyaltyBrand = loyaltyBrand;
        }

        public Builder entryMode(String entryMode){
            this.entryMode = entryMode;
            return Builder.this;
        }

        public Builder identificationType(String identificationType){
            this.identificationType = identificationType;
            return Builder.this;
        }

        public Builder identificationSupport(String identificationSupport){
            this.identificationSupport = identificationSupport;
            return Builder.this;
        }

        public Builder loyaltyID(String loyaltyID){
            this.loyaltyID = loyaltyID;
            return Builder.this;
        }

        public Builder loyaltyBrand(String loyaltyBrand){
            this.loyaltyBrand = loyaltyBrand;
            return Builder.this;
        }

        public LoyaltyAccount build() {
            if (this.entryMode == null) {
                throw new NullPointerException("The property \"entryMode\" is null. "
                        + "Please set the value by \"entryMode()\""
                );
            }
            if (this.identificationType == null) {
                throw new NullPointerException("The property \"identificationType\" is null. "
                        + "Please set the value by \"identificationType()\""
                );
            }
            if (this.identificationSupport == null) {
                throw new NullPointerException("The property \"identificationSupport\" is null. "
                        + "Please set the value by \"identificationSupport()\""
                );
            }
            if (this.loyaltyID == null) {
                throw new NullPointerException("The property \"loyaltyID\" is null. "
                        + "Please set the value by \"loyaltyID()\""
                );
            }
            if (this.loyaltyBrand == null) {
                throw new NullPointerException("The property \"loyaltyBrand\" is null. "
                        + "Please set the value by \"loyaltyBrand()\""
                );
            }
            return new LoyaltyAccount(this);
        }
    }

    private LoyaltyAccount(Builder builder) {
        this.entryMode = builder.entryMode;
        this.identificationType = builder.identificationType;
        this.identificationSupport = builder.identificationSupport;
        this.loyaltyID = builder.loyaltyID;
        this.loyaltyBrand = builder.loyaltyBrand;
    }
}

/*
package au.com.dmg.fusion.response.paymentresponse
class LoyaltyAccount
String entryMode
String identificationType
String identificationSupport
String loyaltyID
String loyaltyBrand
* */
