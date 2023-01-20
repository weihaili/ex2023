package leetcdoe.ex20230117;

public class MatrixReshape {

    public static void main(String[] args) {
        MatrixReshape demo = new MatrixReshape();
        int[][] mat = {{1,2},{3,4}};
        int r = 1;
        int c = 3;
        int[][] ints = demo.matrixReshape(mat, r, c);
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < ints.length; i++) {
            if (buf.length() > 0) {
                buf.delete(0, buf.length());
            }
            for (int j = 0; j < ints[0].length; j++) {
                buf.append(" ").append(ints[i][j]);
            }
            System.out.println(buf.substring(1));
        }
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat == null) {
            return mat;
        }
        int len = mat.length * mat[0].length;
        if (len != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        int[] temp = new int[len];
        int idx = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                temp[idx] = mat[i][j];
                idx++;
            }
        }
        idx = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = temp[idx];
                idx++;
            }
        }
        return res;
    }
}
