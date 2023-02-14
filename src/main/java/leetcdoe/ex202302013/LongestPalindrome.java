package leetcdoe.ex202302013;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/13 11:28
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome demo = new LongestPalindrome();
        String subStr = demo.longestPalindrome1("ababc");
        System.out.println(subStr);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; ++i) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        for (int lg = 2; lg <= len; ++lg) {
            for (int i = 0; i < len; ++i) {
                int endIdx = lg + i - 1;
                if (endIdx >= len) {
                    break;
                }

                if (chars[i] != chars[endIdx]) {
                    dp[i][endIdx] = false;
                } else {
                    if (endIdx - i < 3) {
                        dp[i][endIdx] = true;
                    } else {
                        dp[i][endIdx] = dp[i + 1][endIdx - 1];
                    }
                }
                if (dp[i][endIdx] && endIdx - i + 1 > maxLen) {
                    maxLen = endIdx - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); ++i) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start =  i - ((len -1) >> 1);
                end = i + (len >> 1);
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String str, int ln, int rn) {
        while (ln >= 0 && rn < str.length() && str.charAt(ln) == str.charAt(rn)) {
            --ln;
            ++rn;
        }
        return rn - ln - 1;
    }
}
