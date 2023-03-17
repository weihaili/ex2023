package lnitcode.ex20230317;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/17 10:59
 */
public class PartitionArray {

    public static void main(String[] args) {
        PartitionArray demo = new PartitionArray();
        int idx = demo.partitionArray(new int[]{6,6,8,6,7,9,8,7,9,6,8,6,8,9,8,7,8,6,7,6,6,8,6,6}, 5);
        System.out.println(idx);
    }

    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        if (k > nums[nums.length - 1]) {
            return nums.length;
        }
        if (k <= nums[0]) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                return i;
            }
        }
        return 0;
    }
}
