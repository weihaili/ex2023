package leetcdoe.ex20230117;

import java.util.HashSet;
import java.util.Set;

public class FirstUniqChar {

    public static void main(String[] args) {
        FirstUniqChar demo = new FirstUniqChar();
        String str = "leetcode";
        int idx = demo.firstUniqChar(str);
        System.out.println(idx);
    }
    public int firstUniqChar(String s) {
        int res = -1;
        if (s == null) {
            return res;
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length == 1) {
            res = 0;
        }
        Set<Character> set = new HashSet<>();
        boolean breakFlag = false;
        for (int i = 0; i < length; i++) {
            char tempChar = chars[i];
            if (!set.add(tempChar)) {
                continue;
            }
            for (int j = i + 1; j < length; j++) {
                if (tempChar == chars[j]) {
                    breakFlag = true;
                    break;
                }
            }
            if (breakFlag) {
                breakFlag = false;
                continue;
            }
            res = i;
            break;
        }
        return res;
    }
}
