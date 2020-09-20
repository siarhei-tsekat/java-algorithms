package graph.dynamicConnecctivity;

public class QuickUnionWithPathCompression {
    int[] roots;

    public QuickUnionWithPathCompression(int n) {
        roots = new int[n];
        for (int i = 0; i < n; i++) roots[i] = i;
    }

    public int find(int p) {
        if (roots[p] == p) return p;
        else {
            roots[p] = roots[roots[p]];
            return find(roots[p]);
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void unit(int p, int q) {
        int i = find(p);
        int j = find(q);
        roots[i] = j;
    }
}
