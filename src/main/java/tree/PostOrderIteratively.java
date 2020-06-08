package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrderIteratively {
    public static void main(String[] args) {
        TreeNode treeNode_1 = new TreeNode(1);
        TreeNode treeNode_2 = new TreeNode(2);
        TreeNode treeNode_3 = new TreeNode(3);
        treeNode_2.left = treeNode_1;
        treeNode_2.right = treeNode_3;

        List<Integer> list = postorderTraversal(treeNode_2);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        helper(root, stack);
        return list;
    }

    private static void helper(TreeNode root, Stack<Integer> stack) {

        while (root != null) {
            if (root.left != null) {
                stack.add(root.left.val);
            }
            if (root.right != null) {
                stack.add(root.left.val);
            }
        }

    }
}
