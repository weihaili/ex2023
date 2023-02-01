package leetcdoe.ex20230201;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/1 11:09
 */
public class MaxProfit {

    public static void main(String[] args) {
        MaxProfit demo = new MaxProfit();
        int[] prices = {1,2,3,4,0 };
        int profit = demo.maxProfit(prices);
        System.out.println(profit);
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }
}
