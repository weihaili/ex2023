package leetcdoe.ex20230302.shirodemo;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/2 16:38
 */
public class EncryptionTest {

    public static void main(String[] args) {
        String password = "123456";
        String encodePassword = new Md5Hash(password).toString();
        System.out.println(encodePassword);

        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        System.out.println(salt);
        int time = 2;
        String alogrithmName = "md5";
        String encodePassword2 = new SimpleHash(alogrithmName, password, salt, time).toString();
        System.out.println(encodePassword2);
    }
}
