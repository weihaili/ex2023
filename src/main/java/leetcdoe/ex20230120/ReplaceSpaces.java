package leetcdoe.ex20230120;

public class ReplaceSpaces {

    public static void main(String[] args) {
        ReplaceSpaces demo = new ReplaceSpaces();
        String str = "Mr John Smith    ";
        int len = 0;
        String res = demo.replaceSpaces(str, len);
        System.out.println(str);
        System.out.println(res);
    }

    public String replaceSpaces(String S, int length) {
        if (S == null || length <= 0) {
            return null;
        }
        StringBuilder strBuf = new StringBuilder();
        char[] chars = S.toCharArray();
        for (int i = 0; i < length; i++) {
            char ch = chars[i];
            if (ch == ' ') {
                strBuf.append("%20");
            } else {
                strBuf.append(ch);
            }
        }
        return strBuf.toString();
    }
}
