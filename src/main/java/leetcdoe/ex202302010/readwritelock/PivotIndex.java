package leetcdoe.ex202302010.readwritelock;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/10 16:53
 */
public class PivotIndex {

    public static void main(String[] args) {
        PivotIndex demo = new PivotIndex();
        int idx = demo.pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
        System.out.println(idx);
    }

    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if ((sum << 1) + nums[i] == total ) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
