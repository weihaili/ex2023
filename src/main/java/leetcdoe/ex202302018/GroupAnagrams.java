package leetcdoe.ex202302018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/20 14:11
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams demo = new GroupAnagrams();
//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] strs = {""};
        String[] strs = null;
        List<List<String>> res = demo.groupAnagrams(strs);
        for (List<String> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
     }
}
