package leetcdoe.leetcode;

import java.util.Arrays;

public class ArrayMerge {

    public static void main(String[] args) {
        ArrayMerge demo = new ArrayMerge();
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = nums2.length;
        demo.merge(nums1, m, nums2,  n);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
