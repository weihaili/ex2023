package lnitcode.ex20230317;

import java.util.Stack;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/17 10:27
 */
public class FindHer {

    public static void main(String[] args) {
        FindHer demo = new FindHer();
        boolean flag = demo.findHer(new String[]{
                "S*.*",
                "*..*",
                "...T"
        });
        System.out.println(flag);
    }

    private int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean findHer(String[] maze) {
        if (maze == null || maze.length == 0) {
            return false;
        }
        int[][] az = new int[maze.length][maze[0].length()];
        int[] idx = new int[2];
        for (int i = 0; i < maze.length; ++i) {
            for (int j = 0; j < maze[0].length(); ++j) {
                char c = maze[i].charAt(j);
                if ('.' == c) {
                    az[i][j] = 0;
                } else if ('*' == c) {
                    az[i][j] = 1;
                } else if ('S' == c) {
                    idx[0] = i;
                    idx[1] = j;
                    az[i][j] = 2;
                } else if ('T' == c) {
                    az[i][j] = 3;
                }
            }
        }
        az[idx[0]][idx[1]] = 0;
        Stack<int[][]> stack = new Stack<>();
        Stack<int[]> stackIdx = new Stack<>();
        stack.push(az);
        stackIdx.push(idx);
        while (!stack.isEmpty()) {
            az = stack.pop();
            idx = stackIdx.pop();
            if (!(idx[0] < az.length && idx[0] >= 0 && idx[1] < az[idx[0]].length && idx[1] >= 0)) {
                continue;
            }
            switch (az[idx[0]][idx[1]]) {
                case 0:
                    az[idx[0]][idx[1]] = 1;
                    for (int i = 0; i < dir.length; ++i){
                        stack.push(az);
                        stackIdx.push(new int[]{idx[0] + dir[i][0], idx[1] + dir[i][1]});
                    }
                break;
                case 1:
                    continue;
                case 3:
                    return true;
            }
        }
        return false;
    }
}
