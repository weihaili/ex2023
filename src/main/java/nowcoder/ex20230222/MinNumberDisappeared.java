package nowcoder.ex20230222;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/22 18:05
 */
public class MinNumberDisappeared {

    public static void main(String[] args) {
        MinNumberDisappeared demo = new MinNumberDisappeared();
        int num = demo.minNumberDisappeared(new int[]{4,5,6,8,9});
        System.out.println(num);
    }

    public int minNumberDisappeared(int[] nums) {
        Arrays.sort(nums);
        int pre = 1;
        for (int num : nums) {
            if (num <= 0) {
                continue;
            }
            if (num - pre != 0) {
                return pre;
            }
            ++pre;
        }
        return pre;
    }
}
