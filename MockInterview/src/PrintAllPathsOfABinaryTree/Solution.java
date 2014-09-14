package PrintAllPathsOfABinaryTree;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author: fangzhou
 * Date:   9/14/14.
 */
public class Solution {
    /* Print all paths of a binary tree. How to do it iteratively?
    * */

    // Recursively
    public void printPathRecursively(TreeNode n) {
        if (n == null) {
            return;
        }
        List<TreeNode> buffer = new ArrayList<TreeNode>();
        printPathRecursivelyHelper(n, buffer, 0);
    }

    private void printPathRecursivelyHelper(TreeNode node, List<TreeNode> buffer, int index) {
        if (node == null) {
            return;
        }
        setBuffer(buffer, index, node);
        if (node.left == null && node.right == null) {
            printCollection(buffer, index + 1);
        }
        printPathRecursivelyHelper(node.left, buffer, index + 1);
        printPathRecursivelyHelper(node.right, buffer, index + 1);
    }

    private void printCollection(List<TreeNode> buffer, int end) {
        System.out.println("**********Begin to print**********");
        for (int i = 0; i < end; i++) {
            System.out.println(buffer.get(i).val + ",");
        }
        System.out.println("**********Finish to print**********\n\n");
    }

    private void setBuffer(List<TreeNode> buffer, int index, TreeNode node) {
        if (buffer.size() <= index) {
            buffer.add(node);
        } else {
            buffer.set(index, node);
        }
    }

    // Iterative
    public void printPathIteratively(TreeNode n) {
        if (n == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(n);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur.left == null && cur.right == null) {
                printCollection(stack, stack.size());
                pre = stack.pop();
                continue;
            }

            if (pre == null || (pre != cur.left && pre != cur.right)) {
                if (cur.left != null) {  // if has left child, push and continue
                    stack.push(cur.left);
                    continue;
                }
                if (cur.right != null) {
                    stack.push(cur.right);
                }
            } else {
                if (pre == cur.left && cur.right != null) {  // if left child is done, check if it has right child
                    stack.push(cur.right);
                    continue;
                }
                pre = stack.pop();
            }
        }
    }

    /*    // Iterative
    public void printPathIteratively(TreeNode n) {
        if(n == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(n);
        TreeNode pre = null;
        while(!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if(cur.left == null && cur.right == null) {
                //printCollection(stack, stack.size());
                System.out.println(cur.val+", ");
                pre = stack.pop();
            } else if(pre == null || (pre != cur.left && pre != cur.right)) {
                if(cur.right != null) {
                    stack.push(cur.right);
                }
                if(cur.left != null) {
                    stack.push(cur.left);
                }
            } else {
                System.out.println(cur.val+", ");
                pre = stack.pop();
            }
        }
    }*/

}
