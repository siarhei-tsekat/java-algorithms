package tree;

import common.TreeNode;

/***
 *       1
 *    2    2
 * 4  5   5  4
 */
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;
        node3.left = node7;
        System.out.println(isSymmetric(node1));
    }

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode root, TreeNode root1) {
        if (root == null && root1 == null) return true;
        if (root == null || root1 == null) return false;

        if (root.val == root1.val) return isMirror(root.left, root1.right) && isMirror(root.right, root1.left);
        else
            return false;
    }
}
