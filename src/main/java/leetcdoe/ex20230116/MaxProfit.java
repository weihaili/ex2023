package leetcdoe.ex20230116;

public class MaxProfit {

    public static void main(String[] args) {
        MaxProfit demo = new MaxProfit();
        int[] prices = {1,2, 7, 4,1,0};
        int max = demo.maxProfit(prices);
        System.out.println(max);
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        if (prices == null || prices.length < 2) {
            return res;
        }

        int len = prices.length;
        int minP = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int price = prices[i];
            if (price < minP) {
                minP = price;
            } else {
                res = Math.max(res, price - minP);
            }
        }
        return res;
    }
}
