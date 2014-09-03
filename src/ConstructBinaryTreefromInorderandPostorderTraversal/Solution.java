package ConstructBinaryTreefromInorderandPostorderTraversal;

import java.util.HashMap;

/**
 * Author: fangzhou
 * Date:   9/2/14.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0) {
            return null;
        }
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
            m.put(inorder[i], i);
        }
        return build(postorder, inorder, m, 0,  postorder.length-1, 0, inorder.length-1);
    }

    private TreeNode build(int[] p, int[] i, HashMap<Integer, Integer> m, int pstart, int pend, int istart, int iend) {
        if(pstart > pend || istart > iend) {
            return null;
        }
        int pTail = p[pend];
        int iIndex = m.get(pTail);
        TreeNode n = new TreeNode(pTail);
        n.left = build(p, i, m, pstart, pstart+(iIndex-1-istart), istart, iIndex-1);
        n.right = build(p, i, m, pend-1-(iend-iIndex-1), pend-1, iIndex+1, iend);
        return n;
    }
}
