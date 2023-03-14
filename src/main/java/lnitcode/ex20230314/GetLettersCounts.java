package lnitcode.ex20230314;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/14 13:48
 */
public class GetLettersCounts {

    public static void main(String[] args) {
        GetLettersCounts demo = new GetLettersCounts();
        Map<String, Integer> map = demo.getLettersCounts("Lintcode 666");
        for (Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public Map<String, Integer> getLettersCounts(String s) {
        int nums = 0;
        int letters = 0;
        int spaces = 0;
        int others = 0;
        Map<String, Integer> map = new HashMap<>();
        if (s == null || s.isEmpty()) {
            return map;
        }
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                ++letters;
            } else if (Character.isDigit(c)) {
                ++nums;
            } else if (Character.isSpaceChar(c)) {
                ++spaces;
            } else {
                ++others;
            }
        }
        if (letters > 0) {
            map.put("Letters", letters);
        }
        if (nums > 0) {
            map.put("Numbers", nums);
        }
        if (spaces > 0) {
            map.put("Spaces", spaces);
        }
        if (others > 0) {
            map.put("Others", others);
        }
        return map;
    }
}
