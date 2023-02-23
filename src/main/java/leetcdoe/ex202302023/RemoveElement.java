package leetcdoe.ex202302023;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/23 16:47
 */
public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement demo = new RemoveElement();
        int[] nums = {3,2,2,3, 4, 5, 6, 7};
        int len = demo.removeElement1(nums, 3);
        System.out.println(len + " : " + Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int left = 0;
        for (int i = 0; i < len; ++i) {
            if (nums[i] != val) {
                nums[left] = nums[i];
                ++left;
            }
        }
        return left;
    }

    public int removeElement1(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int repeatTime = 0;
        for (int i = 0; i < len; ++i) {
            int num = nums[i];
            if (num == val) {
                ++repeatTime;
                for (int j = i; j < len - 1; ++j) {
                    nums[j] = nums[j + 1];
                }
            }
        }
        return len - repeatTime;
    }
}
