package FlattenBinaryTreetoLinkedList;

import java.util.Stack;

/**
 * Author: fangzhou
 * Date:   8/29/14.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class Solution {
    public void flatten(TreeNode root) {
        flatten2(root);
    }

    // recursive way.
    // need to backup right, left node before destroy them
    public TreeNode flatten1(TreeNode n) {  // return last element
        if(n == null) {
            return null;
        }
        TreeNode leftLast = flatten1(n.left);
        TreeNode rightLast = flatten1(n.right);
        TreeNode left = n.left;
        TreeNode right = n.right;
        TreeNode cur = n;
        if(leftLast != null) {
            cur.right = left;
            cur = leftLast;
        }
        if(rightLast != null) {
            cur.right = right;
            cur = rightLast;
        }
        n.left = null;
        return cur;
    }

    // iterative way
    public void flatten2(TreeNode n) {  // return last element
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = n;
        while(cur != null || !s.isEmpty()) {
            if(cur.right != null) {
                s.push(cur.right);
            }
            if(cur.left != null) {
                cur.right = cur.left;
                cur.left = null;
            } else if(!s.isEmpty()) {
                cur.right = s.pop();
            }
            cur = cur.right;
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        new Solution().flatten(head);
        print(head);
    }

    private static void print(TreeNode head) {
        TreeNode cur = head;
        while(cur != null) {
            System.out.println(cur.val+",");
            cur = cur.right;
        }
    }
}
