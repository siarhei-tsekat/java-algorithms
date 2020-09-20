package tmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Run {
    public static void main(String[] args) {
//        System.out.println(new tmp.Solution().findSP(new int[][]{{0, 1, -1}, {1, 2, -3}, {0, 2, 3}, {4, 2, 2}, {0, 4, -10}}, 0, 2));
//        System.out.println(new tmp.Solution().findSP(new int[][]{{0, 1, -1}, {1, 2, -3}, {0, 2, 3}, {2, 4, 2}, {4, 0, -1}}, 0, 2));
//        System.out.println(new tmp.Solution().findSP(new int[][]{{0, 1, -1}, {1, 2, -3}, {0, 2, 3}}, 0, 2));


        List<Integer> list = new ArbitrageOpportunity().find(new double[][][]{
                {{0, 1, 0.741}, {0, 2, 0.657}, {0, 3, 1.061}, {0, 4, 1.011}},
                {{1, 0, 1.350}, {1, 2, 0.888}, {1, 3, 1.433}, {1, 4, 1.366}},
                {{2, 0, 1.521}, {2, 1, 1.126}, {2, 3, 1.614}, {2, 4, 1.538}},
                {{3, 0, 0.943}, {3, 1, 0.698}, {3, 2, 0.620}, {3, 4, 0.953}},
                {{4, 0, 0.995}, {4, 1, 0.732}, {4, 2, 0.650}, {4, 3, 1.049}}}, 0);
        System.out.println(list);
    }
}

public class Solution {
    int distTo[] = new int[100];
    int bestTimeToGet[] = new int[100];

    public List<Integer> findSP(int[][] grid, int source, int target) {
        Arrays.fill(distTo, 100);
        Arrays.fill(bestTimeToGet, 100);

        distTo[source] = 0;
        bestTimeToGet[source] = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < grid.length; j++) {

                int from = grid[j][0];
                int to = grid[j][1];
                int time = grid[j][2];

                if (bestTimeToGet[to] > bestTimeToGet[from] + time) {
                    bestTimeToGet[to] = bestTimeToGet[from] + time;
                    distTo[to] = from;
                }
            }
        }

        for (int j = 0; j < grid.length; j++) {

            int from = grid[j][0];
            int to = grid[j][1];
            int time = grid[j][2];

            if (bestTimeToGet[to] > bestTimeToGet[from] + time) {
                List<Integer> res = new ArrayList<>();
                boolean visited[] = new boolean[15];

                while (!visited[to]) {
                    visited[to] = true;
                    res.add(distTo[to]);
                    to = distTo[to];
                }
                return res;
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(source);
        while (distTo[target] != source) {
            list.add(distTo[target]);
            target = distTo[target];
        }

        return list;
    }
}

class ArbitrageOpportunity {
    static class V {
        int USD = 0, EUR = 1, GBP = 2, GHF = 3, CAD = 4;
    }

    int prevVert[] = new int[100];
    double bestTimeToGet[] = new double[100];

    public List<Integer> find(double[][][] grid, int source) {
        Arrays.fill(bestTimeToGet, 100);
        LinkedList<double[]> list = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j][2] = -1 * Math.log(grid[i][j][2]);
            }
        }

        bestTimeToGet[source] = 0;

        for (int i = source; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                list.add(grid[i][j]);
            }
        }

        for (int i = 0; i < source; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                list.add(grid[i][j]);
            }
        }

        for (int j = 1; j < 5 - 1; j++) {
            for (double[] edge : list) {

                int from = (int) edge[0];
                int to = (int) edge[1];
                double time = edge[2];

                if (bestTimeToGet[to] > bestTimeToGet[from] + time) {
                    bestTimeToGet[to] = bestTimeToGet[from] + time;
                    prevVert[to] = from;
                }
            }
        }


        List<Integer> res = new ArrayList<>();

        for (double[] edge : list) {

            int from = (int) edge[0];
            int to = (int) edge[1];
            double time = edge[2];

            if (bestTimeToGet[to] > bestTimeToGet[from] + time) {
                boolean [] visited = new boolean[list.size()];
                while (from != to && !visited[from]) {
                    visited[from] = true;
                    res.add(from);
                    from = prevVert[from];
                }
                res.add(to);
                return res;
            }
        }

        return res;
    }
}
