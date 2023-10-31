package au.com.dmg.fusion.util;

import com.squareup.moshi.Json;

import java.util.Random;

public class PairingData {
    @Json(name = "s")
    private final String saleID;
    @Json(name = "p")
    private final String pairingPOIID;
    @Json(name = "k")
    private final String kek;
    @Json(name = "c")
    private final String certificationCode;
    @Json(name = "n")
    private final String posName;
    @Json(name = "v")
    private final Integer version;

    public String getSaleID(){return saleID; }
    public String getPairingPOIID(){ return pairingPOIID; }
    public String getKEK() {return kek;}
    public String getCertificationCode(){return certificationCode;}
    public String getPosName(){return posName; }
    public Integer getVersion(){return version; }

    public static class Builder {
        private String saleID;
        private String pairingPOIID;
        private String kek;
        private String certificationCode;
        private String posName;
        private Integer version;

        public Builder() {
        }

        Builder(String saleID, String pairingPOIID, String kek, String certificationCode, String posName, Integer version){
            this.saleID = saleID;
            this.pairingPOIID = pairingPOIID;
            this.kek = kek;
            this.certificationCode = certificationCode;
            this.posName = posName;
            this.version = version;
        }

        private Builder saleID(String saleID){
            this.saleID = saleID;
            return Builder.this;
        }
        private Builder pairingPOIID(String pairingPOIID){
            this.pairingPOIID = pairingPOIID;
            return Builder.this;
        }
        private Builder kek(String kek){
            this.kek = kek;
            return Builder.this;
        }
        private Builder certificationCode(String certificationCode){
            this.certificationCode = certificationCode;
            return Builder.this;
        }
        private Builder posName(String posName){
            this.posName = posName;
            return Builder.this;
        }
        private Builder version(Integer version){
            this.version = version;
            return Builder.this;
        }

        public PairingData build(){
            if (this.saleID == null || this.saleID.isEmpty()) {
                throw new NullPointerException("The property \"saleID\" is null or empty. "
                        + "Please set the value by \"saleID()\". "
                        + "The properties \"saleID\", \"pairingPOIID\", \"kek\", \"certificationCode\", \"posName\" and \"version\" are required.");
            }
            if (this.pairingPOIID == null) {
                throw new NullPointerException("The property \"pairingPOIID\" is null or empty. "
                        + "Please set the value by \"pairingPOIID()\". "
                        + "The properties \"saleID\", \"pairingPOIID\", \"kek\", \"certificationCode\", \"posName\" and \"version\" are required.");
            }
            if (this.kek == null) {
                throw new NullPointerException("The property \"kek\" is null or empty. "
                        + "Please set the value by \"kek()\". "
                        + "The properties \"saleID\", \"pairingPOIID\", \"kek\", \"certificationCode\", \"posName\" and \"version\" are required.");
            }
            if (this.certificationCode == null) {
                throw new NullPointerException("The property \"certificationCode\" is null or empty. "
                        + "Please set the value by \"certificationCode()\". "
                        + "The properties \"saleID\", \"pairingPOIID\", \"kek\", \"certificationCode\", \"posName\" and \"version\" are required.");
            }
            if (this.posName == null) {
                throw new NullPointerException("The property \"posName\" is null or empty. "
                        + "Please set the value by \"posName()\". "
                        + "The properties \"saleID\", \"pairingPOIID\", \"kek\", \"certificationCode\", \"posName\" and \"version\" are required.");
            }
            if (this.version == null) {
                throw new NullPointerException("The property \"version\" is null or empty. "
                        + "Please set the value by \"version()\". "
                        + "The properties \"saleID\", \"pairingPOIID\", \"kek\", \"certificationCode\", \"posName\" and \"version\" are required.");
            }
            return new PairingData(this);
        }
    }
    public PairingData(Builder builder) {
        this.saleID = builder.saleID;
        this.pairingPOIID = builder.pairingPOIID;
        this.kek = builder.kek;
        this.certificationCode = builder.certificationCode;
        this.posName = builder.posName;
        this.version = builder.version;
    }

    public static String CreateKEK()
    {
        Random r = new Random();
        char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        String result = "";
        for (int i = 0; i < 48; i++)
        {
            result += chars[r.nextInt(15)];
        }
        return result;
    }
}
