package lnitcode.ex20230316;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/16 11:50
 */
public class Anagrams {

    public static void main(String[] args) {
        Anagrams demo = new Anagrams();
        List<String> res = demo.anagrams(new String[]{"lint", "intl", "inlt", "code"});
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<>();
        if (strs == null || strs.length < 2) {
            return res;
        }
        Map<String, Integer> keyToValueIdx = new HashMap<>() ;
        for (int i = 0; i < strs.length; ++i) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            if (!keyToValueIdx.containsKey(key)) {
                keyToValueIdx.put(key, -i - 1);
            } else {
                int unaddIdx = keyToValueIdx.get(key);
                if (unaddIdx < 0) {
                    res.add(strs[-unaddIdx -1]);
                }
                res.add(strs[i]);
                keyToValueIdx.put(key, i);
            }
        }
        return res;
    }
}
