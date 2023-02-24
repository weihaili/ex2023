package nowcoder.ex20230224;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/24 18:48
 */
public class ArraySort {

    public static void main(String[] args) {
        ArraySort demo = new ArraySort();
        int[] arr = {0, 8, 3, 5, 1, 7, 9, 2};
        demo.bubbleSort(arr);
        demo.chooseSort(arr);
        demo.insertSort(arr);
    }

    private void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j - 1] = temp;
                --j;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private void chooseSort (int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = 0; j < arr.length - 1 - i; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
