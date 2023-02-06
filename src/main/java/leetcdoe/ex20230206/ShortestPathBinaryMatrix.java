package leetcdoe.ex20230206;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: BFS
 *
 * @author Admin
 * @date 2023/2/6 14:44
 */
public class ShortestPathBinaryMatrix {

    public static void main(String[] args) {
        ShortestPathBinaryMatrix demo = new ShortestPathBinaryMatrix();
        int[][] grid = {{0,0, 0},{1,1, 0},{1,1,0}};
        int res = demo.shortestPathBinaryMatrix(grid);
        System.out.println(res);
    }

    private int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1};

    private int[] dirY = {1, 1, 0, -1, -1, -1, 0, 1};

    private int rLen;

    private int cLen;

    public int shortestPathBinaryMatrix(int[][] grid) {
        int res = -1;
        rLen = grid.length;
        cLen = grid[0].length;
        if (grid[0][0] == 1 || grid[rLen - 1][cLen - 1] == 1) {
            return res;
        }
        if (grid[0][0] == 0 && rLen == 1) {
            res = 1;
        }
        int[][] visit = new int[rLen][cLen];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0});
        visit[0][0] = 1;
        int step = 1;
        while (!que.isEmpty()) {
            int s = que.size();
            for (int i = 0; i < s; ++i) {
                int[] temp = que.poll();
                int x = temp[0];
                int y = temp[1];
                for (int j = 0; j < 8; ++j) {
                    int x1 = x + dirX[j];
                    int y1 = y + dirY[j];
                    if (x1 >= 0 && x1 < rLen && y1 >= 0 && y1 < cLen && grid[x1][y1] == 0 && visit[x1][y1] != 1) {
                        que.add(new int[]{x1, y1});
                        visit[x1][y1] = 1;
                    }
                }
                if (x == rLen - 1 && y == cLen - 1) {
                    return step;
                }
            }
            step++;
        }
        return res;
    }
}
