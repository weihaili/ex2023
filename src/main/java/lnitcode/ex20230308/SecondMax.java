package lnitcode.ex20230308;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 10:49
 */
public class SecondMax {

    public static void main(String[] args) {
        SecondMax demo = new SecondMax();
        int num = demo.secondMax(new int[]{1, 3, 2, 4});
        System.out.println(num);
    }


    public int secondMax(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - 2];
    }
}
