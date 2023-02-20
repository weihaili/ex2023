package leetcdoe.ex202302017;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/17 14:37
 */
public class GiveMoney {

    public static void main(String[] args) {
        GiveMoney demo = new GiveMoney();
        int[] res = demo.giveMoney(new int[]{25, 10, 5, 1}, 99);
        System.out.println(Arrays.toString(res));
    }

    public int[] giveMoney(int[] m, int target) {
        int len = m.length;
        int[] nums = new int[len];
        for (int i = 0; i < len; ++i) {
            nums[i] = target / m[i];
            target = target % m[i];
        }
        return nums;
    }
}
