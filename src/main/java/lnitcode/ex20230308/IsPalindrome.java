package lnitcode.ex20230308;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 14:22
 */
public class IsPalindrome {

    public static void main(String[] args) {
        IsPalindrome demo = new IsPalindrome();
        boolean flag = demo.isPalindrome(1232);
        System.out.println(flag);
    }

    public boolean isPalindrome(int num) {
        String str = "" + num;
        int len = str.length();
        for (int i = 0; i < len >> 1; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
