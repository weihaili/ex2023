package leetcdoe.ex20230117;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring demo = new LengthOfLongestSubstring();
        String str = "ababcabdcs";
        int len = demo.lengthOfLongestSubstring(str);
        System.out.println(len);
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        if (s == null) {
            return res;
        }
        Set<Character> set = new HashSet<>();
        int len = s.length();
        int rt = 0;
        for (int i = 0; i < len; ++i) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rt < len && !set.contains(s.charAt(rt))) {
                set.add(s.charAt(rt));
                ++rt;
            }
            res = Math.max(res, rt - i);
        }
        return res;
    }
}
