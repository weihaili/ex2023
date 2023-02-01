package leetcdoe.ex20230201;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/1 16:29
 */
public class IsFlipedString {
    public static void main(String[] args) {
        IsFlipedString demo = new IsFlipedString();
        boolean flag = demo.isFlipedString("abc", "bca");
        System.out.println(flag);
    }

    public boolean isFlipedString(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }

    public boolean isFlipedString1(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            boolean flag = true;
            for (int j = 0; j < len; j++) {
                if (s1.charAt((i + j) % len) != s2.charAt((j))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
