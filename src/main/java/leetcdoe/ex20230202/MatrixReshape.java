package leetcdoe.ex20230202;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/2 9:21
 */
public class MatrixReshape {

    public static void main(String[] args) {
        MatrixReshape demo = new MatrixReshape();
        int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        demo.printArr(mat);
        System.out.println("***************************************");
        int[][] nums = demo.matrixReshape(mat, 2, 8);
        demo.printArr(nums);
    }

    private void printArr(int[][] mat) {
        if (mat == null) {
            System.out.println("mat is null");
        }
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < mat.length; i++) {
            if (buf.length() > 0) {
                buf.delete(0, buf.length());
            }
            for (int j = 0; j < mat[0].length; j++) {
                buf.append(" ").append(mat[i][j]);
            }
            System.out.println(buf.substring(1));
        }
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat == null) {
            return mat;
        }
        int matLen = mat.length * mat[0].length;
        if (matLen != r * c) {
            return mat;
        }
        List<Integer> list = Arrays.stream(mat).flatMapToInt(Arrays::stream).boxed().collect(Collectors.toList());
        System.out.println(Arrays.toString(list.toArray()));
        int[][] newArr = new int[r][c];
        int size = list.size();
        for (int i = 0; i < size; ++i) {
            newArr[i / c][i % c] = list.get(i);
        }
        return newArr;
    }
}
