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

package au.com.dmg.fusion.response;

import java.math.BigDecimal;

import com.squareup.moshi.Json;

import au.com.dmg.fusion.data.TransactionType;

public class PaymentTotal {

	@Json(name = "TransactionType")
	private final TransactionType transactionType;
	@Json(name = "TransactionCount")
	private final Integer transactionCount;
	@Json(name = "TransactionAmount")
	private final BigDecimal transactionAmount;

	public PaymentTotal(TransactionType transactionType, Integer transactionCount, BigDecimal transactionAmount) {
		this.transactionType = transactionType;
		this.transactionCount = transactionCount;
		this.transactionAmount = transactionAmount;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public Integer getTransactionCount() {
		return transactionCount;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

}