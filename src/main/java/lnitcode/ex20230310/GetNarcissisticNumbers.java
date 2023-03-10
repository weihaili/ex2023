package lnitcode.ex20230310;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/10 13:40
 */
public class GetNarcissisticNumbers {

    public static void main(String[] args) {
        GetNarcissisticNumbers demo = new GetNarcissisticNumbers();
        List<Integer> res = demo.getNarcissisticNumbers(3);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<Integer> getNarcissisticNumbers(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int num = 0;
        while (true) {

            String numStr = String.valueOf(num);
            int len = numStr.length();
            if (len > n) {
                break;
            }
            int val = 0;
            for (int i = 0; i < len; i++) {
                val += Math.pow(numStr.charAt(i) - 48, len);
            }
            if (val != num) {
                ++num;
                continue;
            }
            String valStr = String.valueOf(val);
            int valLen = valStr.length();
            if (valLen > n) {
                break;
            }
            if (valLen != n) {
                ++num;
                continue;
            }
            res.add(val);
            ++num;
        }
        return res;
    }
}
