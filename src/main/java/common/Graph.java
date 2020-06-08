package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<Vertex, List<Vertex>> map = new HashMap<>();

    public void addVertex(String label) {
        map.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public Vertex getVertex(String target) {
        for (Vertex vertex1 : map.keySet()) {
            if (vertex1.label.equals(target)) {
                return vertex1;
            }
        }
        return null;
    }

    public void removeVertex(String label) {
        Vertex v = new Vertex(label);
        map.values().forEach(e -> e.remove(v));
        map.remove(new Vertex(label));
    }

    public void addEdge(String label1, String label2, int distance) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        map.get(v1).add(v2);
        map.get(v2).add(v1);
    }

    public void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = map.get(v1);
        List<Vertex> eV2 = map.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    public List<Vertex> getAdjVertices(String label) {
        return map.get(new Vertex(label));
    }

    public static Graph createGraphForShortestPath() {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("F");
        graph.addVertex("E");
        graph.addVertex("X");

        graph.addEdge("A", "B", 40);
        graph.addEdge("A", "D", 40);
        graph.addEdge("A", "X", 40);

        graph.addEdge("B", "C", 40);
        graph.addEdge("B", "D", 40);

        graph.addEdge("C", "F", 40);

        graph.addEdge("D", "F", 40);
        graph.addEdge("D", "E", 40);

        graph.addEdge("X", "D", 40);
        graph.addEdge("X", "E", 40);

        graph.addEdge("E", "F", 40);
        return graph;
    }

    public static Graph createGraph() {
        Graph graph = new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice", 40);
        graph.addEdge("Bob", "Rob", 40);
        graph.addEdge("Alice", "Mark", 40);
        graph.addEdge("Rob", "Mark", 40);
        graph.addEdge("Alice", "Maria", 40);
        graph.addEdge("Rob", "Maria", 40);
        return graph;
    }
}


