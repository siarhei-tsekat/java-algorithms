package recursion;

import java.util.HashMap;

public class CopyRandomList {
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

    static HashMap<Node, Node> map = new HashMap<>();

    public static Node copyRandomList(Node node) {
        if (node != null) {
            if (map.containsKey(node)) {
                return map.get(node);
            }
            Node node1 = new Node(node.val);
            map.put(node, node1);

            node1.next = copyRandomList(node.next);
            node1.random = copyRandomList(node.random);
            return node1;
        }
        return null;
    }
}

