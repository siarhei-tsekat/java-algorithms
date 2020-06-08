package practice;

import common.TreeNode;

/***
 *          15
 *       9       19
 *    7   12   16  24
 * 4   8         21   32
 *
 *
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 *
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 */

public class LowestCommonAncestorofBinarySearchTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(15);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(19);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(12);
        TreeNode node6 = new TreeNode(24);
        TreeNode node7 = new TreeNode(16);
        TreeNode node44 = new TreeNode(4);
        TreeNode node55 = new TreeNode(8);
        TreeNode node88 = new TreeNode(32);
        TreeNode node99 = new TreeNode(21);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;
        node3.left = node7;

        node4.left = node44;
        node4.right = node55;

        node6.right = node88;
        node6.left = node99;

        TreeNode treeNode = lowestCommonAncestor(node1, new TreeNode(8), new TreeNode(21));
        System.out.println(treeNode);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode min, TreeNode max) {
      return null;
    }
}
