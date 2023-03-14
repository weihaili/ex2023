package lnitcode.ex20230314;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/14 15:06
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        ContainsDuplicate demo = new ContainsDuplicate();
        boolean flag = demo.containsDuplicate(new int[]{9, 1, 0, 7, 2});
        System.out.println(flag);
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
