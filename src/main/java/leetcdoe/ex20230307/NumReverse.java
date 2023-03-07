package leetcdoe.ex20230307;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 16:22
 */
public class NumReverse {

    public static void main(String[] args) {
        NumReverse demo = new NumReverse();
        int res = demo.reverseInteger(900);
        System.out.println(res);
    }

    public int reverseInteger(int number) {
        return Integer.parseInt(new StringBuilder(number + "").reverse().toString());
    }
}
