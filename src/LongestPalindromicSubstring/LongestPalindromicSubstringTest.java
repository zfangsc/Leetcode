package LongestPalindromicSubstring;

import org.junit.Assert;
import org.junit.Test;

/**
 * Author: fangzhou
 * Date:   9/9/14.
 */
public class LongestPalindromicSubstringTest {
    @Test
    public void testLongestPalindrome() throws Exception {
        Solution s = new Solution();
        Assert.assertEquals(s.longestPalindrome("bb"), "bb");
    }
}
