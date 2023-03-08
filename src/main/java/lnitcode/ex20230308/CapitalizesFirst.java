package lnitcode.ex20230308;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 14:35
 */
public class CapitalizesFirst {

    public static void main(String[] args) {
        CapitalizesFirst demo = new CapitalizesFirst();
        String str = demo.capitalizesFirst("i jidls    mdijf  i  lsidj  i p l   ");
        System.out.println(str);
    }

    public String capitalizesFirst(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        if (chars[0] >= 'a' && chars[0] <= 'z') {
            chars[0] &= -33;
        }
        for (int i = 1; i < n; i++) {
            if (chars[i - 1] == ' ' && chars[i] != ' ') {
                chars[i] -= 32;
            }
        }
        return String.valueOf(chars);
    }

    public String capitalizesFirst1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder buf = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (false) {

            }
        }
        return buf.toString();
    }
}
