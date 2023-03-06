package nowcoder.ex20230304;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/6 18:32
 */
public class Permute {

    public static void main(String[] args) {
        Permute demo = new Permute();
        ArrayList<ArrayList<Integer>> res = demo.permute(new int[]{1, 2, 3});
        for (ArrayList<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        if (num == null || num.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < num.length; ++i) {
            nums.add(num[i]);
        }
        recursion(res, nums, 0);
        return res;
    }

    private void recursion(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> nums, int idx) {
        if (idx == nums.size() - 1) {
            res.add(nums);
        } else {
            for (int i = idx; i < nums.size(); i++) {
                swap(nums, i, idx);
                recursion(res, nums, idx + 1);
                swap(nums, i, idx);
            }
        }
    }

    private void swap(ArrayList<Integer> nuns, int idx1, int idx2) {
        int temp = nuns.get(idx1);
        nuns.set(idx1, nuns.get(idx2));
        nuns.set(idx2, temp);
    }
}
