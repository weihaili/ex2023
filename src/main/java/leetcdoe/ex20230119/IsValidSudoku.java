package leetcdoe.ex20230119;

public class IsValidSudoku {

    public static void main(String[] args) {
        IsValidSudoku demo = new IsValidSudoku();
        char[][] board = {};
        boolean res = demo.isValidSudoku(board);
        System.out.println(res);
    }

    public boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return false;
        }
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] boxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int idx = c - '0' - 1;
                    rows[i][idx]++;
                    cols[j][idx]++;
                    boxes[i / 3][j / 3][idx]++;
                    if (rows[i][idx] > 1 || cols[j][idx] > 1 ||
                            boxes[i / 3][j / 3][idx] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
