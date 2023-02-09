package leetcdoe.ex20230209;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/9 10:44
 */
public class LetterCombinations {

    private Map<Character, String> map = new HashMap<Character, String>(){{
        put('1', "");
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public static void main(String[] args) {
        LetterCombinations demo = new LetterCombinations();
        List<String> res = demo.letterCombinations("");
        if (res == null) {
            System.out.println("res is null");
        }
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        backtrack(res, digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(List<String> res, String digits, int idx, StringBuilder combination) {
        if (digits.length() == idx) {
            res.add(combination.toString());
        } else {
            char digit = digits.charAt(idx);
            String letters = map.get(digit);
            int lettersLen = letters.length();
            for (int i = 0; i < lettersLen; ++i) {
                combination.append(letters.charAt(i));
                backtrack(res, digits, idx + 1, combination);
                combination.deleteCharAt(idx);
            }
        }
    }
}
