package tree;

import java.util.LinkedList;
import java.util.Stack;

/***
 *      1
 *    2   3
 *  4  5    6
 */
public class AddingNextNode {
    public static void main(String[] args) {
        Node node = connect(generateNodes());
    }

    public static Node connect(Node node) {
        if (node == null) {
            return node;
        }
        Stack<LinkedList<Node>> toProcess = new Stack<>();

        toProcess.push(getStack(node));
        while (!toProcess.isEmpty()) {
            LinkedList<Node> currentLevel = toProcess.pop();

            LinkedList<Node> newLevelNodes = new LinkedList<>();

            while (!currentLevel.isEmpty()) {
                Node currentNode = currentLevel.poll();
                if (currentNode.right != null) {
                    newLevelNodes.add(currentNode.right);
                }
                if (currentNode.left != null) {
                    newLevelNodes.add(currentNode.left);
                }
            }
            if (!newLevelNodes.isEmpty()) {
                toProcess.push(newLevelNodes);
                addNextNodeTo(newLevelNodes);
            }
        }
        return node;
    }

    private static void addNextNodeTo(LinkedList<Node> visited) {
        for (int i = visited.size() - 1; i > 0; i--) {
            Node first = visited.get(i);
            first.next = visited.get(i -1);
        }
    }

    private static LinkedList<Node> getStack(Node node) {
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(node);
        return stack;
    }

    private static Node generateNodes() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;
        return node1;
    }
}

class Node {
    int val;
    Node left;
    Node right;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val + "";
    }
}
