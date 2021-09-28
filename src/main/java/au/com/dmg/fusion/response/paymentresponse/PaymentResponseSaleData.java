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

import au.com.dmg.fusion.request.paymentrequest.SaleTransactionID;
import com.squareup.moshi.Json;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PaymentResponseSaleData {
    @Json(name = "SaleTransactionID")
    private final SaleTransactionID saleTransactionID;
    @Json(name = "SaleReferenceID")
    private final String saleReferenceID;

    public PaymentResponseSaleData(SaleTransactionID saleTransactionID) {
        this.saleTransactionID = saleTransactionID;
        this.saleReferenceID = null;
    }

    public PaymentResponseSaleData(SaleTransactionID saleTransactionID, String saleReferenceID) {
        this.saleTransactionID = saleTransactionID;
        this.saleReferenceID = saleReferenceID;
    }

    @NotNull
    public SaleTransactionID getSaleTransactionID() {
        return saleTransactionID;
    }

    @Nullable
    public String getSaleReferenceID() {
        return saleReferenceID;
    }
}