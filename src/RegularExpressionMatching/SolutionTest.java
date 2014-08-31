package RegularExpressionMatching;

import org.junit.Assert;
import org.junit.Test;

/**
 * Author: fangzhou
 * Date:   8/31/14.
 */
public class SolutionTest {
    @Test
    public void testIsMatch() throws Exception {
        Solution ss = new Solution();
        Assert.assertTrue(ss.isMatch("ab", "ab"));
        Assert.assertFalse(ss.isMatch("ab", "ab."));
        Assert.assertTrue(ss.isMatch("ab", "a*b"));
        Assert.assertTrue(ss.isMatch("abefg", "ac*be.*"));
    }
}
