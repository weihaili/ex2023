package leetcdoe.ex202302023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/23 15:45
 */
public class FourSum {

    public static void main(String[] args) {
        FourSum demo = new FourSum();
        List<List<Integer>> res = demo.fourSum(new int[]{0,1,5,0,1,5,5,-4}, 11);
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null|| nums.length < 4) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; ++i) {
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }
            if (target < (long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3]) {
                break;
            }
            if (target > (long)nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1]) {
                continue;
            }
            for (int j = i + 1; j < len - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[len - 1]) {
                    continue;
                }
                if (target < (long)nums[i] + nums[j] + nums[j + 1] + nums[j + 2]) {
                    break;
                }
                if (target > (long)nums[i] + nums[j] + nums[len - 1] + nums[len - 2]) {
                    continue;
                }
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            ++left;
                        }
                        ++left;
                        while (left < right && nums[right] == nums[right - 1]) {
                            --right;
                        }
                        --right;
                    } else if (sum < target) {
                        ++left;
                    } else {
                        --right;
                    }
                }
            }
        }

        return res.stream().distinct().collect(Collectors.toList());
    }

    public List<List<Integer>> fourSum1(int[] nums, int target) {
        if (nums == null|| nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                for (int k = j + 1; k < len; ++k) {
                    for (int m = k+1; m < len; ++m) {
                        if (target == nums[i] + nums[j] + nums[k] + nums[m]) {
                            res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k], nums[m])));
                        }
                    }
                }
            }
        }

        return new ArrayList<>(res);
    }
}
