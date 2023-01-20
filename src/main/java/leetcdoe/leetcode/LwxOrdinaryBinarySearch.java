package leetcdoe.leetcode;

import java.util.Arrays;

public class LwxOrdinaryBinarySearch {

    public static void main(String[] args) {
        LwxOrdinaryBinarySearch demo = new LwxOrdinaryBinarySearch();
        int[] nums = {-1,0,3,5,9,12};
        int target = 2;
        int res = demo.search(nums, target);
        System.out.println(res);
    }

    public int search(int[] nums, int target) {
        int idx = -1;
        if (nums == null || nums.length < 1) {
            return idx;
        }
        Arrays.sort(nums);
        int first = 0;
        int last = nums.length - 1;
        int mid = (first + last) >> 1;
        while (first <= last) {
            int middle = nums[mid];
            if (middle == target) {
                idx = mid;
                break;
            } else if (middle > target) {
                last = mid - 1;
            } else if (middle < target) {
                first = mid + 1;
            }
            mid = (first + last) >> 1;
        }
        return idx;
    }
}
