package leetcdoe.ex20230201;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/1 8:37
 */
public class AutoCreaseAndDecrease {

    public static void main(String[] args) {
        AutoCreaseAndDecrease demo = new AutoCreaseAndDecrease();
        demo.autoCreaseBefore();
        demo.autoCreaseAfter();
    }

    private void autoCreaseBefore() {
        int i = 0;
        int a = ++i;
        System.out.println("a = " + a + ", i = " + i);
    }

    private void autoCreaseAfter() {
        int i = 0;
        int b = i++;
        System.out.println("b = " + b + ", i = " + i);
    }
}
