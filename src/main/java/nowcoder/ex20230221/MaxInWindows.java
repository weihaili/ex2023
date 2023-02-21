package nowcoder.ex20230221;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/21 17:52
 */
public class MaxInWindows {

    public static void main(String[] args) {
        MaxInWindows demo = new MaxInWindows();
        ArrayList<Integer> maxes = demo.maxInWindows(new int[]{1,2,3,4}, 5);
        System.out.println(Arrays.toString(maxes.toArray()));
    }

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        if (num == null || num.length == 0 || size == 0 || num.length < size) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        int len = num.length;
        for (int i = 0; i <= len - size; ++i) {
            int max = Integer.MIN_VALUE;
            for (int j = i + size - 1; j >= i; --j) {
                max = Math.max(max, num[j]);
            }
            list.add(max);
        }
        return list;
    }
}
