package graph.undirected;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class TreeDiameterBFS {

    public static void main(String[] args) {
        int[][] var = {{0, 1}, {0, 2}};
        treeDiameter(var);
    }

    public static int treeDiameter(int[][] edges) {
        ArrayList<Integer>[] adjList = (ArrayList<Integer>[]) new ArrayList[10000];
        for (int i = 0; i < adjList.length; i++) adjList[i] = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }


        int[] tmp = new int[2];

        findTheLongestPath(adjList, 0, tmp, new boolean[10000]);
        findTheLongestPath(adjList, tmp[0], tmp, new boolean[10000]);

        return tmp[1];
    }

    private static void findTheLongestPath(ArrayList<Integer>[] adjList, Integer vertex, int[] tmp, boolean[] visited) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{vertex, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (tmp[1] < current[1]) {
                tmp[1] = current[1];
                tmp[0] = current[0];
            }
            if (!visited[current[0]]) {
                visited[current[0]] = true;
                for (Integer adj : adjList[current[0]]) {
                    queue.add(new int[]{adj, current[1] + 1});
                }
            }
        }
    }
}
