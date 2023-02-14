package leetcdoe.ex202302013;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/13 14:44
 */
public class MaxProfit {

    public static void main(String[] args) {
        MaxProfit demo = new MaxProfit();
        int max = demo.maxProfit3(new int[]{7,1,5,3,6,4});
        System.out.println(max);
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][1] = -prices[0];
        dp[0][0] = 0;
        for (int i = 1; i < len; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int len = prices.length;
        int hold = -prices[0];
        int noHold = 0;
        for (int i = 1; i < len; ++i) {
            noHold = Math.max(noHold, hold + prices[i]);
            hold = Math.max(hold, noHold - prices[i]);
        }
        return noHold;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int len = prices.length;
        int total = 0;
        int idx = 0;
        while (idx < len) {
            while (idx < len - 1 && prices[idx] >= prices[idx + 1]) {
                idx++;
            }
            int min = prices[idx];
            while (idx < len - 1 && prices[idx] <= prices[idx + 1]) {
                idx++;
            }
            total += prices[idx++] - min;
        }
        return total;
    }

    public int maxProfit3(int[] prices) {
        int total = 0;
        for (int idx = 0; idx < prices.length - 1; ++idx) {
            total += Math.max(prices[idx + 1] - prices[idx], 0);
        }
        return total;
    }
}
