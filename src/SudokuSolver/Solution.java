package SudokuSolver;

/**
 * Author: fangzhou
 * Date:   9/5/14.
 */
public class Solution {
    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][] blocks = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    fill(i, j, board[i][j] - '1');
                }
            }
        }
        solve(board, 0);
    }

    public boolean solve(char[][] b, int x) {
        if (x <= 80) {
            int row = x / 9, col = x % 9;
            if (b[row][col] != '.') {
                return solve(b, x + 1);
            }
            for (int n = 0; n < 9; n++) {
                if (rows[row][n] || cols[col][n] || blocks[row / 3 * 3 + col / 3][n]) {
                    continue;
                }
                b[row][col] = (char) ('1' + n);
                fill(row, col, n);
                if (solve(b, x + 1)) {
                    return true;
                }
                clear(b, row, col);
            }
            return false;
        }
        return true;
    }

    public void fill(int i, int j, int n) {
        rows[i][n] = true;
        cols[j][n] = true;
        blocks[i / 3 * 3 + j / 3][n] = true;
    }

    public void clear(char[][] b, int i, int j) {
        int n = b[i][j] - '1';
        rows[i][n] = false;
        cols[j][n] = false;
        blocks[i / 3 * 3 + j / 3][n] = false;
        b[i][j] = '.';
    }
}
