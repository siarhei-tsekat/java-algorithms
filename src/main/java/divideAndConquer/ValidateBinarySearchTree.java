package divideAndConquer;

import common.TreeNode;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {

        TreeNode treeNode_1 = new TreeNode(1);
        TreeNode treeNode_2 = new TreeNode(2);
        TreeNode treeNode_3 = new TreeNode(3);
        treeNode_2.left = treeNode_1;
        treeNode_2.right = treeNode_3;

        System.out.println(isValidBST(treeNode_2));
    }

    public static boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public static boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.left, lower, val)) return false;
        if (! helper(node.right, val, upper)) return false;
        return true;
    }
}

