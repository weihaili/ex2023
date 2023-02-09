package leetcdoe.ex20230209;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/9 15:35
 */
public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray demo = new MaxSubArray();
        int value = demo.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(value);
    }

    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum += num;
            res = Math.max(res, sum);
        }
        return res;
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pre = 0;
        int maxRes = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxRes = Math.max(pre, maxRes);
        }
        return maxRes;
    }
}
