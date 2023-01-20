package leetcdoe.ex20230120;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class OrangesRotting {

    public static void main(String[] args) {
        OrangesRotting demo = new OrangesRotting();
        int[][] grid = {{0,2}};
        int res = demo.orangesRotting(grid);
        System.out.println(res);
    }

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int orangesRotting(int[][] grid) {
        int len = grid.length;
        int wid = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> dep = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < wid; j++) {
                if (grid[i][j] == 2) {
                    int code = i * wid + j;
                    queue.add(code);
                    dep.put(code, 0);
                }
            }
        }
        int res = 0;
        while (!queue.isEmpty()) {
            Integer code = queue.remove();
            int r = code / wid;
            int c = code % wid;
            for (int k = 0; k < 4; k++) {
                int idx = r + dx[k];
                int idy = c + dy[k];
                if (idx >= 0 && idx < len && idy >= 0 && idy < wid && grid[idx][idy] ==1) {
                    grid[idx][idy] = 2;
                    int next = idx * wid + idy;
                    queue.add(next);
                    dep.put(next, dep.get(code) + 1);
                    res = dep.get(next);
                }
            }
        }
        for (int[] row : grid) {
            for (int val : row) {
                if (val == 1) {
                    return -1;
                }
            }
        }
        return res;
    }
}
