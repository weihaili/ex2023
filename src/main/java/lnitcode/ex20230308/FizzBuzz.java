package lnitcode.ex20230308;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 17:00
 */
public class FizzBuzz {

    public static void main(String[] args) {
        FizzBuzz demo = new FizzBuzz();
        List<String> res = demo.fizzBuzz(15);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<String> fizzBuzz(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("fizz buzz");
                continue;
            }
            if (i % 3 == 0) {
                res.add("fizz");
                continue;
            }
            if (i % 5 == 0) {
                res.add("buzz");
                continue;
            }
            res.add("" + i);
        }
        return res;
    }
}
