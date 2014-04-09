package UniqueBinarySearchTreesII;

import java.util.ArrayList;

/**
 * Author:  fangzhou
 * Date:    4/8/14
 * Time:    10:21 PM
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
    public ArrayList<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> ans = new ArrayList<TreeNode>();
        if(n < 1) {
            ans.add(null);
            return ans;
        }
        return generateByRange(1, n);
    }
    public ArrayList<TreeNode> generateByRange(int start, int end) {
        ArrayList<TreeNode> ans = new ArrayList<TreeNode>();
        if(start <= end) {
            for(int head = start; head <= end; head++) {
                ArrayList<TreeNode> left = generateByRange(start, head-1);
                ArrayList<TreeNode> right = generateByRange(head+1, end);
                int l = left.size();
                int r = right.size();
                if(l == 0 && r == 0) {
                    ans.add(new TreeNode(head));
                } else if(l != 0 && r != 0) {
                    for(int i = 0; i < l; i++) {
                        for(int j = 0; j < r; j++) {
                            TreeNode cur = new TreeNode(head);
                            TreeNode leftSubTree = left.get(i);
                            TreeNode rightSubTree = right.get(j);
                            cur.left = leftSubTree;
                            cur.right = rightSubTree;
                            ans.add(cur);
                        }
                    }
                } else if(l != 0) {
                    for(int i = 0; i < l; i++) {
                        TreeNode cur = new TreeNode(head);
                        TreeNode leftSubTree = left.get(i);
                        cur.left = leftSubTree;
                        ans.add(cur);
                    }
                } else {
                    for(int j = 0; j < r; j++) {
                        TreeNode cur = new TreeNode(head);
                        TreeNode rightSubTree = right.get(j);
                        cur.right = rightSubTree;
                        ans.add(cur);
                    }
                }
            }
        }
        return ans;
    }
}
