package lnitcode.ex20230310;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/10 15:29
 */
public class MostFrequentlyAppearingLetters {

    public static void main(String[] args) {
        MostFrequentlyAppearingLetters demo = new MostFrequentlyAppearingLetters();
        int num = demo.mostFrequentlyAppearingLetters("abca");
        System.out.println(num);
    }

    public int mostFrequentlyAppearingLetters(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map.values().stream().max(Integer::compareTo).get();
    }
}
