package common;

public class BinaryTreeNode {
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int x) {
        value = x;
    }

    @Override
    public String toString() {
        return value+"";
    }
}
