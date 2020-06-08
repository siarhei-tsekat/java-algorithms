package graph;

import common.Graph;
import common.Vertex;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        Graph graph = Graph.createGraph();
        System.out.println(dfs(graph,"Bob"));
    }

    public static Set<String> dfs(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Stack<String> toProcess = new Stack<>();
        toProcess.push(root);
        while (!toProcess.isEmpty()) {
            String vertex = toProcess.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex adjVertex : graph.getAdjVertices(vertex)) {
                    toProcess.push(adjVertex.label);
                }
            }
        }
        return visited;
    }
}
