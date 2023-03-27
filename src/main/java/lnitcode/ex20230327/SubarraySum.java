package lnitcode.ex20230327;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubarraySum {

    public static void main(String[] args) {
        SubarraySum demo = new SubarraySum();
        List<Integer> idx = demo.subarraySum(new int[]{-3, 1, 2, -3, 4});
        System.out.println(Arrays.toString(idx.toArray()));
    }

    public List<Integer> subarraySum(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        for (int i = 0; i < nums.length; ++i) {
            int sum = 0;
            for (int j = i; j < nums.length; ++j) {
                sum += nums[j];
                if (sum == 0) {
                    return Arrays.asList(i, j);
                }
            }
        }
        return res;
    }
}
