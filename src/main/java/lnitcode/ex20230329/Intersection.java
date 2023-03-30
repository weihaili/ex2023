package lnitcode.ex20230329;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Intersection {

    public static void main(String[] args) {
        Intersection demo = new Intersection();
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {4, 5, 6};
        int[] res = demo.intersection(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    public int[] intersection3(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1Len = nums1.length;
        int n2Len = nums1.length;
        int idx1 = 0;
        int idx2 = 0;
        int idx = 0;
        int[] res = new int[Math.min(n1Len, n2Len)];
        while (idx1 < n1Len && idx2 < n2Len) {
            int num1 = nums1[idx1];
            int num2 = nums2[idx2];
            if (num1 == num2) {
                if (idx == 0 || res[idx] != res[idx - 1]) {
                    res[idx++] = num1;
                }
                ++idx1;
                ++idx2;
            } else if (num1 > num2) {
                ++idx2;
            } else {
                ++idx1;
            }
        }
        return Arrays.copyOfRange(res, 0, idx);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> n1Set = new HashSet<>(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
        Set<Integer> n2Set = new HashSet<>(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
        n1Set.retainAll(n2Set);
        return n1Set.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersection1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> n1Set = new HashSet<>(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
        Set<Integer> n2Set = new HashSet<>(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
        Set<Integer> tempRes = new HashSet<>();
        for (Integer num : n2Set) {
            if (n1Set.contains(num)) {
                tempRes.add(num);
            }
        }
        if (tempRes.isEmpty()) {
            return new int[0];
        }
        return tempRes.stream().mapToInt(Integer::intValue).toArray();
    }
}
