package leetcdoe.ex202302013;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/13 12:07
 */
public class NumberOfArithmeticSlices {

    public static void main(String[] args) {
        NumberOfArithmeticSlices demo = new NumberOfArithmeticSlices();
        int cnt = demo.numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(cnt);
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0;
        if (nums == null || nums.length < 3) {
            return res;
        }
        int d = nums[0] - nums[1];
        int time = 0;
        for (int i = 2; i < nums.length; ++i) {
            if (nums[i - 1] - nums[i] == d) {
                ++time;
            } else {
                d = nums[i - 1] - nums[i];
                time = 0;
            }
            res += time;
        }
        return res;
    }
}
