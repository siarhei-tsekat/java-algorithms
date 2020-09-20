package graph.MST;

import java.util.*;

public class BottleneckMinimumSpanningTree {
    public static void main(String[] args) {
        int[][] graph = {{1, 2, 3}, {1, 3, 4}, {2, 3, 2}, {2, 6, 1}, {3, 4, 1}, {3, 5, 1}, {6, 4, 8}, {4, 5, 8}, {7, 5, 3}, {4, 7, 3}, {6, 7, 2}};
        Solution solution = new Solution();
        List<int[]> mst = solution.findMST(7, graph);
        System.out.print("Sum: " + mst.stream().mapToInt((el) -> el[2]).sum());
        mst.forEach(el -> System.out.print(Arrays.toString(el)));

        List<List<int[]>> allmst = solution.findALLMST(7, graph);
        for (List<int[]> list : allmst) {
            System.out.println("------------");
            System.out.print("Sum: " + list.stream().mapToInt((el) -> el[2]).sum());
            list.forEach(el -> System.out.print(Arrays.toString(el)));
            System.out.println();
        }
    }
}

class Solution {

    public List<int[]> findMST(int n, int[][] edges) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((f, s) -> f[2] - s[2]);
        for (int i = 0; i < edges.length; i++) queue.add(edges[i]);
        DJS djs = new DJS(n);

        List<int[]> list = new ArrayList<>();
        while (!queue.isEmpty() && list.size() < n - 1) {
            int[] current = queue.poll();

            if (djs.connected(current)) continue;
            else {
                djs.unit(current);
                list.add(current);
            }
        }
        return list;
    }

    public List<List<int[]>> findALLMST(int n, int[][] edges) {
        HashMap<Integer, List<int[]>> adjMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            int time = edges[i][2];
            List<int[]> orDefault = adjMap.getOrDefault(from, new ArrayList<>());
            orDefault.add(edges[i]);
            adjMap.put(from, orDefault);
            List<int[]> orDefault2 = adjMap.getOrDefault(to, new ArrayList<>());
            orDefault2.add(new int[]{to, from, time});
            adjMap.put(to, orDefault2);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((f, s) -> f[2] - s[2]);
        boolean[] visited = new boolean[n + 1];
        List<List<int[]>> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            List<int[]> tmpres = new ArrayList<>();
            visit(i, visited, queue, adjMap);
            while (!queue.isEmpty()) {
                int[] currInfo = queue.poll();
                int v = currInfo[0];
                int w = currInfo[1];
                if (visited[v] && visited[w]) continue;
                queue.add(currInfo);
                tmpres.add(currInfo);
                if (!visited[w]) visit(w, visited, queue, adjMap);
                if (!visited[v]) visit(v, visited, queue, adjMap);
            }
            visited = new boolean[n + 1];
            if (!tmpres.isEmpty()) res.add(tmpres);
        }
        return res;
    }

    private void visit(int node, boolean[] visited, PriorityQueue<int[]> queue, HashMap<Integer, List<int[]>> adjMap) {
        visited[node] = true;
        for (int[] adjInfo : adjMap.get(node)) {
            if (!visited[adjInfo[1]])
                queue.add(adjInfo);
        }
    }
}

class DJS {
    int[] roots;

    public DJS(int n) {
        roots = new int[n + 1];
        for (int i = 0; i <= n; i++) roots[i] = i;
    }

    public boolean connected(int[] current) {
        return find(current[0]) == find(current[1]);
    }

    private int find(int value) {
        if (value == roots[value]) return value;
        else {
            roots[value] = roots[roots[value]];
            return find(roots[value]);
        }
    }

    public void unit(int[] current) {
        int i = find(current[0]);
        int j = find(current[1]);
        roots[j] = i;
    }
}