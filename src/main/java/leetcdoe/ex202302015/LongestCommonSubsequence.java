package leetcdoe.ex202302015;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/15 17:52
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        LongestCommonSubsequence demo = new LongestCommonSubsequence();
        int len = demo.longestCommonSubsequence("abc", "abdabcd");
        System.out.println(len);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; ++j) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
