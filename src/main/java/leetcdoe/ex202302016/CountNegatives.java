package leetcdoe.ex202302016;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/16 16:59
 */
public class CountNegatives {

    public static void main(String[] args) {
        CountNegatives demo = new CountNegatives();
        int[][] grid = {{4, 3, 2, 1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -2, -3, -1}};
        int cnt = demo.countNegatives(grid);
        System.out.println(cnt);
    }

    public int countNegatives(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int cnt = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] < 0) {
                    ++cnt;
                }
            }
        }
        return cnt;
    }
}
