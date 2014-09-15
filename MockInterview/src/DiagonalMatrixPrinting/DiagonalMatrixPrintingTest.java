package DiagonalMatrixPrinting;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Author: fangzhou
 * Date:   9/14/14.
 */
public class DiagonalMatrixPrintingTest {
    @Test
    public void testPrintMatrix() throws Exception {
        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        /*
        *  1,  2,  3
        *  4,  5,  6
        *  7,  8,  9
        * 10, 11, 12
        * */
        Solution s = new Solution();
        List<Integer> result = s.printMatrix(arr);
        Assert.assertEquals(result.get(2).intValue(), 6);
        Assert.assertEquals(result.get(4).intValue(), 5);
        Assert.assertEquals(result.get(6).intValue(), 4);
        Assert.assertEquals(result.get(10).intValue(), 11);
    }
}
