package lnitcode.ex20230308;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/8 16:12
 */
public class ToLowerCase {

    public static void main(String[] args) {
        ToLowerCase demo = new ToLowerCase();
        String res = demo.toLowerCase("Hello");
        System.out.println(res);
        Character c;
    }

    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder buf = new StringBuilder();
        for (char c : str.toCharArray()) {
            buf.append(Character.isLowerCase(c) ? c : Character.toLowerCase(c));
        }
        return buf.toString();
    }
}
