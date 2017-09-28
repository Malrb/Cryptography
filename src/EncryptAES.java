import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

/**
 * Created by rb on 2017/9/29.
 */
public class EncryptAES {

    public byte[] Encrypt(SecretKey secretKey,byte[] iv, String msg){
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));
            byte[] cipherText = cipher.doFinal(msg.getBytes("UTF-8"));
            //Use AES to generate cipher
            return cipherText;
        }catch (Exception e){
            System.out.println(e.toString());
            System.out.println("Encrypt process Failed");
            return null;
        }
    }

    public String Decrypt(SecretKey secretKey, byte[] cipherText, byte[] iv){
        try{
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
            byte[] decryptText = cipher.doFinal(cipherText);
            String deStr = new String(decryptText);
            return deStr;
            //Return Decrypt result
        }catch (Exception e){
            System.out.println(e.toString());
            System.out.println("Decrypt process Failed");
            return null;
        }
    }

    public SecretKey generateKey(){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256, new SecureRandom());
            SecretKey secretKey = keyGenerator.generateKey();
            return secretKey;
        }catch (Exception e){
            System.out.println(e.toString());
            System.out.println("Key Generate process Failed");
            return null;
        }
    }
}
