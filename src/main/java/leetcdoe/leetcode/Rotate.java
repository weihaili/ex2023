package leetcdoe.leetcode;

import java.util.Arrays;

public class Rotate {

    public static void main(String[] args) {
        Rotate demo = new Rotate();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        demo.rotate(nums, k);

        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return;
        }
        int len = nums.length;
        if (k <= 0 || k == len) {
            return;
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[(i + k) % len] = nums[i];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = res[i];
        }
    }
}
