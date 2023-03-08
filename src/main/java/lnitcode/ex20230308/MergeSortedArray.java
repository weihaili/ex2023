package lnitcode.ex20230308;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 17:38
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        MergeSortedArray demo = new MergeSortedArray();
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {2,4,5,6};
        int[] res = demo.mergeSortedArray(arr1, arr2);
        System.out.println(Arrays.toString(res));
    }

    public int[] mergeSortedArray(int[] a, int[] b) {
        if (a == null || a.length == 0) {
            return b;
        }
        if (b == null || b.length == 0) {
            return a;
        }
        if (a.length < b.length) {
            return mergeSortedArray(b, a);
        }
        int alen = a.length;
        int blen = b.length;
        int[] res = new int[alen + blen];
        System.arraycopy(a, 0, res, 0, alen);
        System.arraycopy(b, 0, res, alen, blen);
        Arrays.sort(res);
        return res;
    }
}
