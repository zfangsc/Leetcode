package FindDuplicateSubtrees;

import Common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by fangz on 8/2/2017.
 */
public class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new LinkedList<>();
        Map<String, Integer> status = new HashMap<>();
        visit(root, status, result);
        return result;
    }

    private String visit(TreeNode root, Map<String, Integer> status, List<TreeNode> result) {
        if (root == null) {
            return "#";
        }
        String left = visit(root.left, status, result);
        String right = visit(root.right, status, result);
        String cur = left + "," + right + "," + root.val;
        if (status.getOrDefault(cur, 0) == 1) {
            result.add(root);
        }
        status.put(cur, status.getOrDefault(cur, 0) + 1);
        return cur;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.right.right = new TreeNode(0);
        root.right.right.right = new TreeNode(0);
        System.out.println(new Solution().findDuplicateSubtrees(root));
    }
}

