package leetcdoe.ex20230116;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes demo = new MoveZeroes();
        int[] nums = {0,1,0,3,12};

        demo.moveZeroes(nums);
    }

    public void moveZeroes(int[] nums) {
        System.out.println(Arrays.toString(nums));
        if (nums == null || nums.length < 2) {
            return;
        }
        int len = nums.length;
        int zeroLen = 0;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int temp = nums[i];
            if (temp != 0) {
                res[i - zeroLen] = temp;
            }
            if (temp == 0) {
                zeroLen ++;
                //res[len - zeroLen] = temp;
            }
        }

        for (int i = 0; i < len; i++) {
            nums[i] = res[i];
        }
        System.out.println(Arrays.toString(nums));
    }
}
