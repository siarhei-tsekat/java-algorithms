package tmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {

//        System.out.println(new tmp.Ford().findShortestPath(new int[][]{{1, 2, 3}, {2, 3, 2}, {0, 1, 2}, {3, 5, -5}, {0, 4, -1}, {4, 5, 2}}, 6, 0, 5));
//        System.out.println(new tmp.Ford()
//                .findCycle(new int[][]{{5, 2, -2}, {0, 1, 2}, {1, 2, -3}, {2, 3, 2}, {3, 5, -5}, {0, 4, -1}, {4, 5, 2}}, 6, 0));

        List<List<Integer>> list = new Ford().findAO(new double[][]{
                {0, 1, 0.741}, {0, 2, 0.657}, {0, 3, 1.061}, {0, 4, 1.011},
                {1, 0, 1.350}, {1, 2, 0.888}, {1, 3, 1.433}, {1, 4, 1.366},
                {2, 0, 1.521}, {2, 1, 1.126}, {2, 3, 1.614}, {2, 4, 1.538},
                {3, 0, 0.943}, {3, 1, 0.698}, {3, 2, 0.620}, {3, 4, 0.953},
                {4, 0, 0.995}, {4, 1, 0.732}, {4, 2, 0.650}, {4, 3, 1.049}}, 5);

        System.out.println(list);

    }
}

class Ford {

    public List<List<Integer>> findAO(double[][] edges, int n) {
        List<List<Integer>> res = new ArrayList<>();

        for (double[] edge : edges) {
            edge[2] = -1 * Math.log(edge[2]);
        }


        double[] distTo = new double[n];
        int[] prev = new int[n];
        Arrays.fill(distTo, 100.0);
        Arrays.fill(prev, -1);
        distTo[0] = 0;

        for (int i = 1; i < n - 1; i++) {
            for (double[] edge : edges) {
                int from = (int) edge[0];
                int to = (int) edge[1];
                double time = edge[2];

                if (distTo[to] > distTo[from] + time) {
                    distTo[to] = distTo[from] + time;
                    prev[to] = from;
                }
            }
        }


        for (double[] edge : edges) {
            int from = (int) edge[0];
            int to = (int) edge[1];
            double time = edge[2];

            if (distTo[to] > distTo[from] + time) {
                boolean [] visited = new boolean[n];
                List<Integer> list = new ArrayList<>();
                while (from != to && from != -1 && !visited[from]) {
                    visited[from] = true;
                    list.add(from);
                    from = prev[from];
                }
                list.add(from);
                res.add(new ArrayList<>(list));
                break;
            }
        }

        return res;
    }

    public List<Integer> findShortestPath(int[][] edges, int n, int source, int target) {
        int[] distTo = new int[n];
        int[] prev = new int[n];

        Arrays.fill(distTo, 100);

        distTo[source] = 0;

        for (int i = 1; i < n - 1; i++) {
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                int time = edge[2];

                if (distTo[to] > distTo[from] + time) {
                    distTo[to] = distTo[from] + time;
                    prev[to] = from;
                }
            }
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int time = edge[2];

            if (distTo[to] > distTo[from] + time)
                return Collections.emptyList();
        }

        List<Integer> list = new ArrayList<>();
        while (prev[target] != source) {
            list.add(target);
            target = prev[target];
        }
        list.add(target);
        list.add(source);
        return list;
    }

    public List<Integer> findCycle(int[][] edges, int n, int source) {
        int[] distTo = new int[n];
        int[] prev = new int[n];

        Arrays.fill(distTo, 100);

        distTo[source] = 0;

        for (int i = 1; i < n - 1; i++) {
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                int time = edge[2];

                if (distTo[to] > distTo[from] + time) {
                    distTo[to] = distTo[from] + time;
                    prev[to] = from;
                }
            }
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int time = edge[2];

            if (distTo[to] > distTo[from] + time) {
                List<Integer> list = new ArrayList<>();
                while (from != to) {
                    list.add(from);
                    from = prev[from];
                }
                list.add(from);
                return list;
            }
        }

        return null;
    }
}
