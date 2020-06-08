package graph;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println(canFinish(3, new int[][]{{1, 0}}));
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }

    private static boolean isPossible = true;
    private static int WHITE = 1;
    private static int GRAY = 2;
    private static int BlACK = 3;
    private static Map<Integer, Integer> color = new HashMap<>();
    private static Map<Integer, List<Integer>> adjList = new HashMap<>();
    private static Stack<Integer> topologicalOrder = new Stack<>();


    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int dependency = prerequisites[i][1];
            color.put(course, WHITE);
            color.put(dependency, WHITE);

            List<Integer> list = adjList.getOrDefault(course, new ArrayList<>());
            list.add(dependency);
            adjList.put(course, list);
        }

        for (Map.Entry<Integer, Integer> pair : color.entrySet()) {
            Integer node = pair.getKey();
            Integer color = pair.getValue();
            if (color == WHITE) {
                dfs(node);
            }
        }
        if (!isPossible) {
            topologicalOrder.clear();
        }
        return topologicalOrder.size() > 0;
    }

    private static void dfs(int node) {
        if (!isPossible) {
            return;
        }
        color.put(node, GRAY);
        for (Integer neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (color.get(neighbor) == WHITE) {
                dfs(neighbor);
            } else if (color.get(neighbor) == GRAY) {
                isPossible = false;
            }
        }

        color.put(node, BlACK);
        topologicalOrder.add(node);
    }
}