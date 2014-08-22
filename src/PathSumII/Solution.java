package PathSumII;

import java.util.LinkedList;
import java.util.List;

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<Integer> trace = new LinkedList<Integer>();
        List<List<Integer>> result = new LinkedList();
        pathSum(root, trace, sum, 0, result);
        return result;
    }

    public void pathSum(TreeNode n, LinkedList<Integer> trace, int sum, int curSum, List<List<Integer>> result) {
        if(n == null) {
            return;
        }
        curSum += n.val;
        trace.addLast(n.val);

        if(n.left == null && n.right == null) {
            if(curSum == sum) {
                result.add((List<Integer>) trace.clone());
            }
        }
        if(n.left != null) {
            pathSum(n.left, trace, sum, curSum, result);
        }
        if(n.right != null) {
            pathSum(n.right, trace, sum, curSum, result);
        }
        trace.pollLast();
    }

    public static void main(String[] args) {
        TreeNode header = new TreeNode(1);
        header.left = new TreeNode(2);
        List l = new Solution().pathSum(header, 3);
        System.out.println(l);
    }
}
