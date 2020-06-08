package practice;

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
        System.out.println("Expected:3. Actual: " + maxDepth(treeNode_3));
    }

    public static int maxDepth(TreeNode root) {
       return 0;
    }
}
