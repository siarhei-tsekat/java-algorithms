package array;

import java.util.*;

public class App {
    public static void main(String[] args) {
        int[] order = new Solutionm().findOrder(2, new int[][]{{1, 0}});
        System.out.println(Arrays.toString(order));
    }
}

class Solutionm {

    List<Integer> list = new LinkedList<>();
    Boolean cycle = false;

    public int[] findOrder(int n, int[][] pre) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < pre.length; i++) {
            map.putIfAbsent(pre[i][1], new ArrayList<>());
            map.get(pre[i][1]).add(pre[i][0]);
        }

        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                list.clear();
                dfs(map, i, visited);
            }
        }

        if (cycle) return new int[0];
        int[] res = new int[list.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public void dfs(Map<Integer, List<Integer>> map, int v, int[] visited) {
        if (visited[v] == 0) {
            visited[v] = 2;

            for (Integer adj : map.getOrDefault(v, new ArrayList<>())) {
                if (visited[adj] == 0) {
                    dfs(map, adj, visited);
                } else if (visited[v] == 2) {
                    cycle = true;
                    return;
                }
            }
            visited[v] = 1;
            list.add(v);
        }
    }
}
