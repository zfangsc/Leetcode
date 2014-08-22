package PathSum;

/**
 * Author: fangzhou
 * Date:   8/21/14.
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
    public boolean hasPathSum(TreeNode root, int sum) {
        boolean[] isValid = new boolean[1];
        isValid[0] = false;
        pathSum(root, sum, 0, isValid);
        return isValid[0];
    }

    public void pathSum(TreeNode n, int sum, int curSum, boolean[] isValid) {
        if(n == null) {
            return;
        }
        curSum += n.val;

        if(n.left == null && n.right == null) {
            if(curSum == sum) {
                isValid[0] = true;
            }
        }
        if(!isValid[0] && n.left != null) {
            pathSum(n.left, sum, curSum, isValid);
        }
        if(!isValid[0] && n.right != null) {
            pathSum(n.right, sum, curSum, isValid);
        }

    }
}
