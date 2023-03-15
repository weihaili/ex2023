package lnitcode.ex20230315;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/15 16:25
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring demo = new LengthOfLongestSubstring();
        int maxLen = demo.lengthOfLongestSubstring("z");
        System.out.println(maxLen);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int len = chars.length;
        int maxLen = 0;
        for (int i = 0; i < len; ++i) {
            int rlen = 0;
            for (int j = i; j < len; ++j) {
                if (set.add(chars[j])) {
                    ++rlen;
                } else {
                    set.clear();
                    break;
                }
            }
            maxLen = Math.max(maxLen, rlen);
        }
        return maxLen;
    }
}
