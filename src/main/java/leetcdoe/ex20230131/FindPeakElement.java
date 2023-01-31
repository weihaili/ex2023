package leetcdoe.ex20230131;

public class FindPeakElement {

    public static void main(String[] args) {
        FindPeakElement demo = new FindPeakElement();
        int[] nums = {1, 2, 4, 3, 6, 5};
        int res = demo.findPeakElement2(nums);
        System.out.println(res);
    }

    public int findPeakElement2(int[] nums) {
        int len = nums.length;
        int idx = (int) Math.random() * len;
        while (!(this.compare(nums, idx - 1, idx) < 0 && this.compare(nums, idx, idx + 1) > 0)) {
            if (this.compare(nums, idx, idx + 1) < 0) {
                idx += 1;
            } else {
                idx -= 1;
            }
        }
        return idx;
    }

    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int lIdx = 0;
        int rIdx = len - 1;
        int resIdx = -1;
        while (lIdx <= rIdx) {
            int midIdx = (lIdx + rIdx) >> 1;
            if (this.compare(nums, midIdx - 1, midIdx) < 0 && this.compare(nums, midIdx, midIdx + 1) > 0) {
                return midIdx;
            }
            if (compare(nums, midIdx, midIdx + 1) < 0) {
                resIdx = midIdx + 1;
            } else {
                resIdx = midIdx - 1;
            }
        }
        return resIdx;
    }

    private int[] getElement(int[] nums, int idx) {
        if (idx < 0 || idx >= nums.length) {
            return new int[]{0, 0};
        }
        return new int[]{1, nums[idx]};
    }

    private int compare(int[] nums, int idx1, int idx2) {
        int[] num1 = this.getElement(nums, idx1);
        int[] num2 = this.getElement(nums, idx2);
        if (num1[0] != num2[0]) {
            return num1[0] > num2[0] ? 1 : -1;
        }
        if (num1[1] == num2[1]) {
            return 0;
        }
        return num1[1] > num2[1] ? 1 : -1;
    }

    public int findPeakElement1(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        return idx;
    }
}
