package graph;

import common.GraphNode;
import common.Vertex;
import common.WeightedGraph;

import java.util.*;

public class FindShortestPathInWeightedGraph {
    public static void main(String[] args) {
        System.out.println(shortestPath(WeightedGraph.createWeightedGraphForShortestPath(), new GraphNode("A"), new GraphNode("F")));
    }

    public static List<GraphNode> shortestPath(WeightedGraph graph, GraphNode start, GraphNode target) {
        List<GraphNode> visited = new ArrayList<>();
        Queue<GraphNode> toProcess = new LinkedList<>();

        toProcess.add(graph.getNode(start));
        while (!toProcess.isEmpty()) {
            GraphNode node = toProcess.poll();
            if (!visited.contains(node)) {
                visited.add(node);

                for (Map.Entry<GraphNode,Integer> pair : node.getAdjacentNodes().entrySet()) {
                    GraphNode graphNode = pair.getKey();
                    Integer value = pair.getValue();

                    ArrayList<GraphNode> updatedShortestPath = new ArrayList<>(node.getShortestPath());
                    updatedShortestPath.add(node);
                    Integer updatedDistance = node.getDistance() + value;
                    graphNode.updateDistanceAndPath(updatedShortestPath, updatedDistance);
                    toProcess.add(graphNode);
                }
            }
        }
        return visited.stream().filter(gr->gr.getName().equals(target.getName())).findFirst().orElse(null).getShortestPath();
    }
}
