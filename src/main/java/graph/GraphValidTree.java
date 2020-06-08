package graph;


public class GraphValidTree {

    public static void main(String[] args) {
        System.out.println(validTree(4, new int[][]{{1, 2}, {3, 4}}));
    }

    public static boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;

        int[] parents = new int[n];
        for(int i = 0; i < n; i++)
            parents[i] = i;


        for (int i = 0; i < edges.length; i++) {
            int x = find(parents, edges[i][0]);
            int y = find(parents, edges[i][1]);

            if (x == y) return false;

            parents[x] = y;
        }

        return true;
    }

    static int  find(int[] parents, int value){
        if (value == parents[value])
            return value;
        return parents[value] = find(parents,parents[value]);
    }
}
