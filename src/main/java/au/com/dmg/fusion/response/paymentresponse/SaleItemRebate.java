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
import com.squareup.moshi.Json;

import au.com.dmg.fusion.data.UnitOfMeasure;

public class SaleItemRebate {

    @Json(name = "ItemID")
    private final Integer itemID;
    @Json(name = "ProductCode")
    private final String productCode;
    @Json(name = "EanUpc")
    private final String eanUpc;
    @Json(name = "UnitOfMeasure")
    private final UnitOfMeasure unitOfMeasure;
    @Json(name = "Quantity")
    private final BigDecimal quantity;
    @Json(name = "ItemAmount")
    private final BigDecimal itemAmount;
    @Json(name = "RebateLabel")
    private final String rebateLabel;

    public Integer getItemID() {
        return itemID;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getEanUpc() {
        return eanUpc;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getItemAmount() {
        return itemAmount;
    }

    public String getRebateLabel() {
        return rebateLabel;
    }

    public static class Builder {
        private Integer itemID;
        private String productCode;
        private String eanUpc;
        private UnitOfMeasure unitOfMeasure;
        private BigDecimal quantity;
        private BigDecimal itemAmount;
        private String rebateLabel;

        public Builder() {
        }

        Builder(Integer itemID, String productCode, String eanUpc, UnitOfMeasure unitOfMeasure, BigDecimal quantity, BigDecimal itemAmount, String rebateLabel) {
            this.itemID = itemID;
            this.productCode = productCode;
            this.eanUpc = eanUpc;
            this.unitOfMeasure = unitOfMeasure;
            this.quantity = quantity;
            this.itemAmount = itemAmount;
            this.rebateLabel = rebateLabel;
        }

        public Builder itemID(Integer itemID){
            this.itemID = itemID;
            return Builder.this;
        }
        
        public Builder productCode(String productCode){
            this.productCode = productCode;
            return Builder.this;
        }

        public Builder eanUpc(String eanUpc){
            this.eanUpc = eanUpc;
            return Builder.this;
        }

        public Builder unitOfMeasure(UnitOfMeasure unitOfMeasure){
            this.unitOfMeasure = unitOfMeasure;
            return Builder.this;
        }

        public Builder quantity(BigDecimal quantity){
            this.quantity = quantity;
            return Builder.this;
        }

        public Builder itemAmount(BigDecimal itemAmount){
            this.itemAmount = itemAmount;
            return Builder.this;
        }

        public Builder rebateLabel(String rebateLabel){
            this.rebateLabel = rebateLabel;
            return Builder.this;
        }

        public SaleItemRebate build() {
            if (this.itemID == null) {
                throw new NullPointerException("The property \"itemID\" is null. "
                        + "Please set the value by \"itemID()\""
                );
            }
            if (this.productCode == null) {
                throw new NullPointerException("The property \"productCode\" is null. "
                        + "Please set the value by \"productCode()\""
                );
            }
            if (this.itemAmount == null) {
                throw new NullPointerException("The property \"itemAmount\" is null. "
                        + "Please set the value by \"itemAmount()\""
                );
            }
            return new SaleItemRebate(this);
        }
    }

    private SaleItemRebate(Builder builder) {
        this.itemID = builder.itemID;
        this.productCode = builder.productCode;
        this.eanUpc = builder.eanUpc;
        this.unitOfMeasure = builder.unitOfMeasure;
        this.quantity = builder.quantity;
        this.itemAmount = builder.itemAmount;
        this.rebateLabel = builder.rebateLabel;
    }
}

/*
package au.com.dmg.fusionsatellite.PaymentRequest
class SaleItemRebate
Integer itemID
String productCode
String eanUpc
UnitOfMeasure unitOfMeasure
BigDecimal quantity
BigDecimal itemAmount
String rebateLabel
* */