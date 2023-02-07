package leetcdoe.ex20230207;

import io.swagger.models.auth.In;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/7 14:20
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        FirstUniqChar demo = new FirstUniqChar();
        int idx = demo.firstUniqChar("aabbccd");
        System.out.println(idx);
    }

    public int firstUniqChar(String s) {
        if (s != null && s.length() != 0) {
            Map<Character, Integer> rule = new HashMap<>();
            char[] chars = s.toCharArray();
            int len = chars.length;
            for (int i = 0; i < len; ++i) {
                char aChar = chars[i];
                rule.put(aChar, rule.getOrDefault(aChar, 0) + 1);
            }
            for (int i = 0; i < len; ++i) {
                if (rule.get(chars[i]) == 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int firstUniqChar1(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            for (int j = 0; j < chars.length; j++) {
                if (c == chars[j]) {
                    count++;
                }
            }
            if (count == 1) {
                return i;
            } else {
                count = 0;
            }
        }
        return -1;
    }
}
