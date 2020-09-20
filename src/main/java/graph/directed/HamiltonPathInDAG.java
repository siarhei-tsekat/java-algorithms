package graph.directed;

public class HamiltonPathInDAG {

    boolean[] visited;

    public boolean exist(DGraph graph, int source) {

        visited = new boolean[graph.V()];
        int res[] = new int[1];

        dfs(graph, source, res);
        return res[0] == 1;
    }

    private void dfs(DGraph graph, int source, int res[]) {

        if (allNodesVisited(visited)) {
            res[0] = 1;
            return;
        }

        if (!visited[source]) {
            visited[source] = true;

            for (Integer adj : graph.adj(source)) {
                dfs(graph, adj, res);
                visited[adj] = false;
            }
        }
    }

    private boolean allNodesVisited(boolean[] visited) {
        for (boolean b : visited) if (!b) return false;
        return true;
    }
}

class Runner_ {
    public static void main(String[] args) {
        HamiltonPathInDAG dag = new HamiltonPathInDAG();
        System.out.println(dag.exist(getDag(5), 0));
    }

    private static DGraph getDag(int i) {
        DGraph dGraph = new DGraph(i);
        dGraph.addEdge(0,1);
        dGraph.addEdge(1,2);
//        dGraph.addEdge(1,5);
        dGraph.addEdge(2,3);
//        dGraph.addEdge(3,7);
        dGraph.addEdge(3,4);
        dGraph.addEdge(4,0);
//        dGraph.addEdge(0,6);
        return dGraph;
    }
}

