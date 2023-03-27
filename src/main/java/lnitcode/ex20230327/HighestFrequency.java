package lnitcode.ex20230327;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HighestFrequency {

    public static void main(String[] args) {
        HighestFrequency demo = new HighestFrequency();
        String[] params = {"192.168.1.1","192.118.2.1","192.168.1.1"};
        String ipStr = demo.highestFrequency(params);
        System.out.println(ipStr);
    }

    public String highestFrequency(String[] ipLines) {
        if (ipLines == null || ipLines.length == 0) {
            return "";
        }
        Map<String, Integer> map = new HashMap<>();
        for (String ip : ipLines) {
            map.put(ip, map.getOrDefault(ip, 0) + 1);
        }
        return map.entrySet().stream().max((entry1, entry2)-> entry1.getValue() - entry2.getValue()).get().getKey();
    }
}
