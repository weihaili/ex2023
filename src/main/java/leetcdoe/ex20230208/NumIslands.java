package leetcdoe.ex20230208;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/8 15:51
 */
public class NumIslands {

    public static void main(String[] args) {
        NumIslands demo = new NumIslands();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int cnt = demo.numIslands(grid);
        System.out.println(cnt);
    }

    public int numIslands(char[][] grid) {
        int cnt = 0;
        if (grid == null || grid.length == 0) {
            return cnt;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r-1][c] == '1') {
                        uf.union(r * nc + c, (r-1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r+1][c] == '1') {
                        uf.union(r * nc + c, (r+1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c-1] == '1') {
                        uf.union(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1 < nc && grid[r][c+1] == '1') {
                        uf.union(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }
        return uf.getCount();
    }

    public int numIslandsByBfs(char[][] grid) {
        int cnt = 0;
        if (grid == null || grid.length == 0) {
            return cnt;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        for (int i = 0; i < nr; ++i) {
            for (int j = 0; j < nc; ++j) {
                if (grid[i][j] == '1') {
                    ++cnt;
                    grid[i][j] = '0';
                    Queue<Integer> neighbors = new LinkedList();
                    neighbors.add(i * nc + j);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            neighbors.add((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.add(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            neighbors.add(row * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return cnt;
    }

    public int numIslandsByDFS(char[][] grid) {
        int cnt = 0;
        if (grid == null || grid.length == 0) {
            return cnt;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        for (int i = 0; i < nr; ++i) {
            for (int j = 0; j < nc; ++j) {
                if (grid[i][j] == '1') {
                    ++cnt;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }

    int[] dirX = new int[]{0, 1, 0, -1};
    int[] dirY = new int[]{1, 0, -1, 0};

    private void dfs(char[][] grid, int i, int j) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (i < 0 || j < 0 || i >= nr || j >= nc || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        for (int k = 0; k < dirX.length; ++k) {
            dfs(grid, i + dirX[k], j + dirY[k]);
        }
    }
}

class UnionFind {
    int count;
    int[] parnet;
    int[] rank;

    public UnionFind(char[][] grid) {
        count = 0;
        int m = grid.length;
        int n = grid[0].length;
        parnet = new int[m * n];
        rank = new int[m * n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    parnet[i * n + j] = i * n + j;
                    ++count;
                }
                rank[i * n + j] = 0;
            }
        }
    }

    public int find(int i) {
        if (parnet[i] != i) {
            parnet[i] = find(parnet[i]);
        }
        return parnet[i];
    }

    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) {
            if (rank[rootx] > rank[rooty]) {
                parnet[rooty] = rootx;
            } else if (rank[rootx] < rank[rooty]){
                parnet[rootx] = rooty;
            } else {
                parnet[rooty] = rootx;
                rank[rootx] += 1;
            }
            --count;
        }
    }

    public int getCount() {
        return count;
    }
}
