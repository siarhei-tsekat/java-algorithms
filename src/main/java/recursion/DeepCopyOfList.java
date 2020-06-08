package recursion;

import java.util.HashMap;

public class DeepCopyOfList {

    static HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node1.random = node2;
        node2.random = node2;
        node2.next = node3;
        Node node = copyRandomList(node1);
        System.out.println(node == node1);
        System.out.println(node.next == node1.next);
        System.out.println(node.next.next == node1.next.next);
    }
    public static Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        if (visitedHash.containsKey(head)) {
            return visitedHash.get(head);
        }

        Node node = new Node(head.val, null, null);

        visitedHash.put(head, node);


        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
    @Override
    public String toString() {
        return val + "";
    }
}