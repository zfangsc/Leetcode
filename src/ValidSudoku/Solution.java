package ValidSudoku;

/**
 * Author: fangzhou
 * Date:   9/5/14.
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] blocks = new boolean[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int n = board[i][j] - '1';
                    if (rows[i][n] || cols[j][n] || blocks[i / 3 * 3 + j / 3][n]) {
                        return false;
                    }
                    rows[i][n] = true;
                    cols[j][n] = true;
                    blocks[i / 3 * 3 + j / 3][n] = true;
                }
            }
        }
        return true;
    }
}
