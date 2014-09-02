package MultiplyStrings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Author: fangzhou
 * Date:   9/1/14.
 */
public class MultiplyStringsTest {
    @Test
    public void testMultiply() throws Exception {
        Solution s = new Solution();
        Assert.assertEquals(s.multiply("12", "12"), "144");
        Assert.assertEquals(s.multiply("10", "1"), "10");
        Assert.assertEquals(s.multiply("99999", "10"), "999990");
        Assert.assertEquals(s.multiply("123", "456"), "56088");
    }
}
