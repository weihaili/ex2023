package leetcdoe.ex20230117;

import java.util.Arrays;

public class CheckInclusion {

    public static void main(String[] args) {
        CheckInclusion demo = new CheckInclusion();
        String str1 = "ab";
        String str2 = "eidboaoo";
        boolean res = demo.checkInclusion(str1, str2);
        System.out.println(res);
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Cut = new int[26];
        int[] s2Cut = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            ++s1Cut[s1.charAt(i) - 'a'];
            ++s2Cut[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(s1Cut, s2Cut)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); ++i) {
            ++s2Cut[s2.charAt(i) - 'a'];
            --s2Cut[s2.charAt(i - s1.length()) - 'a'];
            if (Arrays.equals(s1Cut, s2Cut)) {
                return true;
            }
        }
        return false;
    }
}
