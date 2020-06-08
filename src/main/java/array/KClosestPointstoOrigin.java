package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointstoOrigin {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(kClosest(new int[][]{{1, 3}, {-2, 2}, {2, -2}}, 2)));
    }

    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Pair> queue = new PriorityQueue<>(K, Comparator.comparing(p -> p.distance));
        int[][] res = new int[K][];
        for (int i = 0; i < points.length; i++) {
            queue.add(getDistance(points[i]));
        }
        for (int i = 0; i < K; i++) {
            Pair poll = queue.poll();
            res[i] = new int[]{poll.x, poll.y};
        }
        return res;
    }

    private static Pair getDistance(int[] point) {
        int x = point[0];
        int y = point[1];
        double distance = Math.sqrt(Math.pow(x - 0, 2) + Math.pow(y - 0, 2));
        return new Pair(x, y, distance);
    }
}

class Pair {
    int x;
    int y;
    double distance;

    public Pair(int x, int y, double distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}
