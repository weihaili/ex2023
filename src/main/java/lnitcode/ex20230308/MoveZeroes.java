package lnitcode.ex20230308;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 11:09
 */
public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes demo = new MoveZeroes();
        int[] nums = {0,0,0,0,0, 0 ,12};
        demo.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < len; j++) {
                    if (nums[j] != 0){
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }
}
