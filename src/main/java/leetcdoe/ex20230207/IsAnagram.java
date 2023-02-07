package leetcdoe.ex20230207;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/7 15:25
 */
public class IsAnagram {
    public static void main(String[] args) {
        IsAnagram demo = new IsAnagram();
        boolean flag = demo.isAnagram("aa", "a");
        System.out.println(flag);
    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int[] cnt = new int[26];
        char[] sChars = s.toCharArray();
        for (char ch : sChars) {
            ++cnt[ch - 'a'];
        }
        char[] tChars = t.toCharArray();
        for (char ch : tChars) {
            --cnt[ch - 'a'];
        }
        return Arrays.equals(cnt, new int[26]);
    }
}
