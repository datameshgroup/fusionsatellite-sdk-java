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

import au.com.dmg.fusion.response.balanceinquiryresponse.BalanceInquiryResponse;
import au.com.dmg.fusion.response.reversalresponse.ReversalResponse;
import au.com.dmg.fusion.response.storevalueresponse.StoredValueResponse;
import com.squareup.moshi.Json;

import au.com.dmg.fusion.response.paymentresponse.PaymentResponse;

public class RepeatedResponseMessageBody {
	@Json(name = "PaymentResponse")
	private final PaymentResponse paymentResponse;
	@Json(name = "ReversalResponse")
	private final ReversalResponse reversalResponse;
	@Json(name = "StoredValueResponse")
	private final StoredValueResponse storedValueResponse;
	@Json(name = "BalanceInquiryResponse")
	private final BalanceInquiryResponse balanceInquiryResponse;
	
	public RepeatedResponseMessageBody(PaymentResponse paymentResponse, ReversalResponse reversalResponse) {
		this.paymentResponse = paymentResponse;
		this.reversalResponse = reversalResponse;
		this.storedValueResponse = null;
		this.balanceInquiryResponse = null;
	}

	public RepeatedResponseMessageBody(StoredValueResponse storedValueResponse) {
		this.storedValueResponse = storedValueResponse;
		this.paymentResponse = null;
		this.reversalResponse = null;
		this.balanceInquiryResponse = null;
	}

	public RepeatedResponseMessageBody(BalanceInquiryResponse balanceInquiryResponse) {
		this.balanceInquiryResponse = balanceInquiryResponse;
		this.paymentResponse = null;
		this.reversalResponse = null;
		this.storedValueResponse = null;
	}

	public PaymentResponse getPaymentResponse() {
		return paymentResponse;
	}

	public ReversalResponse getReversalResponse() {
		return reversalResponse;
	}

	public StoredValueResponse getStoredValueResponse() {return storedValueResponse; }

	public BalanceInquiryResponse getBalanceInquiryResponse() {return balanceInquiryResponse; }
}