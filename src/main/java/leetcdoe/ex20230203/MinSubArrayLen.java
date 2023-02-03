package leetcdoe.ex20230203;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/3 14:13
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        MinSubArrayLen demo = new MinSubArrayLen();
        int[] nums = {1, 4, 3, 4, 5, 6, 7, 8};
        int res = demo.minSubArrayLen(29, nums);
        System.out.println(res);
    }

    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        int lIdx = 0;
        int rIdx = 0;
        int sum = 0;
        while (lIdx <= rIdx && rIdx < nums.length) {
            sum += nums[rIdx];
            while (sum >= target) {
                minLen = Math.min(minLen, rIdx - lIdx + 1);
                sum -= nums[lIdx];
                lIdx++;
            }
            rIdx++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        if (nums == null) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        int nLen = nums.length;
        int[] sums = new int[nLen + 1];
        for (int i = 1; i <= nLen; ++i) {
            sums[i] = nums[i - 1] + sums[i - 1];
        }
        for (int i = 1; i <= nLen; ++i) {
            int temp = target + sums[i - 1];
            int bound = Arrays.binarySearch(sums, temp);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= nLen) {
                minLen = Math.min(minLen, bound - i + 1);
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public int minSubArrayLen1(int target, int[] nums) {
        if (nums == null) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        int nLen = nums.length;
        for (int i = 0; i < nLen; i++) {
            int tempSum = 0;
            for (int j = i; j < nLen; j++) {
                tempSum += nums[j];
                if (tempSum >= target) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
