package practice;

public class GraphValidTreeUsingUniqueFind {

    public static void main(String[] args) {
        System.out.println("Expected: false. Actual: " + validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
        System.out.println("Expected: false. Actual: " + validTree(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}));
        System.out.println("Expected: true. Actual: " + validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
    }

    public static boolean validTree(int n, int[][] edges) {
        return false;
    }
}
