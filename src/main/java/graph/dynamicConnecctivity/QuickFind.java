package graph.dynamicConnecctivity;

public class QuickFind {

    int[] roots;

    public QuickFind(int n) {
        roots = new int[n];
        for (int i = 0; i < n; i++) roots[i] = i;
    }

    public int find(int p) {
        return roots[p];
    }

    public boolean connected(int p, int q) {
        return roots[p] == roots[q];
    }

    public void unit(int p, int q) {
        for (int i = 0; i < roots.length; i++) {
            if (roots[i] == roots[p]) roots[i] = roots[q];
        }
    }
}


