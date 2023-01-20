package leetcdoe.ex20230116;

import java.util.Arrays;

public class ReverseStringArr {

    public static void main(String[] args) {
        ReverseStringArr demo = new ReverseStringArr();
        char[] chars = {'h','a','n','n','a', 'h'};
        demo.reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }

    public void reverseString(char[] s) {
        if (s == null || s.length == 1) {
            return;
        }
        int len = s.length;
        for (int i = 0; i < (len >> 1); i++) {
            char temp = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = temp;
        }
    }
}
