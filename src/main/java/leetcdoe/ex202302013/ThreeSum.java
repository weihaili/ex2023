package leetcdoe.ex202302013;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/13 10:19
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum demo = new ThreeSum();
        List<List<Integer>> res = demo.threeSum(new int[]{1, 2, -3});
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int first = 0; first < len; ++first) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = len - 1;
            int targetNum = -nums[first];
            for (int second = first + 1; second < len; ++second) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > targetNum) {
                    --third;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == targetNum) {
                    List<Integer> eles = new ArrayList<>(3);
                    eles.add(nums[first]);
                    eles.add(nums[second]);
                    eles.add(nums[third]);
                    res.add(eles);
                }
            }
        }
        return res;
    }
}
