package lnitcode.ex20230308;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 14:13
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        LengthOfLastWord demo = new LengthOfLastWord();
        int len = demo.lengthOfLastWord("ab  ");
        System.out.println(len);
    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        String temp = s.trim();
        return temp.substring(temp.lastIndexOf(" ") + 1).length();
    }
}
