/*
 * Copyright (c) 2022. DatameshGroup
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

package au.com.dmg.fusion.util;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;

public class Crypto {
    private static final String ENCODING = "UTF-8";

    private static final String SECRET_KEY_ALGORITHM = "DESede";

    private static final String MESSAGE_DIGEST_ALGORITHM = "SHA-256";

    private static final String CIPHER_MODE = "DESede/CBC/NoPadding";

    public static byte[] generate16ByteKey() {
        final SecureRandom random = new SecureRandom();
        final byte[] randomKey = new byte[16];
        random.nextBytes(randomKey);
        return randomKey;
    }

    public static byte[] generateEncryptedKey(byte[] randomKey, String KEK) throws InvalidAlgorithmParameterException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        return crypt(Cipher.ENCRYPT_MODE, randomKey, KEK);
    }

    public static byte[] crypt(int operation, byte[] value, String key) throws InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException {
        byte[] keyBytes = hexStringToByteArray(key);

        // add 8 bytes to satisfy key length requirement
        if (keyBytes.length == 16) {
            byte[] tmpKey = new byte[24];
            System.arraycopy(keyBytes, 0, tmpKey, 0, 16);
            System.arraycopy(keyBytes, 0, tmpKey, 16, 8);
            keyBytes = tmpKey;
        }

        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[8]);
        SecretKey secretKey = new SecretKeySpec(keyBytes, SECRET_KEY_ALGORITHM);
        Cipher cipherEncrpyt = Cipher.getInstance(CIPHER_MODE);
        cipherEncrpyt.init(operation, secretKey, ivParameterSpec);

        return cipherEncrpyt.doFinal(value);
    }

    public static String generateMAC(String request, String randomKeyHex) throws UnsupportedEncodingException,
            NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException,
            IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {

        byte[] hashResults = getSHA(request);
        byte[] hashAppendedBytes = append8Bytes(hashResults);
        byte[] encrypt = crypt(Cipher.ENCRYPT_MODE, hashAppendedBytes, randomKeyHex);
        byte[] last8bytes = getLast8Bytes(encrypt);

        return byteArrayToHexString(last8bytes);
    }

    private static byte[] getSHA(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return MessageDigest.getInstance(MESSAGE_DIGEST_ALGORITHM).digest(input.getBytes(ENCODING));
    }

    private static byte[] append8Bytes(byte[] hash) {
        byte[] resultArray = new byte[hash.length + 8];
        System.arraycopy(hash, 0, resultArray, 0, hash.length);
        resultArray[32] = (byte) ((Character.digit('8', 16) << 4) + Character.digit('0', 16));

        for (int i = 33; i < 40; i++) {
            resultArray[i] = Byte.parseByte("00");
        }

        return resultArray;
    }

    private static byte[] getLast8Bytes(byte[] encrypt) {
        byte[] byteArray = new byte[8];

        System.arraycopy(encrypt, encrypt.length - 8, byteArray, 0, 8);

        return byteArray;
    }

    public static String byteArrayToHexString(final byte[] byteArray) {
        final StringBuilder hex = new StringBuilder(byteArray.length * 2);

        for (final byte b : byteArray) {
            hex.append(String.format("%02x", 0xff & b));
        }

        return hex.toString();
    }

    public static byte[] hexStringToByteArray(String hex) {
        byte[] byteArray = new byte[hex.length() / 2];

        for (int i = 0; i < byteArray.length; i++) {
            int index = i * 2;
            int dataBytes = Integer.parseInt(hex.substring(index, index + 2), 16) & 0xff;
            byteArray[i] = (byte) dataBytes;
        }

        return byteArray;
    }
}
