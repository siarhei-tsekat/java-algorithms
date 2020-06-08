package graph;

import common.Graph;
import common.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindShortestParh {
    public static void main(String[] args) {
        System.out.println(shortestPath(Graph.createGraphForShortestPath(), "A", "F"));
    }

    public static List<Vertex> shortestPath(Graph graph, String start, String target) {
        List<Vertex> visited = new ArrayList<>();
        Queue<Vertex> toProcess = new LinkedList<>();

        toProcess.add(graph.getVertex(start));
        while (!toProcess.isEmpty()) {
            Vertex vertex = toProcess.poll();
            if (!visited.contains(vertex)) {
                visited.add(vertex);

                for (Vertex adjVertex : graph.getAdjVertices(vertex.label)) {
                    ArrayList<Vertex> shortestPath = new ArrayList<>(vertex.getShortestPath());
                    shortestPath.add(vertex);
                    adjVertex.addShortestPath(shortestPath);
                    toProcess.add(adjVertex);
                }
            }
        }
        return visited.stream().filter(v->v.label.equals(target)).findFirst().orElse(null).getShortestPath();
    }
}
