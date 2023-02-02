package leetcdoe.ex20230202;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/2 13:35
 */
public class BackspaceCompare {

    public static void main(String[] args) {
        BackspaceCompare demo = new BackspaceCompare();
        boolean flag = demo.backspaceCompare("ab#c#", "#####ad#c#");
        System.out.println(flag);
    }

    public boolean backspaceCompare(String s, String t) {
        return this.replace(s).equals(this.replace(t));
    }

    private String replace(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '#') {
                if (buf.length() > 0) {
                    buf.deleteCharAt(buf.length() - 1);
                }
            } else {
                buf.append(chars[i]);
            }
        }
        return buf.toString();
    }
}
