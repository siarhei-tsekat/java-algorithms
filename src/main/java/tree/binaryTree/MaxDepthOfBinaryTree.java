package tree.binaryTree;

import common.TreeNode;

public class MaxDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode_3 = new TreeNode(3);
        TreeNode treeNode_9 = new TreeNode(9);
        TreeNode treeNode_20 = new TreeNode(20);
        TreeNode treeNode_15 = new TreeNode(15);
        TreeNode treeNode_7 = new TreeNode(7);

        treeNode_3.left = treeNode_9;
        treeNode_3.right = treeNode_20;
        treeNode_20.left = treeNode_15;
        treeNode_20.right = treeNode_7;
        int i = maxDepth(treeNode_3);
        System.out.println(i);
    }

    public static int maxDepth(TreeNode root) {
        return helper(root, 0);
    }

    private static int helper(TreeNode root, int depth) {
        if (root == null) {
            return 0;
        }
        int depthLeft = 1 + helper(root.left, depth + 1);
        int depthRight = 1 + helper(root.right, depth + 1);
        return Math.max(depthLeft, depthRight);
    }
}
