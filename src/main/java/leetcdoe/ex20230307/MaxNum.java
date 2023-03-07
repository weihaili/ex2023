package leetcdoe.ex20230307;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 17:42
 */
public class MaxNum {

    public static void main(String[] args) {
        MaxNum demo = new MaxNum();
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        int max = demo.maxNum(nums);
        System.out.println(max);
    }

    public int maxNum(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); ++i) {
            max = Math.max(nums.get(i), max);
        }
        return max;
    }

    public int maxNum1(List<Integer> nums) {
        Collections.sort(nums);
        return nums.get(nums.size() - 1);
    }
}
