package graph;

import java.util.LinkedList;

public class ShortestPathinBinaryMatrix {
    public static void main(String[] args) {
        System.out.println(new Solution__().shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
        System.out.println(new Solution__().shortestPathBinaryMatrix(new int[][]{{0, 1}, {1, 0}}));
    }
}

class Solution__ {
    int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    boolean visited[][];

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 || grid[grid.length-1][grid.length-1] == 1) return -1;
        visited = new boolean[grid.length][grid.length];
        return f(grid, 0, 0);
    }

    private int f(int[][] grid, int row, int col) {
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int roww = poll[0];
            int coll = poll[1];

            if (roww == grid.length - 1 && coll == grid.length - 1) {
                return poll[2] + 1;
            }

            for (int i = 0; i < dir.length; i++) {
                int newR = roww + dir[i][0];
                int newC = coll + dir[i][1];
                if (outOfGrid(newR, newC, grid)) continue;
                visited[newR][newC] = true;
                q.add(new int[]{newR, newC, poll[2] + 1});
            }
        }
        return -1;
    }

    private boolean outOfGrid(int roww, int coll, int[][] grid) {
        return roww < 0 || roww >= grid.length || coll < 0 || coll >= grid.length || grid[roww][coll] == 1 || visited[roww][coll] ==true;
    }

}

