package leetcdoe.ex20230307;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 18:02
 */
public class SortIntegers {

    public static void main(String[] args) {
        SortIntegers demo = new SortIntegers();
        int[] arr = new int[]{7,9,3, 1, 5, 2, 0};
        demo.sortIntegers(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sortIntegers(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        int len = a.length;
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
