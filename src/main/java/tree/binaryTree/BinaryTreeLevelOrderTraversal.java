package tree.binaryTree;

import common.TreeNode;
import common.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/***
 *       1
 *    2    2
 * 4  5   5  4
 */

public class BinaryTreeLevelOrderTraversal {
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
        TreeUtils.print(node1);

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        collectData(root, result, 0);
        return result;
    }

    private static void collectData(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) {
            return;
        } else {

            if (result.size() <= level) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(root.val);
                result.add(list);
            } else {
                result.get(level).add(root.val);
            }

            if (root.left != null) {
                collectData(root.left, result, level + 1);
            }
            if (root.right != null) {
                collectData(root.right, result, level + 1);
            }
        }
    }
}
