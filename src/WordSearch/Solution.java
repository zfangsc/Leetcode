package WordSearch;

/**
 * Author: fangzhou
 * Date:   8/24/14.
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0 || word == null || word.isEmpty()) {
            return false;
        }
        boolean[][] m = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                char start = board[i][j];
                if(word.charAt(0) == start) {
                    m[i][j] = true;
                    if(match(board, m, word, 1, i, j)) {
                        return true;
                    }
                    m[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean match(char[][] board, boolean[][] m, String word, int wordInd, int i, int j) {
        if(wordInd == word.length()) {
            return true;
        }
        char c = word.charAt(wordInd);
        if(i-1 >= 0 && board[i-1][j] == c && !m[i-1][j]) {
            m[i-1][j] = true;
            if(match(board, m, word, wordInd+1, i-1, j))
                return true;
            m[i-1][j] = false;
        }
        if(j-1 >= 0 && board[i][j-1] == c && !m[i][j-1]) {
            m[i][j-1] = true;
            if(match(board, m, word, wordInd+1, i, j-1))
                return true;
            m[i][j-1] = false;
        }
        if(i+1 < board.length && board[i+1][j] == c && !m[i+1][j]) {
            m[i+1][j] = true;
            if(match(board, m, word, wordInd+1, i+1, j))
                return true;
            m[i+1][j] = false;
        }
        if(j+1 < board[0].length && board[i][j+1] == c && !m[i][j+1]) {
            m[i][j+1] = true;
            if(match(board, m, word, wordInd+1, i, j+1))
                return true;
            m[i][j+1] = false;
        }
        return false;
    }
}
