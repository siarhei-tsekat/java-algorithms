package tree;

import common.TreeNode;

public class SubtreeofAnotherTree {
    private static TreeNode genearte1() {

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(2);

        node4.left = node5;
        node4.right = node6;


        return node4;
    }

    private static TreeNode genearte() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);


        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        return node1;
    }

    public static void main(String[] args) {
        TreeNode genearte = genearte();
        TreeNode genearte1 = genearte1();
        System.out.println(isSubtree(genearte, genearte1));
    }

    public static boolean isSubtree(TreeNode tree, TreeNode subTree) {
        return go(tree, subTree);
    }

    private static boolean go(TreeNode tree, TreeNode subTree) {
        return tree != null && (check(tree, subTree) || go(tree.left, subTree) || go(tree.right, subTree));
    }

    private static boolean check(TreeNode tree, TreeNode subTree) {

        if (subTree == null && tree == null) return true;
        if (subTree == null || tree == null) return false;

        if (subTree.val == tree.val) {
            return check(tree.left, subTree.left) && check(tree.right, subTree.right);
        } else return false;
    }
}
