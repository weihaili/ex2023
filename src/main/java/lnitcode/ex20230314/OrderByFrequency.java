package lnitcode.ex20230314;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/14 14:41
 */
public class OrderByFrequency {

    public static void main(String[] args) {
        OrderByFrequency demo = new OrderByFrequency();
        Map<Integer, List<Integer>> map = demo.orderByFrequency(new int[]{1, 0});
        for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + Arrays.toString(entry.getValue().toArray()));
        }
    }

    public Map<Integer, List<Integer>> orderByFrequency(int[] nums) {
        Map<Integer, List<Integer>> map  = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        if (nums == null || nums.length == 0) {
            return map;
        }
        Map<Integer, Integer> temp = new TreeMap<>();
        for (int num : nums) {
            temp.put(num, temp.getOrDefault(num, 0) + 1);
        }
        for (Entry<Integer, Integer> entry : temp.entrySet()) {
            int value = entry.getValue();
            List<Integer> element = map.getOrDefault(value, new ArrayList<>());
            element.add(entry.getKey());
            map.put(value, element);
        }
        return map;
    }
}
