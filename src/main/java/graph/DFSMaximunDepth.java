package graph;

import common.Graph;
import common.Node;
import common.Vertex;

import java.util.*;

public class DFSMaximunDepth {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        int max = 0;
        List<Node> firstLevel = new ArrayList<>();
        Set<Integer> visited = new LinkedHashSet<>();
        Deque<Node> toProcess = new LinkedList<>();
        toProcess.push(root);
        firstLevel.addAll(root.children);
        while (!toProcess.isEmpty()) {
            Node node = toProcess.pop();

            result++;

            if (!visited.contains(node)) {
                if (node.children.isEmpty()) {
                    max = result > max ? result : max;
                    if (firstLevel.contains(toProcess.peekFirst())){
                        result = 2;
                    }
                } else {
                    for (Node child : node.children) {
                        toProcess.push(child);
                    }
                }
            }

        }
        return max;
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
