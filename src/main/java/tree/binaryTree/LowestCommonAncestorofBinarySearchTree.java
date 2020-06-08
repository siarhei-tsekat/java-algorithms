package tree.binaryTree;

import common.TreeNode;

/***
 *          15
 *       9       19
 *    7   12   16  24
 * 4   8         21   32
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

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;

        int pVal = p.val;
        int qVal = q.val;

        if (pVal > parentVal && qVal > parentVal) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
