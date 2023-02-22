package leetcdoe.ex202302022;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/22 15:13
 */
public class Multiply {

    public static void main(String[] args) {
        Multiply demo = new Multiply();
        int product = demo.multiply(-333, 100);
        System.out.println(product);
    }

    public int multiply(int A, int B) {
        if (A == 0 || B == 0) {
            return 0;
        }
        if (Math.abs(A) < Math.abs(B)) {
            return multiply(B, A);
        }
        boolean negFlag = false;
        if (A > 0 && B < 0) {
            negFlag = true;
        }
        B = Math.abs(B);
        int product = 0;
        while (B > 0) {
            product += A;
            --B;
        }
        return negFlag ? -product : product;
    }
}
