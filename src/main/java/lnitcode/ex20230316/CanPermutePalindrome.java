package lnitcode.ex20230316;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/16 10:27
 */
public class CanPermutePalindrome {

    public static void main(String[] args) {
        CanPermutePalindrome demo = new CanPermutePalindrome();
        boolean flag = demo.canPermutePalindrome("aba");
        System.out.println(flag);
    }

    public boolean canPermutePalindrome1(String s) {
        if (s == null) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int noRpCnt = 0;
        for (Character key : map.keySet()) {
            noRpCnt += map.get(key) % 2;
        }
        return noRpCnt < 2;
    }

    public boolean canPermutePalindrome(String s) {
        if (s == null) {
            return false;
        }
        BitSet bs = new BitSet();
        for (byte b : s.getBytes()) {
            bs.flip(b);
        }
        return bs.cardinality() < 2;
    }
}
