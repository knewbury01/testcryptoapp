import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.InvalidAlgorithmParameterException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;

public class Test {

    public static void main(String args[])
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] plain = ("test plaintext").getBytes();
        byte[] iv = ("hardcodedIV").getBytes();

        KeyGenerator g = KeyGenerator.getInstance("AES");
        g.init(128);
        Key k = g.generateKey();

        Cipher enc = Cipher.getInstance("AES/CBC/NoPadding");
        byte[] ct;
        enc.init(Cipher.ENCRYPT_MODE, k, new IvParameterSpec(iv));
        ct = enc.doFinal(plain);
    }
}