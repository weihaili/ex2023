package leetcdoe.ex202302013;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/13 10:46
 */
public class Jump {

    public static void main(String[] args) {
        Jump demo = new Jump();
        int step = demo.jump(new int[]{2, 3, 1, 1, 4});
        System.out.println(step);
    }

    public int jump(int[] nums) {
        int step = 0;
        if (nums == null || nums.length == 0) {
            return step;
        }
        int len = nums.length;
        int end = 0;
        int maxPosition = 0;
        for (int i = 0; i < len - 1; ++i) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                ++step;
            }
        }
        return step;
    }

    public int jump1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int position = nums.length - 1;
        int step = 0;
        while (position > 0) {
            for (int i = 0; i < position; ++i) {
                if (i + nums[i] >= position) {
                    ++step;
                    position = i;
                    break;
                }
            }
        }
        return step;
    }
}
