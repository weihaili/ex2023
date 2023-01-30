package leetcdoe.ex20230130;

import java.util.Arrays;

public class SearchRange {

    public static void main(String[] args) {
        SearchRange demo = new SearchRange();
        int[] nums = {8};
        int[] ints = demo.searchRange(nums, 8);
        System.out.println(Arrays.toString(ints));
    }

    public int[] searchRange(int[] nums, int target) {
        int start = this.binarySearch(nums, target, true);
        int end = this.binarySearch(nums, target, false) - 1;
        if (start <= end && nums[start] == target && nums[end] == target) {
            return new int[] {start, end};
        }
        return new int[]{-1, -1};
    }

    private int binarySearch(int[] nums, int target, boolean geFlag) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int len = nums.length;
        int startIdx = 0;
        int endIdx = len - 1;
        int res = len;
        while (startIdx <= endIdx) {
            int midIdx = (startIdx + endIdx) >> 1;
            int curVal = nums[midIdx];
            if (curVal > target || (geFlag && curVal >= target)) {
                endIdx = midIdx - 1;
                res = midIdx;
            } else {
                startIdx = midIdx + 1;
            }
        }
        return res;
    }
}
