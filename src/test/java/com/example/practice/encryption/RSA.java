package com.example.practice.encryption;

import org.bouncycastle.openssl.EncryptionException;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSA {

    public static String encrypt(String content, Key key) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(1, key);
            return Base64.getEncoder().encodeToString(cipher.doFinal(content.getBytes("UTF-8")));
        } catch (Exception var3) {
            throw new RuntimeException("RSA encrypt failed!", var3);
        }
    }

    public static String decrypt(String content, Key key) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(2, key);
            return new String(cipher.doFinal(Base64.getDecoder().decode(content)), StandardCharsets.UTF_8);
        } catch (Exception var3) {
//            throw new EncryptionException("RSA decrypt failed!", var3);
            throw new RuntimeException("RSA decrypt failed!", var3);
        }
    }

    public static RSAPublicKey getPublicKey(String publicKey) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey)));
        } catch (Exception var2) {
            throw new RuntimeException("RSA get Public Key failed!", var2);
        }
    }

    public static RSAPrivateKey getPrivateKey(String privateKey) {
        try {
            return (RSAPrivateKey)KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey)));
        } catch (Exception var2) {
            throw new RuntimeException("RSA get Private Key failed!", var2);
        }
    }
}
