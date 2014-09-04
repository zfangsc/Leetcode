package PartitionList;

import org.junit.Assert;
import org.junit.Test;

/**
 * Author: fangzhou
 * Date:   9/3/14.
 */
public class PartitionListTest {
    @Test
    public void testPartition() throws Exception {
        Solution s = new Solution();
        ListNode h = new ListNode(3);
        h.next = new ListNode(1);
        h.next.next = new ListNode(2);
        ListNode n = s.partition(h, 3);
        Assert.assertEquals(n.val, 1);
        Assert.assertEquals(n.next.val, 2);
        Assert.assertEquals(n.next.next.val, 3);

    }
}
