package PalindromeNumber;

import org.junit.Assert;
import org.junit.Test;

/**
 * Author: fangzhou
 * Date:   9/1/14.
 */
public class PalindromeNumberTest {
    @Test
    public void testIsPalindrome() throws Exception {
        Solution s = new Solution();
        Assert.assertFalse(s.isPalindrome(10));
        Assert.assertTrue(s.isPalindrome(11));
        Assert.assertTrue(s.isPalindrome(9));
        Assert.assertTrue(s.isPalindrome(212));
        Assert.assertFalse(s.isPalindrome(10000021));


    }
}
