package lnitcode.ex20230330;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MissingString {

    public static void main(String[] args) {
        MissingString demo = new MissingString();
        String str1 = "This is an example", str11 = "is is is example";
        String str2 = "The cast of JusticeLeague minus Ben Affleck will be attending ACE Comic Con LONG ISLAND in December These prices are ridiculous", str22 = "JusticeLeague Comic";
        List<String> res = demo.missingString(str22, str2);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<String> missingString(String str1, String str2) {
        if (str1 == null && str2 == null) {
            return new ArrayList<>();
        }
        if ((str1 == null || str1.length() == 0) && str2 != null) {
            return Arrays.asList(str2.split(" "));
        }
        String[] arr1 = str1.split(" ");
        if ((str2 == null || str2.length() == 0) && str2 != null) {
            return Arrays.asList(arr1);
        }
        String[] arr2 = str2.split(" ");
        if (arr1.length < arr2.length) {
            return missingString(str2, str1);
        }
        Set<String> set = Arrays.stream(arr2).collect(Collectors.toSet());
        List<String> res = new ArrayList<>();
        for (String str : arr1) {
            if (set.contains(str)) {
                continue;
            }
            res.add(str);
        }
        return res;
    }

    public List<String> missingString1(String str1, String str2) {
        if (str1 == null && str2 == null) {
            return new ArrayList<>();
        }
        if ((str1 == null || str1.length() == 0) && str2 != null) {
            return Arrays.asList(str2.split(" "));
        }
        String[] arr1 = str1.split(" ");
        if ((str2 == null || str2.length() == 0) && str2 != null) {
            return Arrays.asList(arr1);
        }
        String[] arr2 = str2.split(" ");
        Map<String, Integer> map1 = getStrCntMap(arr1);
        Map<String, Integer> map2 = getStrCntMap(arr2);
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            if (!map2.containsKey(key)) {
                res.add(key);
                continue;
            }
            int val = entry.getValue();
            int temp = Math.abs(val - map2.get(key));
            for (int i = 0; i < temp; i++) {
                res.add(key);
            }
        }
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            if (!map1.containsKey(key)) {
                res.add(key);
            }
        }
        return res;
    }

    private Map<String, Integer> getStrCntMap(String[] arr){
        if (arr == null || arr.length == 0) {
            return new HashMap<>();
        }
        Map<String, Integer> map = new HashMap<>();
        for (String str : arr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        return map;
    }
}
