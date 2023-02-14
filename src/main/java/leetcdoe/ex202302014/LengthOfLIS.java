package leetcdoe.ex202302014;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/14 17:22
 */
public class LengthOfLIS {

    public static void main(String[] args) {
        LengthOfLIS demo = new LengthOfLIS();
        int len = demo.lengthOfLIS(new int[]{0});
        System.out.println(len);
    }

    public int lengthOfLIS(int[] nums) {
        int res = 0;
        if (nums == null || nums.length == 0) {
            return res;
        }
        res = 1;
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
