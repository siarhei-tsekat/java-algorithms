package tree;

import common.TreeNode;

import java.util.LinkedList;
/***
 *         10
 *     8       15
 *   6  9    13   20
 * 5  7
 */
public class BFS {

    public static void main(String[] args) {
        TreeNode node_10 = new TreeNode(10);
        TreeNode node_8 = new TreeNode(8);
        TreeNode node_15 = new TreeNode(15);
        TreeNode node_6 = new TreeNode(6);
        TreeNode node_13 = new TreeNode(13);
        TreeNode node_20 = new TreeNode(20);
        TreeNode node_5 = new TreeNode(5);
        TreeNode node_7 = new TreeNode(7);
        TreeNode node_9 = new TreeNode(9);
        node_10.left = node_8;
        node_10.right = node_15;
        node_8.left = node_6;
        node_8.right = node_9;
        node_6.left = node_5;
        node_6.right = node_7;
        node_15.left = node_13;
        node_15.right = node_20;

        bfs(node_10);
    }

    public static void bfs(TreeNode root) {
        LinkedList<TreeNode> toProcess = new LinkedList<>();
        LinkedList<TreeNode> toPrint = new LinkedList<>();

        toProcess.add(root);
        toPrint.add(root);
        while (toProcess.peek() != null) {
            TreeNode pop = toProcess.pop();

            if (pop.left != null) {
                toProcess.add(pop.left);
                toPrint.add(pop.left);
            }
            if (pop.right != null) {
                toProcess.add(pop.right);
                toPrint.add(pop.right);
            }
        }
        for (TreeNode treeNode : toPrint) {
            System.out.print(" " + treeNode + " ");
        }
    }
}
