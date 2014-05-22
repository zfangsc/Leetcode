package RecoverBinarySearchTree;

/**
 * Author:  fangzhou
 * Date:    5/19/14
 * Time:    10:09 PM
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

 //http://fisherlei.blogspot.com/2012/12/leetcode-recover-binary-search-tree.html
//http://en.wikipedia.org/wiki/Threaded_binary_tree
//http://yucoding.blogspot.com/2013/03/leetcode-question-75-recover-binary.html

class Pointers {
    TreeNode first;
    TreeNode second;
    TreeNode pre;
    public Pointers() {
        first = null;
        second = null;
        pre = null;
    }
}

public class Solution {
    public void recoverTree(TreeNode root) {
        if(root == null) {
            return;
        }
        Pointers p = new Pointers();
        traverse(root, p);
        int temp = p.first.val;
        p.first.val = p.second.val;
        p.second.val = temp;
    }

    public void traverse(TreeNode n, Pointers p) {
        if(n == null) {
            return;
        }
        traverse(n.left, p);
        if(p.pre == null) {
            p.pre = n;
        } else {
            if(p.pre.val > n.val) {
                if(p.first == null) {
                    p.first = p.pre;
                    p.second = n;
                } else {
                    p.second = n;
                }
            }
            p.pre = n;
        }
        traverse(n.right, p);
    }
}