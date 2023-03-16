package lnitcode.ex20230316;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/16 11:12
 */
public class Generate {

    public static void main(String[] args) {
        Generate demo = new Generate();
        List<List<Integer>> res = demo.generate(5);
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1) {
            return res;
        }
        for (int i = 0; i < numRows; ++i) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(list);
        }
        return res;
    }
}
