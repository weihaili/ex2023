package leetcdoe.ex20230201;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/1 15:40
 */
public class Rotate {

    public static void main(String[] args) {
        Rotate demo = new Rotate();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        demo.printMatrix(matrix);
        demo.rotate(matrix);
        System.out.println("***********************************");
        demo.printMatrix(matrix);
    }

    public void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int len = matrix.length;
        for (int i = 0; i < (len >> 1); ++i) {
            for (int j = 0; j < len; ++j) {
                int temp =matrix[i][j];
                matrix[i][j] = matrix[len - i -1][j];
                matrix[len - i -1][j] = temp;
            }
        }
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void printMatrix(int[][] matrix) {
        if (matrix != null) {
            StringBuilder buf = new StringBuilder();
            for (int i = 0; i < matrix.length; i++) {
                if (buf.length() > 0) {
                    buf.delete(0, buf.length());
                }
                for (int j = 0; j < matrix[0].length; j++) {
                    buf.append(" ").append(matrix[i][j]);
                }
                System.out.println(buf.substring(1));
            }
        }
    }

    public void rotate1(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int len = matrix.length;
        for (int i = 0; i < (len >> 1); ++i) {
            for (int j = 0; j < ((len + 1) >> 1); ++j) {
                int temp =matrix[i][j];
                matrix[i][j] = matrix[len - j -1][i];
                matrix[len - j -1][i] = matrix[len - i -1][len - j -1];
                matrix[len - i -1][len - j -1] = matrix[j][len - i -1];
                matrix[j][len - i -1] = temp;
            }
        }
    }

    public void rotate2(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int lines = matrix.length;
        int columns = matrix[0].length;
        int[][] temp = new int[lines][columns];
        for (int i = 0; i < lines; ++i) {
            for (int j = 0; j < columns; ++j) {
                temp[j][lines - i -1] = matrix[i][j];
            }
        }
        for (int i = 0; i < temp.length; ++i) {
            for (int j = 0; j < temp[0].length; ++j) {
                matrix[i][j] = temp[i][j];
            }
        }
    }
}
