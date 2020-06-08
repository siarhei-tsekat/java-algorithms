package divideAndConquer;

import java.util.Arrays;

public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };


        System.out.println(searchMatrix(mat, -5));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            boolean helper = helper(matrix[i], target);
            if (helper) {
                return true;
            }
        }
        return false;
    }

    private static boolean helper(int[] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        if (matrix[matrix.length - 1] < target || matrix[0] > target) {
            return false;
        } else {
            int i = Arrays.binarySearch(matrix, target);
            return i > -1;
        }
    }
}
