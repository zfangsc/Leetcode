package BinarySearchTreeIterator;

import Common.TreeNode;

import java.util.Stack;

/**
 * Created by fangz on 7/15/2017.
 */
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushTree(root);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode next = stack.pop();
        pushTree(next.right);
        return next.val;
    }

    private void pushTree(TreeNode root) {
        if (root != null) {
            stack.push(root);
            while (stack.peek().left != null) {
                stack.push(stack.peek().left);
            }
        }
    }
}
