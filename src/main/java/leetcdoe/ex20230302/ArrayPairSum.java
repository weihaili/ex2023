package leetcdoe.ex20230302;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/2 18:16
 */
public class ArrayPairSum {

    public static void main(String[] args) {
        ArrayPairSum demo = new ArrayPairSum();
        int sum = demo.arrayPairSum(new int[]{1, 4, 3, 2});
        System.out.println(sum);
    }

    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
