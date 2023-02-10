package leetcdoe.ex202302010.readwritelock;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/10 14:39
 */
public class RobSimple {
    public static void main(String[] args) {
        RobSimple demo = new RobSimple();
        int[] nums = {2, 7, 9, 3, 1};
        int maxv = demo.rob2(nums);
        System.out.println(maxv);
    }

    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int first = nums[0];
        int secode = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; ++i) {
            int temp = secode;
            secode = Math.max(first + nums[i], secode);
            first = temp;
        }
        return secode;
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; ++i) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len -1];
    }
}
