package tree;

import common.TreeNode;

public class UpdateBinaryTree {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.generateTree(new Integer[]{100, 80, 110, 72, 85, 105, 121});
        insertNewValue(tree, 101);
        System.out.println(tree);
    }

    private static void insertNewValue(TreeNode root, int value) {
        f(root, root, value);
    }

    private static void f(TreeNode root, TreeNode parent, int value) {
        if (root == null) {
            if (value < parent.val) parent.left = new TreeNode(value);
            else parent.right = new TreeNode(value);
        } else if (value < root.val) {
            f(root.left, root, value);
        } else if (value > root.val) {
            f(root.right, root, value);
        }
    }
}

