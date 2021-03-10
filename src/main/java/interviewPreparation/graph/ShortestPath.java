package interviewPreparation.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ShortestPath {
    public static void main(String[] args) {
        int[][] conn = {{1, 2}, {1, 3}, {2, 4}, {2, 7}, {2, 6}, {7, 6}, {3, 4}, {3, 9}, {4, 8}, {9, 8}, {6, 10}, {8, 10}};
        List<Integer> path = new in().find(conn, 1, 10);
        System.out.println(path);
    }

}

class in {
    public List<Integer> find(int[][] conn, int src, int target) {
        int [] distTo = new int[100];
        List [] pathTo = new ArrayList [100];
        for (int i = 0; i < 100; i++) {
            pathTo[i] = new ArrayList();
            distTo[i] = 100;
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < conn.length; i++) {
            int from = conn[i][0];
            int to = conn[i][1];
            map.putIfAbsent(from, new ArrayList<>());
            map.get(from).add(to);
        }

        LinkedList<Integer> toProcess = new LinkedList<>();
        LinkedList<Integer> visited = new LinkedList<>();

        toProcess.add(src);
        distTo[src] = 0;

        while (!toProcess.isEmpty()) {
            Integer current = toProcess.poll();

            if(visited.contains(current)) continue;

            visited.add(current);

            for(Integer adj : map.getOrDefault(current, new ArrayList<>())) {
                if(distTo[adj] > distTo[current] + 1) {
                    distTo[adj] = distTo[current] + 1;
                    ArrayList newPath = new ArrayList(pathTo[current]);
                    newPath.add(current);
                    pathTo[adj] = newPath;
                }
                toProcess.add(adj);
            }
        }
        System.out.println("distance to " + target + " is " + distTo[target]);
        return pathTo[target];
    }
}

