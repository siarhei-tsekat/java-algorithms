package tree;

import common.TreeNode;

public class InsertIntoBinarySearchTree {

    public static void main(String[] args) {
        TreeNode treeNode_1 = new TreeNode(1);
        TreeNode treeNode_2 = new TreeNode(2);
        TreeNode treeNode_3 = new TreeNode(3);
        treeNode_2.left = treeNode_1;
        treeNode_2.right = treeNode_3;
        TreeNode treeNode = insertIntoBST(treeNode_2, 3);
        System.out.println(treeNode);
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val && root.left == null) {
            root.left = new TreeNode(val);
        }

        if (val > root.val && root.right == null) {
            root.right = new TreeNode(val);
        }

        if (val < root.val && root.left != null) {
            insertIntoBST(root.left, val);
        }

        if (val > root.val && root.right != null) {
            insertIntoBST(root.right, val);
        }

        return root;
    }
}

