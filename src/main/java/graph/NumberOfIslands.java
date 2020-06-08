package graph;

public class NumberOfIslands {
    private static final char LAND = '1';
    private static final char WATER = '0';

    public static int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == LAND) {
                    f(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private static void f(char[][] grid, int x, int y) {
        if ((x < 0 || x > grid.length - 1) || (y < 0 || y > grid[x].length - 1)) {
            return;
        } else if (grid[x][y] == WATER) {
            return;
        } else {
            grid[x][y] = WATER;
            f(grid, x, y - 1);
            f(grid, x, y + 1);
            f(grid, x - 1, y);
            f(grid, x + 1, y);
        }
    }
}
