package leetcdoe.ex20230118;

import java.util.Deque;
import java.util.LinkedList;

public class MaxAreaOfIsland {

    public static void main(String[] args) {
        MaxAreaOfIsland demo = new MaxAreaOfIsland();
        int[][] grid = new int[][]{
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,1,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
//        int res = demo.maxAreaOfIsland(grid);
        int res = demo.maxAreaOfIslandByStack(grid);
        System.out.println(res);
    }

    public int maxAreaOfIslandByStack(int[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0) {
            return res;
        }
        Deque<Integer> stackX = new LinkedList<>();
        Deque<Integer> stackY = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int cur = 0;
                stackX.push(i);
                stackY.push(j);
                while (!stackX.isEmpty()) {
                    int curIdx = stackX.pop();
                    int curIdy = stackY.pop();
                    if (grid[curIdx][curIdy] != 1) {
                        continue;
                    }
                    ++cur;
                    grid[curIdx][curIdy] = 0;
                    for (int k = 0; k < 4; k++) {
                        int nextX = curIdx + dx[k];
                        int nextY = curIdy + dy[k];
                        stackX.push(nextX);
                        stackY.push(nextY);
                    }
                }
                res = Math.max(res, cur);
            }
        }
        return res;
    }


    /**
     * function control deep
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0) {
            return res;
        }
        for (int i = 0; i != grid.length; ++i) {
            for (int j = 0; j != grid[0].length; ++j) {
                res = Math.max(res, dfs(grid, i, j));
            }
        }
        return res;
    }

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 0;
        int res = 1;
        for (int k = 0; k != 4; ++k) {
            int nextIdx = i + dx[k];
            int nextIdy = j + dy[k];
            res += dfs(grid, nextIdx, nextIdy);
        }
        return res;
    }
}
