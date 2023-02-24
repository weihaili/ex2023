package leetcdoe.ex202302024;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/24 10:01
 */
public class FindDuplicate {

    public static void main(String[] args) {
        FindDuplicate demo = new FindDuplicate();
        int num = demo.findDuplicate(new int[]{3,1,3,4,2});
        System.out.println(num);
    }

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int pre = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (pre == nums[i]) {
                break;
            }
            pre = nums[i];
        }
        return pre;
    }
}
