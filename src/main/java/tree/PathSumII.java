package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathSumII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pathSum(getTree(), 22));
    }

    private static TreeNode getTree() {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node44 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node55 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        node5.left = node4;
        node5.right = node8;

        node4.left = node11;
        node11.left = node7;
        node11.right = node2;

        node8.left = node13;
        node8.right = node44;

        node44.left = node55;
        node44.right = node1;
        return node5;
    }
}

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return new ArrayList<>();
        f(root, sum - root.val, new ArrayList<>(Arrays.asList(root.val)));
        return res;
    }

    private void f(TreeNode node, int sum, ArrayList<Integer> tmpP) {

        if (node.left == null && node.right == null) {
            if (sum == 0) res.add(new ArrayList<>(tmpP));
        }

        if (node.left != null) {
            tmpP.add(node.left.val);
            sum-=node.left.val;
            f(node.left, sum, tmpP);
            tmpP.remove(tmpP.size()-1);
            sum+=node.left.val;
        }

        if (node.right != null) {
            tmpP.add(node.right.val);
            sum-=node.right.val;
            f(node.right, sum, tmpP);
            tmpP.remove(tmpP.size()-1);
        }
    }
}
