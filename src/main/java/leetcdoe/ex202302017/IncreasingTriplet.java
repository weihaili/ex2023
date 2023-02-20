package leetcdoe.ex202302017;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/17 14:05
 */
public class IncreasingTriplet {

    public static void main(String[] args) {
        IncreasingTriplet demo = new IncreasingTriplet();
        boolean flag = demo.increasingTriplet(new int[]{20, 100, 10, 12, 5, 13});
        System.out.println(flag);
    }

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; ++i) {
            int num = nums[i];
            if (num > second) {
                return true;
            } else if (num > first) {
                second = num;
            } else {
                first = num;
            }
        }
        return false;
    }
}
