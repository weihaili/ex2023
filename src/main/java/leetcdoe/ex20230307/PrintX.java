package leetcdoe.ex20230307;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 17:29
 */
public class PrintX {

    public static void main(String[] args) {
        PrintX demo = new PrintX();
        List<String> strs = demo.printX(5);
        System.out.println(Arrays.toString(strs.toArray()));
    }

    public List<String> printX(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        char[] chars = new char[n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                chars[j] = ' ';
            }
            chars[i] = 'X';
            chars[n - i - 1] = 'X';
            res.add(new String(chars));
        }
        return res;
    }
}
