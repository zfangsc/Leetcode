package ThreeSumClosest;

import org.junit.Assert;
import org.junit.Test;

/**
 * Author: fangzhou
 * Date:   9/4/14.
 */
public class ThreeSumClosestTest {
    @Test
    public void testThreeSumClosest() throws Exception {
        Solution s = new Solution();
        int[] arr = new int[] {1,1,-1,-1,3};

        Assert.assertEquals(s.threeSumClosest(arr, -1), -1);
    }
}
