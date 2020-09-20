package graph;

public class TimeNeededtoInformAllEmployees {
    public static void main(String[] args) {
        System.out.println("21 => " + new Solutio_n().numOfMinutes(7, 6, new int[]{1, 2, 3, 4, 5, 6, -1}, new int[]{0, 6, 5, 4, 3, 2, 1}));
        System.out.println("1 => " + new Solutio_n().numOfMinutes(6, 2, new int[]{2, 2, -1, 2, 2, 2}, new int[]{0, 0, 1, 0, 0, 0}));
        System.out.println("3 => " + new Solutio_n().numOfMinutes(15, 0, new int[]{-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6}, new int[]{1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}));
        System.out.println("612 => " + new Solutio_n().numOfMinutes(8, 0, new int[]{-1, 5, 0, 6, 7, 0, 0, 0}, new int[]{89, 0, 0, 0, 0, 523, 241, 519}));
        System.out.println("2560 => " + new Solutio_n().numOfMinutes(11, 4, new int[]{5, 9, 6, 10, -1, 8, 9, 1, 9, 3, 4}, new int[]{0, 213, 0, 253, 686, 170, 975, 0, 261, 309, 337}));
    }
}

class Solutio_n {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int timeLastPersonInformed = 0;
        for (int i = 0; i < n; i++) {
            timeLastPersonInformed = Math.max(timeLastPersonInformed, traceBack(i, manager, informTime));
        }
        return timeLastPersonInformed;
    }

    public int traceBack(int i, int[] manager, int[] informTime) {
        if (manager[i] != -1) {
            informTime[i] += traceBack(manager[i], manager, informTime);
            manager[i] = -1;
        }
        return informTime[i];
    }
}