package LargestRectangleinHistogram1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Author: fangzhou
 * Date:   9/11/14.
 */
public class LargestRectangleinHistogramTest {
    @Test
    public void testLargestRectangleArea() throws Exception {
        Solution s = new Solution();
        Assert.assertEquals(s.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}), 10);
    }
}
