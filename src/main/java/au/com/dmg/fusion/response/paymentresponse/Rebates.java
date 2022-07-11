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

import java.math.BigDecimal;
import java.util.List;

import org.jetbrains.annotations.Nullable;

import com.squareup.moshi.Json;

public class Rebates {

    @Json(name = "TotalRebate")
    @Nullable
    private BigDecimal totalRebate;

    @Json(name = "RebateLabel")
    private String rebateLabel;

    @Json(name = "SaleItemRebate")
    private List<SaleItemRebate> saleItemRebate;

    public BigDecimal getTotalRebate() {
        return totalRebate;
    }

    public String getRebateLabel() {
        return rebateLabel;
    }

    public List<SaleItemRebate> getSaleItemRebate() {
        return saleItemRebate;
    }

    public static class Builder {
        private BigDecimal totalRebate;
        private String rebateLabel;
        private List<SaleItemRebate> saleItemRebate;

        public Builder() {
        }

        Builder(BigDecimal totalRebate, String rebateLabel, List<SaleItemRebate> saleItemRebate) {
            this.totalRebate = totalRebate;
            this.rebateLabel = rebateLabel;
            this.saleItemRebate = saleItemRebate;
        }

        public Builder totalRebate(BigDecimal totalRebate){
            this.totalRebate = totalRebate;
            return Builder.this;
        }
        
        public Builder rebateLabel(String rebateLabel){
            this.rebateLabel = rebateLabel;
            return Builder.this;
        }

        public Builder saleItemRebate(List<SaleItemRebate> saleItemRebate){
            this.saleItemRebate = saleItemRebate;
            return Builder.this;
        }

        public Rebates build() {
            if(this.saleItemRebate == null){
                throw new NullPointerException("The property \"saleItemRebate\" is null. "
                        + "Please set the value by \"saleItemRebate()\""
                );
            }
            return new Rebates(this);
        }
    }

    private Rebates(Builder builder) {
        this.totalRebate = builder.totalRebate;
        this.rebateLabel = builder.rebateLabel;
        this.saleItemRebate = builder.saleItemRebate;
    }
}

/*
package au.com.dmg.fusionsatellite.PaymentRequest
BigDecimal totalRebate
String rebateLabel
List<SaleItemRebate> saleItemRebate
* */