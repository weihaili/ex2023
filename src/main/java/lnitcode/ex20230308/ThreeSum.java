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
 * @date 2023/3/8 18:29
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum demo = new ThreeSum();
        List<List<Integer>> res = demo.threeSum(new int[]{-1,0,1,2,-1,-4});
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }

    public List<List<Integer>> threeSum(int[] numbers) {
        if (numbers == null || numbers.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(numbers);
        Set<List<Integer>> res = new HashSet<>();
        int len = numbers.length;
        for (int i = 0; i < len; ++i) {
            int dif = 0 - numbers[i];
            for (int j = i + 1; j < len; ++j) {
                int target = dif - numbers[j];
                for (int k = j + 1; k < len; ++k) {
                    if (target == numbers[k]) {
                        res.add(Arrays.asList(numbers[i], numbers[j], numbers[k]));
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }
}
