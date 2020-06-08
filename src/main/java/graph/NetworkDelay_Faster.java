package graph;

/***
 * There are N network nodes, labelled 1 to N.
 *
 * Given times, a list of travel times as directed edges times[i] = (u, v, w),
 * where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.
 *
 * Now, we send a signal from a certain node K.
 * How long will it take for all nodes to receive the signal? If it is impossible, return -1.
 */
public class NetworkDelay_Faster {
    public static void main(String[] args) {
        System.out.println("Expected: 3. Actual: " + networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 4}}, 3, 1));
        System.out.println("Expected: 2. Actual: " + networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        System.out.println("Expected: 3. Actual: " + networkDelayTime(new int[][]{{1, 2, 1}, {2, 1, 3}}, 2, 2));
    }

    public static int networkDelayTime(int[][] times, int nodeAmount, int startfrom) {

        int[][] graph = new int[nodeAmount + 1][nodeAmount + 1];
        for (int i = 0; i < nodeAmount + 1; i++) {
            for (int j = 0; j < nodeAmount + 1; j++) {
                graph[i][j] = -1;
            }
        }
        for (int[] i : times) {
            graph[i[0]][i[1]] = i[2];
        }

        int[] timefromK = new int[nodeAmount + 1];

        for (int i = 0; i < nodeAmount + 1; i++) {
            timefromK[i] = Integer.MAX_VALUE;
        }
        boolean[] visited = new boolean[nodeAmount + 1];

        timefromK[startfrom] = 0;

        for (int i = 0; i < nodeAmount; i++) {
            int currentNode = findMin(timefromK, visited);
            visited[currentNode] = true;

            for (int next = 1; next <= nodeAmount; next++) {
                if (!visited[next] && graph[currentNode][next] != -1) {
                    timefromK[next] = Math.min(timefromK[next], timefromK[currentNode] + graph[currentNode][next]);
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= nodeAmount; i++) {
            if (timefromK[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(timefromK[i], max);
        }
        return max;
    }

    private static int findMin(int[] timefromK, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 1; i < timefromK.length; i++) {
            if (!visited[i] && timefromK[i] < min) {
                min = timefromK[i];
                index = i;
            }
        }
        return index;
    }
}
