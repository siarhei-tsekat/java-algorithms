package interviewPreparation.graph;

import java.util.*;

public class ShortestPathInWeightedGraph {
    public static void main(String[] args) {
        int[][] conn = {{1, 2, 8}, {1, 3, 20}, {2, 4, 2}, {2, 7, 2}, {2, 6, 30}, {7, 6, 1}, {3, 4, 4}, {3, 9, 10}, {4, 8, 10}, {9, 8, 1}, {6, 10, 10}, {8, 10, 1}};
        List<Integer> path = new n().find(conn, 1, 10);
        System.out.println(path);
    }
}

class n {
    public List<Integer> find(int[][] grid, int start, int target) {

        List[] pathTo = new ArrayList[100];

        for (int i = 0; i < 100; i++) {
            pathTo[i] = new ArrayList();
        }
        int[] distTo = new int[100];
        Arrays.fill(distTo, 100);

        HashMap<Integer, List<int[]>> map = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            int from = grid[i][0];
            int to = grid[i][1];
            int length = grid[i][2];

            map.putIfAbsent(from, new ArrayList<>());
            map.get(from).add(new int[]{to, length});
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((f, s) -> f[1] - s[1]);
        q.add(new int[]{start, 0});
        distTo[start] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currNode = curr[0];
            int edge = curr[1];

            if (currNode == target) return pathTo[target];

            for (int[] info : map.getOrDefault(currNode, new ArrayList<>())) {
                if (distTo[info[0]] > distTo[currNode] + edge) {
                    distTo[info[0]] = distTo[currNode] + edge;
                    q.add(new int[]{info[0], info[1]});
                    List path = new ArrayList(pathTo[currNode]);
                    path.add(currNode);
                    pathTo[info[0]] = path;
                }
            }
        }
        return pathTo[target];
    }
}
