package lnitcode.ex20230330;

import java.util.Arrays;

public class MoveTarget {

    public static void main(String[] args) {
        MoveTarget demo = new MoveTarget();
        int[] nums = {5, 1, 6, 1};
        demo.moveTarget(nums, 1);
        System.out.println(Arrays.toString(nums));
    }

    public void moveTarget(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        int idx0 = 0;
        int idx = 0;
        while (idx < len) {
            int num = nums[idx];
            if (num == target) {
                if (idx == 0) {
                    ++idx;
                    continue;
                }
                for (int i = idx; i > idx0; --i) {
                    nums[i] = nums[i - 1];
                }
                nums[idx0++] = target;
            }
            ++idx;
        }
    }
}
