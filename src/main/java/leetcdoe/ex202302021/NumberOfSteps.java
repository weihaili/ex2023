package leetcdoe.ex202302021;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/21 14:38
 */
public class NumberOfSteps {

    public static void main(String[] args) {
        NumberOfSteps demo = new NumberOfSteps();
        int steps = demo.numberOfSteps(123);
        System.out.println(steps);
    }

    public int numberOfSteps(int num) {
        int step = 0;
        while (num > 0) {
            num = (num & 1) != 1 ? num >> 1 : --num;
            ++step;
        }
        return step;
    }
}
