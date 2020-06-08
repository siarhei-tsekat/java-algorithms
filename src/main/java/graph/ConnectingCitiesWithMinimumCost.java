package graph;

import java.util.Arrays;

public class ConnectingCitiesWithMinimumCost {
    public static void main(String[] args) {
        int[][] arg = new int[][]{{1, 2, 5}, {1, 3, 6}, {2, 3, 1}};
        System.out.println(minimumCost(3, arg));
    }

    public static int minimumCost(int n, int[][] connections) {
        if (n <= 0 || connections == null || connections.length == 0) return -1;

        int[] parents = new int[n + 1];
        int[] distances = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parents[i] = i;
            distances[i] = 1;
        }

        Arrays.sort(connections, (a, b) -> Integer.compare(a[2], b[2]));

        int sum = 0;
        int disconnected = n;
        for (int[] connection : connections) {

            int x = connection[0];
            int y = connection[1];

            if (union(parents, distances, x, y)) {
                sum += connection[2];
                disconnected--;
            }
        }
        return disconnected == 1 ? sum : -1;
    }

    private static boolean union(int[] parents, int[] distances, int city1, int city2) {
        int p1 = find(parents, city1);
        int p2 = find(parents, city2);

        if (p1 == p2) return false;

        if (distances[p1] > distances[p2]) {
            parents[p2] = p1;
            distances[p1] += distances[p2];
        } else {
            parents[p1] = p2;
            distances[p2] += distances[p1];
        }

        return true;
    }

    private static int find(int[] parents, int city) {
        if (parents[city] == city)
            return parents[city];

        parents[city] = find(parents, parents[city]);
        return parents[city];
    }
}

