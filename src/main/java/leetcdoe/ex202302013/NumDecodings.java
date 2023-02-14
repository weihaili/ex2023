package leetcdoe.ex202302013;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/13 12:21
 */
public class NumDecodings {

    public static void main(String[] args) {
        NumDecodings demo = new NumDecodings();
        int cnt = demo.numDecodings1("112");
        System.out.println(cnt);

    }

    public int numDecodings1(String s) {
        if (s == null) {
            return 0;
        }
        int len = s.length();
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 1; i <= len; ++i) {
            c = 0;
            if (s.charAt(i - 1) != '0') {
                c += b;
            }
            if (i > 1 && s.charAt(i - 2) != '0' &&((s.charAt(i - 2) -'0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                c += a;
            }
            a = b;
            b = c;
        }
        return c;
    }

    public int numDecodings(String s) {
        if (s == null) {
            return 0;
        }
        int len = s.length();
        if (len == 0) {
            return 1;
        }
        int[] ways = new int[len + 1];
        ways[0] = 1;
        for (int i = 1; i <= len; ++i) {
            if (s.charAt(i - 1) != '0') {
                ways[i] += ways[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                ways[i] += ways[i - 2];
            }
        }
        return ways[len];
    }
}
