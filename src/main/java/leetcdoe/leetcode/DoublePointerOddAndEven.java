package leetcdoe.leetcode;

import java.util.Arrays;

public class DoublePointerOddAndEven {

    public static void main(String[] args) {
        DoublePointerOddAndEven demo = new DoublePointerOddAndEven();
        int[] nums = {1,2,3,4,5,6,7};

        demo.reorderArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void reorderArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }
        int i = 0;
        int j = nums.length -1;
        while (i < j) {
            while (i < j && nums[i] % 2 == 1) {
                i++;
            }
            while (i < j && nums[j] % 2 == 0) {
                j--;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
}
