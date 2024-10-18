package org.example.cuttingdown.common.util;

import cn.hutool.crypto.digest.MD5;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

public class EncryptUtils {
    public static String encryptWithSalt(String password) {
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);

        MD5 md5 = new MD5(salt);
        byte[] hashedPassword = md5.digest(password.getBytes(StandardCharsets.UTF_8));

        byte[] combined = new byte[salt.length + hashedPassword.length];
        System.arraycopy(salt, 0, combined, 0, salt.length);
        System.arraycopy(hashedPassword, 0, combined, salt.length, hashedPassword.length);
        return Base64.getEncoder().encodeToString(combined);
    }

    public static boolean verifyPassword(String password, String encryptedPassword) {
        byte[] decoded = Base64.getDecoder().decode(encryptedPassword);
        byte[] salt = new byte[16];
        System.arraycopy(decoded, 0, salt, 0, salt.length);

        MD5 md5 = new MD5(salt);
        byte[] hashedPassword = md5.digest(password.getBytes(StandardCharsets.UTF_8));

        byte[] expectedHashedPassword = new byte[decoded.length - salt.length];
        System.arraycopy(decoded, salt.length, expectedHashedPassword, 0, expectedHashedPassword.length);

        return java.util.Arrays.equals(hashedPassword, expectedHashedPassword);
    }
}
