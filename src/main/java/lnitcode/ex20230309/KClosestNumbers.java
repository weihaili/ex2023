package lnitcode.ex20230309;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/9 11:43
 */
public class KClosestNumbers {

    public static void main(String[] args) {
        KClosestNumbers demo = new KClosestNumbers();
        int[] nums = demo.kClosestNumbers(new int[]{1, 2, 3}, 2, 3);
        System.out.println(Arrays.toString(nums));
    }

    public int[] kClosestNumbers(int[] a, int target, int k) {
        if (a == null || k < 1 || a.length < k) {
            return new int[] {0};
        }
        int[] res = new int[k];
        int len = a.length;
        int idx = Arrays.binarySearch(a, 2);
        if (idx >= 0 && idx <= len -1) {
            res[0] = a[idx];
            int midSize = (k - 1) >> 1;

        }
        return res;
    }
}
