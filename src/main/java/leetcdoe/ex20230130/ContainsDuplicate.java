package leetcdoe.ex20230130;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        ContainsDuplicate demo = new ContainsDuplicate();
        int[] nums = {1,2,3,4};
        boolean flag = demo.containsDuplicate(nums);
        System.out.println(flag);
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        return Arrays.stream(nums).distinct().count() != (long)nums.length;
    }

    public boolean containsDuplicate1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
