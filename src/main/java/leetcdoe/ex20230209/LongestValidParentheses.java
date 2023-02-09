package leetcdoe.ex20230209;

import java.util.Stack;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/9 16:08
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        LongestValidParentheses demo = new LongestValidParentheses();
        int len = demo.longestValidParentheses("((()))))");
        System.out.println(len);
    }

    public int longestValidParentheses(String s) {
        int res = 0;
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    public int longestValidParentheses1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i -1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2]: 0) + 2;
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
