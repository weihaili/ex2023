package leetcdoe.ex202302028;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/28 18:21
 */
public class MaximumGap {

    public static void main(String[] args) {
        MaximumGap demo = new MaximumGap();
        int num = demo.maximumGap(new int[]{3,6,9,1});
        System.out.println(num);
    }

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; ++i) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }
        return max;
    }
}
