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
        int[] arr = {8, 3, 0, 6, 2, 9, 1};
//        demo.bubbleSort(arr);
//        demo.chooseSort(arr);
//        demo.insertSort(arr);
        demo.xierSort(arr);
    }

    private void xierSort(int[] arr) {
        for (int gap = arr.length >> 1; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; ++i) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && temp < arr[j - gap] ; j -= gap  ) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            for (int k = i; k > 0; --k) {
                if (arr[k] < arr[k - 1]) {
                    int temp = arr[k];
                    arr[k] = arr[k - 1];
                    arr[k - 1] = temp;
                }
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
