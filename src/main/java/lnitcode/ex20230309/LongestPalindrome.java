package lnitcode.ex20230309;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/9 9:15
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome demo = new LongestPalindrome();
        String res = demo.longestPalindrome("a");
        System.out.println(res);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        int maxLen = 0;
        String res = "";
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; j++) {
                String str = s.substring(i, j + 1);
                if (isPalindrome(str)) {
                    if (str.length() > maxLen) {
                        maxLen = str.length();
                        res = str;
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int startIdx = 0;
        int endIdx = str.length() - 1;
        while (startIdx <= endIdx) {
            if (str.charAt(startIdx) != str.charAt(endIdx)) {
                return false;
            }
            ++startIdx;
            --endIdx;
        }
        return true;
    }
}
