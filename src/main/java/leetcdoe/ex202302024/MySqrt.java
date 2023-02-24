package leetcdoe.ex202302024;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/24 9:08
 */
public class MySqrt {

    public static void main(String[] args) {
        MySqrt demo = new MySqrt();
        int num = demo.mySqrt(10);
        System.out.println(num);
    }

    public int mySqrt(int x) {
        int ln = 0;
        int rn = x;
        int res = -1;
        while (ln <= rn) {
            int mn = (ln + rn) >> 1;
            if ((long)mn * mn <= x) {
                res = mn;
                ln = mn + 1;
            } else {
                rn = mn - 1;
            }
        }
        return res;
    }
}
