package lnitcode.ex20230313;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/13 11:12
 */
public class MultiSort {

    public static void main(String[] args) {
        MultiSort demo = new MultiSort();
        int[][] res = demo.multiSort(new int[][]{{2,50}, {1,50},{3,50}});
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }

    public int[][] multiSort(int[][] array) {
        if (array == null || array.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(array, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        return array;
    }
}
