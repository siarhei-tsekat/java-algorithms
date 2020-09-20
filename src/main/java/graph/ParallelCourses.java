package graph;

import java.util.*;

public class ParallelCourses {
    public static void main(String[] args) {
        System.out.println("2 => " + new ___Solution().minimumSemesters(3, new int[][]{{1, 3}, {2, 3}}));
        System.out.println("-1 => " + new ___Solution().minimumSemesters(3, new int[][]{{1, 2}, {2, 3}, {3, 1}}));
    }
}

class ___Solution {
    enum COLOR {WHITE, GRAY, BLACK}

    HashMap<Integer, List<Integer>> adjMap = new HashMap<>();
    HashMap<Integer, COLOR> colors = new HashMap<>();
    Stack<Integer> topologicalOrder = new Stack<>();
    boolean isPossible = true;
    int[] distTo = new int[1000];
    boolean[] visited = new boolean[1000];

    public int minimumSemesters(int n, int[][] pre) {

        for (int i = 0; i < pre.length; i++) {
            int from = pre[i][0];
            int to = pre[i][1];
            adjMap.putIfAbsent(from, new ArrayList<>());
            adjMap.get(from).add(to);

            colors.put(from, COLOR.WHITE);
            colors.put(to, COLOR.WHITE);
        }

        for (Map.Entry<Integer, COLOR> entry : colors.entrySet()) {
            Integer node = entry.getKey();
            if (colors.get(node) == COLOR.WHITE) {
                dfs(node);
            }
        }

        if (!isPossible) return -1;

        LinkedList<Integer> q = new LinkedList<>();
        Integer pop = topologicalOrder.pop();
        q.add(100);

        adjMap.put(100, new ArrayList<>(Arrays.asList(pop)));
        adjMap.put(topologicalOrder.firstElement(), new ArrayList<>(Arrays.asList(200)));

        Arrays.fill(distTo, Integer.MIN_VALUE);
        distTo[100] = 0;

        while (!q.isEmpty()) {
            Integer node = q.pop();

            for (Integer adjNode : adjMap.getOrDefault(node, new ArrayList<>())) {
                if (distTo[adjNode] < distTo[node] + 1)
                    distTo[adjNode] = distTo[node] + 1;
                q.add(adjNode);
            }
        }

        return distTo[200] -1;
    }

    private void dfs(Integer node) {
        colors.put(node, COLOR.GRAY);

        for (Integer adj : adjMap.getOrDefault(node, new ArrayList<>())) {
            if (colors.get(adj) == COLOR.WHITE) {
                dfs(adj);
            } else if (colors.get(adj) == COLOR.GRAY) isPossible = false;
        }

        topologicalOrder.add(node);
        colors.put(node, COLOR.BLACK);
    }
}
