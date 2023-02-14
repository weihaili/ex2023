package leetcdoe.ex202302014;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/14 14:56
 */
public class SortColors {

    public static void main(String[] args) {
        SortColors demo = new SortColors();
        int[] nums = {1, 2, 0, 2, 0, 1};
        demo.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int idx0 = 0;
        int idx1 = 0;
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[idx1];
                nums[idx1] = temp;
                ++idx1;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[idx0];
                nums[idx0] = temp;
                if (idx0 < idx1) {
                    temp = nums[i];
                    nums[i] = nums[idx1];
                    nums[idx1] = temp;
                }
                ++idx0;
                ++idx1;
            }
        }
    }

    public void sortColors_2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        int idx = 0;
        for (int i = 0; i < len; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                ++idx;
            }
        }
        for (int i = idx; i < len; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                ++idx;
            }
        }
    }

    public void sortColors_1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int idx = 0;
        int[] res = new int[nums.length];
        for (int num : nums) {
            if (num == 0) {
                res[idx] = 0;
                ++idx;
            }
        }
        for (int num : nums) {
            if (num == 1) {
                res[idx] = 1;
                ++idx;
            }
        }
        for (int num : nums) {
            if (num == 2) {
                res[idx] = 2;
                ++idx;
            }
        }
        for (int i = 0; i < res.length; ++i) {
            nums[i] = res[i];
        }
    }
}
