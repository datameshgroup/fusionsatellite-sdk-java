package au.com.dmg.fusion.response;

import com.squareup.moshi.Json;

public class POISoftware {
    @Json(name = "ProviderIdentification")
    private final String providerIdentification;

    @Json(name = "ApplicationName")
    private final String applicationName;

    @Json(name = "SoftwareVersion")
    private final String softwareVersion;

    @Json(name = "CertificationCode")
    private final String certificationCode;

    @Json(name = "ComponentDescription")
    private final String componentDescription;

    @Json(name = "ComponentType")
    private final String componentType;

    public String getProviderIdentification() {
        return providerIdentification;
    }

    public String getApplicationName() { return applicationName; }

    public String getSoftwareVersion() { return softwareVersion; }

    public String getCertificationCode() { return certificationCode; }

    public String getComponentDescription() { return componentDescription; }

    public String getComponentType() { return componentType; }

    public static class Builder {

        private String providerIdentification;
        private String applicationName;
        private String softwareVersion;
        private String certificationCode;
        private String componentDescription;
        private String componentType;

        public Builder() {
        }

        Builder(String providerIdentification, String applicationName, String softwareVersion, String certificationCode, String componentDescription, String componentType) {
            this.providerIdentification = providerIdentification;
            this.applicationName = applicationName;
            this.softwareVersion = softwareVersion;
            this.certificationCode =  certificationCode;
            this.componentDescription = componentDescription;
            this.componentType =  componentType;
        }

        public Builder providerIdentification(String providerIdentification) {
            this.providerIdentification = providerIdentification;
            return Builder.this;
        }

        public Builder applicationName(String applicationName) {
            this.applicationName = applicationName;
            return Builder.this;
        }

        public Builder softwareVersion(String softwareVersion) {
            this.softwareVersion = softwareVersion;
            return Builder.this;
        }

        public Builder certificationCode(String certificationCode) {
            this.certificationCode = certificationCode;
            return Builder.this;
        }

        public Builder componentDescription(String componentDescription) {
            this.componentDescription = componentDescription;
            return Builder.this;
        }

        public Builder componentType(String componentType) {
            this.componentType = componentType;
            return Builder.this;
        }

        public POISoftware build() {
            return new POISoftware(this);
        }
    }

    private POISoftware(Builder builder) {
        this.providerIdentification = builder.providerIdentification;
        this.applicationName = builder.applicationName;
        this.softwareVersion = builder.softwareVersion;
        this.certificationCode =  builder.certificationCode;
        this.componentDescription = builder.componentDescription;
        this.componentType =  builder.componentType;
    }
}
