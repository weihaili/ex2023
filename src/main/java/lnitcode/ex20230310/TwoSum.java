package lnitcode.ex20230310;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/10 14:18
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum demo = new TwoSum();
        int[] idxs = demo.twoSum(new int[]{15,2,7,11}, 9);
        System.out.println(Arrays.toString(idxs));
    }

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int tg = target - numbers[i];
            for (int j = i + 1; j < numbers.length; ++j) {
                if (numbers[j] == tg) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
