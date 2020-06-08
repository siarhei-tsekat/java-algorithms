package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostOrder {
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
        helper(root, list);
        return list;
    }

    private static void helper(TreeNode root, List<Integer> list) {

        if (root.left != null) {
            helper(root.left, list);
        }

        if (root.right != null) {
            helper(root.right, list);
        }
        list.add(root.val);
    }
}
