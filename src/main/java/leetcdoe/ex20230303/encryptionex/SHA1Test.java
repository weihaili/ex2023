package leetcdoe.ex20230303.encryptionex;

import org.apache.commons.codec.binary.Hex;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/3 9:22
 */
public class SHA1Test {

    public static void main(String[] args) {
        SHA1Test demo = new SHA1Test();
        String password = "123456";
        System.out.println(demo.encode(password));
    }

    private String encode(String password) {
        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            sha1.update(password.getBytes("UTF-8"));
            byte[] digest = sha1.digest();
            return byteToHexString(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private String byteToHexString(byte[] bytes) {
        return String.valueOf(Hex.encodeHex(bytes));
    }
}
