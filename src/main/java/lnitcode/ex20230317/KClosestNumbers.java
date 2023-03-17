package lnitcode.ex20230317;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/17 16:00
 */
public class KClosestNumbers {

    public static void main(String[] args) {
        KClosestNumbers demo = new KClosestNumbers();
        int[] res = demo.kClosestNumbers(new int[]{1, 4, 6, 8}, 3, 3);
        System.out.println(Arrays.toString(res));
    }

    public int[] kClosestNumbers(int[] a, int target, int k) {
        if (a == null || a.length < k) {
            return new int[0];
        }
        int len = a.length;
        int[] res = new int[k];
        int idx = Arrays.binarySearch(a, target);
        if (-1 == idx) {
            for (int i = 0; i < k; ++i) {
                res[i] = a[i];
            }
        } else if (len == idx - 1) {
            int index = 0;
            for (int i = len - 1 - k; i < len; ++i) {
                res[index++] = a[i];
            }
        } else {
            int orgIdx = 0;
            if (idx >=0 && idx < len) {
                orgIdx = idx;
            } else {
                Math.min(Math.abs(target - (a[-idx - 1])), Math.abs(target - (a[idx])));
                orgIdx = -idx - 1;
            }
        }

        return res;
    }
}
