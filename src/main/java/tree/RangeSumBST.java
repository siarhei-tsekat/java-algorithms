package tree;

import common.TreeNode;


public class RangeSumBST {

    public static int rangeSumBST(TreeNode root, int L, int R) {
        int val = 0;
        if (root.val >= L && root.val <= R) {
            val = root.val;
        }
        if (root.left != null) {
            if (root.val > L) {
                val += rangeSumBST(root.left, L, R);
            }
        }

        if (root.right != null) {
            if (root.val < R) {
                val += rangeSumBST(root.right, L, R);
            }
        }
        return val;
    }
}
