package leetcdoe.ex202302015;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/15 16:41
 */
public class Rotate {

    public static void main(String[] args) {
        Rotate demo = new Rotate();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        demo.print(matrix);
        demo.rotate(matrix);
        demo.print(matrix);
    }

    private void print(int[][] matrix) {
        System.out.println("******************************");
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int len = matrix.length;
        for (int i = 0; i < (len >> 1); ++i) {
            for (int j = 0; j < (len + 1) >> 1; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - j - 1][i];
                matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
                matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
                matrix[j][len - i - 1] = temp;
            }
        }
    }
}
