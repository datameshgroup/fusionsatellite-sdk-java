package au.com.dmg.fusion.response.adminresponse;

import au.com.dmg.fusion.response.Response;
import au.com.dmg.fusion.response.ResponseType;
import com.squareup.moshi.Json;
import org.jetbrains.annotations.NotNull;

public class AdminResponse implements ResponseType {
    @Json(name = "Response")
    private final Response response;

    public AdminResponse(Builder builder) {
        this.response = builder.response;
    }

    @NotNull
    public Response getResponse() { return response; }

    public static class Builder {
        private Response response;

        public Builder() {
        }

        Builder(Response response){
            this.response = response;
        }

        public Builder response(Response response){
            this.response = response;
            return Builder.this;
        }


        public AdminResponse build() {
            if (this.response == null) {
                throw new NullPointerException("The property \"response\" is null. "
                        + "Please set the value by \"response()\". "
                        + "The properties \"response\", is required.");
            }
            return new AdminResponse(this);
        }
    }
}
