package leetcdoe.ex202302015;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/15 17:13
 */
public class GenerateMatrix {

    public static void main(String[] args) {
        GenerateMatrix demo = new GenerateMatrix();
        int[][] matrix = demo.generateMatrix(9);
        demo.print(matrix);
    }

    private void print(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[0][0];
        }
        int maxNum = n * n;
        int[][] matrix = new int[n][n];
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        int row = 0;
        int column = 0;
        int curNum = 1;
        int dirIdx = 0;
        while (curNum <= maxNum) {
            matrix[row][column] = curNum;
            ++curNum;
            int nextRow = row + dir[dirIdx][0];
            int nextColumn = column + dir[dirIdx][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] != 0) {
                dirIdx = (dirIdx + 1) % 4;
            }
            row = row + dir[dirIdx][0];
            column = column + dir[dirIdx][1];
        }
        return matrix;
    }
}
