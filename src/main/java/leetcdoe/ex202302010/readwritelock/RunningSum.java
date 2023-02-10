package leetcdoe.ex202302010.readwritelock;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/10 16:43
 */
public class RunningSum {

    public static void main(String[] args) {
        RunningSum demo = new RunningSum();
        int[] arr = demo.runningSum(new int[]{3, 1, 2, 11});
        System.out.println(Arrays.toString(arr));
    }

    public int[] runningSum(int[] nums) {
        if (nums == null || nums.length == 1) {
            return new int[0];
        }
        int len = nums.length;
        int[] res = new int[len];
        int pre = 0;
        for (int i = 0; i < len; ++i) {
            res[i] = pre + nums[i];
            pre = res[i];
        }
        return res;
    }
}
