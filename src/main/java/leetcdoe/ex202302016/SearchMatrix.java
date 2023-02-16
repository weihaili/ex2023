package leetcdoe.ex202302016;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/16 13:33
 */
public class SearchMatrix {

    public static void main(String[] args) {
        SearchMatrix demo = new SearchMatrix();
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 12, 22}};
        boolean flag = demo.searchMatrix(matrix, 13);
        System.out.println(flag);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int columns = matrix[0].length;
        int idx = 0;
        int idy = columns - 1;
        while (idx < row && idy >= 0) {
            if (matrix[idx][idy] == target) {
                return true;
            } else if (matrix[idx][idy] > target) {
                --idy;
            } else {
                ++idx;
            }
        }
        return false;
    }
}
