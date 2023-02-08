package leetcdoe.ex20230208;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/8 14:26
 */
public class PermuteUnique {
    public static void main(String[] args) {
        PermuteUnique demo = new PermuteUnique();
        int[] nums = {3,3,0,3};
        List<List<Integer>> res = demo.permuteUnique(nums);
        if (res == null) {
            System.out.println("res is null");
        }
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }

    }

    boolean[] visit;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        int len = nums.length;
        List<Integer> elsments = new ArrayList<>(len);
        visit = new boolean[len];
        Arrays.sort(nums);
        backtrack(nums, res, 0, elsments);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, int idx, List<Integer> elsments) {
        if (nums.length == idx) {
            res.add(new ArrayList<>(elsments));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (visit[i] || (i > 0 && nums[i] == nums[i - 1] && !visit[i - 1])) {
                continue;
            }
            elsments.add(nums[i]);
            visit[i] = true;
            backtrack(nums, res, idx + 1, elsments);
            visit[i] = false;
            elsments.remove(idx);
        }
    }
}
