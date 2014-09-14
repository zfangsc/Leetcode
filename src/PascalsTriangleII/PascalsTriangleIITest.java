package PascalsTriangleII;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Author: fangzhou
 * Date:   9/12/14.
 */
public class PascalsTriangleIITest {
    @Test
    public void testGetRow() throws Exception {
        Solution s = new Solution();
        List<Integer> l = s.getRow(3);
        Assert.assertEquals(l.get(0).intValue(), 1);
        Assert.assertEquals(l.get(1).intValue(), 3);
        Assert.assertEquals(l.get(2).intValue(), 3);
        Assert.assertEquals(l.get(3).intValue(), 1);
    }
}
