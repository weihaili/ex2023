package leetcdoe.ex202302027;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/27 17:40
 */
public class MinRemoveToMakeValid {

    public static void main(String[] args) {
        MinRemoveToMakeValid demo = new MinRemoveToMakeValid();
        String str = demo.minRemoveToMakeValid("a)b(c)d");
        System.out.println(str);
    }

    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Set<Integer> rmIdx = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            }
            if (ch == ')') {
                if (stack.isEmpty()) {
                    rmIdx.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            rmIdx.add(stack.pop());
        }
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            if (rmIdx.contains(i)) {
                continue;
            }
            buf.append(s.charAt(i));
        }
        return buf.toString();
    }
}
