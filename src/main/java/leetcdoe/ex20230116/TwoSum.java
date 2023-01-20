package leetcdoe.ex20230116;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum demo = new TwoSum();
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ints = demo.twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers .length < 2) {
            return null;
        }
        int len = numbers.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (target == (numbers[i] + numbers[j])) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return null;
    }
}
