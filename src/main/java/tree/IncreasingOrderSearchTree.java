package tree;

import common.TreeNode;

/***
 * Given a binary search tree, rearrange the tree in in-order
 * so that the leftmost node in the tree is now the root of
 * the tree, and every node has no left child and only 1 right child.
 */
public class IncreasingOrderSearchTree {
    TreeNode curr;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        curr = ans;
        func(root);
        return ans.right;
    }

    private void func(TreeNode root) {
        if (root != null) {
            func(root.left);
            root.left = null;
            curr.right = root;
            curr = root;
            func(root.right);
        }
    }
}
