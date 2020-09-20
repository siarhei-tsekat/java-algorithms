package dynamicProgramming;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        Solution_ solution = new Solution_();
//        System.out.println(solution.uniquePaths(3, 2));
        System.out.println(solution.uniquePaths(7, 3));
    }
}

class Solution_ {
    public int uniquePaths(int m, int n) {
        int[][] d = new int[m][n];

        for(int[] arr : d) {
            Arrays.fill(arr, 1);
        }
        for(int col = 1; col < m; ++col) {
            for(int row = 1; row < n; ++row) {
                d[col][row] = d[col - 1][row] + d[col][row - 1];
            }
        }

        return d[m - 1][n - 1];
    }
}
