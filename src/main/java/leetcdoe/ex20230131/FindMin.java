package leetcdoe.ex20230131;

public class FindMin {

    public static void main(String[] args) {
        FindMin demo = new FindMin();
        int[] nums = new int[]{3, 1, 2};
        int min = demo.findMin(nums);
        System.out.println(min);
    }

    public int findMin(int[] nums) {
        int minIdx = 0;
        int maxIdx = nums.length - 1;
        while (minIdx < maxIdx) {
            int pivot = minIdx + ((maxIdx - minIdx) >> 1);
            int curVal = nums[pivot];
            if (curVal < nums[maxIdx]) {
                maxIdx = pivot;
            } else {
                minIdx = pivot + 1;
            }
        }
        return nums[minIdx];
    }
}
