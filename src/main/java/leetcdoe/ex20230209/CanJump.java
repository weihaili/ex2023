package leetcdoe.ex20230209;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/9 15:57
 */
public class CanJump {

    public static void main(String[] args) {
        CanJump demo = new CanJump();
        boolean flag = demo.canJump(new int[]{2,0,0,1,4});
        System.out.println(flag);
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        int maxCanIdx = 0;
        for (int i = 0; i < len; ++i) {
            if (i <= maxCanIdx) {
                maxCanIdx = Math.max(maxCanIdx, i + nums[i]);
                if (maxCanIdx >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
