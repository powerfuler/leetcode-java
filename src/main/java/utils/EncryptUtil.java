/*
 *  Copyright (c) 2013 The CCP project authors. All Rights Reserved.
 *
 *  Use of this source code is governed by a Beijing Speedtong Information Technology Co.,Ltd license
 *  that can be found in the LICENSE file in the root of the web site.
 *
 *   http://www.cloopen.com
 *
 *  An additional intellectual property rights grant can be found
 *  in the file PATENTS.  All contributing project authors may
 *  be found in the AUTHORS file in the root of the source tree.
 */
package utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

@SuppressWarnings("restriction")
public class EncryptUtil {

    private static final Charset UTF_8 = StandardCharsets.UTF_8;

    /**
     * MD5数字签名 
     */
    public static String md5Digest(String src) throws Exception {
        // 定义数字签名方法, 可用：MD5, SHA-1
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] b = md.digest(src.getBytes(UTF_8));
        return byte2HexStr(b);
    }

    /**
     * BASE64编码
     */
    public static String base64Encoder(String src) {
        return Base64.getEncoder().encodeToString(src.getBytes(UTF_8));
    }

    /**
     * BASE64解码
     */
    public static String base64Decoder(String dest) {
        return new String(Base64.getDecoder().decode(dest), UTF_8);
    }

    /**
     * 字节数组转化为大写16进制字符串 
     */
    private static String byte2HexStr(byte[] b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            String s = Integer.toHexString(b[i] & 0xFF);
            if (s.length() == 1) {
                sb.append("0");
            }
            sb.append(s.toUpperCase());
        }
        return sb.toString();
    }

    public static byte[] aesEncrypt(String secretKey, byte[] data) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(UTF_8), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new EncryptionException(e);
        }
    }

    public static byte[] aesDecrypt(String secretKey, byte[] data) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(UTF_8), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new EncryptionException(e);
        }
    }

    public static class EncryptionException extends RuntimeException {
        public EncryptionException(Throwable cause) {
            super(cause);
        }
    }
}






