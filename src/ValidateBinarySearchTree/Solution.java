package ValidateBinarySearchTree;

/**
 * Author: fangzhou
 * Date:   8/28/14.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST1(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST1(TreeNode n, int low, int high) {
        if(n == null) {
            return true;
        }
        if(n.val <= low || n.val >= high) {
            return false;
        }
        return isValidBST1(n.left, low, n.val) && isValidBST1(n.right, n.val, high);
    }
}
