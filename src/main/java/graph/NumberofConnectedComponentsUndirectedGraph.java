package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberofConnectedComponentsUndirectedGraph {
    public static void main(String[] args) {

        System.out.println(countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}}));
        System.out.println(countComponents(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}));
        System.out.println(countComponents(3, new int[][]{{1, 0}, {2, 0}}));
    }


    private static int res;
    private static final Integer BLACK = 1;
    private static final Integer WHITE = 0;
    private static Map<Integer, Integer> color = new HashMap<>();
    static Map<Integer, List<Integer>> adjMap = new HashMap<>();

    public static int countComponents(int n, int[][] edges) {
        res = 0;
        color = new HashMap<>();
        adjMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int firstV = edges[i][0];
            int secondV = edges[i][1];

            List<Integer> list = adjMap.getOrDefault(firstV, new ArrayList<>());
            list.add(secondV);
            adjMap.put(firstV, list);

            List<Integer> list2 = adjMap.getOrDefault(secondV, new ArrayList<>());
            list2.add(firstV);
            adjMap.put(secondV, list2);
            color.put(firstV, WHITE);
            color.put(secondV, WHITE);
        }

        for (Map.Entry<Integer, List<Integer>> entry : adjMap.entrySet()) {
            Integer node = entry.getKey();
            if (color.get(node).equals(WHITE)) {
                res++;
                define(node);
            }
        }

        return res + (n - color.size());
    }

    private static void define(Integer node) {
        if (color.get(node).equals(WHITE)) {
            color.put(node, BLACK);
            for (Integer adj : adjMap.getOrDefault(node, new ArrayList<>())) {
                define(adj);
            }
        }
    }
}
