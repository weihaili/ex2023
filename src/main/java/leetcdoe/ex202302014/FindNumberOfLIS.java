package leetcdoe.ex202302014;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/14 17:55
 */
public class FindNumberOfLIS {

    public static void main(String[] args) {
        FindNumberOfLIS demo = new FindNumberOfLIS();
        int cnt = demo.findNumberOfLIS(new int[]{1, 3, 5, 4, 7});
        System.out.println(cnt);
    }

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int len = nums.length;
        int[] dp = new int[len];
        int[] cnt = new int[len];
        int maxLen = 0;
        for (int i = 0; i < len; ++i) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > maxLen) {
               maxLen = dp[i];
               res = cnt[i];
            } else if (dp[i] == maxLen) {
                res += cnt[i];
            }
        }
        return res;
    }
}
