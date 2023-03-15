package lnitcode.ex20230315;

import java.util.ArrayList;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/15 14:38
 */
public class StrUtils {
    public static void main(String[] args) {
        StrUtils demo = new StrUtils();
        boolean flag = demo.isNotEmpty("  ");
        System.out.println(flag);

        ArrayList<Object> list = new ArrayList<>();
        list.remove(0);

    }

    public boolean isEmpty(String s) {
        // --- write your code here ---
        return s == null || s.trim().length() == 0;
    }

    public boolean isNotEmpty(String s) {
        // --- write your code here ---
        return !isEmpty(s);
    }

}
