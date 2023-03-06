package nowcoder.ex20230304;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/6 19:08
 */
public class IslandCountBM57 {

    public static void main(String[] args) {
        IslandCountBM57 demo = new IslandCountBM57();
        int count = demo.solve(new char[][]{{'1','1','0','0','0'},
                {'0','1','0','1','1'},
                {'0','0','0','1','1'},
                {'0','0','0','0','0'},
                {'0','0','1','1','1'}});
        System.out.println(count);
    }

    public int solve(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == '1') {
                    ++res;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        grid[i][j] = '0';
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            dfs(grid, i - 1, j);
        }
        if (i + 1 < n && grid[i + 1][j] == '1') {
            dfs(grid, i + 1, j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            dfs(grid, i, j - 1);
        }
        if (j + 1 < m && grid[i][j + 1] == '1') {
            dfs(grid, i, j + 1);
        }
    }
}
