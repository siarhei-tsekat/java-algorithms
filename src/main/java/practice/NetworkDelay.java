package practice;

/***
 * There are N network nodes, labelled 1 to N.
 *
 * Given times, a list of travel times as directed edges times[i] = (u, v, w),
 * where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.
 *
 * Now, we send a signal from a certain node K.
 * How long will it take for all nodes to receive the signal? If it is impossible, return -1.
 */

public class NetworkDelay {
    public static void main(String[] args) {
        System.out.println("Expected: 3. Actual: " + networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 4}}, 3, 1));
        System.out.println("Expected: 2. Actual: " + networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        System.out.println("Expected: 3. Actual: " + networkDelayTime(new int[][]{{1, 2, 1}, {2, 1, 3}}, 2, 2));
    }

    public static int networkDelayTime(int[][] times, int nodeAmount, int startfrom) {
        return 0;
    }
}
