package graph.undirected;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TreeDiameterDFS {
    public int treeDiameter(int[][] edges) {
        ArrayList<Integer>[] adjList = (ArrayList<Integer>[]) new ArrayList[10000];
        for (int i = 0; i < adjList.length; i++) adjList[i] = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }

        int[] tmp = new int[2];
        findTheLongestPath(adjList, 0, new int[1], tmp, new boolean[10000]);
        findTheLongestPath(adjList, tmp[1], new int[1], tmp, new boolean[10000]);

        return tmp[0];
    }

    private void findTheLongestPath(ArrayList<Integer>[] adjList, Integer vertex, int[] dist, int[] tmp, boolean[] visited) {
        if (tmp[0] < dist[0]) {
            tmp[0] = dist[0];
            tmp[1] = vertex;
        }
        if (!visited[vertex]) {
            visited[vertex] = true;
            for (Integer adj : adjList[vertex]) {
                dist[0]++;
                findTheLongestPath(adjList, adj, dist, tmp, visited);
                dist[0]--;
            }
        }
    }
}
