package leetcdoe.ex20230307;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 16:34
 */
public class CircleCalculate {

    public static void main(String[] args) {
        CircleCalculate demo = new CircleCalculate();
        double[] arr = demo.calculate(2);
        System.out.println(Arrays.toString(arr));
    }

    public double[] calculate(int r) {
        double[] res = new double[2];
        res[0] = 2 * Math.PI* r;
        res[1] = Math.PI * Math.pow(r, 2);
        return res;
    }
}
