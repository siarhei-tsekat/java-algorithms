package tree;

import common.TreeNode;

import java.util.*;

/***
 *         10
 *     8       15
 *   6  9    13   20
 * 5  7
 */
public class BinaryTreeZigzagLevelOrderTraversal {
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
        List<List<Integer>> lists = zigzagLevelOrder(node_10);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root==null){
            return Collections.emptyList();
        }
        int flag = 0;
        List<List<Integer>> result = new ArrayList<>();

        Stack<Stack<TreeNode>> toProcess = new Stack<>();
        Stack<TreeNode> level = new Stack<>();
        level.add(root);
        toProcess.push(level);
        List<Integer> inner = new ArrayList<>();
        inner.add(root.val);
        result.add(inner);

        while (!toProcess.isEmpty()) {
            Stack<TreeNode> currentLevel = toProcess.pop();
            Stack<TreeNode> newLevel = new Stack<>();
            List<Integer> innerResult = new ArrayList<>();

            while (!currentLevel.isEmpty()) {
                TreeNode treeNode = null;
                if (flag % 2 != 0) {
                    treeNode = currentLevel.pop();
                    if (treeNode.left != null) {
                        newLevel.add(treeNode.left);
                        innerResult.add(treeNode.left.val);
                    }
                    if (treeNode.right != null) {
                        newLevel.add(treeNode.right);
                        innerResult.add(treeNode.right.val);
                    }
                } else {
                    treeNode = currentLevel.remove(currentLevel.size()-1);


                    if (treeNode.right != null) {
                        newLevel.add(treeNode.right);
                        innerResult.add(treeNode.right.val);
                    }
                    if (treeNode.left != null) {
                        newLevel.add(treeNode.left);
                        innerResult.add(treeNode.left.val);
                    }
                }
            }
            flag++;

            if (!newLevel.isEmpty()) {
                toProcess.add(newLevel);
                result.add(innerResult);
            }
        }
        return result;
    }
}
