package leetcdoe.ex20230209;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/9 14:39
 */
public class GuessNumber {
    public static void main(String[] args) {
        GuessNumber demo = new GuessNumber();
        int num = demo.guessNumber(3);
        System.out.println(num);
    }

    public int guessNumber(int n) {
        int ln = 1;
        int bn = n;
        while (ln < bn) {
            int mid = ln + bn >> 1;
            if (guss(mid) <= 0) {
                bn = mid;
            } else {
                ln = ++mid;
            }
        }
        return ln;
    }

    private int guss(int num) {
        return -1;
    }
}
