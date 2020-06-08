package graph;

import java.util.*;

public class CourseScheduleTwo {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
    }
    static int WHITE = 1;
    static int GREY = 2;
    static int BLACK = 3;
    static boolean isPossible;
    static Map<Integer, Integer> color;
    static Map<Integer, List<Integer>> adjList;
    static List<Integer> topologicalOrder;

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        init(numCourses);

        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<>());
            lst.add(dest);
            adjList.put(src, lst);
        }

        for (int i = 0; i < numCourses; i++) {
            if (color.get(i) == WHITE) {
                dfs(i);
            }
        }

        int[] order;
        if (isPossible) {
            order = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                order[i] = topologicalOrder.get(numCourses - i - 1);
            }
        } else {
            order = new int[0];
        }
        return order;
    }

    private static void init(int numCourses) {
        isPossible = true;
        color = new HashMap<>();
        adjList = new HashMap<>();
        topologicalOrder = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            color.put(i, WHITE);
        }
    }

    private static void dfs(int node) {
        if (!isPossible) {
            return;
        }
        color.put(node, GREY);

        for (Integer neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (color.get(neighbor) == WHITE) {
                dfs(neighbor);
            } else if (color.get(neighbor) == GREY) {
                isPossible = false;
            }
        }

        color.put(node, BLACK);
        topologicalOrder.add(node);
    }
}
