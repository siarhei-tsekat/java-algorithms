package graph.undirected;

import java.util.Stack;

public class DFS {

    public void traverse(Graph graph, int source) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.V()];

        stack.add(source);
        visited[source] = true;

        while (!stack.isEmpty()) {
            Integer current = stack.pop();

            for (Integer adj : graph.adj(current)) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    stack.add(adj);
                }
            }
        }
    }
}
