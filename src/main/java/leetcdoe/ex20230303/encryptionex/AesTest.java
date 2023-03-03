package leetcdoe.ex20230303.encryptionex;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Locale;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/3 9:44
 */
public class AesTest {

    public static void main(String[] args) {
        AesTest demo = new AesTest();
        String key = "123456";
        String pwd = "123456";
        String encodeStr = demo.encode(key, pwd);
        System.out.println(encodeStr);

        String decodeStr = demo.decode(key, encodeStr);
        System.out.println(decodeStr);
    }

    private String decode(String key, String encodeStr) {
        byte[] res = null;
        byte[] content = parseHexStr2Byte(key);
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(encodeStr.getBytes(StandardCharsets.UTF_8));
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec keySpec = new SecretKeySpec(enCodeFormat, "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            res = cipher.doFinal(content);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        }
        return new String(res);
    }

    private byte[] parseHexStr2Byte(String key) {
        if (key.isEmpty()) {
            return null;
        }
        byte[] res = new byte[key.length() >> 1];
        for (int i = 0; i < key.length() >> 1; i++) {
            int high = Integer.parseInt(key.substring(i << 1, (i << 1) + 1), 16);
            int low = Integer.parseInt(key.substring((i << 1) + 1, (i << 1) + 2), 16);
            res[i] = (byte)((high << 4) + low);
        }
        return res;
    }

    private String encode(String key, String pwd) {
        byte[] res = null;
        try {
            KeyGenerator aes = KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(pwd.getBytes(StandardCharsets.UTF_8));
            aes.init(128, random);
            SecretKey secretKey = aes.generateKey();
            byte[] encoded = secretKey.getEncoded();

            SecretKeySpec keySks = new SecretKeySpec(encoded, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, keySks);
            byte[] keyContent = key.getBytes();
            res = cipher.doFinal(keyContent);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        }

        return parseByte2HexStr(res);
    }

    private String parseByte2HexStr(byte[] res) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < res.length; ++i) {
            String hex = Integer.toHexString(res[i] & 0xFf);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            buf.append(hex.toUpperCase(Locale.ROOT));
        }
        return buf.toString();
    }
}
