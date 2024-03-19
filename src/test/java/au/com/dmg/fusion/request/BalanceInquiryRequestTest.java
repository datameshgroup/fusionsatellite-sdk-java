package au.com.dmg.fusion.request;

import au.com.dmg.fusion.Message;
import au.com.dmg.fusion.MessageHeader;
import au.com.dmg.fusion.data.MessageCategory;
import au.com.dmg.fusion.data.MessageClass;
import au.com.dmg.fusion.data.MessageType;
import au.com.dmg.fusion.request.balanceinquiryrequest.BalanceInquiryRequest;
import junit.framework.TestCase;

public class BalanceInquiryRequestTest extends TestCase {
    public void testValidBalanceInquiryRequestTest(){
        BalanceInquiryRequest balanceInquiryRequest = new BalanceInquiryRequest();

        SaleToPOIRequest request = new SaleToPOIRequest.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .protocolVersion("3.1")
                        .messageClass(MessageClass.Service)
                        .messageCategory(MessageCategory.BalanceInquiry)
                        .messageType(MessageType.Request)
                        .serviceID("3a5b52e2-13d9-4c3c-b0bd-af92335d7237")
                        .build())
                .request(balanceInquiryRequest)
                .build();

        String json = new Message(request).toJson();
        System.out.println(json);
        assert (json != null && json != "");
    }
}
