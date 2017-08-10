package Common;

/**
 * Author: fangzhou
 * Date:   9/14/14.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        if (left != null) {
            sb.append(left.toString());
        } else {
            sb.append('#');
        }
        sb.append('<');
        sb.append(val);
        sb.append('>');
        if (right != null) {
            sb.append(right.toString());
        } else {
            sb.append('#');
        }
        return sb.toString();
    }
}
