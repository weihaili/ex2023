package leetcdoe.ex20230117;

public class SetMatrixZeroes {

    public static void main(String[] args) {
        SetMatrixZeroes demo = new SetMatrixZeroes();
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        demo.setZeroes(matrix);
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

    public void setZeroes(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    setZeroe(matrix, i, j);
                }
            }
        }
    }

    private void setZeroe(int[][] matrix, int i, int j) {
        for (int k = 0; k < matrix[0].length; k++) {
            matrix[i][k] = 0;
        }
        for (int k = 0; k < matrix.length; k++) {
            matrix[k][j] = 0;
        }
    }
}
