package lnitcode.ex20230310;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/10 15:02
 */
public class Count {

    public static void main(String[] args) {
        Count demo = new Count();
        int count = demo.count("This won iz correkt. It has, No Mistakes et Oll. But there are two BIG mistakes in this sentence. and here is one more.");
        System.out.println(count);
    }

    public int count(String s) {
        int cnt = 0;


        return cnt;
    }

    public int count1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        String[] strs = s.split("\\.");
        for (String str : strs) {
            String[] chars = str.trim().split(" ");
            for (int i = 0; i < chars.length; ++i) {
                String aChar = chars[i];
                for (int j = 0; j < aChar.length() ; j++) {
                    char c = aChar.charAt(i);
                    if (i == 0 && Character.isLowerCase(c)) {
                        ++count;
                        continue;
                    }
                    if (Character.isUpperCase(c)) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }
}
