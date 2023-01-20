package leetcdoe.leetcode;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum demo = new TwoSum();
        int[] nums = {3,3};
        int target = 6;
        int[] ints = demo.twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length -1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }
}
