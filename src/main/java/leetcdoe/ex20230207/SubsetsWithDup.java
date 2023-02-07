package leetcdoe.ex20230207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/7 17:22
 */
public class SubsetsWithDup {

    public static void main(String[] args) {
        SubsetsWithDup demo = new SubsetsWithDup();
        List<List<Integer>> res = demo.subsetsWithDup(new int[]{4,4,4, 1, 4});
        if (res == null) {
            System.out.println("res is null");
        }
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        Set<List<Integer>> res = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < (1 << len); ++i) {
            List<Integer> ele = new ArrayList<>();
            for (int j = 0; j < len; ++j) {
                if ((i & (1 << j)) != 0) {
                    ele.add(nums[j]);
                }
            }
            Collections.sort(ele);
            res.add(ele);
        }
        return new ArrayList<>(res);
    }
}
