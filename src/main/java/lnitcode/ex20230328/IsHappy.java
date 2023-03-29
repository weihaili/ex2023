package lnitcode.ex20230328;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {

    public static void main(String[] args) {
        IsHappy demo = new IsHappy();
        boolean flag = demo.isHappy(5);
        System.out.println(flag);
    }

    private Set<Integer> seen = new HashSet<>();

    public boolean isHappy(int n) {
        if (1 == n) {
            return true;
        }
        String numStr = "" + n;
        char[] numChars = numStr.toCharArray();
        int sum  = 0;
        for (int i = 0; i < numChars.length; ++i) {
            int num = numChars[i] - 48;
            sum += num * num;
        }
        if (!seen.add(sum)) {
            return false;
        }
        return isHappy(sum);
    }
}
