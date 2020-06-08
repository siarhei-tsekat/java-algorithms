package practice;


import java.util.Arrays;

public class WallsandGates {

    private static final int GATE = 0;
    private static final int OBS = -1;

    public static void main(String[] args) {
        int[][] ints = new int[][]{
                {10000, -1, 0, 10000},
                {10000, 10000, 10000, -1},
                {10000, -1, 10000, -1},
                {0, -1, 10000, 10000}
        };
        wallsAndGates(ints);
        System.out.println("Actual:   " + Arrays.deepToString(ints));
        System.out.println("Expected: [[3, -1, 0, 1], [2, 2, 1, -1], [1, -1, 2, -1], [0, -1, 3, 4]]");
    }

    public static void wallsAndGates(int[][] rooms) {
    }
}
