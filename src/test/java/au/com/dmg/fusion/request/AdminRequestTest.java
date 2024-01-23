package au.com.dmg.fusion.request;

import au.com.dmg.fusion.Message;
import au.com.dmg.fusion.MessageHeader;
import au.com.dmg.fusion.data.MessageCategory;
import au.com.dmg.fusion.data.MessageClass;
import au.com.dmg.fusion.data.MessageType;
import au.com.dmg.fusion.data.ServiceIdentification;
import au.com.dmg.fusion.request.adminrequest.AdminRequest;
import au.com.dmg.fusion.request.adminrequest.PrintShiftTotalsRequest;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.junit.Test;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AdminRequestTest {
    @Test
    public void testValid(){
        AdminRequest adminRequest = new AdminRequest.Builder()
                .serviceIdentification(ServiceIdentification.PrintLastCustomerReceipt)
                .build();
        Moshi moshi = new Moshi.Builder()
                .build();
        JsonAdapter<AdminRequest> jsonAdapter = moshi.adapter(AdminRequest.class);
        String json = jsonAdapter.toJson(adminRequest);
        System.out.println(json);

        AdminRequest serializedRequest = null;
        try {
            serializedRequest = jsonAdapter.fromJson(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert (serializedRequest.getServiceIdentification().toString().equals("PrintLastCustomerReceipt"));
    }

    @Test
    public void testNullServiceIdentification(){
        NullPointerException exception =
                assertThrows(NullPointerException.class,
                        ()->{
                            AdminRequest adminRequest = new AdminRequest.Builder()
                                    .build();
                            Moshi moshi = new Moshi.Builder()
                                    .build();
                            JsonAdapter<AdminRequest> jsonAdapter = moshi.adapter(AdminRequest.class);
                            String json = jsonAdapter.toJson(adminRequest);
                            System.out.println(json);

                        });
        assertEquals("The property \"serviceIdentification\" is null. Please set the value by \"serviceIdentification()\". The property \"serviceIdentification\" is required.", exception.getMessage());
    }

    @Test
    public void PrintShiftTotalsRequest(){
        AdminRequest adminRequest = new AdminRequest.Builder()
                .serviceIdentification(ServiceIdentification.PrintShiftTotals)
                .build();

        SaleToPOIRequest request = new SaleToPOIRequest.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .protocolVersion("3.1")
                        .messageClass(MessageClass.Service)
                        .messageCategory(MessageCategory.Admin)
                        .messageType(MessageType.Request)
                        .serviceID("3a5b52e2-13d9-4c3c-b0bd-af92335d7237")
                        .build())
                .request(adminRequest)
                .build();
        String json = new Message(request).toJson();
        System.out.println(json);
        assert (json != null && json != "");
    }

    @Test
    public void testValidPrintShiftTotalsRequest(){
        LocalDateTime date = LocalDateTime.now().minusHours(1);
        System.out.println("testValidPrintShiftTotalsRequest --- Date:" + date);

        Instant instantFrom = Instant.now()
                .atZone(ZoneId.of("Australia/Sydney"))
                .minusHours(2).toInstant();
        System.out.println("testValidPrintShiftTotalsRequest --- Instantfrom:" + instantFrom);
        System.out.println("testValidPrintShiftTotalsRequest --- InstantNow:" + Instant.now());

        PrintShiftTotalsRequest printShiftTotalsRequest = new PrintShiftTotalsRequest.Builder()
                .shiftNumber("XXTestShiftNumber")
                .shiftStartTime(instantFrom)
                .shiftEndTime(Instant.now())
                .build();

        AdminRequest adminRequest = new AdminRequest.Builder()
                .serviceIdentification(ServiceIdentification.PrintShiftTotals)
                .printShiftTotalsRequest(printShiftTotalsRequest)
                .build();


        SaleToPOIRequest request = new SaleToPOIRequest.Builder()
                .messageHeader(new MessageHeader.Builder()
                        .protocolVersion("3.1")
                        .messageClass(MessageClass.Service)
                        .messageCategory(MessageCategory.Admin)
                        .messageType(MessageType.Request)
                        .serviceID("3a5b52e2-13d9-4c3c-b0bd-af92335d7237")
                        .build())
                .request(adminRequest)
                .build();
        String json = new Message(request).toJson();
        System.out.println(json);
        assert (json != null && json != "");
    }
}
