package tree.binaryTree;

import common.TreeNode;

public class LowestCommonAncestorofBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode min, TreeNode max) {

        if (root == min) return min;

        if (root == max) return max;

        TreeNode left = null;
        TreeNode right = null;

        if (root.left != null) {
            left = lowestCommonAncestor(root.left, min, max);
        }

        if (root.right != null) {
            right = lowestCommonAncestor(root.right, min, max);
        }

        if (left != null && right == null) return left;

        if (left == null && right != null) return right;

        if (left == null && right == null) return null;

        return root;

    }
}

