package leetcdoe.ex202302014.threadtest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/14 14:23
 */
public class RegularTest {

    public static void main(String[] args) {
        RegularTest demo = new RegularTest();
        demo.test();
    }

    private void test() {
        Pattern pattern = Pattern.compile("\\d*");
        // match arbitrary number
        Matcher matRes = pattern.matcher("121234565t");
        boolean flag = matRes.matches();
        System.out.println(flag);

        boolean res = Pattern.matches("\\S*", "12234ttt");
        System.out.println(res);
    }
}
