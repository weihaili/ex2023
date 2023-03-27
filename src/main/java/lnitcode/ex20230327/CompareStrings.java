package lnitcode.ex20230327;

import java.util.HashMap;
import java.util.Map;


public class CompareStrings {

    public static void main(String[] args) {
        CompareStrings demo = new CompareStrings();
        boolean flag = demo.compareStrings("ABCD", "ABBD");
        System.out.println(flag);
    }

    public boolean compareStrings(String a, String b) {
        for (int i = 0; i < b.length(); ++i) {
            if (a.indexOf(b.charAt(i)) == -1) {
                return false;
            }
            a = a.substring(0, a.indexOf(b.charAt(i))) + a.substring(a.indexOf(b.charAt(i))+ 1);
        }
        return true;
    }

    public boolean compareStrings1(String a, String b) {
        if (a == null || b == null) {
            return false;
        }
        Map<Character, Integer> aMap = countChar(a);
        Map<Character, Integer> bMap = countChar(b);
        for (Map.Entry<Character, Integer> entry : bMap.entrySet()) {
            Character key = entry.getKey();
            Integer cnt = entry.getValue();
            if (!aMap.containsKey(key)) {
                return false;
            }
            if (aMap.get(key).compareTo(cnt) < 0) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> countChar(String a) {
        Map<Character, Integer> map = new HashMap<>();
        if (a == null || a.length() == 0) {
            return map;
        }
        for (char c : a.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
