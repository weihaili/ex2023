package lnitcode.ex20230310;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/10 14:54
 */
public class IsUnique {

    public static void main(String[] args) {
        IsUnique demo = new IsUnique();
        boolean flag = demo.isUnique("");
        System.out.println(flag);
    }

    public boolean isUnique(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (!set.add(c)) {
                return false;
            }
        }
        return true;
    }
}
