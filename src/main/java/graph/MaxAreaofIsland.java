package graph;

public class MaxAreaofIsland {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println("6 => " + new Solution___().maxAreaOfIsland(grid));

    }
}

class Solution___ {
    int res = 0;
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !visited(i, j, grid)) {
                    res = Math.max(res, f(i, j, grid)+1);
                }
            }
        }

        return res;
    }

    private int f(int row, int col, int[][] grid) {

        for (int i = 0; i < dir.length; i++) {
            int newR = row + dir[i][0];
            int newC = col + dir[i][1];

            if (outOfGrid(newR, newC, grid) || visited(newR, newC, grid) || notAnIsland(newR, newC, grid))
                continue;

            grid[newR][newC]= grid[row][col]+1;
            return f(newR, newC, grid);
        }
        return grid[row][col];
    }

    private boolean notAnIsland(int row, int col, int[][] grid) {
        return grid[row][col] == 0;
    }

    private boolean visited(int row, int col, int[][] grid) {
        return grid[row][col] >= 2;
    }

    private boolean outOfGrid(int row, int col, int[][] grid) {
        return row < 0 || row >= grid.length || col < 0 || col >= grid[row].length;
    }
}
