package lnitcode.ex20230330;

import java.util.Arrays;

public class Intersection {

    public static void main(String[] args) {
        Intersection demo = new Intersection();
        int[] res = demo.intersection(new int[]{1,1,2}, new int[]{1});
        System.out.println(Arrays.toString(res));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1Len = nums1.length;
        int l2Len = nums2.length;
        int[] tempRes = new int[Math.min(l1Len, l2Len)];
        int idxL1 = 0;
        int idxL2 = 0;
        int idx = 0;
        while (idxL1 < l1Len && idxL2 < l2Len) {
            int num1 = nums1[idxL1];
            int num2 = nums2[idxL2];
            if (num1 == num2) {
                tempRes[idx++] = num1;
                ++idxL1;
                ++idxL2;
            } else if (num1 > num2) {
                ++idxL2;
            } else {
                ++idxL1;
            }
        }
        return Arrays.copyOfRange(tempRes, 0, idx);
    }
}
