package tree.binaryTree;

import common.TreeNode;

public class KthSmallestElementinaBST {

    public int kthSmallest(TreeNode root, int k) {
        int sum[] = new int[1];
        func(root, k, sum, new int[]{1});
        return sum[0];
    }

    public void func(TreeNode root, int k, int[] sum, int[] level) {
        if (root == null) return;

        int val = root.val;
        func(root.left, k, sum, level);
        if (level[0]++ == k) sum[0] = val;
        func(root.right, k, sum, level);

    }
}
