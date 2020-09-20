package graph.MST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KruskalAlgorithm {
    public static void main(String[] args) {
        Solution__ solution = new Solution__();
        int[][] edges = {{0, 1, 1}, {1, 2, 1}, {2, 3, 2}, {0, 3, 2}, {0, 4, 3}, {3, 4, 3}, {1, 4, 6}};
        System.out.println("[0, 1, 1][1, 2, 1][0, 3, 2][3, 4, 3]");
        solution.findCriticalAndPseudoCriticalEdges(5, edges).forEach(el -> System.out.print(Arrays.toString(el)));
    }
}

class Solution__ {
    public ArrayList<int[]> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((f, s) -> f[2] - s[2]);

        for (int i = 0; i < edges.length; i++) queue.add(edges[i]);

        DJS_ djs = new DJS_(n);
        ArrayList<int[]> graph = new ArrayList<>();

        while (!queue.isEmpty() && graph.size() < n - 1) {
            int[] current = queue.poll();
            if (!djs.connected(current)) {
                djs.unit(current);
                graph.add(current);
            }
        }

        return graph;
    }
}

class DJS_ {
    int[] parents;

    public DJS_(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = i;
    }

    private int find(int value, int[] parents) {
        if (value == parents[value]) return value;
        else {
            parents[value] = parents[parents[value]];
            return find(parents[value], parents);
        }
    }

    public boolean connected(int[] current) {
        return find(current[0], parents) == find(current[1], parents);
    }

    public void unit(int[] current) {
        int i = find(current[0], parents);
        int j = find(current[1], parents);
        parents[i] = j;
    }
}
