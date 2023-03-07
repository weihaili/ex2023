package leetcdoe.ex20230307;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 16:42
 */
public class CanWinBash {

    public static void main(String[] args) {
        CanWinBash demo = new CanWinBash();
        boolean flag = demo.canWinBash(5);
        System.out.println(flag);
    }

    public boolean canWinBash(int n) {
        return n % 4 != 0;
    }
}
