package lnitcode.ex20230316;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/16 14:10
 */
public class ReverseWords {

    public static void main(String[] args) {
        ReverseWords demo = new ReverseWords();
        String res = demo.reverseWords("a b c");
        System.out.println(res);
    }

    public String reverseWords(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        String[] strs = str.trim().split(" ");
        StringBuilder buf = new StringBuilder();
        for (int i = strs.length - 1; i > -1; --i) {
            buf.append(" ").append(strs[i]);
        }
        return buf.substring(1);
    }
}
