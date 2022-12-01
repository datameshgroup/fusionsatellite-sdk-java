/*
 * Copyright (c) 2021. DatameshGroup
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package au.com.dmg.fusion;

import au.com.dmg.fusion.data.*;
import au.com.dmg.fusion.request.Request;
import au.com.dmg.fusion.request.SaleToPOIRequest;
import au.com.dmg.fusion.request.paymentrequest.carddata.KEKIdentifier;
import au.com.dmg.fusion.response.SaleToPOIResponse;
import au.com.dmg.fusion.securitytrailer.*;
import au.com.dmg.fusion.util.BigDecimalAdapter;
import au.com.dmg.fusion.util.Crypto;
import au.com.dmg.fusion.util.DefaultOnDataMismatchAdapter;
import au.com.dmg.fusion.util.InstantAdapter;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.Moshi;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Message implements Serializable {
    @Json(name = "SaleToPOIRequest")
    private SaleToPOIRequest request = null;
    @Json(name = "SaleToPOIResponse")
    private SaleToPOIResponse response = null;
    @Json(name = "FusionSatelliteLibraryVersion")
    public static String FUSION_SATELLITE_VERSION = "1.2.0";

    public static String INTENT_EXTRA_MESSAGE = "SaleToPOIJson";
    public static String INTENT_EXTRA_VERSION = "JsonVersion";
    public static String INTENT_EXTRA_APPLICATION_NAME = "ApplicationName";
    public static String INTENT_EXTRA_APPLICATION_VERSION = "SoftwareVersion";
    public static String INTENT_ACTION_SALETOPOI_REQUEST = "au.com.dmg.axispay.action.SaleToPOIRequest";
    public static String AXISPAY_PACKAGE_NAME = "au.com.dmg.axispay";
    public static int INTENT_REQUEST_CODE = 100;

    public Message(SaleToPOIRequest request) {
        this.request = request;
    }

    public Message(SaleToPOIResponse response) {
        this.response = response;
    }

    public SaleToPOIRequest getRequest() {
        return request;
    }

    public SaleToPOIResponse getResponse() {
        return response;
    }

    public String toJson() {
        Moshi moshi = new Moshi.Builder()
                .add(new BigDecimalAdapter())
                .add(new InstantAdapter())
                .build();
        JsonAdapter<Message> jsonAdapter = moshi.adapter(Message.class);
        return jsonAdapter.toJson(this);
    }

    public static Message fromJson(String jsonString) throws IOException, JsonDataException {
        Moshi moshi = new Moshi.Builder()
                .add(new BigDecimalAdapter())
                .add(new InstantAdapter())
                .add(DefaultOnDataMismatchAdapter.newFactory(Account.class, Account.Unknown))
                .add(DefaultOnDataMismatchAdapter.newFactory(EntryMode.class, EntryMode.Unknown))
                .add(DefaultOnDataMismatchAdapter.newFactory(ErrorCondition.class, ErrorCondition.Unknown))
                .add(DefaultOnDataMismatchAdapter.newFactory(PaymentBrand.class, PaymentBrand.Other))
                .add(DefaultOnDataMismatchAdapter.newFactory(PaymentInstrumentType.class, PaymentInstrumentType.Other))
                .add(DefaultOnDataMismatchAdapter.newFactory(UnitOfMeasure.class, UnitOfMeasure.Other))
                .add(DefaultOnDataMismatchAdapter.newFactory(MessageCategory.class, MessageCategory.Other))
                .add(DefaultOnDataMismatchAdapter.newFactory(ReversalReason.class, ReversalReason.Unknown))
                .add(DefaultOnDataMismatchAdapter.newFactory(LoyaltyBrand.class, LoyaltyBrand.Unknown))
                .add(DefaultOnDataMismatchAdapter.newFactory(CurrencySymbol.class, CurrencySymbol.Unknown))
                .add(DefaultOnDataMismatchAdapter.newFactory(IdentificationType.class, IdentificationType.Unknown))
                .add(DefaultOnDataMismatchAdapter.newFactory(IdentificationSupport.class, IdentificationSupport.Unknown))
                .add(DefaultOnDataMismatchAdapter.newFactory(LoyaltyUnit.class, LoyaltyUnit.Unknown))
                .build();

        JsonAdapter<Message> jsonAdapter = moshi.adapter(Message.class);
        return jsonAdapter.nonNull().fromJson(jsonString);
    }

    @Override
    public String toString() {
        return toJson();
    }

    public void populateSecurityTrailer(String KEK, String keyIdentifier, String keyVersion) throws InvalidAlgorithmParameterException, UnsupportedEncodingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeySpecException, InvalidKeyException {
        if(this.request == null){
            throw new IllegalStateException("No Request Available. Security Trailer generation only supported for SaleToPOIRequest.");
        }
        Request myRequest = this.request.getRequest();
        if(myRequest == null){
            throw new IllegalStateException("No Request available inside SaleToPOIRequest");
        }
        String requestJson = this.request.toJson();
        byte[] key = Crypto.generate16ByteKey();
        byte[] encryptedKey = Crypto.generateEncryptedKey(key, KEK);
        String encryptedHexKey = Crypto.byteArrayToHexString(encryptedKey);

        String macBody = buildMACBody(this.request.getMessageHeader(), this.request.getRequest());
        String hexKey = Crypto.byteArrayToHexString(key);
        String MAC = Crypto.generateMAC(macBody, hexKey).toUpperCase();

        // Security Trailer
        KEK kek = new KEK("v4", //
                new KEKIdentifier(keyIdentifier, keyVersion), //
                new KeyEncryptionAlgorithm("des-ede3-cbc"), //
                encryptedHexKey);

        Recipient recipient = new Recipient(kek, //
                new MACAlgorithm("id-retail-cbc-mac-sha-256"), //
                new EncapsulatedContent("iddata"), //
                MAC);

        AuthenticatedData authenticatedData = new AuthenticatedData("v0", recipient);

        SecurityTrailer securityTrailer = new SecurityTrailer("id-ctauthData", authenticatedData);
        //todo.
        SaleToPOIRequest newRequest = new SaleToPOIRequest.Builder()
                .request(this.request.getRequest())
                .messageHeader(this.request.getMessageHeader())
                .securityTrailer(securityTrailer)
                .build();
        this.request = newRequest;
    }

    private String buildMACBody(MessageHeader messageHeader, Request request) {
        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<MessageHeader> jsonAdapter = moshi.adapter(MessageHeader.class);
        String macBody = String.format("\"MessageHeader\":%s,\"%sRequest\":%s", jsonAdapter.toJson(messageHeader),
                messageHeader.getMessageCategory(), request.toJson());

        return macBody;
    }

    private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException {
        String json = aInputStream.readUTF();
        Message message = Message.fromJson(json);
        this.response = message.getResponse();
        this.request = message.getRequest();
    }

    private void writeObject(ObjectOutputStream aOutputStream) throws IOException {
        aOutputStream.writeUTF(this.toJson());
    }
}
