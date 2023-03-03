package leetcdoe.ex20230303.encryptionex;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/3 9:04
 */
public class Md5Test {

    public static void main(String[] args) {
        Md5Test md5 = new Md5Test();
        String password = "123456";
        System.out.println(md5.encode(password));
    }

    public String encode(String str) {
        byte[] res = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes("UTF-8"));
            res = md5.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return parseByte2HexStr(res);
    }

    private String parseByte2HexStr(byte[] buf) {
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < buf.length; ++i) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            bf.append(hex.toUpperCase(Locale.ROOT));
        }
        return bf.toString();
    }
}
