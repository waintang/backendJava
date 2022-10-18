package com.example.practice.encryption;

import org.apache.commons.lang.StringUtils;
import org.bouncycastle.openssl.EncryptionException;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;

public class RsaTest {
    private static String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJL0JkqsUoK6kt3JyogsgqNp9VDGDp+t3ZAGMbVoMPdHNT2nfiIVh9ZMNHF7g2XiAa8O8AQWyh2PjMR0NiUSVQMCAwEAAQ==";
    private static String privateKey = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAkvQmSqxSgrqS3cnKiCyCo2n1UMYOn63dkAYxtWgw90c1Pad+IhWH1kw0cXuDZeIBrw7wBBbKHY+MxHQ2JRJVAwIDAQABAkB3TKXZcVP6tSSN0UgOjLPxng99Z4xvrWJ1jdHFB7TYyUDcnOtE6GkeeMGxtszYtuZ0m5rN9r8eRvIdVUciXbQhAiEA7WGcLd+cvHHA8xNFrbT78Aq4iYm0TVTS6m05ZEOS328CIQCeetcFV8Kdb+P2Y+yWvMtbyFGhROQIFizvxM3S3TiZrQIhAJLrYPB7f9SaSyOm/+89Htk4qXJmyjM6lrgFFgpaUGL9AiB+pkCr/mSDGOYfA+AQ3rPNl5rUvI9XfxFOVAMAntYayQIhAO0hrnwtng6Ubs+58BN69vAl+sd/xugf0jsHcNgZppAb";
    public static void main(String[] args) {

        String encryptPwd = encrypt("ZXCVBNM");
        System.out.println(encryptPwd);
        String decryptPwd = decrypt(encryptPwd);
        System.out.println(decryptPwd);
    }

    public static String encrypt(String content) {
        if (StringUtils.isBlank(content)) {
            return content;
        } else {
            try {
                return RSA.encrypt(content, RSA.getPublicKey(publicKey));
            } catch (Exception var3) {
                System.out.println("encrypt content error, will return content directly! ex={}, content={}"+var3.getMessage()+ content);
                return content;
            }
        }
    }

    public static String decrypt(String content) {
        if (StringUtils.isBlank(content)) {
            return content;
        } else {
            try {
                return RSA.decrypt(content, RSA.getPrivateKey(privateKey));
            } catch (Exception var3) {
                System.out.println("decrypt content error, will return content directly! ex={}, content={}"+ var3.getMessage()+ content);
                return content;
            }
        }
    }

}
