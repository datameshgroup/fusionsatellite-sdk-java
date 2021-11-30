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

import com.squareup.moshi.Json;

import java.util.ArrayList;
import java.util.List;

public class PaymentTransaction {
    @Json(name = "AmountsReq")
    private final AmountsReq amountsReq;
    @Json(name = "OriginalPOITransaction")
    private final OriginalPOITransaction originalPOITransaction;
    @Json(name = "TransactionConditions")
    private final TransactionConditions transactionConditions;
    @Json(name = "SaleItem")
    private final List<SaleItem> saleItems;

    public AmountsReq getAmountsReq() {
        return amountsReq;
    }

    public OriginalPOITransaction getOriginalPOITransaction() {
        return originalPOITransaction;
    }

    public TransactionConditions getTransactionConditions() {
        return transactionConditions;
    }

    public List<SaleItem> getSaleItems() {
        return saleItems;
    }

    public static class Builder {

        private AmountsReq amountsReq;
        private OriginalPOITransaction originalPOITransaction;
        private TransactionConditions transactionConditions;
        private List<SaleItem> saleItems = new ArrayList<>();

        public Builder() {
        }

        Builder(AmountsReq amountsReq, OriginalPOITransaction originalPOITransaction, TransactionConditions transactionConditions, List<SaleItem> saleItems) {
            this.amountsReq = amountsReq;
            this.originalPOITransaction = originalPOITransaction;
            this.transactionConditions = transactionConditions;
            this.saleItems = saleItems;
        }

        public Builder amountsReq(AmountsReq amountsReq) {
            this.amountsReq = amountsReq;
            return Builder.this;
        }

        public Builder originalPOITransaction(OriginalPOITransaction originalPOITransaction) {
            this.originalPOITransaction = originalPOITransaction;
            return Builder.this;
        }

        public Builder transactionConditions(TransactionConditions transactionConditions) {
            this.transactionConditions = transactionConditions;
            return Builder.this;
        }

        public Builder saleItems(List<SaleItem> saleItems) {
            if(saleItems == null){
                this.saleItems = new ArrayList<>();
            } else {
                this.saleItems = saleItems;
            }
            return Builder.this;
        }

        public Builder addSaleItem(SaleItem saleItem) {
            this.saleItems.add(saleItem);
            return Builder.this;
        }

        public Builder addSaleItems(List<SaleItem> saleItems) {
            this.saleItems.addAll(saleItems);
            return Builder.this;
        }

        public PaymentTransaction build() {
            if (this.amountsReq == null) {
                throw new NullPointerException("The property \"amountsReq\" is null. "
                        + "Please set the value by \"amountsReq()\". "
                        + "The properties \"amountsReq\", \"paymentData\" are required.");
            }
            return new PaymentTransaction(this);
        }
    }

    private PaymentTransaction(Builder builder) {
        this.amountsReq = builder.amountsReq;
        this.originalPOITransaction = builder.originalPOITransaction;
        this.transactionConditions = builder.transactionConditions;
        this.saleItems = builder.saleItems;
    }
}


/*
package au.com.dmg.fusionsatellite.PaymentRequest
class PaymentTransaction
@Required AmountsReq amountsReq
OriginalPOITransaction originalPOITransaction
TransactionConditions transactionConditions
List<SaleItem> saleItems
@Required PaymentData paymentData
* */
