package interviewPreparation.graph.BFS;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Given a m * n grid, where each cell is either 0 (empty) or 1 (obstacle).
 * In one step, you can move up, down, left or right from and to an empty cell.
 *
 * Return the minimum number of steps to walk from the upper left corner (0, 0)
 * to the lower right corner (m-1, n-1) given that you can eliminate at most k obstacles.
 * If it is not possible to find such walk return -1.
 * */

public class ShortestPathGridWithObstaclesElimination {
    public static void main(String[] args) {
        System.out.println("6 => " + new Solution().shortestPath(new int[][]{{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}}, 1));
    }
}

class Solution {

    int dir[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestPath(int[][] grid, int k) {

        int[][] visit = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(visit[i], -1);
        }

        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visit[0][0] = 0;
        int tmp = 0;
        int res = 100;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {

                int curr[] = q.poll();

                if (curr[0] == grid.length - 1 && curr[1] == grid[0].length - 1) return tmp;


                for (int i = 0; i < dir.length; i++) {
                    int newR = curr[0] + dir[i][0];
                    int newC = curr[1] + dir[i][1];

                    if (outOfGrid(grid, newR, newC)) continue;

                    if ((visit[newR][newC] == -1 || visit[newR][newC] > visit[curr[0]][curr[1]] + grid[newR][newC]) && visit[curr[0]][curr[1]] + grid[newR][newC] <= k) {

                        visit[newR][newC] = visit[curr[0]][curr[1]] + grid[newR][newC];
                        q.add(new int[]{newR, newC});
                    }
                }
            }
            tmp++;
        }
        return res == 100 ? -1 : res;
    }

    public boolean outOfGrid(int[][] grid, int r, int c) {
        return r < 0 || r >= grid.length || c < 0 || c >= grid[r].length;
    }
}
