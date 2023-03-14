package lnitcode.ex20230314;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/14 13:31
 */
public class SortByLength {

    public static void main(String[] args) {
        SortByLength demo = new SortByLength();
        String[] strArr = {"lint", "code", "Lintcode"};
        demo.sortByLength(strArr);
        System.out.println(Arrays.toString(strArr));
    }

    public void sortByLength(String[] strArr) {
        Arrays.stream(strArr).sorted(Comparator.comparing(String::length)).forEach(System.out::println);
    }
}
