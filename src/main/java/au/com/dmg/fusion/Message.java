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
import au.com.dmg.fusion.request.SaleToPOIRequest;
import au.com.dmg.fusion.response.SaleToPOIResponse;
import au.com.dmg.fusion.util.BigDecimalAdapter;
import au.com.dmg.fusion.util.DefaultOnDataMismatchAdapter;
import au.com.dmg.fusion.util.InstantAdapter;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Message implements Serializable {
    @Json(name = "SaleToPOIRequest")
    private SaleToPOIRequest request = null;
    @Json(name = "SaleToPOIResponse")
    private SaleToPOIResponse response = null;
    @Json(name = "FusionSatelliteLibraryVersion")

    public static String FUSION_SATELLITE_VERSION = "1.3.28";

    public static String AXISPAY_PACKAGE_NAME = "au.com.dmg.axispay";
    public static String AXISPAY_LAUNCH = "au.com.dmg.axispay" + ".MainActivity";
    public static String INTENT_EXTRA_MESSAGE = "SaleToPOIJson";
    public static String INTENT_EXTRA_VERSION = "JsonVersion";
    public static String INTENT_EXTRA_APPLICATION_NAME = "ApplicationName";
    public static String INTENT_EXTRA_APPLICATION_VERSION = "SoftwareVersion";
    public static String INTENT_ACTION_SALETOPOI_REQUEST = AXISPAY_PACKAGE_NAME + ".action.SaleToPOIRequest";
    public static String INTENT_ACTION_BROADCAST =  AXISPAY_PACKAGE_NAME + ".Fusion.REQUEST";
    public static String INTENT_ACTION_BROADCAST_RECEIVER = AXISPAY_PACKAGE_NAME + ".Fusion.RESPONSE";
    public static String RETURN_TO_PACKAGE = "RETURN_TO_PACKAGE";

    public static String AXIS_PULL_UPDATE = AXISPAY_PACKAGE_NAME + ".action.UPDATE";
    public static String AXIS_RESULT_ACTIVITY = "OnUpdateFinishAction";
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
                .add(DefaultOnDataMismatchAdapter.newFactory(CustomFieldType.class, CustomFieldType.Unknown))
                .build();

        JsonAdapter<Message> jsonAdapter = moshi.adapter(Message.class);
        return jsonAdapter.nonNull().fromJson(jsonString);
    }

    @Override
    public String toString() {
        return toJson();
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
