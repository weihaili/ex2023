package leetcdoe.ex20230203;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/3 13:30
 */
public class NumSubarrayProductLessThanK {
    public static void main(String[] args) {
        NumSubarrayProductLessThanK demo = new NumSubarrayProductLessThanK();
        int[] nums = null;
        int res = demo.numSubarrayProductLessThanK(nums, 0);
        System.out.println(res);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        int cnt = 0;
        int nLen = nums.length;
        int prod = 1;
        int i = 0;
        for (int j = 0; j < nLen; j++) {
            prod *= nums[j];
             while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            cnt += j - i + 1;
        }
        return cnt;
    }
}
