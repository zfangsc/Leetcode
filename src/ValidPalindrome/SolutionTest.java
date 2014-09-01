package ValidPalindrome;

import org.junit.Assert;
import org.junit.Test;

/**
 * Author: fangzhou
 * Date:   8/31/14.
 */
public class SolutionTest {
    @Test
    public void testIsPalindrome() throws Exception {
        Solution s = new Solution();
        Assert.assertTrue(s.isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertFalse(s.isPalindrome("race a car"));
        Assert.assertFalse(s.isPalindrome("1a2"));
    }
}
