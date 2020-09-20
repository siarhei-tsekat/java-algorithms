package graph.dynamicConnecctivity;

class Runner {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    private static void test6() {
        int[][] logFile = {{0, 1, 1}, {2, 3, 2}, {1, 2, 3}, {0, 4, 4}, {2, 5, 5}, {4, 5, 6}};
        SocialNetworkConnectivity connectivity = new SocialNetworkConnectivity();
        System.out.println("5 => " + connectivity.determineEarliestTime(6, logFile));
    }

    private static void test5() {
        int[][] logFile = {{0, 1, 1}, {0, 2, 2}, {0, 3, 3}, {4, 5, 4}, {4, 6, 5}, {7, 8, 6}, {8, 9, 7}, {10, 11, 8}, {8, 11, 9}, {8, 6, 10},
                {1, 10, 11}, {3, 9, 12}, {11, 5, 13}};
        SocialNetworkConnectivity connectivity = new SocialNetworkConnectivity();
        System.out.println("11 => " + connectivity.determineEarliestTime(12, logFile));
    }

    private static void test4() {
        int[][] logFile = {{0, 1, 1}, {2, 7, 2}, {0, 2, 3}, {0, 4, 4}, {2, 5, 5}, {0, 3, 6}, {2, 6, 7}, {3, 6, 8}};
        SocialNetworkConnectivity connectivity = new SocialNetworkConnectivity();
        System.out.println("7 => " + connectivity.determineEarliestTime(8, logFile));
    }

    private static void test3() {
        int[][] logFile = {{0, 1, 1}, {2, 3, 2}, {0, 4, 3}, {1, 2, 4}, {4, 3, 5}, {4, 2, 6}, {4, 1, 7}};
        SocialNetworkConnectivity connectivity = new SocialNetworkConnectivity();
        System.out.println("4 => " + connectivity.determineEarliestTime(5, logFile));
    }

    private static void test2() {
        int[][] logFile = {{0, 1, 1}, {0, 2, 2}, {3, 4, 3}, {2, 5, 4}, {2, 3, 5}, {5, 6, 6}, {2, 6, 7}};
        SocialNetworkConnectivity connectivity = new SocialNetworkConnectivity();
        System.out.println("6 => " + connectivity.determineEarliestTime(7, logFile));
    }

    private static void test1() {
        int[][] logFile = {{2, 3, 1}, {2, 5, 2}, {1, 0, 3}, {2, 6, 4}, {0, 2, 5}, {3, 4, 6}, {6, 5, 7}};
        SocialNetworkConnectivity connectivity = new SocialNetworkConnectivity();
        System.out.println("6 => " + connectivity.determineEarliestTime(7, logFile));
    }
}

public class SocialNetworkConnectivity {
    public int determineEarliestTime(int members, int[][] logFile) {
        int[] roots = new int[members];
        for (int i = 0; i < members; i++) roots[i] = i;

        for (int i = 0; i < logFile.length; i++) {
            unit(logFile[i][0], logFile[i][1], roots);
            if (checkIfAllConnected(roots)) return logFile[i][2];
        }
        return -1;
    }

    private boolean checkIfAllConnected(int[] roots) {
        int res = 0;
        for (int i = 0; i < roots.length; i++) {
            if (roots[i] == i) res++;
        }
        return res == 1;
    }

    private void unit(int p, int q, int[] roots) {
        int i = find(p, roots);
        int j = find(q, roots);
        roots[i] = j;
    }

    private int find(int p, int[] roots) {
        if (roots[p] == p) return p;
        else {
            roots[p] = roots[roots[p]];
            return find(roots[p], roots);
        }
    }
}
