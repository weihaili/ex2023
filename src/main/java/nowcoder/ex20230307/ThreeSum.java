package nowcoder.ex20230307;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 15:12
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum demo = new ThreeSum();
        ArrayList<ArrayList<Integer>> res = demo.threeSum(new int[]{-2,0,1,1,2});
        for (ArrayList<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        if (num == null || num.length < 3) {
            return new ArrayList<>();
        }
        Set<ArrayList<Integer>> set = new HashSet<>();
        int len = num.length;
        Arrays.sort(num);
        for (int i = 0; i < len; i++) {
            int sum = 0 - num[i];
            for (int j = i + 1; j < len; j++) {
                int temp = sum - num[j];
                for (int k = j + 1; k < len; k++) {
                    if (num[k] == temp) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[k]);
                        set.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}
