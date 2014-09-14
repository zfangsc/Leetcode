package PrintAllPathsOfABinaryTree;

import Common.TreeNode;

/**
 * Author: fangzhou
 * Date:   9/14/14.
 */
public class PrintAllPathsOfABinaryTreeTest {

    private static TreeNode getTree() {
        TreeNode header = null;
        header = new TreeNode(1);
        header.left = new TreeNode((2));
        header.right = new TreeNode(3);
        header.left.left = new TreeNode(4);
        header.left.right = new TreeNode(5);
        return header;
    }

    @org.junit.Test
    public void testPrintPathRecursively() throws Exception {
        Solution s = new Solution();
        s.printPathRecursively(getTree());
    }

    @org.junit.Test
    public void testPrintPathIteratively() throws Exception {
        Solution s = new Solution();
        s.printPathIteratively(getTree());
    }
}
