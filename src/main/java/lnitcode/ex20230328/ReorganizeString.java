package lnitcode.ex20230328;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ReorganizeString {

    public static void main(String[] args) {
        ReorganizeString demo = new ReorganizeString();
        String param1 = "abcaa";
        String param2 = "aaab";
        String str = demo.reorganizeString(param1);
        System.out.println(str);
    }

    public String reorganizeString(String s) {
        if (s == null || s.trim().length() < 3) {
            return s;
        }
        int len = s.length();
        int[] charCnt = new int[26];
        for (char c : s.toCharArray()) {
            charCnt[c - 'a'] += 100;
        }
        for (int i = 0; i < 26; i++) {
            charCnt[i] += i;
        }
        Arrays.sort(charCnt);
        char[] res = new char[len];
        int t = 1;
        for (int code : charCnt) {
            if (code < 100) {
                continue;
            }
            int cnt = code / 100;
            if (cnt > (len + 1 >> 1)) {
                return "";
            }
            char ch = (char)('a' + (code % 100));
            for (int i = 0; i < cnt; ++i) {
                if (t >= len) {
                    t = 0;
                }
                res[t] = ch;
                t += 2;
            }
        }
        return new String(res);
    }

    public String reorganizeString1(String s) {
        if (s == null || s.trim().length() < 3) {
            return s;
        }
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int max = 0;
        char maxC = ' ';
        for (char c : chars) {
            int cnt = map.getOrDefault(c, 0) + 1;
            map.put(c, cnt);
            if (cnt > max) {
                max = cnt;
                maxC = c;
            }
        }
        if ((len & 1) == 1) {
            if ( max > ((len >> 1) + 1)) {
                return "";
            }
        } else {
            if (max > len >> 1) {
                return "";
            }
        }
        StringBuilder buf = new StringBuilder();
        buf.append(maxC);
        map.put(maxC, map.get(maxC) - 1);
        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        while (buf.length() < len) {
            char c = buf.charAt(buf.length() - 1);
            for (Map.Entry<Character, Integer> entry : entrySet) {
                Character key = entry.getKey();
                int val = entry.getValue();
                if (key == c && val == 0) {
                    entrySet.remove(entry);
                    continue;
                }
                if (key == c) {
                    continue;
                }
                buf.append(key);
                entry.setValue(--val);
            }
        }
        return buf.toString();
    }
}
