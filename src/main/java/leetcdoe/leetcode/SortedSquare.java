package leetcdoe.leetcode;

import java.util.Arrays;

public class SortedSquare {

    public static void main(String[] args) {
        SortedSquare demo = new SortedSquare();
        int[] nums = {-7,-3,2,3,11};
        int[] ints = demo.sortedSquares(nums);
        System.out.println(Arrays.toString(ints));
    }

    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new int[0];
        }
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = (int) Math.pow(nums[i], 2);
        }
        Arrays.sort(res);
        return res;
    }

}
