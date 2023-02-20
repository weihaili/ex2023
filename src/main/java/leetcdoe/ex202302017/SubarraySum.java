package leetcdoe.ex202302017;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/17 15:40
 */
public class SubarraySum {

    public static void main(String[] args) {
        SubarraySum demo = new SubarraySum();
        int cnt = demo.subarraySum1(new int[]{1, -1, 0}, 0);
        System.out.println(cnt);
    }

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int cnt = 0;
        for (int i = 0; i < len; ++i) {
            int sum  = 0;
            for (int j = i; j >= 0; --j) {
                sum += nums[j];
                if (sum == k) {
                    ++cnt;
                }
            }
        }
        return cnt;
    }

    public int subarraySum1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int cnt = 0;
        for (int i = 0; i < len; ++i) {
            int sum  = 0;
            for (int j = i; j < len; ++j) {
                sum += nums[j];
                if (sum == k) {
                    ++cnt;
                }
            }
        }
        return cnt;
    }
}
