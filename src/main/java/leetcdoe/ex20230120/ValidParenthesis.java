package leetcdoe.ex20230120;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        ValidParenthesis demo = new ValidParenthesis();
        String str = "{[}]";
        boolean flag = demo.isValid(str);
        System.out.println(flag);
    }

    Map<Character, Character> dic = new HashMap<Character, Character>(){{
        put(')','(');
        put(']','[');
        put('}','{');
    }};

    public boolean isValid(String s) {
        if (s == null || ((s.length() & 1)) == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : chars) {
            if (dic.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != dic.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
