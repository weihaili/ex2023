package leetcdoe.ex202302013;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/13 14:23
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates demo = new RemoveDuplicates();
        int len = demo.removeDuplicates(new int[]{1, 1, 2, 2, 3});
        System.out.println(len);
    }

    public int removeDuplicates1(int[] nums) {
        int dCnt = 0;
        if (nums == null || nums.length == 0) {
            return dCnt;
        }
        int len = nums.length;
        for (int i = 1; i < len; ++i) {
            if (nums[i] != nums[i - 1]) {
                ++dCnt;
            } else {
                nums[i - dCnt] = nums[i];
            }
        }
        return len - dCnt;
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int lIdx = 0;
        for (int rIdx = 1; rIdx < nums.length; ++rIdx) {
            if (nums[rIdx] != nums[lIdx]) {
                nums[++lIdx] = nums[rIdx];
            }
        }
        return ++lIdx;
    }
}
