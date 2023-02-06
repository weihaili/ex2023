package leetcdoe.ex20230206;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/6 15:29
 */
public class Solve {

    public static void main(String[] args) {
        Solve demo = new Solve();
        char[][] board = {{'O','X','O'},{'X','O','X'},{'O','X','O'}};
        demo.print(board);
        demo.solve(board);
        System.out.println("***************************");
        demo.print(board);
        System.out.println("***************************");
        char[][] board1 = {{'O','X','O'},{'X','O','X'},{'O','X','O'}};
        demo.print(board1);
        System.out.println("***************************");
        demo.solveForBfs(board1);
        demo.print(board1);
    }

    public void solveForBfs(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        rLen = board.length;
        cLen = board[0].length;
        Queue<int[]> que = new LinkedList();
        for (int i = 0; i < rLen; ++i) {
            if (board[i][0] == 'O') {
                que.add(new int[]{i, 0});
                board[i][0] = 'A';
            }
            if (board[i][cLen - 1] == 'O') {
                que.add(new int[]{i, cLen - 1});
                board[i][cLen - 1] = 'A';
            }
        }
        for (int i = 1; i < cLen - 1; ++i) {
            if (board[0][i] == 'O') {
                que.add(new int[]{0, i});
                board[0][i] = 'A';
            }
            if (board[rLen - 1][i] == 'O') {
                que.add(new int[]{rLen - 1, i});
                board[rLen - 1][i] = 'A';
            }
        }

        while (!que.isEmpty()) {
            int[] cell = que.poll();
            int x = cell[0];
            int y = cell[1];
            for (int i = 0; i < dirX.length; i++) {
                int x1 = x + dirX[i];
                int y1 = y + dirY[i];
                if (x1 < 0 || x1 >= rLen || y1 < 0 || y1 >= cLen || board[x1][y1] != 'O') {
                    continue;
                }
                que.add(new int[]{x1, y1});
                board[x1][y1] = 'A';
            }
        }
        for (int i = 0; i < rLen; ++i) {
            for (int j = 0; j < cLen; ++j) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void print(char[][] board) {
        if (board == null) {
            System.out.println("board is null");
            return;
        }

        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }

    private int rLen;

    private int cLen;

    private int[] dirX = {0, 1, 0, -1};

    private int[] dirY = {1, 0, -1, 0};

    /**
     * DFS
     *
     * @param board
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        rLen = board.length;
        ;
        cLen = board[0].length;
        for (int i = 0; i < rLen; ++i) {
            dfs(board, i, 0);
            dfs(board, i, rLen - 1);
        }

        for (int i = 0; i < cLen; ++i) {
            dfs(board, 0, i);
            dfs(board, cLen - 1, i);
        }

        for (int i = 0; i < rLen; ++i) {
            for (int j = 0; j < cLen; ++j) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= rLen || y < 0 || y >= cLen || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        for (int i = 0; i < dirX.length; ++i) {
            dfs(board, x + dirX[i], y + dirY[y]);
        }
    }
}
