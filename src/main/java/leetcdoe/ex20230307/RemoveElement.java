package leetcdoe.ex20230307;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 9:52
 */
public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement demo = new RemoveElement();
        int[] arr = new int[] {4, 1, 2, 3, 4, 5, 6, 4};
        demo.removeElements(arr, 4);
        System.out.println(Arrays.toString(arr));
    }


    private void removeElements(int[] arr, int num) {
        int showIndex = 0;
        for (int fastIndex = 0; fastIndex < arr.length; ++fastIndex) {
            if (arr[fastIndex] != num) {
                ++showIndex;
            }
        }
        System.out.println(showIndex);
    }
    
    private void removeElements1(int[] arr, int num) {
        int len = arr.length;
        for (int i = 0; i < len; ++i) {
            if (arr[i] == num) {
                for (int j = i + 1; j < len; ++j) {
                    arr[j - 1] = arr[j];
                }
                --i;
                --len;
            }
        }
        System.out.println(len);
    }
}
