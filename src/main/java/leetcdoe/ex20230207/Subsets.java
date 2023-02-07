package leetcdoe.ex20230207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/7 16:50
 */
public class Subsets {

    public static void main(String[] args) {
        Subsets demo = new Subsets();
        List<List<Integer>> res = demo.subsets(new int[]{1,2,3});
        if (res != null) {
            System.out.println("res is null");
        }
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subList = new ArrayList<>();


    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return result;
    }

    private void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            result.add(new ArrayList<>(subList));
            return;
        }
        subList.add(nums[cur]);
        dfs(cur + 1, nums);
        subList.remove(subList.size() - 1);
        dfs(cur + 1, nums);

    }

    public List<List<Integer>> subsets1(int[] nums) {
        if (nums == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < (1<< len); ++i) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < len; ++j) {
                if ((i & (1 << j)) != 0) {
                    temp.add(nums[j]);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
