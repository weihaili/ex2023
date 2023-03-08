package lnitcode.ex20230308;

import java.util.Stack;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 16:22
 */
public class MatchParentheses {

    public static void main(String[] args) {
        MatchParentheses demo = new MatchParentheses();
        boolean flag = demo.matchParentheses("(())");
        System.out.println(flag);
    }

    public boolean matchParentheses(String string) {
        if (string == null || (string.length() & 1) == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : string.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            char temp = stack.peek();
            if (temp == '(' && c == ')') {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        return stack.isEmpty();
    }
}
