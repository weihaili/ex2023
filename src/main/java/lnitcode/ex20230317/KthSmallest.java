package lnitcode.ex20230317;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/17 11:11
 */
public class KthSmallest {

    public static void main(String[] args) {
        KthSmallest demo = new KthSmallest();
        int num = demo.kthSmallest(10, new int[]{1,2,3,4,5,6,8,9,10,7});
        System.out.println(num);
    }

    public int kthSmallest(int k, int[] nums) {
        if (nums == null || nums.length < k || k < 1) {
            return 0;
        }
        Arrays.sort(nums);
        return nums[k - 1];
    }
}
