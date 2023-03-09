package lnitcode.ex20230309;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/9 10:59
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring demo = new LengthOfLongestSubstring();
        int len = demo.lengthOfLongestSubstring("z");
        System.out.println(len);
    }


    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int cnt = 0;
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int len = chars.length;
        int slowIdx = 0;
        int fastIdx = 1;
        while (fastIdx < len) {
            if (set.isEmpty()) {
                set.add(chars[slowIdx]);
            }
            if (!set.add(chars[fastIdx])) {
                cnt = Math.max(cnt, set.size());
                set.clear();
                ++slowIdx;
                fastIdx = slowIdx + 1;
                continue;
            }
            ++fastIdx;
        }
        return cnt >= set.size() ? cnt : set.size();
    }
}
