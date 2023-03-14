package lnitcode.ex20230314;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/14 16:28
 */
public class PutMap {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        putMap(map);
        map.entrySet().stream().forEach(System.out::println);
    }

    public static void putMap(Map<String, Integer> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("January", 31);
        map.put("February", 28);
        map.put("March", 31);
        map.put("April", 30);
        map.put("May", 31);
        map.put("June", 30);
        map.put("July", 31);
        map.put("August", 31);
        map.put("September", 30);
        map.put("October", 31);
        map.put("November", 30);
        map.put("December", 31);
    }
}
