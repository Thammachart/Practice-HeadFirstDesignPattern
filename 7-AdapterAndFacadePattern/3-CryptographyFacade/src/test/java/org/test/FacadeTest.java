package org.test;

import org.junit.Test;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;

import java.util.Base64;

import org.des.DESFacade;

public class FacadeTest {

    @Test
    public void DESWithoutFacadeTest() {
        try {
            // Preparation
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            SecretKey secretKey = keyGenerator.generateKey();

            Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // Encryption
            byte[] plainTextBytes = "Attack at dawn!".getBytes();
            desCipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] cipherTextBytes = desCipher.doFinal(plainTextBytes);

            Base64.Encoder base64Encoder = Base64.getEncoder();
            String cipherTextString = base64Encoder.encodeToString(cipherTextBytes);

            System.out.println("DES Encryption Result: " + cipherTextString);

            // Decryption
            Base64.Decoder base64Decoder = Base64.getDecoder();
            cipherTextBytes = base64Decoder.decode(cipherTextString);
            desCipher.init(Cipher.DECRYPT_MODE, secretKey);
            plainTextBytes = desCipher.doFinal(cipherTextBytes);
            String plainText = new String(plainTextBytes);

            System.out.println("DES Decryption Result: " + plainText);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void DESWithFacadeTest() {
        // Preparation
        DESFacade facade = new DESFacade();

        // Encryption
        String cipherText = facade.encryptToBase64String("Attack at dawn!");
        System.out.println("DES Encryption Result: " + cipherText);

        // Decryption
        String plainText = facade.decryptBase64StringToPlainText(cipherText);
        System.out.println("DES Decryption Result: " + plainText);
    }
}
