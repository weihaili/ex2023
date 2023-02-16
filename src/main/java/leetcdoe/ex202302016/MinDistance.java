package leetcdoe.ex202302016;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/16 14:29
 */
public class MinDistance {

    public static void main(String[] args) {
        MinDistance demo = new MinDistance();
        int cnt = demo.minDistance("intention", "execution");
        System.out.println(cnt);
    }

    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        }
        if ((word1 == null || word1.length() == 0) && word2 != null) {
            return word2.length();
        }
        if (word1 != null  && (word2 == null || word1.length() == 0)) {
            return word1.length();
        }
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; ++i) {
            dp[0][i] = i;
        }
        for (int i = 1; i < m + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                int ln = dp[i - 1][j] + 1;
                int dn = dp[i][j - 1] + 1;
                int lnd = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    lnd += 1;
                }
                dp[i][j] = Math.min(ln, Math.min(dn, lnd));
            }
        }
        return dp[m][n];
    }
}
