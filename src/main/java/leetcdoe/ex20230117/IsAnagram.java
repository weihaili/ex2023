package leetcdoe.ex20230117;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

    public static void main(String[] args) {
        IsAnagram demo = new IsAnagram();
        String ransomNote = "anagram";
        String magazine = "nagara";
        boolean flag = demo.isAnagram(ransomNote, magazine);
        System.out.println(flag);
    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        char[] tArr = t.toCharArray();
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }
}
