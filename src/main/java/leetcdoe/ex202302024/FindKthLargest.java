package leetcdoe.ex202302024;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/24 13:31
 */
public class FindKthLargest {

    public static void main(String[] args) {
        FindKthLargest demo = new FindKthLargest();
        int num = demo.findKthLargest(new int[]{3,2,1,5,6,4}, 2);
        System.out.println(num);
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
