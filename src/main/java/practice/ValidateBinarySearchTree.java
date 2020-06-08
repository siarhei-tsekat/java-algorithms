package practice;

import common.TreeNode;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {

        TreeNode treeNode_1 = new TreeNode(1);
        TreeNode treeNode_2 = new TreeNode(2);
        TreeNode treeNode_3 = new TreeNode(3);
        treeNode_2.left = treeNode_1;
        treeNode_2.right = treeNode_3;

        System.out.println("Expected: true. Actual: " + isValidBST(treeNode_2));
    }

    public static boolean isValidBST(TreeNode root) {
        return false;
    }
}
