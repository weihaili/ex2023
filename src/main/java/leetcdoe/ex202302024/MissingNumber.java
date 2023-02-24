package leetcdoe.ex202302024;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/24 9:31
 */
public class MissingNumber {

    public static void main(String[] args) {
        MissingNumber demo = new MissingNumber();
        int num = demo.missingNumber(new int[]{9,6,4,2,3,5,7,0,1});
        System.out.println(num);
    }

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int pre = 0;
        for (int num : nums) {
            if (num == pre) {
                ++pre;
            } else {
                break;
            }
        }
        return pre;
    }
}
