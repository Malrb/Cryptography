import javax.crypto.SecretKey;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;

/**
 * Created by rb on 2017/9/29.
 */
public class PlainText {

    String plainText = null;

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string you want to encrypt: ");
        String str = scanner.nextLine();

        EncryptAES aes = new EncryptAES();
        //parameters must be 16 length
        byte[] iv = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(iv);

        //Key generate
        SecretKey secretKey = aes.generateKey();

        //Encrypt
        byte[] ret = aes.Encrypt(secretKey, iv, str);
        System.out.println("Encrypt result with Base64: " + Base64.getEncoder().encodeToString(ret));

        //Decrypt
        String retStr = aes.Decrypt(secretKey, ret, iv);
        System.out.println("Decrypt result: " + retStr);

        if(str.equals(retStr)){
            System.out.println("Decrypt Success");
        }else{
            System.out.println("Decrypt Failed");
        }
    }
}
