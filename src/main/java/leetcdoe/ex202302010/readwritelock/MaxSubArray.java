package leetcdoe.ex202302010.readwritelock;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/10 16:25
 */
public class MaxSubArray {

    public static void main(String[] args) {
        MaxSubArray demo = new MaxSubArray();
        int sum = demo.maxSubArray(new int[]{1, 2, -4, 3, -1});
        System.out.println(sum);
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pre = 0;
        int maxRes = nums[0];
        for (int i = 0; i < nums.length; ++i) {
            pre = Math.max(pre + nums[i], nums[i]);
            maxRes = Math.max(maxRes, pre);
        }
        return maxRes;
    }
}
