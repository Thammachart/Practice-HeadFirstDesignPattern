package org.des;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;
import java.security.NoSuchAlgorithmException;

import java.util.Base64;

public class DESFacade {

    private Cipher cipher;
    private SecretKey secretKey;

    public DESFacade() {
        this(null);
    }

    public DESFacade(SecretKey secretKey) {
        try {
            cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            this.secretKey = secretKey;

            if(secretKey == null) {
                this.secretKey = getDESKeyGenerator().generateKey();
            }
        } catch(Exception e) {
            throw new RuntimeException("Error on Initializing the Facade", e);
        }
    }

    public String encryptToBase64String(String plainText) {
        try {
            byte[] plainTextBytes = plainText.getBytes();
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] cipherTextBytes = cipher.doFinal(plainTextBytes);

            return getBase64Encoder().encodeToString(cipherTextBytes);
        } catch(Exception e) {
            throw new RuntimeException("Error on Encrypting the PlainText", e);
        }
    }

    public String decryptBase64StringToPlainText(String ciperText) {
        try {
            byte[] cipherTextBytes = getBase64Decoder().decode(ciperText);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] plainTextBytes = cipher.doFinal(cipherTextBytes);

            return new String(plainTextBytes);
        } catch(Exception e) {
            throw new RuntimeException("Error on Decrypting the CipherText", e);
        }
    }

    public SecretKey getSecretKey() {
        return this.secretKey;
    }

    private KeyGenerator getDESKeyGenerator() throws NoSuchAlgorithmException {
        return KeyGenerator.getInstance("DES");
    }

    private Base64.Encoder getBase64Encoder() {
        return Base64.getEncoder();
    }

    private Base64.Decoder getBase64Decoder() {
        return Base64.getDecoder();
    }
}
