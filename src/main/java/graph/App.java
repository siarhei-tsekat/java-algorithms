package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) {
        int i = new Solution11().networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 4}}, 3, 1);
        System.out.println(i);
    }
}

class Solution11 {
    public int networkDelayTime(int[][] times, int n, int k) {

        HashMap<Integer, List<int[]>> map = new HashMap<>();

        for (int i = 0; i < times.length; i++) {
            int from = times[i][0];
            int to = times[i][1];
            int time = times[i][2];

            map.putIfAbsent(from, new ArrayList<>());
            map.get(from).add(new int[]{to, time});
        }
        int[] visited = new int[n + 1];

        PriorityQueue<int[]> list = new PriorityQueue<>((f, s) -> f[0] - s[0]);
        list.add(new int[]{0, k});

        int finalTime = 0;
        int neededEdges = n - 1;

        while (list.isEmpty() == false) {

            int size = list.size();
            int levelmaxTime = 0;

            while (size > 0) {

                int[] curr = list.poll();
                int currNode = curr[1];
                int timeToGetCurrNode = curr[0];

                for (int[] adj : map.getOrDefault(currNode, new ArrayList<int[]>())) {

                    if (visited[adj[1]] == 1) continue;
                    visited[adj[1]] = 1;

                    int timeToGetAdj = adj[0];
                    levelmaxTime = Math.max(levelmaxTime, timeToGetAdj + timeToGetCurrNode);
                    list.add(new int[]{adj[0], timeToGetAdj + timeToGetCurrNode});

                }
                size--;
                neededEdges--;
            }

            if (finalTime < levelmaxTime) {
                finalTime = levelmaxTime + finalTime;
            }

            if (neededEdges <= 0) {
                break;
            }
        }

        return finalTime == 0 ? -1 : finalTime;

    }
}
