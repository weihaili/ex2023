package leetcdoe.ex202302013;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/13 15:33
 */
public class IsPerfectSquare {

    public static void main(String[] args) {
        IsPerfectSquare demo = new IsPerfectSquare();
        boolean flag = demo.isPerfectSquare(123456789);
        System.out.println(flag);
    }

    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) {
            return true;
        }
        int x = 1;
        int sqr = 1;
        while (x <= (num >> 1)) {
            if (sqr == num) {
                return true;
            }
            ++x;
            sqr = x * x;
        }
        return false;
    }

    public boolean isPerfectSquare9(int num) {
        int n = (int) Math.sqrt(num);
        return n * n == num;
    }
}
