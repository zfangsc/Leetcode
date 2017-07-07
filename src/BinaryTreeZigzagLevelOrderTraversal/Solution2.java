package BinaryTreeZigzagLevelOrderTraversal;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fangz on 7/6/2017.
 */
public class Solution2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> current = new LinkedList<>();
        boolean direction = true;
        current.add(root);

        while (!current.isEmpty()) {
            LinkedList<TreeNode> next = new LinkedList<>();
            List<Integer> layer = new LinkedList<>();
            for (TreeNode cur : current) {
                layer.add(cur.val);
                if (cur.left != null) {
                    next.add(cur.left);
                }
                if (cur.right != null) {
                    next.add(cur.right);
                }
            }
            if (!direction) {
                Collections.reverse(layer);
            }
            direction = !direction;
            result.add(layer);
            current = next;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(new Solution2().zigzagLevelOrder(root));
    }
}
