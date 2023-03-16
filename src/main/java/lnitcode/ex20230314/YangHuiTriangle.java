package lnitcode.ex20230314;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/14 19:15
 */
public class YangHuiTriangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < num; ++i) {
            List<Integer> nums = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    nums.add(1);
                } else {
                    nums.add(res.get(i - 1).get(j -1) + res.get(i - 1).get(j));
                }
            }
            res.add(nums);
        }
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }
}
