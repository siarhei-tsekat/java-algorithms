package graph;

import java.util.*;

public class ScheduleTasks {
    public static void main(String[] args) {
        int[][] precendce = {{6, 1}, {5, 2}, {6, 3}, {3, 4}, {6, 4}, {3, 2}, {4, 2}, {6, 2}, {3, 5}, {4, 5}, {6, 5}};
        List<Integer> list = new Schedule().find(precendce);
        System.out.println(list);
    }
}

class Schedule {
    enum COLOR {WHITE, GRAY, BLACK}

    HashMap<Integer, List<Integer>> adjMap = new HashMap<>();
    HashMap<Integer, COLOR> colors = new HashMap<>();
    Stack<Integer> topologicalOrder = new Stack<>();
    boolean isPossible = true;

    public List<Integer> find(int[][] pre) {
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

        ArrayList<Integer> list = new ArrayList<>();
        while (!topologicalOrder.isEmpty()) list.add(topologicalOrder.pop());
        return list;
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
