package lnitcode.ex20230330;

import java.util.Arrays;

public class InterleavedArray {

    public static void main(String[] args) {
        InterleavedArray demo = new InterleavedArray();
        int[] a = {1, 2};
        int[] b = {3, 4};
        int[] res = demo.interleavedArray(a, b);
        System.out.println(Arrays.toString(res));
    }

    public int[] interleavedArray(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) {
            return new int[0];
        }
        int len = a.length;
        int[] res = new int[len << 1];
        for (int i = 0; i < len; i++) {
            res[i << 1] = a[i];
            res[(i << 1) + 1] = b[i];
        }
        return res;
    }

    public int[] interleavedArray1(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) {
            return new int[0];
        }
        int idxa = 0;
        int idxb = 0;
        int idx = 0;
        int[] res = new int[a.length + b.length];
        boolean flagA = true;
        while (idxa < a.length || idxb < b.length) {
            if (flagA) {
                res[idx++] = a[idxa++];
                flagA = false;
            } else {
                res[idx++] = b[idxb++];
                flagA = true;
            }
        }
        return res;
    }
}
