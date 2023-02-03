package leetcdoe.ex20230203;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/3 9:09
 */
public class IsValidSudoku {
    public static void main(String[] args) {
        IsValidSudoku demo = new IsValidSudoku();
        char[][] board = {
             {'5','3','.','.','7','.','.','.','.'}
            ,{'6','.','.','1','9','5','.','.','.'}
            ,{'.','9','8','.','.','.','.','6','.'}
            ,{'8','.','.','.','6','.','.','.','3'}
            ,{'4','.','.','8','.','3','.','.','1'}
            ,{'7','.','.','.','2','.','.','.','6'}
            ,{'.','6','.','.','.','.','2','8','.'}
            ,{'.','.','.','4','9','9','.','.','5'}
            ,{'.','.','.','.','8','.','.','7','9'}
        };
        boolean flag = demo.isValidSudoku(board);
        System.out.println(flag);
    }

    public boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return false;
        }
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] boxies = new int[3][3][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char c = board[i][j];
                if (c != '.') {
                    int idx = c - '0' - 1;
                    rows[i][idx]++;
                    columns[j][idx]++;
                    boxies[i / 3][j / 3][idx]++;
                    if (rows[i][idx] > 1 || columns[j][idx]> 1 || boxies[i / 3][j / 3][idx] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
