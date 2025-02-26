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

import au.com.dmg.fusion.data.DocumentQualifier;
import au.com.dmg.fusion.request.printrequest.OutputContent;
import au.com.dmg.fusion.util.Base64;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class PaymentReceiptTest {

    @Test
    public void test() throws UnsupportedEncodingException {
        String receipt = "<p id=\"receipt-info\">\n" +
                "  16/09/2021 14:46:04<br/>\n" +
                "  Merchant ID: M00000021<br/>\n" +
                "  Terminal ID: WR000002\n" +
                "</p>\n" +
                "<p id=\"receipt-details\">\n" +
                "  <b>Purchase Transaction</b><br/>\n" +
                "  Amount: $1.00<br/>\n" +
                "  Surcharge: $0.01<br/>\n" +
                "  Total: $1.01<br/>\n" +
                "  VISA: 000000XXXXXX0000 (T)<br/>\n" +
                "  Credit Account\n" +
                "</p>\n" +
                "<p id=\"receipt-result\">\n" +
                "  <b>Approved</b><br/>\n" +
                "  Reference: 0000 0000 0911<br/>\n" +
                "  Auth Code: 696744<br/>\n" +
                "  AID: A0000000031010<br/>\n" +
                "  ATC: 0016<br/>\n" +
                "  TVR: 0000000000<br/>\n" +
                "  ARQC: 62262DE32EFBBC91\n" +
                "</p>";

        PaymentReceipt pr = new PaymentReceipt.Builder()
                .documentQualifier(DocumentQualifier.CashierReceipt)
                .requiredSignatureFlag(false)
                .integratedPrintFlag(false)
                .outputContent(new OutputContent("XHTML", Base64.encode(receipt.getBytes("UTF-8"))))
                .build();

        System.out.println(pr.getReceiptContentAsString());
    }
}