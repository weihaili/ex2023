package lnitcode.ex20230328;

import java.util.HashMap;
import java.util.Map;

public class PickCarrots {

    public static void main(String[] args) {
        PickCarrots demo = new PickCarrots();
        int[][] matrix = new int[][]{{5, 7, 6, 3},{2,  4, 8, 12},{3, 5, 10, 7},{4, 16, 4, 17}};
        int[][] matrix2 = new int[][]{{5, 3, 7, 1, 7},{4, 6, 5, 2, 8},{2, 1, 1, 4, 6}};
        int[][] matrix3 = new int[][]{{2,0,2},{0,2,0},{2,0,2}};
        int cnt = demo.pickCarrots(matrix3);
        System.out.println(cnt);
    }

    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int pickCarrots(int[][] carrot) {
        int cnt = 0;
        if (carrot == null || carrot.length == 0) {
            return cnt;
        }
        int rLen = carrot.length;
        int cLen = carrot[0].length;
        int[][] visited = new int[rLen][cLen];
        // find the center coordinates
        int idx = rLen - 1 >> 1;
        int idy = cLen - 1 >> 1;
        while (visited[idx][idy] != 1) {
            // set the center has been visited
            visited[idx][idy] = 1;
            // add up carrot quantity
            cnt += carrot[idx][idy];
            // find next coordinate (the max carrot quantity of the four directions)
            Map<Integer, int[]> qtyCdtMap = new HashMap<>();
            int max = 0;
            for (int i = 0; i < dirs.length; i++) {
                int tempIdx = idx + dirs[i][0];
                // boundary limit x-axis
                if (tempIdx < 0 || tempIdx > rLen - 1) {
                    tempIdx = idx;
                }
                int tempIdy = idy + dirs[i][1];
                // boundary limit y-axis
                if (tempIdy < 0 || tempIdy > cLen - 1) {
                    tempIdy = idy;
                }
                // carrot only use once
                if (visited[tempIdx][tempIdy] == 1) {
                    continue;
                }
                int qty = carrot[tempIdx][tempIdy];
                if (qty == 0) {
                    continue;
                }
                qtyCdtMap.put(qty, new int[]{tempIdx, tempIdy});
                max = Math.max(max, qty);
            }
            // there is no next step
            if (qtyCdtMap.isEmpty()) {
                break;
            }
            idx = qtyCdtMap.get(max)[0];
            idy = qtyCdtMap.get(max)[1];
        }
        return cnt;
    }
}
