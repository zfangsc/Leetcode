package BinaryTreeLevelOrderTraversalII;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author: fangzhou
 * Date:   8/27/14.
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
    /*
    * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
    * (ie, from left to right, level by level from leaf to root).
    * */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        List<List<TreeNode>> recorder = new ArrayList();

        if(root == null) {
            return result;
        }
        List<TreeNode> level = new ArrayList<TreeNode>();
        level.add(root);
        recorder.add(level);
        while(true) {
            List<TreeNode> pre = recorder.get(recorder.size()-1);
            level = new ArrayList<TreeNode>();
            for(TreeNode parent : pre) {
                if(parent.left != null) {
                    level.add(parent.left);
                }
                if(parent.right != null) {
                    level.add(parent.right);
                }
            }
            if(!level.isEmpty()) {
                recorder.add(level);
            } else {
                break;
            }
        }

        for(int i = recorder.size()-1; i >= 0; i--) {
            level = recorder.get(i);
            List<Integer> numbers = new ArrayList<Integer>();
            for(TreeNode n : level) {
                numbers.add(n.val);
            }
            result.add(numbers);
        }
        return result;
    }
}
