package leetcdoe.ex20230119;

public class MatrixSetZero {

    public static void main(String[] args) {
        MatrixSetZero demo = new MatrixSetZero();
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        demo.print(matrix);
        demo.setZeroes(matrix);
        System.out.println("*********************");
        demo.print(matrix);

    }

    private void print(int[][] matrix) {
        if (matrix == null) {
            System.out.println("matrix is empty...");
        } else {
            StringBuilder strBuf = new StringBuilder();
            for (int i = 0; i < matrix.length; i++) {
                if (strBuf.length() > 0) {
                    strBuf.delete(0, strBuf.length());
                }
                for (int j = 0; j < matrix[0].length; j++) {
                    strBuf.append(" ").append(matrix[i][j]);
                }
                System.out.println(strBuf.substring(1));
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        boolean[] flagRow = new boolean[rowLen];
        boolean[] flagCol = new boolean[colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == 0) {
                    flagRow[i] = flagCol[j] = true;
                }
            }
        }
        for (int i = 0; i < flagRow.length; i++) {
            for (int j = 0; j < flagCol.length; j++) {
                if (flagRow[i] || flagCol[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
