package leetcdoe.ex202302017;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/17 17:25
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        FindMedianSortedArrays demo = new FindMedianSortedArrays();
        double res = demo.findMedianSortedArrays(new int[]{1,2}, new int[]{3, 4});
        System.out.println(res);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int left = 0;
        int right = m;
        double mid1 = 0;
        double mid2 = 0;
        while (left <= right) {
            int i = left + right >> 1;
            int j = (m + n + 1) / 2 - i;
            int numsM1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int numsi = i == m ? Integer.MAX_VALUE : nums1[i];
            int numsM2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int numsj = j == n ? Integer.MAX_VALUE : nums2[j];
            if (numsM1 <= numsj) {
                mid1 = Math.max(numsM1, numsM2);
                mid2 = Math.min(numsi, numsj);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        return ((m + n) & 1) == 1 ? (mid1 + mid2) / 2.0 : mid1;
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) {
            return 0;
        }
        if ((nums1 == null || nums1.length == 0) && nums2 != null && nums2.length > 0) {
            return findMedianSortedArrays(nums2);
        }
        if (nums1 != null && nums1.length > 0 && (nums2 == null || nums2.length == 0)) {
            return findMedianSortedArrays(nums1);
        }
        int[] nums = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, nums, 0, nums1.length);
        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
        return findMedianSortedArrays(nums);
    }

    private double findMedianSortedArrays(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if ((len & 1) == 1) {
            return nums[(len + 1) >> 1];
        }
        return (nums[len >> 1] + nums[(len >> 1) + 1]) >> 1;
    }
}
