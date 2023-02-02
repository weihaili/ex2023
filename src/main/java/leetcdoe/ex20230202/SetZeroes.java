package leetcdoe.ex20230202;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/2 17:01
 */
public class SetZeroes {
    public static void main(String[] args) {
        SetZeroes demo = new SetZeroes();
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        demo.print(matrix);
        demo.setZeroes(matrix);
        System.out.println("****************************************");
        demo.print(matrix);
    }

    private void print(int[][] matrix) {
        if (matrix == null) {
            System.out.println("matrix is null");
        }
        StringBuilder buf = new StringBuilder();
        for (int[] ints : matrix) {
            if (buf.length() > 0) {
                buf.delete(0, buf.length());
            }
            for (int anInt : ints) {
                buf.append(" ").append(anInt);
            }
            System.out.println(buf.substring(1));
        }
    }

    public void setZeroes(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        List<int[]> coordinates = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    coordinates.add(new int[]{i, j});
                }
            }
        }
        for (int[] coordinate : coordinates) {
            int cx = coordinate[0];
            for (int i = 0; i < matrix[0].length; ++i) {
                matrix[cx][i] = 0;
            }
            int cy = coordinate[1];
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][cy] = 0;
            }
        }
    }
}
