package design;

import common.TreeNode;

import java.util.Stack;

/***
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 */

public class BinarySearchTreeIterator {
    public static void main(String[] args) {
        TreeNode tree7 = new TreeNode(7);
        TreeNode tree3 = new TreeNode(3);
        TreeNode tree15 = new TreeNode(15);
        TreeNode tree9 = new TreeNode(9);
        TreeNode tree20 = new TreeNode(20);

        tree7.left = tree3;
        tree7.right = tree15;
        tree15.left = tree9;
        tree15.right = tree20;

        BSTIterator bstIterator = new BSTIterator(tree7);
        while (bstIterator.hasNext()){
            System.out.println(bstIterator.next());
        }
    }
}

class BSTIterator {

    private TreeNode root;
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        this.root = root;
        f(root);
    }

    private void f(TreeNode root) {
        if (root != null) {
            f(root.right);
            stack.add(root);
            f(root.left);
        }
    }

    public int next() {
        return stack.pop().val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
