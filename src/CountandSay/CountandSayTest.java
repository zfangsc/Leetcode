package CountandSay;

import org.junit.Assert;
import org.junit.Test;

/**
 * Author: fangzhou
 * Date:   9/6/14.
 */
public class CountandSayTest {
    @Test
    public void testCountAndSay() throws Exception {
        Solution s = new Solution();
        Assert.assertEquals(s.countAndSay(5), "111221");
    }
}
