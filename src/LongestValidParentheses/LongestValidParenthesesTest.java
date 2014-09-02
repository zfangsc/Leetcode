package LongestValidParentheses;

import org.junit.Assert;
import org.junit.Test;

/**
 * Author: fangzhou
 * Date:   9/1/14.
 */
public class LongestValidParenthesesTest {
    @Test
    public void testLongestValidParentheses() throws Exception {
        Solution s = new Solution();
        Assert.assertEquals(s.longestValidParentheses("())()"), 2);
        Assert.assertEquals(s.longestValidParentheses(")()()"), 4);
        Assert.assertEquals(s.longestValidParentheses(")()())"), 4);
    }
}
