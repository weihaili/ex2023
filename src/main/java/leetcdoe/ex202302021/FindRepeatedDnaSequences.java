package leetcdoe.ex202302021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/21 10:34
 */
public class FindRepeatedDnaSequences {

    public static void main(String[] args) {
        FindRepeatedDnaSequences demo = new FindRepeatedDnaSequences();
        List<String> res = demo.findRepeatedDnaSequences("AAAAAAAAAAAAA");
        System.out.println(Arrays.toString(res.toArray()));
    }

    private int lmtLen = 10;
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 11) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - lmtLen; ++i) {
            String subStr = s.substring(i, i + lmtLen);
            map.put(subStr, map.getOrDefault(subStr, 0) + 1);
            if (map.get(subStr) == 2) {
                res.add(subStr);
            }
        }
        return res;
    }
}
