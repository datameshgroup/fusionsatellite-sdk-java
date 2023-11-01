package au.com.dmg.fusion.util;

import au.com.dmg.fusion.Message;
import au.com.dmg.fusion.MessageHeader;
import au.com.dmg.fusion.data.CustomFieldType;
import au.com.dmg.fusion.data.MessageCategory;
import au.com.dmg.fusion.data.MessageClass;
import au.com.dmg.fusion.data.MessageType;
import au.com.dmg.fusion.request.SaleToPOIRequest;
import au.com.dmg.fusion.request.paymentrequest.CustomField;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import junit.framework.TestCase;

public class PairingDataTest extends TestCase {


    public void testValidCreatePairingData() {
        PairingData pairingData = new PairingData.Builder()
                .saleID("testSaleID")
                .pairingPOIID("testPairingPOIID")
                .kek(PairingData.CreateKEK())
                .certificationCode("testCertificationCode")
                .posName("testPosName")
                .version(1)
                .build();

        String json = toJson(pairingData);
        System.out.println(json);
        assert (json != null && json != "");
        assert (pairingData.getPairingPOIID().equals("testPairingPOIID"));
    }

    public void testInvalidCreatePairingData() {
        // Missing posName
        try{
            PairingData pairingData = new PairingData.Builder()
                    .saleID("testSaleID")
                    .pairingPOIID("testPairingPOIID")
                    .kek(PairingData.CreateKEK())
                    .certificationCode("testCertificationCode")
                    .version(1)
                    .build();
            assert(false);
        } catch (NullPointerException e){
            System.out.println(e);
            assert(e.toString().equals("java.lang.NullPointerException: The property \"posName\" is null or empty. Please set the value by \"posName()\". The properties \"saleID\", \"pairingPOIID\", \"kek\", \"certificationCode\", \"posName\" and \"version\" are required."));
            assert(true);
        }

        // Missing certificationCode
        try{
            PairingData pairingData = new PairingData.Builder()
                    .saleID("testSaleID")
                    .pairingPOIID("testPairingPOIID")
                    .kek(PairingData.CreateKEK())
                    .posName("testPosName")
                    .version(1)
                    .build();
            assert(false);
        } catch (NullPointerException e){
            System.out.println(e);
            assert(e.toString().equals("java.lang.NullPointerException: The property \"certificationCode\" is null or empty. Please set the value by \"certificationCode()\". The properties \"saleID\", \"pairingPOIID\", \"kek\", \"certificationCode\", \"posName\" and \"version\" are required."));
            assert(true);
        }
    }

    public String toJson(PairingData pairingData) {
        Moshi moshi = new Moshi.Builder()
                .build();
        JsonAdapter<PairingData> jsonAdapter = moshi.adapter(PairingData.class);
        return jsonAdapter.toJson(pairingData);
    }

}
