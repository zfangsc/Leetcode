package BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Author:  fangzhou
 * Date:    4/29/14
 * Time:    9:15 PM
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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return result;

        Stack<TreeNode> prev = new Stack<TreeNode>();
        Stack<TreeNode> cur = new Stack<TreeNode>();
        int order = 0;  // from left to right
        prev.push(root);
        while(!prev.empty()) {
            order ^= 1;
            ArrayList<Integer> level = new ArrayList<Integer>();
            while(!prev.empty()) {
                TreeNode n = prev.pop();
                level.add(n.val);
                if(order == 1) {
                    if(n.left != null) {
                        cur.add(n.left);
                    }
                    if(n.right != null) {
                        cur.add(n.right);
                    }
                }
                else {
                    if(n.right != null) {
                        cur.add(n.right);
                    }
                    if(n.left != null) {
                        cur.add(n.left);
                    }
                }
            }
            result.add(level);
            prev = cur;
            cur = new Stack<TreeNode>();
        }
        return result;
    }
}
