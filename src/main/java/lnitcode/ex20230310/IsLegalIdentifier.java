package lnitcode.ex20230310;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/10 15:36
 */
public class IsLegalIdentifier {

    public static void main(String[] args) {
        IsLegalIdentifier demo = new IsLegalIdentifier();
        boolean flag = demo.isLegalIdentifier("123_abc");
        System.out.println(flag);
    }

    public boolean isLegalIdentifier(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        char firstChar = str.charAt(0);
        if (Character.isDigit(firstChar)) {
            return false;
        }
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (!Character.isLetterOrDigit(aChar) && '_' != aChar) {
                return false;
            }
        }
        return true;
    }
}
