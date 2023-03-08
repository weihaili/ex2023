package lnitcode.ex20230308;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 13:59
 */
public class RotateString {

    public static void main(String[] args) {
        RotateString demo = new RotateString();
        String s = "abcdefg";
        char[] chars = s.toCharArray();
        demo.rotateString(chars, 0);
        System.out.println(Arrays.toString(chars));
    }

    public void rotateString(char[] s, int offset) {
        if (s == null || s.length == 0) {
            return;
        }
        if (offset < 1) {
            return;
        }
        int len = s.length;
        int rf = offset % len;
        char[] res = new char[len];
        System.arraycopy(s, len - rf, res, 0, rf);
        System.arraycopy(s, 0, res, rf, len - rf);
        System.arraycopy(res, 0, s, 0, len);
    }
}
