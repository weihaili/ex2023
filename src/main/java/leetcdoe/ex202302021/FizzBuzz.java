package leetcdoe.ex202302021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/21 14:53
 */
public class FizzBuzz {

    public static void main(String[] args) {
        FizzBuzz demo = new FizzBuzz();
        List<String> strs = demo.fizzBuzz(15);
        System.out.println(Arrays.toString(strs.toArray()));
    }

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder buf = new StringBuilder();
        for (int i = 1; i <= n; ++i) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add(i - 1, "FizzBuzz");
            } else if (i % 3 == 0) {
                res.add(i - 1, "Fizz");
            } else if (i % 5 == 0) {
                res.add(i - 1, "Buzz");
            } else {
                res.add(i - 1, i + "");
            }
        }
        return res;
    }
}
