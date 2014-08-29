package MinimumDepthofBinaryTree;

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
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left == 0) {
            return right+1;
        }
        if(right == 0) {
            return left+1;
        }
        return Math.min(left, right) + 1;
    }
}