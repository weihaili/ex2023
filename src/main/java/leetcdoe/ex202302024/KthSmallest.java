package leetcdoe.ex202302024;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/24 10:11
 */
public class KthSmallest {

    public static void main(String[] args) {
        KthSmallest demo = new KthSmallest();
        int num = demo.kthSmallest(new int[][]{{1,5,9},{10, 11, 13},{12,13,15}}, 3);
        System.out.println(num);
    }

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[] ints = Arrays.stream(matrix).flatMapToInt(IntStream::of).sorted().toArray();
        System.out.println(Arrays.toString(ints));
        return ints[k - 1];
    }
}
