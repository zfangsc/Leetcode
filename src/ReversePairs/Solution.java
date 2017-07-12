package ReversePairs;

/**
 * Created by fangz on 7/9/2017.
 */
public class Solution {
    class Node {
        int counter; // how many node of this tree
        long val; // integer value of the node
        int freq; // how many int are stored in this node (have the same dup value)
        Node left, right;

        public Node(long val) { // learn: would overflow if we use integer
            this.val = val;
            freq = 1;
            counter = 1;
        }

        public void insert(long target) {
            counter++;
            if (target == val) {
                freq++;
            } else if (target > val) {
                if (right == null) {
                    right = new Node(target);
                } else {
                    right.insert(target);
                }
            } else {
                if (left == null) {
                    left = new Node(target);
                } else {
                    left.insert(target);
                }
            }
        }
    }

    // Count how many reverse pairs
    private static int count(Node n, int target) {
        if (n == null) {
            return 0;
        }
        if (target > n.val) {
            return n.freq + (n.left == null ? 0 : n.left.counter) + count(n.right, target);
        }
        return count(n.left, target);
    }

    public int reversePairs(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Node root = new Node(2 * (long) nums[nums.length - 1]);
        int count = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            count += count(root, nums[i]);
            root.insert(2 * (long) nums[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reversePairs(new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}));
    }
}
