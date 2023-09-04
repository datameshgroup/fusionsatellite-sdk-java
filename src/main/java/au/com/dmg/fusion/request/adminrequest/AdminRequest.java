package au.com.dmg.fusion.request.adminrequest;


import au.com.dmg.fusion.data.ServiceIdentification;
import au.com.dmg.fusion.request.Request;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

public class AdminRequest implements Request {
    @Json(name = "ServiceIdentification")
    private final ServiceIdentification serviceIdentification;

    public ServiceIdentification getServiceIdentification() {
        return serviceIdentification;
    }

    public static class Builder{
        private ServiceIdentification serviceIdentification;
        public Builder() {
        }
        Builder(ServiceIdentification serviceIdentification){
            this.serviceIdentification = serviceIdentification;
        }

        public Builder serviceIdentification(ServiceIdentification serviceIdentification){
            if(serviceIdentification==null){
                this.serviceIdentification = ServiceIdentification.Default;
            }else{
                this.serviceIdentification = serviceIdentification;
            }
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
    }

    @Override
    public String toJson() {
        Moshi moshi = new Moshi.Builder()
                .build();
        JsonAdapter<AdminRequest> jsonAdapter = moshi.adapter(AdminRequest.class);
        return jsonAdapter.toJson(this);
    }
}
