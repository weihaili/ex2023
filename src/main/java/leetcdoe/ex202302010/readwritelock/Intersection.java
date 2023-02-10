package leetcdoe.ex202302010.readwritelock;

import java.util.Arrays;


/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/10 15:52
 */
public class Intersection {
    public static void main(String[] args) {
        Intersection demo = new Intersection();
        int[] arr = demo.intersection(new int[]{1, 2, 3, 4}, new int[]{3, 4, 6});
        System.out.println(Arrays.toString(arr));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[Math.min(len1, len2)];
        int uidx = 0;
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < len1 && idx2 < len2) {
            int num1 = nums1[idx1];
            int num2 = nums2[idx2];
            if (num1 == num2) {
                if (uidx == 0 || res[uidx - 1] != num1) {
                    res[uidx] = num1;
                    ++uidx;
                }
                ++idx1;
                ++idx2;
            } else if (num1 > num2) {
                ++idx2;
            } else {
                ++idx1;
            }
        }
        return Arrays.copyOfRange(res, 0, uidx);
    }
}
