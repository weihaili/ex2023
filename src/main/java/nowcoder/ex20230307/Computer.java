package nowcoder.ex20230307;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 14:30
 */
public class Computer {

    public static void main(String[] args) {
        Computer demo = new Computer();
        int res = demo.solve("3+2*3*4-1");
        System.out.println(res);
    }

    public int solve(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] res = func(s, 0);
        return res[0];
    }

    private int[] func(String s, int idx) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char op = '+';
        int i;
        int len = s.length();
        for (i = idx; i < len; i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + s.charAt(i) - '0';
                if (i != len - 1) {
                    continue;
                }
            }
            if (s.charAt(i) == '(') {
                int[] arr = func(s, i + 1);
                num = arr[0];
                i = arr[1];
                if (i != len - 1) {
                    continue;
                }
            }
            switch (op) {
                case '+':
                    stack.push(num);
                    break;
                case '-':
                    stack.push(-num);
                    break;
                case '*':
                    int temp = stack.pop();
                    stack.push(temp * num);
                    break;
            }
            num = 0;
            if (s.charAt(i) == ')') {
                break;
            } else {
                op = s.charAt(i);
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return new int[]{sum, i};
    }
}
