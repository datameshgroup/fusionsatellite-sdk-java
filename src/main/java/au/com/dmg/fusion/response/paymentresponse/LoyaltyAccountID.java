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

import au.com.dmg.fusion.data.EntryMode;
import au.com.dmg.fusion.data.IdentificationSupport;
import au.com.dmg.fusion.data.IdentificationType;

import org.jetbrains.annotations.NotNull;

public class LoyaltyAccountID {

    @Json(name = "EntryMode")
    private EntryMode entryMode;

    @Json(name = "IdentificationType")
    private IdentificationType identificationType;

    @Json(name = "IdentificationSupport")
    private IdentificationSupport identificationSupport;
    
    @Json(name = "LoyaltyID")
    private String loyaltyID;

    @NotNull
    public EntryMode getEntryMode() {
        return entryMode;
    }

    @NotNull
    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    @NotNull
    public IdentificationSupport getIdentificationSupport() {
        return identificationSupport;
    }

    @NotNull
    public String getLoyaltyID() {
        return loyaltyID;
    }

    public static class Builder {

        private EntryMode entryMode;
        private IdentificationType identificationType;
        private IdentificationSupport identificationSupport;
        private String loyaltyID;

        public Builder() {
        }

        Builder(EntryMode entryMode, IdentificationType identificationType, IdentificationSupport identificationSupport, String loyaltyID) {
            this.entryMode = entryMode;
            this.identificationType = identificationType;
            this.identificationSupport = identificationSupport;
            this.loyaltyID = loyaltyID;
        }

        public Builder entryMode(EntryMode entryMode){
            this.entryMode = entryMode;
            return Builder.this;
        }

        public Builder identificationType(IdentificationType identificationType){
            this.identificationType = identificationType;
            return Builder.this;
        }

        public Builder identificationSupport(IdentificationSupport identificationSupport){
            this.identificationSupport = identificationSupport;
            return Builder.this;
        }

        public Builder loyaltyID(String loyaltyID){
            this.loyaltyID = loyaltyID;
            return Builder.this;
        }

        public LoyaltyAccountID build() {
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
            return new LoyaltyAccountID(this);
        }
    }

    private LoyaltyAccountID(Builder builder) {
        this.entryMode = builder.entryMode;
        this.identificationType = builder.identificationType;
        this.identificationSupport = builder.identificationSupport;
        this.loyaltyID = builder.loyaltyID;
    }
}

/*
package au.com.dmg.fusion.response.paymentresponse
class LoyaltyAccountID
EntryMode entryMode
IdentificationType identificationType
IdentificationSupport identificationSupport
String loyaltyID
* */
