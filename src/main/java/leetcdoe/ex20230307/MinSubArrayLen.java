package leetcdoe.ex20230307;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 10:13
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        MinSubArrayLen demo = new MinSubArrayLen();
        int[] nums = new int[]{2,3,1,2,4,3};
        int len = demo.minSubArrayLen(7, nums);
        System.out.println(len);
    }

    int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int subLen = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                subLen = i - start + 1;
                res = Math.min(res, subLen);
                sum -= nums[start++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    int minSubArrayLen1(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int subLen = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    subLen = j - i + 1;
                    res = Math.min(res, subLen);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
