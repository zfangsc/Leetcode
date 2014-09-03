package ConstructBinaryTreefromPreorderandInorderTraversal;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length == 0) {
            return null;
        }
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
            m.put(inorder[i], i);
        }
        return build(preorder, inorder, m, 0,  preorder.length-1, 0, inorder.length-1);
    }

    private TreeNode build(int[] p, int[] i, HashMap<Integer, Integer> m, int pstart, int pend, int istart, int iend) {
        if(pstart > pend || istart > iend) {
            return null;
        }
        int pHead = p[pstart];
        int iIndex = m.get(pHead);
        TreeNode n = new TreeNode(pHead);
        n.left = build(p, i, m, pstart+1, pstart+(iIndex-istart), istart, iIndex-1);
        n.right = build(p, i, m, pend-(iend-iIndex-1), pend, iIndex+1, iend);
        return n;
    }
}
