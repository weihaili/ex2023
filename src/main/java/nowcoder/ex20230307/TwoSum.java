package nowcoder.ex20230307;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 15:01
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum demo = new TwoSum();
        int[] arr = demo.twoSum(new int[]{0,4,3,0}, 0);
        System.out.println(Arrays.toString(arr));
    }

    public int[] twoSum (int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[0];
        }
        int len = numbers.length;
        for (int i = 0; i < len; ++i) {
            int num = target - numbers[i];
            for (int j = i + 1; j < len; ++j) {
                if (numbers[j] == num) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[0];
    }
}
