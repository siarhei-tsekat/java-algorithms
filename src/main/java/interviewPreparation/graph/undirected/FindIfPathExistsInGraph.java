package interviewPreparation.graph.undirected;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive).
 * The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a
 * bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
 * You want to determine if there is a valid path that exists from vertex source to vertex destination.
 * Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
 */

public class FindIfPathExistsInGraph {
    public static void main(String[] args) {
        System.out.println("true => " + new FindIfPathExistsInGraph_Solution().validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2));
        System.out.println("false => " + new FindIfPathExistsInGraph_Solution().validPath(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5));
    }
}

class FindIfPathExistsInGraph_Solution {

    public boolean validPath(int n, int[][] edges, int src, int target) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];

            map.putIfAbsent(from, new ArrayList<>());
            map.putIfAbsent(to, new ArrayList<>());

            map.get(from).add(to);
            map.get(to).add(from);
        }

        int[] visited = new int[n];

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (queue.isEmpty() == false) {

            Integer curr = queue.poll();

            if (curr == target) {
                return true;
            }

            for (Integer adj : map.getOrDefault(curr, new ArrayList<>())) {
                if (visited[adj] == 1) {
                    continue;
                }
                visited[adj] = 1;
                queue.add(adj);
            }
        }

        return false;
    }
}
