package leetcdoe.ex20230307;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 18:16
 */
public class SwapIntegers {

    public static void main(String[] args) {
        SwapIntegers demo = new SwapIntegers();
        int[] arr = new int[]{1, 3, 2};
        demo.swapIntegers(arr, 2, 2);
        System.out.println(Arrays.toString(arr));
    }

    public void swapIntegers(int[] a, int index1, int index2) {
        if (a == null || a.length == 0 || a.length <= index1 - 1 || a.length <= index2 - 1 || index1 == index2) {
            return;
        }
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}
