package au.com.dmg.fusion.response;

import au.com.dmg.fusion.MessageHeader;
import au.com.dmg.fusion.data.MessageCategory;
import au.com.dmg.fusion.data.MessageClass;
import au.com.dmg.fusion.data.MessageType;
import au.com.dmg.fusion.request.adminrequest.AdminRequest;
import au.com.dmg.fusion.response.diagnosisresponse.AddressLocation;
import au.com.dmg.fusion.response.diagnosisresponse.DiagnosisResponse;
import au.com.dmg.fusion.response.responseextensiondata.POIInformation;
import au.com.dmg.fusion.response.responseextensiondata.ResponseExtensionData;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

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
        assert(response.getDiagnosisResponse().getExtensionData().getPoiInformation().getAddressLocation().getAddressState().equals("NSW"));
    }

    @Test
    public void NullPOIInformation(){
        NullPointerException exception =
                assertThrows(NullPointerException.class,
                        ()->{
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
                                                    .build())
                                            .build())
                                    .build();

                            System.out.println(response.toJson());

                        });
        assertEquals("The property \"poiInformation\" is null or empty. "
                + "Please set the value by \"poiInformation()\". "
                + "The properties \"poiInformation\", is required.", exception.getMessage());
    }
    @Test
    public void NullPOIInformationTID(){
        NullPointerException exception =
                assertThrows(NullPointerException.class,
                        ()->{
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
                                                            .mid("xxmid")
                                                            .addressLocation(addressLocation)
                                                            .build())
                                                    .build())
                                            .build())
                                    .build();

                            System.out.println(response.toJson());

                        });
        assertEquals("The property \"tid\" is null or empty. "
                + "Please set the value by \"tid()\". "
                + "The properties \"tid\", is required.", exception.getMessage());
    }

    @Test
    public void NullHostStatusAcquirerID(){
        NullPointerException exception =
                assertThrows(NullPointerException.class,
                        ()->{
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

                        });
        assertEquals("The property \"acquirerID\" is null or empty. "
                + "Please set the value by \"acquirerID()\". "
                + "The properties \"acquirerID\", is required.", exception.getMessage());
    }
}
