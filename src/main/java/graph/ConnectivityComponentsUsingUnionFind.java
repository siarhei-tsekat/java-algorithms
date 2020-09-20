package graph;

class _Runner {
    public static void main(String[] args) {
        ConnectivityComponentsUsingUnionFind solution = new ConnectivityComponentsUsingUnionFind();
//        int[][] edges = {{1, 0}, {2, 6}, {1, 7}, {6, 4}, {7, 0}, {0, 5}};
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println("2 => " + solution.countComponents(5, edges));
    }
}

public class ConnectivityComponentsUsingUnionFind {
    int[] parents;

    public int countComponents(int n, int[][] edges) {
        if (n == 0) return 0;
        if (edges.length == 0) return n;
        parents = new int[n];
        int res = 0;

        for (int i = 0; i < n; i++) parents[i] = i;

        for (int i = 0; i < edges.length; i++) union(edges[i][0], edges[i][1]);

        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == i) res++;
        }

        return res;
    }

    private void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        parents[i] = j;
    }

    private int find(int value) {
        if (parents[value] == value) return value;
        else {
            parents[value] = parents[parents[value]];
            return find(parents[value]);
        }
    }
}
