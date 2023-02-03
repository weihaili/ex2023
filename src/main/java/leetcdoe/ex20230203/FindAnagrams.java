package leetcdoe.ex20230203;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/3 10:33
 */
public class FindAnagrams {

    public static void main(String[] args) {
        FindAnagrams demo = new FindAnagrams();
        List<Integer> res = demo.findAnagrams("abcdefg", "cb");
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null) {
            return Collections.emptyList();
        }
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>(sLen - pLen);
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(sCount, pCount)) {
            res.add(0);
        }
        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];
            if (Arrays.equals(sCount, pCount)) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        if (s == null || p == null) {
            return Collections.emptyList();
        }
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>(sLen - pLen);
        int[] count = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }
        int dif = 0;
        for (int i = 0; i < 26; ++i) {
            if (count[i] != 0) {
                ++dif;
            }
        }
        if (dif == 0) {
            res.add(0);
        }
        for (int i = 0; i < sLen - pLen; ++i) {
            if (count[s.charAt(i) - 'a'] == 1) {
                --dif;
            } else {
                ++dif;
            }
            --count[s.charAt(i) - 'a'];
            if (count[s.charAt(i + pLen) - 'a'] == -1) {
                --dif;
            } else if (count[s.charAt(i + pLen) - 'a'] == 0) {
                ++dif;
            }
            ++count[s.charAt(i+pLen) - 'a'];
            if (dif == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public List<Integer> findAnagrams1(String s, String p) {
        if (s == null || p == null) {
            return Collections.emptyList();
        }
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return Collections.emptyList();
        }
        Map<Character, Integer> rule = new HashMap<>();
        char[] chars = p.toCharArray();
        for (char aChar : chars) {
            rule.put(aChar, rule.getOrDefault(aChar, 0) + 1);
        }
        char[] sChars = s.toCharArray();

        List<Integer> res = new ArrayList<>(sLen - pLen);
        for (int i = 0; i <= sLen - pLen; i++) {
            Map<Character, Integer> temp = new HashMap<>();
            for (int j = i; j < i + pLen; j++) {
                temp.put(sChars[j], temp.getOrDefault(sChars[j], 0) + 1);
            }
            if (temp.size() == rule.size() && temp.keySet().containsAll(rule.keySet())) {
                boolean flag = true;
                for (Entry<Character, Integer> entry : rule.entrySet()) {
                    Character key = entry.getKey();
                    Integer value = entry.getValue();
                    if (!temp.get(key).equals(value)) {
                        flag = false;
                    }
                }
                if (flag) {
                    res.add(i);
                }
            }
        }
        return res;
    }
}
