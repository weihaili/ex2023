package nowcoder.ex20230307;

import java.util.Stack;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 13:33
 */
public class ValidParenthesis {

    public static void main(String[] args) {
        ValidParenthesis demo = new ValidParenthesis();
        boolean flag = demo.isValid("{}(");
        System.out.println(flag);
    }

    public boolean isValid (String s) {
        if (s == null || s.length() == 0 || (s.length() & 1) == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            Character temp = stack.peek();
            if ((temp == '(' && c == ')') || (temp == '[' && c == ']') || (temp == '{' && c == '}')) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
