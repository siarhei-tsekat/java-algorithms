package backtracking;

public class NQueenProblem {
    public boolean isAvailable(int row, int col, int n,
                               int[] rows,
                               int[] hills,
                               int[] dales) {
        int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
        return (res == 0) ? true : false;
    }

    public int backtrack(int row, int count, int n, int[] rows, int[] hills, int[] dales) {
        for (int col = 0; col < n; col++) {
            if (isAvailable(row, col, n, rows, hills, dales)) {
                placeQueen(row, n, rows, hills, dales, col);

                if (row + 1 == n) {
                    count++;
                } else count = backtrack(row + 1, count, n, rows, hills, dales);

                removeQueen(row, n, rows, hills, dales, col);
            }
        }
        return count;
    }

    private void removeQueen(int row, int n, int[] rows, int[] hills, int[] dales, int col) {
        helper(row, n, rows, hills, dales, col, 0);
    }

    private void placeQueen(int row, int n, int[] rows, int[] hills, int[] dales, int col) {
        helper(row, n, rows, hills, dales, col, 1);
    }

    private void helper(int row, int n, int[] rows, int[] hills, int[] dales, int col, int i) {
        rows[col] = i;
        hills[row - col + 2 * n] = i;
        dales[row + col] = i;
    }

    public int totalNQueens(int n) {
        int rows[] = new int[n];
        // "hill" diagonals
        int hills[] = new int[4 * n - 1];
        // "dale" diagonals
        int dales[] = new int[2 * n - 1];

        return backtrack(0, 0, n, rows, hills, dales);
    }
}
