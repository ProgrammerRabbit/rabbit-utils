package com.github.programmerrabbit.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yangwen on 2016/12/3.
 */
public class EncryptUtils {
    public static String MD5(String data) {
        return encrypt(data, "MD5");
    }

    public static String SHA1(String data) {
        return encrypt(data, "SHA1");
    }

    private static String encrypt(String data, String algorithm) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(data.getBytes());
            byte[] bytes = messageDigest.digest();
            return toHexString(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String toHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte theByte : bytes) {
            int theInt = (int) theByte;
            if (theInt < 0) {
                theInt = 256 + theInt;
            }
            if (theInt < 16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(theInt));
        }
        return sb.toString();
    }
}
