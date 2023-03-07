package leetcdoe.ex20230307;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/7 10:38
 */
public class GenerateMatrix {

    public static void main(String[] args) {
        GenerateMatrix demo = new GenerateMatrix();
        int[][] matrix = demo.generateMatrix(3);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int startx = 0, starty = 0;
        int loop = n >> 1;
        int mid = n >> 1;
        int count = 1;
        int offset = 1;
        int i, j;
        while (loop-- > 0) {
            i = startx;
            j = starty;
            for (j = starty; i < starty + n - offset; j++) {
                int[] a = {0};
               char[] c = {0, 1, 2, 3 ,4 };
            }
        }

        return res;
    }
}
