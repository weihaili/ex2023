package leetcdoe.ex20230307;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 17:00
 */
public class MaxOfThreeNumbers {

    public static void main(String[] args) {
        MaxOfThreeNumbers demo = new MaxOfThreeNumbers();
        int max = demo.maxOfThreeNumbers(1, 2, 3);
        System.out.println(max);
    }

    public int maxOfThreeNumbers(int num1, int num2, int num3) {
        return Math.max(Math.max(num1,num2), num3);
    }
}
