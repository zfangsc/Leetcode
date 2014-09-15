package DiagonalMatrixPrinting;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: fangzhou
 * Date:   9/14/14.
 */
// http://nkcoder.github.io/blog/20140516/algorithm-print-matrix-diagonally/
public class Solution {
    public List<Integer> printMatrix(int[][] m) {
        List<Integer> result = new ArrayList<Integer>();
        if (m.length == 0 || m[0].length == 0) {
            return result;
        }
        for (int col = m[0].length - 1; col >= 0; col--) {
            printLine(m, 0, col, result);
        }

        for (int row = 1; row < m.length; row++) {
            printLine(m, row, 0, result);
        }

        return result;
    }

    private void printLine(int[][] m, int row, int col, List<Integer> result) {
        while (row >= 0 && row < m.length && col >= 0 && col < m[0].length) {
            result.add(m[row][col]);
            row++;
            col++;
        }
    }
}
