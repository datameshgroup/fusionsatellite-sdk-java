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

package au.com.dmg.fusion.request.paymentrequest;

import au.com.dmg.fusion.data.UnitOfMeasure;
import com.squareup.moshi.Json;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SaleItem {
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
    @Json(name = "UnitPrice")
    private final BigDecimal unitPrice;
    @Json(name = "ItemAmount")
    private final BigDecimal itemAmount;
    @Json(name = "TaxCode")
    private final String taxCode;
    @Json(name = "SaleChannel")
    private final String saleChannel;
    @Json(name = "ProductLabel")
    private final String productLabel;
    @Json(name = "AdditionalProductInfo")
    private final String additionalProductInfo;
    @Json(name = "ParentItemID")
    private final Integer parentItemID;
    @Json(name = "CostBase")
    private final BigDecimal costBase;
    @Json(name = "Discount")
    private final BigDecimal discount;
    @Json(name = "Categories")
    private final List<String> categories;
    @Json(name = "Brand")
    private final String brand;
    @Json(name = "QuantityInStock")
    private final BigDecimal quantityInStock;
    @Json(name = "Tags")
    private final List<String> tags;
    @Json(name = "Restricted")
    private final Boolean restricted;
    @Json(name = "PageUrl")
    private final String pageUrl;
    @Json(name = "ImageUrls")
    private final List<String> imageUrls;
    @Json(name = "Style")
    private final String style;
    @Json(name = "Size")
    private final String size;
    @Json(name = "Colour")
    private final String colour;
    @Json(name = "Weight")
    private final BigDecimal weight;
    @Json(name = "WeightUnitOfMeasure")
    private final String weightUnitOfMeasure;


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

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public BigDecimal getItemAmount() {
        return itemAmount;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public String getSaleChannel() {
        return saleChannel;
    }

    public String getProductLabel() {
        return productLabel;
    }

    public String getAdditionalProductInfo() {
        return additionalProductInfo;
    }

    public BigDecimal getCostBase() {
        return costBase;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public List<String> getCategories() {
        return categories;
    }

    public String getBrand() {
        return brand;
    }

    public BigDecimal getQuantityInStock() {
        return quantityInStock;
    }

    public List<String> getTags() {
        return tags;
    }

    public Boolean getRestricted() {
        return restricted;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public String getStyle() {
        return style;
    }

    public String getSize() {
        return size;
    }

    public String getColour() {
        return colour;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public String getWeightUnitOfMeasure() {
        return weightUnitOfMeasure;
    }

    public Integer getParentItemID() {
        return parentItemID;
    }

    public static class Builder {

        private Integer itemID;
        private String productCode;
        private String eanUpc;
        private UnitOfMeasure unitOfMeasure;
        private BigDecimal quantity;
        private BigDecimal unitPrice;
        private BigDecimal itemAmount;
        private String taxCode = "GST";
        private String saleChannel = "Unknown";
        private String productLabel;
        private String additionalProductInfo;
        private Integer parentItemID;
        private BigDecimal costBase;
        private BigDecimal discount;
        private List<String> categories;
        private String subCategory;
        private String brand;
        private BigDecimal quantityInStock;
        private List<String> tags = new ArrayList<>();
        private Boolean restricted = false;
        private String pageUrl;
        private List<String> imageUrls = new ArrayList<>();
        private String style;
        private String size;
        private String colour;
        private BigDecimal weight;
        private String weightUnitOfMeasure;

        public Builder() {
        }

        Builder(Integer itemID, String productCode, String eanUpc, UnitOfMeasure unitOfMeasure, BigDecimal quantity, BigDecimal unitPrice, BigDecimal itemAmount, String taxCode, String saleChannel, String productLabel, String additionalProductInfo, Integer parentItemID, BigDecimal costBase, BigDecimal discount, List<String> categories, String brand, BigDecimal quantityInStock, List<String> tags, Boolean restricted, String pageUrl, List<String> imageUrls, String style, String size, String colour, BigDecimal weight, String weightUnitOfMeasure) {
            this.itemID = itemID;
            this.productCode = productCode;
            this.eanUpc = eanUpc;
            this.unitOfMeasure = unitOfMeasure;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
            this.itemAmount = itemAmount;
            this.taxCode = taxCode;
            this.saleChannel = saleChannel;
            this.productLabel = productLabel;
            this.additionalProductInfo = additionalProductInfo;
            this.parentItemID = parentItemID;
            this.costBase = costBase;
            this.discount = discount;
            this.categories = categories;
            this.brand = brand;
            this.quantityInStock = quantityInStock;
            this.tags = tags;
            this.restricted = restricted;
            this.pageUrl = pageUrl;
            this.imageUrls = imageUrls;
            this.style = style;
            this.size = size;
            this.colour = colour;
            this.weight = weight;
            this.weightUnitOfMeasure = weightUnitOfMeasure;
        }

        public Builder itemID(Integer itemID) {
            this.itemID = itemID;
            return Builder.this;
        }

        public Builder productCode(String productCode) {
            this.productCode = productCode;
            return Builder.this;
        }

        public Builder eanUpc(String eanUpc) {
            this.eanUpc = eanUpc;
            return Builder.this;
        }

        public Builder unitOfMeasure(UnitOfMeasure unitOfMeasure) {
            this.unitOfMeasure = unitOfMeasure;
            return Builder.this;
        }

        public Builder quantity(BigDecimal quantity) {
            this.quantity = quantity;
            return Builder.this;
        }

        public Builder unitPrice(BigDecimal unitPrice) {
            this.unitPrice = unitPrice;
            return Builder.this;
        }

        public Builder itemAmount(BigDecimal itemAmount) {
            this.itemAmount = itemAmount;
            return Builder.this;
        }

        public Builder taxCode(String taxCode) {
            this.taxCode = taxCode;
            return Builder.this;
        }

        public Builder saleChannel(String saleChannel) {
            this.saleChannel = saleChannel;
            return Builder.this;
        }

        public Builder productLabel(String productLabel) {
            this.productLabel = productLabel;
            return Builder.this;
        }

        public Builder additionalProductInfo(String additionalProductInfo) {
            this.additionalProductInfo = additionalProductInfo;
            return Builder.this;
        }

        public Builder parentItemID(Integer parentItemID){
            this.parentItemID = parentItemID;
            return Builder.this;
        }

        public Builder costBase(BigDecimal costBase) {
            this.costBase = costBase;
            return Builder.this;
        }

        public Builder discount(BigDecimal discount) {
            this.discount = discount;
            return Builder.this;
        }

        public Builder categories(List<String> categories) {
            this.categories = categories;
            return Builder.this;
        }

        public Builder restricted(Boolean restricted) {
            this.restricted = restricted;
            return Builder.this;
        }

        public Builder pageUrl(String pageUrl) {
            this.pageUrl = pageUrl;
            return Builder.this;
        }

        public Builder imageUrls(List<String> imageUrls) {
            this.imageUrls = imageUrls;
            return Builder.this;
        }

        public Builder style(String style) {
            this.style = style;
            return Builder.this;
        }

        public Builder size(String size) {
            this.size = size;
            return Builder.this;
        }

        public Builder colour(String colour) {
            this.colour = colour;
            return Builder.this;
        }

        public Builder weight(BigDecimal weight) {
            this.weight = weight;
            return Builder.this;
        }

        public Builder weightUnitOfMeasure(String weightUnitOfMeasure) {
            this.weightUnitOfMeasure = weightUnitOfMeasure;
            return Builder.this;
        }

        public Builder brand(String brand) {
            this.brand = brand;
            return Builder.this;
        }

        public Builder quantityInStock(BigDecimal quantityInStock) {
            this.quantityInStock = quantityInStock;
            return Builder.this;
        }

        public Builder tags(List<String> tags) {
            this.tags = tags;
            return Builder.this;
        }

        public Builder addTags(String tags) {
            this.tags.add(tags);
            return Builder.this;
        }

        public SaleItem build() {
            if (this.itemID == null) {
                throw new NullPointerException("The property \"itemID\" is null. "
                        + "Please set the value by \"itemID()\". "
                        + "The properties \"itemID\", \"productCode\", \"unitOfMeasure\", \"quantity\", \"unitPrice\", \"itemAmount\" and \"productLabel\" are required.");
            }
            if (this.productCode == null) {
                throw new NullPointerException("The property \"productCode\" is null. "
                        + "Please set the value by \"productCode()\". "
                        + "The properties \"itemID\", \"productCode\", \"unitOfMeasure\", \"quantity\", \"unitPrice\", \"itemAmount\" and \"productLabel\" are required.");
            }
            if (this.unitOfMeasure == null) {
                throw new NullPointerException("The property \"unitOfMeasure\" is null. "
                        + "Please set the value by \"unitOfMeasure()\". "
                        + "The properties \"itemID\", \"productCode\", \"unitOfMeasure\", \"quantity\", \"unitPrice\", \"itemAmount\" and \"productLabel\" are required.");
            }
            if (this.quantity == null) {
                throw new NullPointerException("The property \"quantity\" is null. "
                        + "Please set the value by \"quantity()\". "
                        + "The properties \"itemID\", \"productCode\", \"unitOfMeasure\", \"quantity\", \"unitPrice\", \"itemAmount\" and \"productLabel\" are required.");
            }
            if (this.unitPrice == null) {
                throw new NullPointerException("The property \"unitPrice\" is null. "
                        + "Please set the value by \"unitPrice()\". "
                        + "The properties \"itemID\", \"productCode\", \"unitOfMeasure\", \"quantity\", \"unitPrice\", \"itemAmount\" and \"productLabel\" are required.");
            }
            if (this.itemAmount == null) {
                throw new NullPointerException("The property \"itemAmount\" is null. "
                        + "Please set the value by \"itemAmount()\". "
                        + "The properties \"itemID\", \"productCode\", \"unitOfMeasure\", \"quantity\", \"unitPrice\", \"itemAmount\" and \"productLabel\" are required.");
            }
            if (this.productLabel == null) {
                throw new NullPointerException("The property \"productLabel\" is null. "
                        + "Please set the value by \"productLabel()\". "
                        + "The properties \"itemID\", \"productCode\", \"unitOfMeasure\", \"quantity\", \"unitPrice\", \"itemAmount\" and \"productLabel\" are required.");
            }

            return new SaleItem(this);
        }
    }

    private SaleItem(Builder builder) {
        this.itemID = builder.itemID;
        this.productCode = builder.productCode;
        this.eanUpc = builder.eanUpc;
        this.unitOfMeasure = builder.unitOfMeasure;
        this.quantity = builder.quantity;
        this.unitPrice = builder.unitPrice;
        this.itemAmount = builder.itemAmount;
        this.taxCode = builder.taxCode;
        this.saleChannel = builder.saleChannel;
        this.productLabel = builder.productLabel;
        this.additionalProductInfo = builder.additionalProductInfo;
        this.parentItemID = builder.parentItemID;
        this.costBase = builder.costBase;
        this.discount = builder.discount;
        this.categories = builder.categories;
        this.brand = builder.brand;
        this.quantityInStock = builder.quantityInStock;
        this.tags = builder.tags;
        this.restricted = builder.restricted;
        this.pageUrl = builder.pageUrl;
        this.imageUrls = builder.imageUrls;
        this.style = builder.style;
        this.size = builder.size;
        this.colour = builder.colour;
        this.weight = builder.weight;
        this.weightUnitOfMeasure = builder.weightUnitOfMeasure;
    }
}


/*
package au.com.dmg.fusionsatellite.PaymentRequest
class SaleItem
@Required Integer itemID
@Required String productCode
String eanUpc
@Required UnitOfMeasure unitOfMeasure
@Required BigDecimal quantity
@Required BigDecimal unitPrice
@Required BigDecimal itemAmount
String taxCode
String saleChannel
@Required String productLabel
String additionalProductInfo
BigDecimal costBase
BigDecimal discount
List<String> categories
String subCategory
String brand
BigDecimal quantityInStock
List<String> tags

* */