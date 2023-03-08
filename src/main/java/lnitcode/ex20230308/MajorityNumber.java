package lnitcode.ex20230308;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 17:08
 */
public class MajorityNumber {

    public static void main(String[] args) {
        MajorityNumber demo = new MajorityNumber();
        List<Integer> nums = Arrays.asList(1);
        int num = demo.majorityNumber(nums);
        System.out.println(num);
    }

    public int majorityNumber(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return -1;
        }
        Collections.sort(nums);
        return nums.get(nums.size() >> 1);
    }
}
