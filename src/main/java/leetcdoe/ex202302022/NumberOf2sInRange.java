package leetcdoe.ex202302022;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/22 15:35
 */
public class NumberOf2sInRange {

    public static void main(String[] args) {
        NumberOf2sInRange demo = new NumberOf2sInRange();
        int cnt = demo.numberOf2sInRange(25);
        System.out.println(cnt);
    }

    public int numberOf2sInRange(int n) {
        if (n == 0) {
            return 0;
        }
        int digit = (int)Math.log(n) + 1;
        int[][] dp = new int[digit + 1][2];
        dp[1][0] = n % 10 >= 2 ? 1 : 0;
        dp[1][1] = 1;
        for (int i = 2; i <= digit; ++i) {
            int k = n / ((int)Math.pow(10, i - 1)) % 10;
            dp[i][0] = k * dp[i - 1][1] + dp[i - 1][0];
            if (k == 2) {
                dp[i][0] += n % (int)Math.pow(10, i - 1) + 1;
            } else if (k > 2) {
                dp[i][0] += (int) Math.pow(10, i - 1);
            }
            dp[i][1] = 10 * dp[i - 1][1] + (int)Math.pow(10, i - 1);
        }
        return dp[digit][0];
    }
}
