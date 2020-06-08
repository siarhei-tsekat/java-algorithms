package tree;

import common.TreeNode;

public class InsufficientNodesinRoottoLeafPaths {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (func(root, 0, limit)) return null;
        return root;
    }

    private boolean func(TreeNode root, int sum, int limit) {
        if(root.left == null && root.right == null) return sum + root.val < limit;

        boolean left = true, right = true;

        if (root.left != null) left = func(root.left, sum + root.val, limit);
        if (root.right != null) right = func(root.right, sum + root.val, limit);

        if (left) root.left = null;
        if (right) root.right = null;

        return left && right;
    }
}
