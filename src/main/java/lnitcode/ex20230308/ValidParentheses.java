package lnitcode.ex20230308;

import java.util.Stack;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 16:36
 */
public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses demo = new ValidParentheses();
        boolean flag = demo.isValidParentheses("()[]");
        System.out.println(flag);
    }

    public boolean isValidParentheses(String s) {
        if (s == null || (s.length() & 1) == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            char temp = stack.peek();
            if (temp == '(' && c == ')' || temp == '[' && c == ']' || temp == '{' && c == '}') {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        return stack.isEmpty();
    }
}
