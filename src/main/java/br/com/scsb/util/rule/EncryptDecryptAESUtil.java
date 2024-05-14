package br.com.scsb.util.rule;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;

public class EncryptDecryptAESUtil {
    public static String generateSecretKey() {
        return UUID.randomUUID().toString();
    }

    public static String encrypt(String secretKey, String plaintext, String cipherChosen) throws GeneralSecurityException {
        IvParameterSpec iv = generateIv();
        Cipher cipher = getCipher(cipherChosen);
        cipher.init(Cipher.ENCRYPT_MODE, getKeySpec(secretKey), iv);
        byte[] cipherText = cipher.doFinal(plaintext.getBytes());
        String var10000 = Base64.getEncoder().encodeToString(iv.getIV());
        return var10000 + Base64.getEncoder().encodeToString(cipherText);
    }

    public static String decrypt(String secretKey, String encrypted, String cipherChosen) throws GeneralSecurityException {
        byte[] iv = Base64.getDecoder().decode(encrypted.substring(0, 24));
        Cipher cipher = getCipher(cipherChosen);
        cipher.init(Cipher.DECRYPT_MODE, getKeySpec(secretKey), new IvParameterSpec(iv));
        byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted.substring(24)));
        return new String(original);
    }

    private static IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        (new SecureRandom()).nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    private static SecretKeySpec getKeySpec(String secretKey) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return new SecretKeySpec(digest.digest(secretKey.getBytes(StandardCharsets.UTF_8)), "AES");
    }

    private static Cipher getCipher(String cipherChosen) throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance(cipherChosen);
    }
}
