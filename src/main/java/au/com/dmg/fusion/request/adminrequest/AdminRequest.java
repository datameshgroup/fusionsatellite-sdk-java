package au.com.dmg.fusion.request.adminrequest;


import au.com.dmg.fusion.data.ServiceIdentification;
import au.com.dmg.fusion.request.Request;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.jetbrains.annotations.Nullable;

public class AdminRequest implements Request {
    @Json(name = "ServiceIdentification")
    private final ServiceIdentification serviceIdentification;
    @Nullable
    @Json(name = "PrintShiftTotalsRequest")
    private final PrintShiftTotalsRequest printShiftTotalsRequest;

    public ServiceIdentification getServiceIdentification() {
        return serviceIdentification;
    }
    public PrintShiftTotalsRequest getPrintShiftTotalsRequest() {
        return printShiftTotalsRequest;
    }

    public static class Builder{
        private ServiceIdentification serviceIdentification;
        private PrintShiftTotalsRequest printShiftTotalsRequest;

        public Builder() {
        }

        Builder(ServiceIdentification serviceIdentification){
            this.serviceIdentification = serviceIdentification;
        }

        Builder(ServiceIdentification serviceIdentification, PrintShiftTotalsRequest printShiftTotalsRequest){
            this.serviceIdentification = serviceIdentification;
            this.printShiftTotalsRequest = printShiftTotalsRequest;
        }

        public Builder serviceIdentification(ServiceIdentification serviceIdentification){
            this.serviceIdentification = serviceIdentification;
            return Builder.this;
        }

        public Builder printShiftTotalsRequest(PrintShiftTotalsRequest printShiftTotalsRequest){
            this.printShiftTotalsRequest = printShiftTotalsRequest;
            return Builder.this;
        }

        public AdminRequest build(){
            if(this.serviceIdentification == null){
                throw new NullPointerException("The property \"serviceIdentification\" is null. "
                        + "Please set the value by \"serviceIdentification()\". "
                        + "The property \"serviceIdentification\" is required.");
            }

            return new AdminRequest(this);
        }
    }
    private AdminRequest(Builder builder) {
        this.serviceIdentification = builder.serviceIdentification;
        this.printShiftTotalsRequest = builder.printShiftTotalsRequest;
    }

    @Override
    public String toJson() {
        Moshi moshi = new Moshi.Builder()
                .build();
        JsonAdapter<AdminRequest> jsonAdapter = moshi.adapter(AdminRequest.class);
        return jsonAdapter.toJson(this);
    }
}
