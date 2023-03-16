package lnitcode.ex20230316;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/16 11:26
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix demo = new LongestCommonPrefix();
        String str = demo.longestCommonPrefix(new String[]{"AB","ABCDEFG", "ABCEFG", "ABCEFA"});
        System.out.println(str);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        Arrays.sort(strs, (str1, str2) -> str1.length() - str2.length());
        String minStr = strs[0];
        StringBuilder buf = new StringBuilder();
        loop: for (int i = 0; i < minStr.length(); ++i) {
            char c = minStr.charAt(i);
            for (int j = 1; j < strs.length; ++j) {
                if (c != strs[j].charAt(i)) {
                    break loop;
                }
            }
            buf.append(c);
        }
        return buf.toString();
    }
}
