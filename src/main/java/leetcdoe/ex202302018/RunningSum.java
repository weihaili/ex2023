package leetcdoe.ex202302018;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/20 17:07
 */
public class RunningSum {

    public static void main(String[] args) {
        RunningSum demo = new RunningSum();
        int[] sums = demo.runningSum(new int[]{1,2,3,4,5});
        System.out.println(Arrays.toString(sums));
    }

    public int[] runningSum(int[] nums) {
        if (nums == null) {
            return new int[0];
        }
        int pre = 0;
        int len = nums.length;
        int[] sums = new int[len];
        for (int i = 0; i < len; ++i) {
            sums[i] = pre + nums[i];
            pre = sums[i];
        }
        return sums;
    }

    public int[] runningSum1(int[] nums) {
        if (nums == null) {
            return new int[0];
        }
        int pre = nums[0];
        int len = nums.length;
        int[] sums = new int[len];
        sums[0] = nums[0];
        for (int i = 1; i < len; ++i) {
            sums[i] = pre + nums[i];
            pre = sums[i];
        }
        return sums;
    }
}
