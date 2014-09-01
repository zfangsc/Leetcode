package SumRoottoLeafNumbers;

/**
 * Author: fangzhou
 * Date:   9/1/14.
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
    public int sumNumbers(TreeNode root) {
        int[] buf = new int[2]; // [curbuffer, global result sum]
        cal(root, buf);
        return buf[1];
    }

    public void cal(TreeNode root, int[] buf) {
        if(root == null) {
            return;
        }
        buf[0] *= 10;
        buf[0] += root.val;
        if(root.left == null && root.right == null) {
            buf[1] += buf[0];
        } else {
            cal(root.left, buf);
            cal(root.right, buf);
        }
        buf[0] /= 10;
    }
}
