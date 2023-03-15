package lnitcode.ex20230315;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/15 16:58
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache demo = new LRUCache(2);
        demo.set(2, 1);
        demo.set(1, 1);
        System.out.println(demo.get(2));
        demo.set(4, 1);
        System.out.println(demo.get(1));
        System.out.println(demo.get(2));
    }

    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

    private int maxSize;

    /*
     * @param capacity: An integer
     */
    public LRUCache(int capacity) {
        // do intialization if necessary
        maxSize = capacity;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (!map.containsKey(key)) {
            return -1;
        }
        Integer value = map.remove(key);
        map.put(key, value);
        return value;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
        } else {
            map.put(key, value);
        }
        while (map.size() > maxSize) {
            Iterator<Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
    }
}
