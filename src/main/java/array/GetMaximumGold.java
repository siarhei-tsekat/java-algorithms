package array;

public class GetMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    res = Math.max(res, func(grid, i, j));
                }
            }
        }
        return res;
    }

    private int func(int[][] grid, int row, int col) {
        if (row < 0 || row <= grid.length || col < 0 || col <= grid[row].length) return 0;

        int currValue = grid[row][col];
        grid[row][col] = 0;
        int max = 0;
        max = Math.max(max, max + func(grid, row - 1, col));
        max = Math.max(max, max + func(grid, row, col + 1));
        max = Math.max(max, max + func(grid, row + 1, col));
        max = Math.max(max, max + func(grid, row, col - 1));
        grid[row][col] = currValue;
        return currValue + max;
    }
}
