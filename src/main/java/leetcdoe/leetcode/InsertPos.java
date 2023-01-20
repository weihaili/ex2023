package leetcdoe.leetcode;

public class InsertPos {

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 4;
        InsertPos demo = new InsertPos();
        int res = demo.searchInsert(nums, target);
        System.out.println(res);
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int first = 0;
        int last = nums.length -1;
        while (first <= last) {
            int mid = first + ((last - first) >> 1);
            if (nums[mid] < target) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return first;
    }

    public int searchInsert2(int[] nums, int target) {
        int idx = 0;
        if (nums == null || nums.length < 1) {
            return idx;
        }
        if (nums[0] > target) {
            return idx;
        }

        if (nums[nums.length -1] < target) {
            return nums.length;
        }
        int first = 0;
        int last = nums.length -1;
        int mid = (first + last) >> 1;
        //todo 新元素插入位置确定
        while (first <= last) {
            int midVal = nums[mid];
            if (midVal == target) {
                idx = mid;
                break;
            } else if (midVal > target) {
                last = mid - 1;
            } else if (midVal < target) {
                first = mid + 1;
            }
            mid = (first + last) >> 1;
        }
        return idx;
    }
}
