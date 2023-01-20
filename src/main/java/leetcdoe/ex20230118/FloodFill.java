package leetcdoe.ex20230118;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public static void main(String[] args) {
        FloodFill demo = new FloodFill();
        int[][] image = {{0,0,0},{0,0,0}};
        int[][] res = demo.floodFill(image, 0, 0, 2);
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (buf.length() > 0) {
                buf.delete(0, buf.length());
            }
            for (int j = 0; j < res[0].length; j++) {
                buf.append(" ").append(res[i][j]);
            }
            System.out.println(buf.substring(1));
        }
    }

    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int curColor = image[sr][sc];
        if (curColor == color) {
            return image;
        }

        int row = image.length;
        int cow = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = color;
        while (!queue.isEmpty()) {
            int[] unit = queue.poll();
            int x = unit[0];
            int y = unit[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                boolean changeFlag = mx >= 0 && mx < row && my >= 0 && my < cow && image[mx][my] == curColor;
                if(changeFlag) {
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = color;
                }
            }
        }
        return image;
    }
}
