package tree.binaryTree;

import common.TreeNode;

public class SearchBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root != null) {

            if(root.val == val) return root;
            if(val < root.val) return searchBST(root.left, val);
            else return searchBST(root.right, val);

        } else return null;
    }
}
