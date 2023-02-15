package leetcdoe.ex202302015;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/15 18:10
 */
public class MinDistance {

    public static void main(String[] args) {
        MinDistance demo = new MinDistance();
        int step = demo.minDistance("ab", "a");
        System.out.println(step);
    }

    public int minDistance1(String word1, String word2) {
        if ((word1 == null || word1.length() == 0) && (word2 == null || word1.length() == 0)) {
            return 0;
        }
        if ((word1 == null || word1.length() == 0) && (word2 != null && word2.length() > 0)) {
            return word2.length();
        }
        if ((word1 != null || word1.length() > 0) && (word2 == null || word2.length() == 0)) {
            return word1.length();
        }
        for (int i = 0; i < word1.length(); ++i) {
            char c1 = word1.charAt(i);
            for (int j = 0; j < word2.length(); ++j) {
                if (c1 == word2.charAt(j)) {
                    word1.replace(c1, ' ');
                    word2.replace(c1, ' ');
                    break;
                }
            }
        }
        word1.replaceAll(" ", "");
        word2.replaceAll(" ", "");
        return word1.length() + word2.length();

    }

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

}
