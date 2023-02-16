package leetcdoe.ex202302016;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/16 15:17
 */
public class IntegerBreak {

    public static void main(String[] args) {
        IntegerBreak demo = new IntegerBreak();
        int num = demo.integerBreak(10);
        System.out.println(num);
    }

    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int qt = n / 3;
        int rm = n % 3;
        if (rm == 0) {
            return (int)Math.pow(3, qt);
        } else if (rm == 1) {
            return (int) Math.pow(3, qt - 1) * 4;
        } else {
            return (int)Math.pow(3, qt) * 2;
        }
    }
}
