package common;

import java.util.LinkedList;

public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer x) {
        val = x;
    }

    @Override
    public String toString() {
        if (val == null) return "";
        return val + " " + (left == null ? "" : left.toString()) + (right == null ? "" : right.toString());
    }

    public static TreeNode generateTree(Integer[] numbers) {
        if (numbers.length == 0) return null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        int i = 0;
        TreeNode root = new TreeNode(numbers[i++]);
        queue.add(root);

        while (!queue.isEmpty() && i < numbers.length) {
            int j = queue.size();


            while (j > 0) {
                TreeNode current = queue.poll();

                TreeNode left = i < numbers.length && numbers[i++] != null ? new TreeNode(numbers[i-1]) : null;
                TreeNode right = i < numbers.length && numbers[i++] != null ? new TreeNode(numbers[i-1]) : null;
                current.left = left;
                current.right = right;

                if (left != null) queue.add(left);
                if (right != null) queue.add(right);
                j--;
            }
        }
        return root;
    }
}
