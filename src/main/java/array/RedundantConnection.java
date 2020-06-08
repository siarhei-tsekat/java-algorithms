package array;

import java.util.ArrayList;
import java.util.List;

public class RedundantConnection {
    public static void main(String[] args) {
        System.out.println(findRedundantConnection(new int[][]{{16,25},{7,9},{3,24},{10,20},{15,24},{2,8},{19,21},{2,15},{13,20},{5,21},{7,11},{6,23},{7,16},{1,8},{17,20},{4,19},{11,22},{5,11},{1,16},{14,20},{1,4},{22,23},{12,20},{15,18},{12,16}}));
    }
    public static int[] findRedundantConnection(int[][] edges) {
        int [] parent = new int[1000];
        for(int i = 0; i < 1000; i++) {
            parent[i] = i;
        }
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < edges.length; i++) {
            int x = find(parent, edges[i][0]);
            int y = find(parent, edges[i][1]);

            if(x == y) {
                list.add(new int[]{edges[i][0],edges[i][1]});
            }
            parent[x] = y;
        }
        return list.get(list.size()-1);
    }

    public static int find(int [] parent, int value) {
        if(value == parent[value]) return value;
        else return parent[value] = find(parent, parent[value]);
    }
}
