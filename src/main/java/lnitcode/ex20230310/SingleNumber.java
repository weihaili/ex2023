package lnitcode.ex20230310;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/10 13:34
 */
public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber demo = new SingleNumber();
        int num = demo.singleNumber(new int[]{1, 2, 1, 2, 3});
        System.out.println(num);
    }

    public int singleNumber(int[] a) {
        int res = 0;
        for (int num : a) {
            res ^= num;
        }
        return res;

    }

}
