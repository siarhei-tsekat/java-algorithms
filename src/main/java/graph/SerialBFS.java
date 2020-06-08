package graph;

import common.SerialGraph;
import common.SerialNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerialBFS {
    public static void main(String[] args) {
        SerialNode a = new SerialNode("A");
        SerialNode b = new SerialNode("B");
        SerialNode c = new SerialNode("C");
        SerialNode d = new SerialNode("D");
        SerialNode e = new SerialNode("E");
        a.addChild(b);
        a.addChild(c);
        a.addChild(d);
        d.addChild(e);
        SerialGraph serialGraph = new SerialGraph();
        serialGraph.addNode(Arrays.asList(a, b, c, d, e));
        bfs(serialGraph, new SerialNode("D"));
    }

    public static void bfs(SerialGraph graph, SerialNode start) {
        SerialNode root = graph.getNode(start);

        Queue<SerialNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            SerialNode current = queue.poll();
            for (SerialNode child : current.childs) {
                if (child.distance == 0) {
                    child.distance = current.distance + 1;
                    child.parent = current;
                    queue.add(child);
                }
            }
        }
    }
}


