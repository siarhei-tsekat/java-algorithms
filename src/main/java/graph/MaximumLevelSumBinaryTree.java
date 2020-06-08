package graph;

import common.TreeNode;

public class MaximumLevelSumBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode_1 = new TreeNode(10);
        TreeNode treeNode_2 = new TreeNode(7);
        TreeNode treeNode_3 = new TreeNode(15);
        TreeNode treeNode_4 = new TreeNode(6);
        TreeNode treeNode_5 = new TreeNode(25);
        treeNode_1.left = treeNode_2;
        treeNode_1.right = treeNode_3;

        treeNode_2.left = treeNode_4;
        treeNode_3.right = treeNode_5;
        System.out.println(maxLevelSum(treeNode_1));
    }

    public static int maxLevelSum(TreeNode root) {
        int n = 10;
        int[] levelSum = new int[n];
        inorder(root, 1, levelSum);

        int maxIdx = 0;
        for (int i = 0; i < n; ++i) {
            maxIdx = levelSum[i] > levelSum[maxIdx] ? i : maxIdx;
        }
        return maxIdx;
    }

    public static void inorder(TreeNode node, int level, int[] levelSum) {
        if (node != null) {
            inorder(node.left, level + 1, levelSum);
            levelSum[level] += node.val;
            inorder(node.right, level + 1, levelSum);
        }
    }
}
