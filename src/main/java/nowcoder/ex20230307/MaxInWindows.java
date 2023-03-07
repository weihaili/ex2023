package nowcoder.ex20230307;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 13:50
 */
public class MaxInWindows {

    public static void main(String[] args) {
        MaxInWindows demo = new MaxInWindows();
        ArrayList<Integer> res = demo.maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        if (num == null || size < 1 || num.length < size) {
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < num.length - size + 1; ++i) {
            int j = i + size - 1;
            int maxVal = num[j];
            for (int k = i; k < j; ++k) {
                maxVal = Math.max(maxVal, num[k]);
            }
            res.add(maxVal);
        }
        return res;
    }
}
