package leetcdoe.ex20230120;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {

    public static void main(String[] args) {
        CheckPermutation demo = new CheckPermutation();
        String str1 = "abb";
        String str2 = "aab";
        boolean flag = demo.CheckPermutation(str1, str2);
        System.out.println(flag);
    }

    public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> s1Dic = this.getCharCount(s1);
        Map<Character, Integer> s2Dic = this.getCharCount(s2);
        for (Map.Entry<Character, Integer> entry : s1Dic.entrySet()) {
            Character key = entry.getKey();
            if (!s2Dic.containsKey(key) || s2Dic.get(key) != entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> getCharCount(String s1) {
        Map<Character, Integer> dic = new HashMap<>();
        if (s1 == null) {
            return dic;
        }
        char[] chars = s1.toCharArray();
        for (char ch : chars) {
            Integer count = dic.get(ch);
            count = count != null ? ++count : 1;
            dic.put(ch, count);
        }
        return dic;
    }
}
