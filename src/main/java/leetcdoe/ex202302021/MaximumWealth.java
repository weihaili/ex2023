package leetcdoe.ex202302021;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/21 14:45
 */
public class MaximumWealth {

    public static void main(String[] args) {
        MaximumWealth demo = new MaximumWealth();
        int[][] accounts = new int[][]{{1,2,3},{3,2,1}};
        int max = demo.maximumWealth(accounts);
        System.out.println(max);
    }

    public int maximumWealth(int[][] accounts) {
        if (accounts == null || accounts.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < accounts.length; ++i) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; ++j) {
                sum += accounts[i][j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
