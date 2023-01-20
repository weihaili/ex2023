package leetcdoe.ex20230117;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {

    public static void main(String[] args) {
        CanConstruct demo = new CanConstruct();
        String ransomNote = "aa";
        String magazine = "ab";
        boolean flag = demo.canConstruct(ransomNote, magazine);
        System.out.println(flag);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> noteMap = getCharTimes(ransomNote);
        Map<Character, Integer> mgzMap = getCharTimes(magazine);
        for (Map.Entry<Character, Integer> entry : noteMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            Integer exTimes = mgzMap.get(key);
            if (exTimes == null || exTimes != value) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> getCharTimes(String str) {
        Map<Character, Integer> map = new HashMap<>();
        if (str == null || str.length() < 1) {
            return map;
        }
        for (char ch : str.toCharArray()) {
            Integer time = map.get(ch);
            map.put(ch, time != null ? ++time : 1);
        }
        return map;
    }
}
