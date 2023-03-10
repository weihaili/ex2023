package lnitcode.ex20230310;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/10 14:26
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        FirstUniqChar demo = new FirstUniqChar();
        char c = demo.firstUniqChar("ababcd");
        System.out.println(c);
    }

    public char firstUniqChar(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            boolean uniqueFlag = true;
            char c = chars[i];
            for (int j = 0; j < chars.length; j++) {
                if (j == i) {
                    continue;
                }
                if (c == chars[j]) {
                    uniqueFlag = false;
                    break;
                }
            }
            if (uniqueFlag) {
                return c;
            }
        }
        return ' ';
    }

    public char firstUniqChar1(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String[] arr = str.split(c + "");
            if (arr.length == 2) {
                return c;
            }
        }
        return ' ';
    }
}
