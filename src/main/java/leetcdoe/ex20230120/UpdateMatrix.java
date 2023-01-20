package leetcdoe.ex20230120;

import java.util.LinkedList;
import java.util.Queue;

public class UpdateMatrix {

    public static void main(String[] args) {
        UpdateMatrix demo = new UpdateMatrix();
        int[][] mat = {{0,0,0}, {0,1,0}, {1,1,1}};
        demo.pintRes(mat);
        System.out.println("********************************");
        int[][] nums = demo.updateMatrix(mat);
        demo.pintRes(nums);
    }

    private void pintRes(int[][] nums) {
        if (nums == null || nums.length < 1) {
            System.out.println("result is empty...");
            return;
        }
        StringBuilder strBuf = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (strBuf.length() > 0) {
                strBuf.delete(0, strBuf.length());
            }
            for (int j = 0; j < nums[0].length; j++) {
                strBuf.append(" ").append(nums[i][j]);
            }
            System.out.println(strBuf.substring(1));
        }
    }

    int[][] dic = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length < 1) {
            return mat;
        }
        int len = mat.length;
        int wid = mat[0].length;
        int[][] dist = new int[len][wid];
        boolean[][] seen = new boolean[len][wid];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < wid; j++) {
                if (0 == mat[i][j]) {
                    queue.offer(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0];
            int j = cell[1];
            for (int k = 0; k < 4; k++) {
                int idx = i + dic[k][0];
                int idy = j + dic[k][1];
                if (idx >= 0 && idx < len && idy >= 0 && idy < wid && !seen[idx][idy]) {
                    dist[idx][idy] = dist[i][j] + 1;
                    queue.offer(new int[]{idx, idy});
                    seen[idx][idy] = true;
                }
            }
        }
        return dist;
    }
}
