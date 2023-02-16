package leetcdoe.ex202302016;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/16 14:57
 */
public class CoinChange {

    public static void main(String[] args) {
        CoinChange demo = new CoinChange();
        int cnt = demo.coinChange(new int[]{2,5}, 0);
        System.out.println(cnt);
    }

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < coins.length; ++j) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
