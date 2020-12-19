package tree;

public class RedBlackTree {
    public static void main(String[] args) {
        RBTree tree = new RBTree();
        tree.insert(1);
    }
}

class RBTree {
    public RBNode root;

    public void insert(int val) {
        RBNode parent = f(root, root, val);

        if (parent.color == RBNode.colors.RED) {

        }
    }

    private RBNode f(RBNode parent, RBNode node, int val) {
        if (node == null) {
            node = new RBNode(val);
            return parent;
        }

        if (val < node.val) {
           return f(node, node.left, val);
        } else {
           return f(node, node.right, val);
        }
    }
}

class RBNode {
    public enum colors {RED, BLACK}

    public colors color = colors.RED;
    public int val;
    public RBNode left;
    public RBNode right;

    public RBNode(int val) {
        this.val = val;
    }

    public RBNode(colors color, int val) {
        this.color = color;
        this.val = val;
    }
}
