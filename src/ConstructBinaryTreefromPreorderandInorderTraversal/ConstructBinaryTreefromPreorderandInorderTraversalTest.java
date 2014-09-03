package ConstructBinaryTreefromPreorderandInorderTraversal;

import org.junit.Assert;
import org.junit.Test;

/**
 * Author: fangzhou
 * Date:   9/2/14.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversalTest {
    @Test
    public void testBuildTree() throws Exception {
        Solution s = new Solution();
        int[] a = new int[]{1, 2};
        int[] b = new int[]{2, 1};
        TreeNode n = s.buildTree(a, b);
        Assert.assertEquals(n.val, 1);

        a = new int[]{1, 2};
        b = new int[]{1, 2};
        n = s.buildTree(a, b);
        Assert.assertEquals(n.val, 1);
    }
}
