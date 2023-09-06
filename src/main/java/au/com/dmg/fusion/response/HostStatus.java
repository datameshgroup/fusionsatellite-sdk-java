package au.com.dmg.fusion.response;

import com.squareup.moshi.Json;

public class HostStatus {
    @Json(name = "AcquirerID")
    private final String acquirerID;
    @Json(name = "IsReachableFlag")
    private final boolean isReachableFlag;

    public String getAcquirerID() {
        return acquirerID;
    }

    public boolean isReachableFlag() {
        return isReachableFlag;
    }

    public static class Builder {
        private String acquirerID;
        private boolean isReachableFlag;

        public Builder() {
        }

        Builder(String acquirerID, boolean isReachableFlag){
            this.acquirerID = acquirerID;
            this.isReachableFlag = isReachableFlag;
        }

        public Builder acquirerID(String acquirerID){
            this.acquirerID = acquirerID;
            return Builder.this;
        }

        public Builder isReachableFlag(boolean isReachableFlag){
            this.isReachableFlag = isReachableFlag;
            return Builder.this;
        }

        public HostStatus build(){
            if (this.acquirerID == null|| this.acquirerID.isEmpty()) {
                throw new NullPointerException("The property \"acquirerID\" is null or empty. "
                        + "Please set the value by \"acquirerID()\". "
                        + "The properties \"acquirerID\", is required.");
            }
            return new HostStatus(this);
        }
    }
    private HostStatus(Builder builder) {
        this.acquirerID = builder.acquirerID;
        this.isReachableFlag = builder.isReachableFlag;
    }
}
