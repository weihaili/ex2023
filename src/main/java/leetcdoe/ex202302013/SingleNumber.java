package leetcdoe.ex202302013;

/**
 * Description:异或运算
 *  a ^ 0 = a
 *  a ^ a = 0
 *  a ^ b ^ c = a ^ c ^ b
 *
 * @author Admin
 * @date 2023/2/13 9:06
 */
public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber demo = new SingleNumber();
        int sn = demo.singleNumber(new int[]{4, 1, 2, 1, 2});
        System.out.println(sn);
    }
    public int singleNumber(int[] nums) {
        int res = 0;
        if (nums == null || nums.length == 0) {
            return res;
        }
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
