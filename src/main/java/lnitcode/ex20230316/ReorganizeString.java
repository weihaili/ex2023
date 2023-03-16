package lnitcode.ex20230316;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/16 15:52
 */
public class ReorganizeString {

    public static void main(String[] args) {
        ReorganizeString demo = new ReorganizeString();
        String str = demo.reorganizeString("vvvlo");
        System.out.println(str);
    }

    public String reorganizeString(String s) {
        if (s == null || s.length() < 2) {
            return "";
        }
        int maxRpCharCnt = 0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            int cnt = map.getOrDefault(c, 0) + 1;
            map.put(c, cnt);
            maxRpCharCnt = Math.max(cnt, maxRpCharCnt);
        }
        int len = s.length();
        if (maxRpCharCnt > ((len & 1) == 1 ? (len >> 1) + 1 : len >> 1)) {
            return "";
        }
        Arrays.sort(chars);
        for (int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            for (int j = i + 1; j < chars.length; ++j) {
                if (c == chars[j]) {
                    continue;
                }
                char temp = chars[i + 1];
                chars[i + 1] = chars[j];
                chars[j] = temp;
            }
        }
        return new String(chars);
    }
}
