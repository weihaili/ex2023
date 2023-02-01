package leetcdoe.ex20230201;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/1 13:57
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum demo = new ThreeSum();
        int[] nums = {-1, 0, 1, 1, -2, 2, -1};
        List<List<Integer>> res = demo.threeSum(nums);
        if (res != null) {
            for (List<Integer> re : res) {
                System.out.println(Arrays.toString(re.toArray()));
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>(Math.floorDiv(len, 3));
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
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}
