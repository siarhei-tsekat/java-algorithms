package graph;

class Runner {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        ConnectivityComponentsUsingDFS connectivityComponents = new ConnectivityComponentsUsingDFS();
        System.out.println("2 => " + connectivityComponents.countComponents(5, edges));
    }
}

public class ConnectivityComponentsUsingDFS {

    boolean[] visited = null;
    int[][] adjMatrix = null;

    public int countComponents(int n, int[][] edges) {
        visited = new boolean[n];
        adjMatrix = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            adjMatrix[edges[i][0]][edges[i][1]] = 1;
            adjMatrix[edges[i][1]][edges[i][0]] = 1;
        }

        int tmp = 0;
        int nodes = 0;
        for (int i = 0; i < edges.length; i++) {
            int res[] = new int[1];
            dfs(edges[i][0], res);
            if (res[0] != 0) {
                tmp++;
                nodes+=res[0];
            }
        }

        return nodes == n ? tmp :tmp + (nodes - n);
    }

    private void dfs(int node, int res[]) {
        if (!visited[node]) {
            res[0]++;
            visited[node] = true;

            for (int j = 0; j < adjMatrix[node].length; j++) {
                if (adjMatrix[node][j] != 0) {
                    dfs(j, res);
                }
            }
        }
    }
}
