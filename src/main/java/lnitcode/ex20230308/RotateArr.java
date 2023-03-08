package lnitcode.ex20230308;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 13:32
 */
public class RotateArr {

    public static void main(String[] args) {
        RotateArr demo = new RotateArr();
        int[] res = demo.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 8);
        System.out.println(Arrays.toString(res));
    }

    public int[] rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        if (k < 1) {
            return nums;
        }
        int len = nums.length;
        int temp = k % len;
        int[] arr = new int[len];
        System.arraycopy(nums, len - temp, arr, 0, temp);
        System.arraycopy(nums, 0, arr, temp, len - temp);
        return arr;
    }
}
