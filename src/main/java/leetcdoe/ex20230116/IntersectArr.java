package leetcdoe.ex20230116;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IntersectArr {

    public static void main(String[] args) {
        IntersectArr demo = new IntersectArr();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2, 2};
        int[] res = demo.intersect(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (isEmptyArr(nums1) || isEmptyArr(nums2)) {
            return null;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int idx1 = 0;
        int idx2 = 0;
        int[] arr = new int[Math.min(len1, len2)];
        int idx = 0;
        while (idx1 < len1 && idx2 < len2) {
            if (nums1[idx1] > nums2[idx2]) {
                idx2++;
            } else if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else {
                arr[idx++] = nums1[idx1];
                idx1++;
                idx2++;
            }
        }
        return Arrays.copyOfRange(arr, 0, idx);
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        if (isEmptyArr(nums1) || isEmptyArr(nums2)) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            Integer times = map.get(nums1[i]);
            times = times != null ? times ++ : 1;
            map.put(nums1[i], times);
        }

        Set<Integer> resSet = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            Integer temp = map.get(nums2[i]);
            if (temp != null) {
                resSet.add(nums2[i]);
            }
        }

        return resSet.stream().mapToInt(Integer::valueOf).toArray();
    }

    private boolean isEmptyArr(int[] arr) {
        return arr == null || arr.length < 1;
    }
}
