package au.com.dmg.fusion.response.diagnosisresponse;

import au.com.dmg.fusion.request.paymentrequest.extenstiondata.ExtensionData;
import au.com.dmg.fusion.response.HostStatus;
import au.com.dmg.fusion.response.POIStatus;
import au.com.dmg.fusion.response.Response;
import au.com.dmg.fusion.response.ResponseType;
import au.com.dmg.fusion.response.responseextensiondata.ResponseExtensionData;
import com.squareup.moshi.Json;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class DiagnosisResponse implements ResponseType {

    @Json(name = "Response")
    private final Response response;
    @Json(name = "LoggedSaleID")
    public List<String> loggedSaleID;
    @Json(name = "POIStatus")
    public POIStatus poiStatus;
    @Json(name = "HostStatus")
    public List<HostStatus> hostStatus;
    @Json(name = "ResponseExtensionData")
    public ResponseExtensionData responseExtensionData;

    public DiagnosisResponse(Builder builder) {
        this.response = builder.response;
        this.loggedSaleID = builder.loggedSaleID;
        this.poiStatus = builder.poiStatus;
        this.hostStatus = builder.hostStatus;
        this.responseExtensionData = builder.responseExtensionData;
    }

    @NotNull
    public Response getResponse() { return response; }
    public List<String> getLoggedSaleID() { return loggedSaleID; }
    public POIStatus getPOIStatus() { return poiStatus; }
    public List<HostStatus> getHostStatus() { return hostStatus; }
    public ResponseExtensionData getResponseExtensionData() { return responseExtensionData; }

    public static class Builder {
        private Response response;
        private List<String> loggedSaleID;
        private POIStatus poiStatus;
        private List<HostStatus> hostStatus;
        private ResponseExtensionData responseExtensionData;

        public Builder() {
        }

        Builder(Response response,List<String> loggedSaleID, POIStatus poiStatus, List<HostStatus> hostStatus, ResponseExtensionData responseExtensionData){
            this.response = response;
            this.loggedSaleID = loggedSaleID;
            this.poiStatus = poiStatus;
            this.hostStatus = hostStatus;
            this.responseExtensionData = responseExtensionData;
        }

        public Builder response(Response response){
            this.response = response;
            return Builder.this;
        }
        public Builder loggedSaleIDs(List<String> loggedSaleID){
            this.loggedSaleID = loggedSaleID;
            return Builder.this;
        }
        public Builder loggedSaleID(String loggedSaleID){
            this.loggedSaleID = Collections.singletonList(loggedSaleID);
            return Builder.this;
        }
        public Builder loggedSaleID(List<String> loggedSaleID){
            this.loggedSaleID = loggedSaleID;
            return Builder.this;
        }
        public Builder addLoggedSaleID(String loggedSaleID){
            if(loggedSaleID!=null) {
                if (this.loggedSaleID != null) {
                    this.loggedSaleID.add(loggedSaleID);
                } else {
                    this.loggedSaleID = Collections.singletonList(loggedSaleID);
                }
            }
                return Builder.this;
        }
        public Builder poiStatus(POIStatus poiStatus){
            this.poiStatus = poiStatus;
            return Builder.this;
        }
        public Builder hostStatus(List<HostStatus> hostStatus){
            this.hostStatus = hostStatus;
            return Builder.this;
        }
        public Builder hostStatus(HostStatus hostStatus){
            this.hostStatus = Collections.singletonList(hostStatus);
            return Builder.this;
        }
        public Builder addHostStatus(HostStatus hostStatus){
            if(hostStatus!=null){
                if(this.hostStatus!=null){
                    this.hostStatus.add(hostStatus);
                }else{
                    this.hostStatus = Collections.singletonList(hostStatus);
                }
            }
            return Builder.this;
        }

        public Builder responseExtensionData(ResponseExtensionData responseExtensionData){
            this.responseExtensionData = responseExtensionData;
            return Builder.this;
        }

        public DiagnosisResponse build() {
            return new DiagnosisResponse(this);
        }
    }
}
