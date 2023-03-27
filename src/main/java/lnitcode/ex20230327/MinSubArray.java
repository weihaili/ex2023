package lnitcode.ex20230327;

import java.util.Arrays;
import java.util.List;
public class MinSubArray {

    public static void main(String[] args) {
        MinSubArray demo = new MinSubArray();
        int num = demo.minSubArray(Arrays.asList(1, 1));
        System.out.println(num);
    }

    public int minSubArray(List<Integer> nums) {
        if (nums == null) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int sum = 0;
            for (int j = i; j < nums.size(); j++) {
                sum += nums.get(j);
                min = Math.min(min, sum);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
