package au.com.dmg.fusion.request;

import static org.junit.Assert.assertThrows;

import au.com.dmg.fusion.Message;
import au.com.dmg.fusion.MessageHeader;
import au.com.dmg.fusion.data.MessageCategory;
import au.com.dmg.fusion.data.MessageClass;
import au.com.dmg.fusion.data.MessageType;
import junit.framework.TestCase;

import java.io.UnsupportedEncodingException;

import au.com.dmg.fusion.data.ResponseMode;
import au.com.dmg.fusion.request.printrequest.OutputContent;
import au.com.dmg.fusion.request.printrequest.PrintOutput;
import au.com.dmg.fusion.request.printrequest.PrintRequest;
import au.com.dmg.fusion.util.Base64;

public class PrintRequestTest extends TestCase{
    public void testValidPrintRequestTest() throws UnsupportedEncodingException {
        String receipt = "<html><head></head> <body>  <div>   <p>01/07/2024 08:29</p>   <p>URN: Unavailable</p>   <p>Dealer ID: Unavailable</p>       <p>Merchant Id: M00000025</p>   <p>Terminal Id: INGB7241</p> <b>Purchase Transaction</b>   <p>Total Amount (incl GST): $4.00</p>   <p>    </p>           <div>    <p>Eftpos</p>    <p>560254XXXXXX0226 (C)</p>    <p>AID: A00000038410</p>    <p>STAN: 001588</p>    <p>Account: Savings</p>    <p>ARQC A590300AD374B249</p>    <p>CVM: 020000</p>    <p>TVR: 0000000000</p>    <p>ATC: 008F</p>    <p>PSN: 01</p>    <p>AIP: 1900</p>    <p>CURR: 0036</p>    <p>TSI: E800</p>   </div>    <div>    <p>Approved</p>    <p>RC: 00</p>   </div>       <div>    <p>RRN: 000000180772</p>   </div>   <p></p>   <p>    </p>                  <p></p>  </div> </body></html>";

        PrintOutput po = new PrintOutput.Builder()
                .documentQualifier("x")
                .responseMode(ResponseMode.PrintEnd)
                .requiredSignatureFlag(false)
                .integratedPrintFlag(false)
                .outputContent(new OutputContent("XHTML", Base64.encode(receipt.getBytes("UTF-8"))))
                .build();

        System.out.println(po.getReceiptContentAsString());

        PrintRequest printRequest = new PrintRequest(po);

        SaleToPOIRequest request = new SaleToPOIRequest.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .protocolVersion("3.1")
                        .messageClass(MessageClass.Device)
                        .messageCategory(MessageCategory.Print)
                        .messageType(MessageType.Request)
                        .serviceID("3a5b52e2-13d9-4c3c-b0bd-af92335d7237")
                        .build())
                .request(printRequest)
                .build();

        String json = new Message(request).toJson();
        System.out.println(json);
        assert (json != null && !json.equals(""));
    }

    public void testInvalidPrintRequestMissingDocumentQualifierTest() throws UnsupportedEncodingException {
        String receipt = "<html><head></head> <body>  <div>   <p>01/07/2024 08:29</p>   <p>URN: Unavailable</p>   <p>Dealer ID: Unavailable</p>       <p>Merchant Id: M00000025</p>   <p>Terminal Id: INGB7241</p> <b>Purchase Transaction</b>   <p>Total Amount (incl GST): $4.00</p>   <p>    </p>           <div>    <p>Eftpos</p>    <p>560254XXXXXX0226 (C)</p>    <p>AID: A00000038410</p>    <p>STAN: 001588</p>    <p>Account: Savings</p>    <p>ARQC A590300AD374B249</p>    <p>CVM: 020000</p>    <p>TVR: 0000000000</p>    <p>ATC: 008F</p>    <p>PSN: 01</p>    <p>AIP: 1900</p>    <p>CURR: 0036</p>    <p>TSI: E800</p>   </div>    <div>    <p>Approved</p>    <p>RC: 00</p>   </div>       <div>    <p>RRN: 000000180772</p>   </div>   <p></p>   <p>    </p>                  <p></p>  </div> </body></html>";

        NullPointerException exceptionResponse =
                assertThrows(NullPointerException.class,
                        ()->  new PrintOutput.Builder()
                                .requiredSignatureFlag(false)
                                .integratedPrintFlag(false)
                                .outputContent(new OutputContent("XHTML", Base64.encode(receipt.getBytes("UTF-8"))))
                                .build());

        System.out.println("PrintRequestTest - testInvalidPrintRequestMissingDocumentQualifierTest");
        assertEquals("The property \"documentQualifier\" is null. "
                + "Please set the value by \"documentQualifier()\". "
                + "The properties \"documentQualifier\", \"requiredSignatureFlag\" are required.", exceptionResponse.getMessage());


    }

    public void testInvalidPrintRequestMissingRequiredSignatureFlagTest() throws UnsupportedEncodingException {
        String receipt = "<html><head></head> <body>  <div>   <p>01/07/2024 08:29</p>   <p>URN: Unavailable</p>   <p>Dealer ID: Unavailable</p>       <p>Merchant Id: M00000025</p>   <p>Terminal Id: INGB7241</p> <b>Purchase Transaction</b>   <p>Total Amount (incl GST): $4.00</p>   <p>    </p>           <div>    <p>Eftpos</p>    <p>560254XXXXXX0226 (C)</p>    <p>AID: A00000038410</p>    <p>STAN: 001588</p>    <p>Account: Savings</p>    <p>ARQC A590300AD374B249</p>    <p>CVM: 020000</p>    <p>TVR: 0000000000</p>    <p>ATC: 008F</p>    <p>PSN: 01</p>    <p>AIP: 1900</p>    <p>CURR: 0036</p>    <p>TSI: E800</p>   </div>    <div>    <p>Approved</p>    <p>RC: 00</p>   </div>       <div>    <p>RRN: 000000180772</p>   </div>   <p></p>   <p>    </p>                  <p></p>  </div> </body></html>";

        NullPointerException exceptionResponse =
                assertThrows(NullPointerException.class,
                        ()->  new PrintOutput.Builder()
                                .documentQualifier("x")
                                .integratedPrintFlag(false)
                                .outputContent(new OutputContent("XHTML", Base64.encode(receipt.getBytes("UTF-8"))))
                                .build());

        System.out.println("PrintRequestTest - testInvalidPrintRequestMissingRequiredSignatureFlagTest");
        assertEquals("The property \"requiredSignatureFlag\" is null. "
                + "Please set the value by \"requiredSignatureFlag()\". "
                + "The properties \"documentQualifier\", \"requiredSignatureFlag\" are required.", exceptionResponse.getMessage());
    }
}
