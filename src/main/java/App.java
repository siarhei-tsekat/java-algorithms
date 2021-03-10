import java.util.*;

public class App {
    public static void main(String[] args) {
        System.out.println("3 => " + new __Solution().findTheCity(4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4));
    }
}

class __Solution {
    HashMap<Integer, List<int[]>> map = new HashMap<>();
    HashSet[] info;
    boolean[] visited;

    public int findTheCity(int n, int[][] edges, int trh) {
        info = new HashSet[n];
        visited = new boolean[n];

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            int w = edges[i][2];

            map.putIfAbsent(from, new ArrayList<>());
            map.putIfAbsent(to, new ArrayList<>());
            map.get(from).add(new int[]{to, w});
            map.get(to).add(new int[]{from, w});
        }

        for (int i = 0; i < n; i++) {
            LinkedList<int[]> q = new LinkedList<>();
            int[] start = {i, 0};
            q.add(start); // {to , path}
            info[start[0]] = new HashSet();
            visited[start[0]] = true;

            while (!q.isEmpty()) {
                int size = q.size();

                while (size > 0) {
                    int[] currInfo = q.poll();
                    int to = currInfo[0];
                    int weight = currInfo[1];

                    for (int[] adjInfo : map.getOrDefault(to, new ArrayList<>())) {
                        if (weight + adjInfo[1] > trh || adjInfo[0] == i) continue;
                        q.add(new int[]{adjInfo[0], weight + adjInfo[1]});
                        info[start[0]].add(adjInfo[0]);
                    }

                    size--;
                }
            }
            visited = new boolean[n];
        }

        System.out.println(Arrays.toString(info));

        int min = 1000000;
        int ind = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i].size() <= min) {
                min = info[i].size();
                ind = i;
            }
        }
        return ind;
    }

}
