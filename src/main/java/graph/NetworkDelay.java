package graph;

import java.util.*;

public class NetworkDelay {
    public static void main(String[] args) {
        System.out.println("Expected: 3. Actual: " + networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 4}}, 3, 1));
        System.out.println("Expected: 2. Actual: " + networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        System.out.println("Expected: 3. Actual: " + networkDelayTime(new int[][]{{1, 2, 1}, {2, 1, 3}}, 2, 2));
    }

    public static int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            int from = edge[0];
            int to = edge[1];
            int time = edge[2];

            List<int[]> orDefault = graph.getOrDefault(from, new ArrayList<>());
            orDefault.add(new int[]{to, time});
            graph.put(from, orDefault);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((info1, info2) -> info1[0] - info2[0]);
        heap.add(new int[]{0, K});

        Map<Integer, Integer> dist = new HashMap<>();

        while (!heap.isEmpty()) {
            int[] info = heap.poll();
            int timeToGetNode = info[0];
            int node = info[1];

            if (dist.containsKey(node)) continue;

            dist.put(node, timeToGetNode);
            for (int[] edge : graph.getOrDefault(node, new ArrayList<>())) {
                int adjacent = edge[0];
                int timeToGetAdj = edge[1];

                if (!dist.containsKey(adjacent))
                    heap.add(new int[]{timeToGetNode + timeToGetAdj, adjacent});
            }
        }

        if (dist.size() != N) return -1;

        return dist.values().stream().max(Integer::compareTo).orElse(0);
    }
}
