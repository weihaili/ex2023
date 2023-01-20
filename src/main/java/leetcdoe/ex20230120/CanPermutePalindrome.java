package leetcdoe.ex20230120;


import java.util.HashMap;
import java.util.Map;

public class CanPermutePalindrome {

    public static void main(String[] args) {
        CanPermutePalindrome demo = new CanPermutePalindrome();
        String str = "a";
        boolean flag = demo.canPermutePalindrome(str);
        System.out.println(flag);
    }

    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() < 1) {
            return false;
        }
        Map<Character, Integer> dic = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            Integer count = dic.get(ch);
            dic.put(ch, count == null ? 1 : ++count);
        }

        return dic.values().stream().filter(num -> (num & 1) == 1).count() <= 1;
    }
}
