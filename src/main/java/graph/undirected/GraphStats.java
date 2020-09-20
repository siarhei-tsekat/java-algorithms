package graph.undirected;

import java.util.Iterator;

public class GraphStats {
    public static int degree(Graph graph, int v) {
        int res = 0;
        while (graph.adj(v).iterator().hasNext()) res++;
        return res;
    }

    public static int maxDegree(Graph graph) {
        int res = 0;
        for (int i = 0; i < graph.V(); i++) {
            res = Math.max(degree(graph, i), res);
        }
        return res;
    }

    public static double averageDegree(Graph graph) {
        return 2.0 * graph.E() / graph.V();
    }

    public static int numberOfSelfLoops(Graph graph) {
        int res = 0;
        for (int i = 0; i < graph.V(); i++) {
            for (Integer integer : graph.adj(i)) {
                if (i == integer) res++;
            }
        }
        return res/2;
    }
}
