package leetcdoe.ex202302023;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/23 14:21
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        FindMedianSortedArrays demo = new FindMedianSortedArrays();
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        double val = demo.findMedianSortedArrays(nums1, nums2);
        System.out.println(val);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int totalLen = len1 + len2;
        int[] arr = new int[totalLen];
        System.arraycopy(nums1, 0, arr, 0, nums1.length);
        System.arraycopy(nums2, 0, arr, nums1.length, nums2.length);
        Arrays.sort(arr);
        return (totalLen & 1) == 0 ? (arr[(totalLen >> 1) - 1] + arr[totalLen >> 1]) / 2.0 : arr[totalLen >> 1];
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int left = 0;
        int right = m;
        int mid1 = 0;
        int mid2 = 0;
        while (left <= right) {
            int i = left + right >> 1;
            int j = (m + n + 1 >> 1) - i;
            int numsM1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int numsi = i == m ? Integer.MAX_VALUE : nums1[i];
            int numsM2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int numsj = j == n ? Integer.MAX_VALUE : nums2[j];
            if (numsM1 < numsj) {
                mid1 = Math.max(numsM1, numsM2);
                mid2 = Math.min(numsi, numsj);
                left = i + 1;
            } else {
                right = j - 1;
            }
        }
        return ((m + n) & 1) == 0 ? (mid1 + mid2) / 2.0 : mid1;
    }
}
