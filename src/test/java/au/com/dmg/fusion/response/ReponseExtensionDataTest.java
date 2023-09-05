package au.com.dmg.fusion.response;

import au.com.dmg.fusion.MessageHeader;
import au.com.dmg.fusion.data.MessageCategory;
import au.com.dmg.fusion.data.MessageClass;
import au.com.dmg.fusion.data.MessageType;
import au.com.dmg.fusion.response.diagnosisresponse.AddressLocation;
import au.com.dmg.fusion.response.diagnosisresponse.DiagnosisResponse;
import au.com.dmg.fusion.response.responseextensiondata.POIInformation;
import au.com.dmg.fusion.response.responseextensiondata.ResponseExtensionData;
import org.junit.Test;

public class ReponseExtensionDataTest {
    @Test
    public void testValid(){
        ResponseExtensionData responseExtensionData = new ResponseExtensionData.Builder()
                .poiInformation(new POIInformation.Builder()
                        .tid("xxtid")
                        .mid("xxmid")
                        .addressLocation(new AddressLocation.Builder()
                                .address1("a1xx")
                                .address2("a2xx")
                                .addressState("NSW")
                                .location("locationxx")
                                .build())
                        .build())
                .build();
    }

    @Test
    public void testDiagnosisResponse() {
        AddressLocation addressLocation = new AddressLocation.Builder()
                .address1("address1")
                .address2("address2")
                .addressState("NSW")
                .location("location")
                .build();

        SaleToPOIResponse response = new SaleToPOIResponse.Builder()
                .messageHeader(
                        new MessageHeader.Builder()
                                .messageClass(MessageClass.Service)
                                .messageCategory(MessageCategory.Diagnosis)
                                .messageType(MessageType.Response)
                                .saleID("")
                                .serviceID("")
                                .POIID("poid")
                                .build()
                )
                .response(new DiagnosisResponse.Builder()
                        .response(new Response.Builder()
                                .result(ResponseResult.Success)
                                .build())
                        .loggedSaleID("SaleID1")
                        .poiStatus(new POIStatus.Builder()
                                .globalStatus("OK")
                                .build())
                        .hostStatus(new HostStatus.Builder()
                                .acquirerID("xxx")
                                .isReachableFlag(true)
                                .build())
                        .responseExtensionData(new ResponseExtensionData.Builder()
                                .poiInformation(new POIInformation.Builder()
                                        .tid("xxtid")
                                        .mid("xxmid")
                                        .addressLocation(addressLocation)
                                        .build())
                                .build())
                        .build())
                .build();

        System.out.println(response.toJson());
        assert(response.getDiagnosisResponse().getResponseExtensionData().getPoiInformation().getAddressLocation().getAddressState().equals("NSW"));
    }
}
