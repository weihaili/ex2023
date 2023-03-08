package lnitcode.ex20230308;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 11:48
 */
public class CalcYangHuisTriangle {

    public static void main(String[] args) {
        CalcYangHuisTriangle demo = new CalcYangHuisTriangle();
        List<List<Integer>> res = demo.calcYangHuisTriangle(4);
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }

    public List<List<Integer>> calcYangHuisTriangle(int n) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(res.get(i - 1).get(j -1) + res.get(i - 1).get(j));
                }
            }
            res.add(temp);
        }
        return res;
    }
}
