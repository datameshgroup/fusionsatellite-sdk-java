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

package au.com.dmg.fusion.data;

import com.squareup.moshi.Json;

public enum PaymentBrand {
    @Json(name = "VISA") VISA,
    Mastercard,
    @Json(name = "American Express") AmericanExpress,
    @Json(name = "Diners Club") DinersClub,
    JCB,
    @Json(name = "UnionPay") UnionPay,
    @Json(name = "CUP Debit") CUPDebit,
    Discover,
    Debit,
    AliPay,
    @Json(name = "WeChat Pay") WeChatPay,
    Card,
    @Json(name = "CryptoDotCom") CryptoDotCom,
    @Json(name = "BPGiftCard") BPGiftCard,
    @Json(name = "QantasPoints") QantasPoints,
    @Json(name = "DRCDollars") DRCDollars,
    @Json(name = "Cash") Cash,

    @Json(name = "Fastcard") Fastcard, //Cabcharge Fast Card
    @Json(name = "eTicket") eTicket,
    @Json(name = "Digital Product") DigitalProduct, //CabCharge DigitalPass, Digital Fast Card
    @Json(name = "ACT TSS") ACTTSS,
    @Json(name = "NSW TSS") NSWTSS,
    @Json(name = "NT TSS") NTTSS,
    @Json(name = "QLD TSS") QLDTSS,
    @Json(name = "SA TSS") SATSS,
    @Json(name = "TAS TSS") TASTSS,
    @Json(name = "VIC TSS") VICTSS,
    @Json(name = "WA TSS") WATSS,

    Other
}
