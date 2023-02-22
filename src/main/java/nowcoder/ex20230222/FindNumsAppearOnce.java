package nowcoder.ex20230222;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/22 17:39
 */
public class FindNumsAppearOnce {

    public static void main(String[] args) {
        FindNumsAppearOnce demo = new FindNumsAppearOnce();
        int[] ints = demo.FindNumsAppearOnce(new int[]{1, 4, 1, 6});
        System.out.println(Arrays.toString(ints));
    }

    public int[] FindNumsAppearOnce (int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        int res1 = 0;
        int res2 = 0;
        int temp = 0;
        for (int i : array) {
            temp ^= i;
        }
        int k = 1;
        while ((k & temp) == 0) {
            k <<= 1;
        }
        for (int num : array) {
            if ((k & num) == 0) {
                res1 ^= num;
            } else {
                res2 ^= num;
            }
        }
        return res1 > res2 ? new int[]{res2, res1} : new int[]{res1, res2};
    }
}
