package leetcdoe.ex20230208;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/8 15:00
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum demo = new CombinationSum();
        int[] nums = {2,3,5};
        List<List<Integer>> res = demo.combinationSum(nums, 8);
        if (res == null) {
            System.out.println("res is null");
        }
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, res, combine, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(combine));
            return;
        }
        dfs(candidates, target, res, combine, idx + 1);
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], res, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }
}
