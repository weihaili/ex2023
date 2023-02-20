package leetcdoe.ex202302018;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/20 16:36
 */
public class WordPattern {

    public static void main(String[] args) {
        WordPattern demo = new WordPattern();
        boolean flag = demo.wordPattern("abba", "dog cat mose dog");
        System.out.println(flag);
    }

    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> str2ch = new HashMap<>();
        Map<Character, String> ch2str = new HashMap<>();
        int m = s.length();
        int i = 0;
        char[] chars = pattern.toCharArray();
        for (int p = 0; p < chars.length; ++p) {
            if (i >= m) {
                return false;
            }
            int j = i;
            while (j < m && s.charAt(j) != ' '){
                ++j;
            }
            String str = s.substring(i, j);
            if (str2ch.containsKey(str) && str2ch.get(str) != chars[p]) {
                return false;
            }
            if (ch2str.containsKey(chars[p]) && !str.equals(ch2str.get(chars[p]))) {
                return false;
            }
            str2ch.put(str, chars[p]);
            ch2str.put(chars[p], str);
            i = j + 1;
        }
        return i >= m;
    }
}
