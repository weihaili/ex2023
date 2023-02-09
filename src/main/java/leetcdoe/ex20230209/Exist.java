package leetcdoe.ex20230209;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/9 11:51
 */
public class Exist {

    public static void main(String[] args) {
        Exist demo = new Exist();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean flag = demo.exist(board, "ABCCEDS");
        System.out.println(flag);
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }
        int nr = board.length;
        int nc = board[0].length;
        boolean[][] visited = new boolean[nr][nc];
        char c = word.charAt(0);
        for (int i = 0; i < nr; ++i) {
            for (int j = 0; j < nc; ++j) {
                if (board[i][j] != c) {
                    continue;
                }
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, boolean[][] visited, int i, int j, String word, int k) {
        if (board[i][j] != word.charAt(k)) {
            return false;
        } else if (k == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] dirs = {{0, 1},{1, 0},{0, -1},{-1, 0}};
        boolean res = false;
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >= 0 && ni < board.length && nj >=0 && nj < board[0].length) {
                if (!visited[ni][nj]) {
                    boolean flag = check(board, visited, ni, nj, word, k + 1);
                    if (flag) {
                        res = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return res;
    }
}
