package PalindromePartitioningII;

import org.junit.Assert;
import org.junit.Test;

/**
 * Author: fangzhou
 * Date:   9/10/14.
 */
public class PalindromePartitioningIITest {
    @Test
    public void testMinCut() throws Exception {
        Solution s = new Solution();
        Assert.assertEquals(s.minCut("bb"), 0);
        Assert.assertEquals(s.minCut("aabc"), 2);

    }
}
