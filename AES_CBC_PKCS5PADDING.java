import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * Created by rb on 2017/9/27.
 */
public class AES_CBC_PKCS5PADDING {
    public static byte[] Encrypt(SecretKey secretKey, byte[] iv, String msg) throws Exception{
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));
        System.out.println("AES_CBC_PKCS5PADDING IV:"+cipher.getIV());
        System.out.println("AES_CBC_PKCS5PADDING Algoritm:"+cipher.getAlgorithm());
        byte[] byteCipherText = cipher.doFinal(msg.getBytes("UTF-8"));
        System.out.println("加密結果的Base64編碼：" + Base64.getEncoder().encodeToString(byteCipherText));

        return byteCipherText;
    }

    public static void Decrypt(SecretKey secretKey, byte[] cipherText, byte[] iv) throws Exception{
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
        byte[] decryptedText = cipher.doFinal(cipherText);
        String strDecryptedText = new String(decryptedText);
        System.out.println("解密結果：" + strDecryptedText);
    }

    public static void main(String args[]) throws Exception{
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256,new SecureRandom( ) );
        SecretKey secretKey = keyGen.generateKey();
        byte[] iv = new byte[16];
        SecureRandom prng = new SecureRandom();
        prng.nextBytes(iv);

        byte[] cipher = AES_CBC_PKCS5PADDING.Encrypt(secretKey, iv, "Hello YoEn, Im Chishen! Can you hear me?");
        System.out.println(cipher);
        AES_CBC_PKCS5PADDING.Decrypt(secretKey, cipher, iv);
    }
}
