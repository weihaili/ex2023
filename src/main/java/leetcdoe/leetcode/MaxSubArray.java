package leetcdoe.leetcode;

public class MaxSubArray {

    public static void main(String[] args) {
        MaxSubArray demo = new MaxSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int res = demo.maxSubArray(nums);
        System.out.println(res);
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int pre = 0;
        int maxRes = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxRes = Math.max(maxRes, pre);
        }
        return maxRes;
    }
}
