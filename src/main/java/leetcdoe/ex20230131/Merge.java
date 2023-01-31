package leetcdoe.ex20230131;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        Merge demo = new Merge();
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        demo.merge(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));
    }

    public void merge(int[] num1, int m, int[] num2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;
        int curVal;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 < 0) {
                curVal = num2[p2--];
            } else if (p2 <0) {
                curVal = num1[p1--];
            } else if (num1[p1] < num2[p2]) {
                curVal = num2[p2--];
            } else {
                curVal = num1[p1--];
            }
            num1[tail--] = curVal;
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int[] sorted = new int[m + n];
        int curVal;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                curVal = nums2[p2++];
            } else if (p2 == n) {
                curVal = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                curVal = nums1[p1++];
            } else {
                curVal = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = curVal;
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = sorted[i];
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
