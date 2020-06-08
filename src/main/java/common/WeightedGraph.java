package common;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {

    private List<GraphNode> nodes = new ArrayList<>();

    public void addNode(GraphNode nodeA) {
        nodes.add(nodeA);
    }

    public GraphNode getNode(GraphNode start) {
        return nodes.stream().filter(n->n.getName().equals(start.getName())).findFirst().orElse(null);
    }

    public static WeightedGraph createWeightedGraphForShortestPath() {
        GraphNode nodeA = new GraphNode("A");
        GraphNode nodeB = new GraphNode("B");
        GraphNode nodeC = new GraphNode("C");
        GraphNode nodeD = new GraphNode("D");
        GraphNode nodeE = new GraphNode("E");
        GraphNode nodeF = new GraphNode("F");
        GraphNode nodeX = new GraphNode("X");

        nodeA.addDestination(nodeB, 5);
        nodeA.addDestination(nodeD, 10);
        nodeA.addDestination(nodeX, 3);

        nodeB.addDestination(nodeC, 2);
        nodeB.addDestination(nodeD, 40);

        nodeC.addDestination(nodeF, 1);

        nodeD.addDestination(nodeF, 40);
        nodeD.addDestination(nodeE, 10);

        nodeE.addDestination(nodeF, 1);

        nodeX.addDestination(nodeD, 15);
        nodeX.addDestination(nodeE, 40);

        WeightedGraph graph = new WeightedGraph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        graph.addNode(nodeX);
        return graph;
    }
}