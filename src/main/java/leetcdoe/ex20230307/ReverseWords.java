package leetcdoe.ex20230307;

import java.util.Stack;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 18:37
 */
public class ReverseWords {

    public static void main(String[] args) {
        ReverseWords demo = new ReverseWords();
        String res = demo.reverseWords("   the sky is blue");
        System.out.println(res);
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] arr = s.split(" ");
        Stack<String> stack = new Stack<>();
        for (String str : arr) {
            if ("".equals(str)) {
                continue;
            }
            stack.push(str);
        }
        StringBuilder buf = new StringBuilder();
        while (!stack.isEmpty()) {
            buf.append(" ").append(stack.pop());
        }
        return buf.length() > 0 ? buf.substring(1) : "";
    }
}
