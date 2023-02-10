package leetcdoe.ex202302010.readwritelock;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/10 14:35
 */
public class Rob {
    public static void main(String[] args) {
        Rob demo = new Rob();
        int[] nums = {2, 3, 2};
        int maxV = demo.rob(nums);
        System.out.println(maxV);
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, len - 2), robRange(nums, 1, len -1));
    }

    private int robRange(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2 ; i <= end; ++i) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

    private int robRangeByArray(int[] nums, int start, int end) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < len; ++i) {
            dp[i] = Math.max(dp[i - 1] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }
}
