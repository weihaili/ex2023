package leetcdoe.ex202302010.readwritelock;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/10 17:06
 */
public class MaxProfit {
    public static void main(String[] args) {
        MaxProfit demo = new MaxProfit();
        int max = demo.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(max);
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int minPr = Integer.MAX_VALUE;
        int maxPf = 0;
        for (int i = 0; i < prices.length; i++) {
            minPr = Math.min(minPr, prices[i]);
            maxPf = Math.max(maxPf, prices[i] - minPr);
        }
        return maxPf;
    }

    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int len = prices.length;
        int maxp = 0;
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                maxp = Math.max(maxp, prices[j] - prices[i]);
            }
        }
        return maxp;
    }
}
