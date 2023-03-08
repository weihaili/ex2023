package lnitcode.ex20230308;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 11:42
 */
public class ReverseArray {

    public static void main(String[] args) {
        ReverseArray demo = new ReverseArray();
        int[] nums = {1, 2, 3, 4};
        demo.reverseArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void reverseArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int len = nums.length;
        for (int i = 0; i < len >> 1; i++) {
            int temp = nums[i];
            nums[i] = nums[len - i - 1];
            nums[len - i - 1] = temp;
        }
    }
}
