package SerializeAndDeserializeBinaryTree;

import Common.TreeNode;

/**
 * Created by fangz on 7/7/2017.
 */
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuffer sb) {
        if (sb.length() != 0) {
            sb.append(',');
        }
        if (root == null) {
            sb.append("null");
            return;
        }
        sb.append(root.val);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {  // learn: next time, split data by delimiter
        return deserialize(data, new int[]{0});
    }

    private TreeNode deserialize(String data, int[] startIndex) {
        if (startIndex[0] >= data.length()) {
            return null;
        }
        int index = indexOf(',', data, startIndex[0]);
        String current = data.substring(startIndex[0], index);
        startIndex[0] = index + 1;
        if (current.equals("null")) {
            return null;
        }
        TreeNode curNode = new TreeNode(Integer.valueOf(current));
        curNode.left = deserialize(data, startIndex);
        curNode.right = deserialize(data, startIndex);
        return curNode;
    }

    private int indexOf(char c, String data, int startIndex) {
        for (int i = startIndex; i < data.length(); i++) {
            if (data.charAt(i) == c) {
                return i;
            }
        }
        return data.length();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        SerializeAndDeserializeBinaryTree s = new SerializeAndDeserializeBinaryTree();
        TreeNode after = s.deserialize(s.serialize(root));
        System.out.println(after);
    }
}
