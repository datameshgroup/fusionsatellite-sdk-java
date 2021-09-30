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

import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.squareup.moshi.Json;

import au.com.dmg.fusion.data.PaymentInstrumentType;

public class TransactionTotal {

	@Json(name = "PaymentInstrumentType")
	private PaymentInstrumentType paymentInstrumentType;
	@Json(name = "CardBrand")
	private String cardBrand;
	@Json(name = "TID")
	private String TID;
	@Json(name = "MID")
	private String MID;
	@Json(name = "AcquirerID")
	private String acquirerID;
	@Json(name = "LastShiftTotalTime")
	private String lastShiftTotalTime;
	@Json(name = "PaymentCurrency")
	private String paymentCurrency;
	@Json(name = "PaymentTotals")
	private List<PaymentTotal> paymentTotals;

	public TransactionTotal(PaymentInstrumentType paymentInstrumentType, String cardBrand, String TID, String MID,
			String acquirerID, String lastShiftTotalTime, String paymentCurrency, List<PaymentTotal> paymentTotals) {
		this.paymentInstrumentType = paymentInstrumentType;
		this.cardBrand = cardBrand;
		this.TID = TID;
		this.MID = MID;
		this.acquirerID = acquirerID;
		this.lastShiftTotalTime = lastShiftTotalTime;
		this.paymentCurrency = paymentCurrency;
		this.paymentTotals = paymentTotals;
	}

	@NotNull
	public PaymentInstrumentType getPaymentInstrumentType() {
		return paymentInstrumentType;
	}

	public String getCardBrand() {
		return cardBrand;
	}

	public String getTID() {
		return TID;
	}

	public String getMID() {
		return MID;
	}

	public String getAcquirerID() {
		return acquirerID;
	}

	public String getLastShiftTotalTime() {
		return lastShiftTotalTime;
	}

	public String getPaymentCurrency() {
		return paymentCurrency;
	}

	public List<PaymentTotal> getPaymentTotals() {
		return paymentTotals;
	}

}