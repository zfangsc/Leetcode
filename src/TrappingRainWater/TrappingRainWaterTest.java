package TrappingRainWater;

import org.junit.Assert;
import org.junit.Test;

/**
 * Author: fangzhou
 * Date:   9/9/14.
 */
public class TrappingRainWaterTest {
    @Test
    public void testTrap() throws Exception {
        Solution s = new Solution();
        int[] arr = new int[]{2, 0, 2};
        Assert.assertEquals(s.trap(arr), 2);
    }
}
