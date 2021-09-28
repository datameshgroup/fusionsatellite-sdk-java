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

package au.com.dmg.fusion.securitytrailer;

import au.com.dmg.fusion.util.BigDecimalAdapter;
import au.com.dmg.fusion.request.paymentrequest.carddata.KEKIdentifier;
import au.com.dmg.fusion.util.InstantAdapter;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.junit.Test;

import java.io.IOException;

public class SecurityTrailerTest {
    @Test
    public void testToJson() {
        SecurityTrailer trailer = new SecurityTrailer(
                "id-ctauthData",
                new AuthenticatedData(
                        "v0",
                        new Recipient(
                                new KEK(
                                        "v4",
                                        new KEKIdentifier("SpecV2TestMACKey", "20191122164326.594"),
                                        new KeyEncryptionAlgorithm("des-ede3-cbc"),
                                        "834EAB305DD18724B9ADF361FC698CE0"
                                ),
                        new MACAlgorithm("id-retail-cbc-mac-sha-256"),
                        new EncapsulatedContent("iddata"),
                        "C5142F4DB828AA1C"
                )
        ));

        String json = trailer.toJson();
        System.out.println(json);
    }

    @Test
    public void testFromJson(){
        String json = "{\n" +
                "  \"ContentType\":\"id-ctauthData\",\n" +
                "  \"AuthenticatedData\":{\n" +
                "   \"Version\":\"v0\",\n" +
                " \"Recipient\":{\n" +
                "   \"KEK\":{\n" +
                "  \"Version\":\"v4\",\n" +
                "  \"KEKIdentifier\":{\n" +
                "    \"KeyIdentifier\":\"SpecV2TestMACKey\",\n" +
                "    \"KeyVersion\":\"20191122164326.594\"\n" +
                "  },\n" +
                "  \"KeyEncryptionAlgorithm\":{\n" +
                "    \"Algorithm\":\"des-ede3-cbc\"\n" +
                "  },\n" +
                "  \"EncryptedKey\":\"834EAB305DD18724B9ADF361FC698CE0\"\n" +
                "   },\n" +
                "   \"MACAlgorithm\":{\n" +
                "  \"Algorithm\":\"id-retail-cbc-mac-sha-256\"\n" +
                "   },\n" +
                "   \"EncapsulatedContent\":{\n" +
                "  \"ContentType\":\"iddata\"\n" +
                "   },\n" +
                "   \"MAC\":\"C5142F4DB828AA1C\"\n" +
                " }\n" +
                "  }\n" +
                "}";

        Moshi moshi = new Moshi.Builder()
                .add(new BigDecimalAdapter())
                .add(new InstantAdapter())
                .build();

        JsonAdapter<SecurityTrailer> jsonAdapter = moshi.adapter(SecurityTrailer.class);
        SecurityTrailer trailer = null;
        try {
            trailer = jsonAdapter.failOnUnknown().nonNull().fromJson(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert(trailer != null);
        assert(trailer.getContentType().equals("id-ctauthData"));
        assert(trailer.getAuthenticatedData().getVersion().equals("v0"));
        assert(trailer.getAuthenticatedData().getRecipient().getKek().getEncryptedKey().equals("834EAB305DD18724B9ADF361FC698CE0"));
    }
}