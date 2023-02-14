package leetcdoe.ex202302013;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/13 11:08
 */
public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths demo = new UniquePaths();
        int res = demo.uniquePaths(3, 7);
        System.out.println(res);
    }

    public int uniquePaths(int m, int n) {
        int[][] ways = new int[m][n];
        for (int i = 0; i < m; ++i) {
            ways[i][0] = 1;
        }
        for (int i = 0; i < n; ++i) {
            ways[0][i] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
            }
        }
        return ways[m - 1][n - 1];
    }

    /**
     * combination
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        long res = 1;
        for (int i = n, j = 1; j < m; ++i, ++j) {
            res = res * i / j;
        }
        return (int)res;
    }
}
