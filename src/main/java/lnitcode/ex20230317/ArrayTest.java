package lnitcode.ex20230317;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/17 17:10
 */
public class ArrayTest {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        System.out.println(Arrays.equals(arr1, arr2));

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        int[] arr = new int[n];
        while (n > 0 && sc.hasNext()) {
            int num = sc.nextInt();
            arr[n - 1] = num;
            --n;
            max = Math.max(max, num);
        }
        int sum = 0;
        for (int num : arr) {
            if (num == max) {
                continue;
            }
            sum += num;
        }
        System.out.println(sum);
    }
}
