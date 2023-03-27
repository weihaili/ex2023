package lnitcode.ex20230327;

import java.util.Arrays;

public class SearchMatrix {

    public static void main(String[] args) {
        SearchMatrix demo = new SearchMatrix();
        int[][] matrix = {{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}};
        boolean flag = demo.searchMatrix(matrix, 16);
        System.out.println(flag);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[i][matrix[i].length - 1] < target) {
                continue;
            }
            if (matrix[i][0] > target) {
                break;
            }
            int idx = Arrays.binarySearch(matrix[i], target);
            if (idx >=0 && idx < matrix[i].length) {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
