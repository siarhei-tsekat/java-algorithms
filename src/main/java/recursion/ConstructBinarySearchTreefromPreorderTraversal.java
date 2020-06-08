package recursion;

import common.TreeNode;
import common.TreeUtils;

public class ConstructBinarySearchTreefromPreorderTraversal {
    public static void main(String[] args) {
        int[] var = {8, 5, 1, 7, 10, 12};
        bstFromPreorder(var);
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        TreeNode helper = helper(preorder, 0, preorder.length - 1);
        TreeUtils.print(helper);
        return helper;
    }

    private static TreeNode helper(int[] preorder, int start, int end) {
        if (start > end) return null;

        TreeNode node = new TreeNode(preorder[start]);
        int i;
        for (i = start; i <= end; i++) {
            if (preorder[i] > node.val) break;
        }

        node.left = helper(preorder, start + 1, i - 1);
        node.right = helper(preorder, i, end);
        return node;

    }
}
