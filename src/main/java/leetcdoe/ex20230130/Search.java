package leetcdoe.ex20230130;

public class Search {

    public static void main(String[] args) {
        Search demo = new Search();
        int[] nums = {6,7,8,1,2,3};
        int res = demo.search(nums, 8);
        System.out.println(res);
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int len = nums.length;
        int startIdx = 0;
        int endIdx = len - 1;
        while (startIdx <= endIdx) {
            int midIdx = (startIdx + endIdx) >> 1;
            int curVal = nums[midIdx];
            if (curVal == target) {
                return midIdx;
            } else if (nums[0] <= curVal) {
                if (nums[0] <= target && target < curVal) {
                    endIdx = midIdx - 1;
                } else {
                    startIdx = midIdx + 1;
                }
            } else {
                if (curVal < target && target <= nums[len - 1]) {
                    startIdx = midIdx + 1;
                } else {
                    endIdx = midIdx - 1;
                }
            }
        }
        return -1;
    }
}
