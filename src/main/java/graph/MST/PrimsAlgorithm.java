package graph.MST;

import java.util.*;

import static java.util.Arrays.asList;
import static java.util.Collections.*;

public class PrimsAlgorithm {
    public static void main(String[] args) {
        Solution_ solution = new Solution_();
        int[][] edges = {{0, 1, 1}, {1, 2, 1}, {2, 3, 2}, {0, 3, 2}, {0, 4, 3}, {3, 4, 3}, {1, 4, 6}};
        System.out.println("Expected:  [0, 1, 1][1, 2, 1][0, 3, 2][3, 4, 3]");
        solution.find(5, edges).forEach(el->System.out.print(Arrays.toString(el)));
    }
}

class Solution_ {
    HashMap<Integer, List<int[]>> adjMap = new HashMap<>();
    PriorityQueue<int[]> queue = new PriorityQueue<>((f, s) -> f[2] - s[2]);
    boolean[] visited;

    public List<int[]> find(int n, int[][] edges) {
        visited = new boolean[n];
        for (int i = 0; i < edges.length; i++) {
            int [] info = edges[i];
            int from = edges[i][0];
            int to = edges[i][1];
            int time = edges[i][2];
            adjMap
                    .merge(from, new ArrayList<>(singletonList(info)), (newL, oldL) -> { newL.add(info); return newL;});
        }

        visit(0);
        List<int []> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if(visited[current[0]] && visited[current[1]]) continue;
            list.add(current);
            if(!visited[current[0]]) visit(current[0]);
            if(!visited[current[1]]) visit(current[1]);
        }
        return list;
    }

    private void visit(int node) {
        visited[node] = true;

        for (int[] info : adjMap.getOrDefault(node, new ArrayList<>())) queue.add(info);

    }
}

