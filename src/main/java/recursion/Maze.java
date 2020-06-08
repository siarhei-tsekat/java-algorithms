package recursion;

public class Maze {
    public static void main(String[] args) {
        int[][] var = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = {0,4};
        int[] dest = {4,4};
        System.out.println(hasPath(var, start, dest));
    }

    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean res[] = {false};
        func(maze, start, destination, res);
        return res[0];
    }

    public static void func(int[][] maze, int[] step, int[] dest, boolean[] res) {
        if (step[0] < 0 || step[0] >= maze.length || step[1] < 0 || step[1] >= maze[step[0]].length ||
                maze[step[0]][step[1]] == 2) return;

        if (isTarget(step, dest)) {
            res[0] = true;
            return;
        }

        maze[step[0]][step[1]] = 2;
        printMaze(maze);
        func(maze, getBottomtMost(maze, step), dest, res);
        func(maze, getRightMost(maze, step), dest, res);
        func(maze, getLeftMost(maze, step), dest, res);
        func(maze, getTopMost(maze, step), dest, res);
    }

    public static int[] getBottomtMost(int[][] maze, int[] step) {
        int [] arr = new int []{step[0], step[1]};
        while (arr[0] + 1 < maze.length) {
            if (maze[arr[0] + 1][arr[1]] == 1) return arr;
            else arr[0]++;
        }
        return arr;
    }

    public static int[] getTopMost(int[][] maze, int[] step) {
        int [] arr = new int []{step[0], step[1]};
        while (arr[0] - 1 >= 0) {
            if (maze[arr[0] - 1][arr[1]] == 1) return arr;
            else arr[0]--;
        }
        return arr;
    }

    public static int[] getRightMost(int[][] maze, int[] step) {
        int [] arr = new int []{step[0], step[1]};
        while (arr[1] + 1 < maze[step[0]].length) {
            if (maze[arr[0]][arr[1] + 1] == 1) return arr;
            else arr[1]++;
        }
        return arr;
    }

    public static int[] getLeftMost(int[][] maze, int[] step) {
        int [] arr = new int []{step[0], step[1]};
        while (arr[1] - 1 >= 0) {
            if (maze[arr[0]][arr[1] - 1] == 1) return arr;
            else arr[1]--;
        }
        return arr;
    }

    public static boolean isTarget(int[] step, int[] dest) {
        return step[0] == dest[0] && step[1] == dest[1];
    }

    private static void printMaze(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j]);
                System.out.print(" ");
            }
            System.out.println("]");
        }
        System.out.println("----------------------------");
    }
}
