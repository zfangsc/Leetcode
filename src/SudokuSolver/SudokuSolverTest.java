package SudokuSolver;

import org.junit.Assert;
import org.junit.Test;

/**
 * Author: fangzhou
 * Date:   9/6/14.
 */
public class SudokuSolverTest {
    @Test
    public void testSolveSudoku() throws Exception {
        Solution s = new Solution();
        char[][] arr = new char[][]{
                "..9748...".toCharArray(),
                "7........".toCharArray(),
                ".2.1.9...".toCharArray(),
                "..7...24.".toCharArray(),
                ".64.1.59.".toCharArray(),
                ".98...3..".toCharArray(),
                "...8.3.2.".toCharArray(),
                "........6".toCharArray(),
                "...2759..".toCharArray()};
        s.solveSudoku(arr);
        Assert.assertEquals(arr[0][0], '5');
    }
}
