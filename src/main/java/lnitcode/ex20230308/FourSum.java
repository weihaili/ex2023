package lnitcode.ex20230308;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 19:05
 */
public class FourSum {

    public static void main(String[] args) {
        FourSum demo = new FourSum();
        int[] numbers = {1,0,-1,0,-2,2};
        List<List<Integer>> res = demo.fourSum(numbers, 0);
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }

    public List<List<Integer>> fourSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 4) {
            return new ArrayList<>();
        }
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(numbers);
        int len = numbers.length;
        for (int i = 0; i < len; ++i) {
            int dif = target -numbers[i];
            for (int j = i + 1; j < len; ++j) {
                int diff = dif - numbers[j];
                for (int k = j + 1; k < len; ++k) {
                    int tg = diff - numbers[k];
                    for (int m = k + 1; m < len; ++m) {
                        if (tg == numbers[m]) {
                            res.add(Arrays.asList(numbers[i], numbers[j], numbers[k], numbers[m]));
                        }
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }
}
