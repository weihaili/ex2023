package lnitcode.ex20230316;

import java.util.Stack;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/16 15:09
 */
public class Calculate {

    public static void main(String[] args) {
        Calculate demo = new Calculate();
        int res = demo.calculate(" 3/2 ");
        System.out.println(res);
    }

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        char operator = '+';
        int num = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - 48);
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                switch (operator) {
                    case '+' :
                        stack.push(num);
                        break;
                    case '-' :
                        stack.push(-num);
                        break;
                    case '*' :
                        stack.push(stack.pop() * num);
                        break;
                    case '/' :
                        stack.push(stack.pop() / num);
                        break;
                }
                num = 0;
                operator = c;
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
