package leetcdoe.ex20230119;

import java.util.HashSet;
import java.util.Set;

public class IsUniqueChar {

    public static void main(String[] args) {
        String str = "null";
        IsUniqueChar demo = new IsUniqueChar();
        boolean res = demo.isUnique(str);
        System.out.println(res);
    }

    public boolean isUnique(String astr) {
        if (astr == null || astr.length() < 2) {
            return true;
        }
        Set<Character> unique = new HashSet<>();
        char[] chars = astr.toCharArray();
        for (char ch : chars) {
            if (unique.add(ch)) {
                continue;
            }
            return false;
        }
        return true;
    }
}
