package graph.directed;

import graph.undirected.Graph;

import java.util.LinkedList;

public class ShortestDirectedCycle {

    public int find(DGraph graph, int source) {
        LinkedList<int[]> queue = new LinkedList<>();
        int[] dist = new int[graph.V()];
        int res = 100;
        boolean[] visited = new boolean[graph.V()];
        queue.add(new int[]{source, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (visited[current[0]] == false) {
                visited[current[0]] = true;

                for (Integer adj : graph.adj(current[0])) {
                    queue.add(new int[]{adj, current[1] + 1});
                }
            } else {
                res = Math.min(res, current[1]);
            }
        }
        return res;
    }
}

class Runner {
    public static void main(String[] args) {
        ShortestDirectedCycle cycle = new ShortestDirectedCycle();
        System.out.println(cycle.find(createGraph(), 0));
    }

    private static DGraph createGraph() {
        DGraph graph = new DGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 3);
        graph.addEdge(5, 0);
        graph.addEdge(2, 0);
        return graph;
    }
}

