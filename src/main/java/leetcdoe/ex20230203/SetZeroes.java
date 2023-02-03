package leetcdoe.ex20230203;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/3 9:47
 */
public class SetZeroes {

    public static void main(String[] args) {
        SetZeroes demo = new SetZeroes();
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1},{1,1,1},{0,1,1}};
        demo.print(matrix);
        demo.setZeroes(matrix);
        demo.print(matrix);
    }

    private void print(int[][] matrix) {
        System.out.println("********************************");
        if (matrix == null) {
            System.out.println("matrix is null");
        }
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public void setZeroes(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int rLen = matrix.length;
        int cLen = matrix[0].length;
        boolean cFlag0 = false;
        boolean rFlag0 = false;
        for (int i = 0; i < rLen; i++) {
            if (matrix[i][0] == 0) {
                cFlag0 = true;
            }
        }
        for (int i = 0; i < cLen; i++) {
            if (matrix[0][i] == 0) {
                rFlag0 = true;
            }
        }
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < rLen; i++) {
            for (int j = 1; j < cLen; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (cFlag0) {
            for (int i = 0; i < rLen; ++i) {
                matrix[i][0] = 0;
            }
        }
        if (rFlag0) {
            for (int i = 0; i < cLen; ++i) {
                matrix[0][i] = 0;
            }
        }
    }

    public void setZeroes1(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int rLen = matrix.length;
        int cLen = matrix[0].length;
        boolean[] rzFlag = new boolean[rLen];
        boolean[] czFlag = new boolean[cLen];
        for (int i = 0; i < rLen; ++i) {
            for (int j = 0; j < cLen; ++j) {
                if (matrix[i][j] == 0) {
                    rzFlag[i] = czFlag[j] = true;
                }
            }
        }
        for (int i = 0; i < rLen; ++i) {
            for (int j = 0; j < cLen; ++j) {
                if (rzFlag[i] || czFlag[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
