package leetcdoe.ex20230116;

public class ReverseWords {

    public static void main(String[] args) {
        ReverseWords demo = new ReverseWords();
        String s = "Let's take LeetCode contest";
        String res = demo.reverseWords(s);
        System.out.println(res);
    }

    public String reverseWords(String s) {
        String res = null;
        if (s == null) {
            return null;
        }
        String temp = s.trim();
        if (temp.length() < 2) {
            return temp;
        }

        String[] strs = temp.split(" ");
        StringBuilder buf = new StringBuilder();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            buf.append(" ");
            for (int i = chars.length -1; i >= 0; i--) {
                buf.append(chars[i]);
            }
        }
        return buf.substring(1);
    }
}
