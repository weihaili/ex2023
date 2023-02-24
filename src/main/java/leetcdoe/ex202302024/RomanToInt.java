package leetcdoe.ex202302024;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/24 16:06
 */
public class RomanToInt {

    public static void main(String[] args) {
        RomanToInt demo = new RomanToInt();
        int num = demo.romanToInt("MCMXCIV");
        System.out.println(num);
    }

    private Map<Character, Integer> map = new HashMap<Character, Integer>(){{
        put('I',1);
        put('V',5);
        put('X',10);
        put('L',50);
        put('C',100);
        put('D',500);
        put('M',1000);
    }};

    public int romanToInt(String s) {
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int val = map.get(s.charAt(i));
            if (i < n - 1 && val < map.get(s.charAt(i + 1))) {
                res -= val;
            } else {
                res += val;
            }
        }
        return res;
    }
}
