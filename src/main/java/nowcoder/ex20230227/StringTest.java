package nowcoder.ex20230227;

import javax.swing.*;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/27 14:08
 */
public class StringTest {

    public static void main(String[] args) {
        StringTest demo = new StringTest();
//        demo.test1();
//        demo.test2();
//        demo.test3();
        demo.test4();
    }

    private void test4() {
        JPasswordField pwf;
    }

    private void test3() {
        String a = "aabb";
        String b = new String(a);
        String c = b.intern();
        System.out.println(a == c); // true
        System.out.println(a == b); // false
        System.out.println(b == c); // false
    }

    private void test2() {
        final String a = "a";
        String b = "aa";
        String c = a + a;
        String d = "a" + a;
        System.out.println(b == c);
        System.out.println(b == d);
    }

    private void test1() {
        String ss = "hello world";
        String a1 = "!";
        String str = new String("hello world!");
        String str1 = "hello world!";
        String str2 = ss + a1;
        String str3 = "hello world" + a1;
        String str4 = "hello world" + a1;
        System.out.println("str == str1: " + str == str1);
        System.out.println("str equals str1 : " + str.equals(str1));

        System.out.println("str == str2 : " + str == str2);

        System.out.println("str1 == str2 : " + str1 == str2);

        System.out.println("str1 == str3 : " + str1 == str3);

        System.out.println("str1 == str3 : " + str1 == str3);

        System.out.println("str3 == str4 : " + str3 == str4);
    }


}
