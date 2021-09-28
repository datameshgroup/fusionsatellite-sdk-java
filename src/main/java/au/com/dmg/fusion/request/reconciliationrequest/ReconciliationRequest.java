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

package au.com.dmg.fusion.request.reconciliationrequest;

import au.com.dmg.fusion.util.BigDecimalAdapter;
import au.com.dmg.fusion.request.Request;
import au.com.dmg.fusion.util.InstantAdapter;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

public class ReconciliationRequest implements Request {
    @Json(name = "ReconciliationType")
    private final String reconciliationType;
    @Json(name = "POIReconciliationID")
    private final String POIReconciliationID;

    public ReconciliationRequest(String reconciliationType, String POIReconciliationID) {
        this.reconciliationType = reconciliationType;
        this.POIReconciliationID = POIReconciliationID;
    }

    public String getReconciliationType() {
        return reconciliationType;
    }

    public String getPOIReconciliationID() {
        return POIReconciliationID;
    }

    @Override
    public String toJson() {
        Moshi moshi = new Moshi.Builder()
                .add(new BigDecimalAdapter())
                .add(new InstantAdapter())
                .build();
        JsonAdapter<ReconciliationRequest> jsonAdapter = moshi.adapter(ReconciliationRequest.class);
        return jsonAdapter.toJson(this);
    }
}
