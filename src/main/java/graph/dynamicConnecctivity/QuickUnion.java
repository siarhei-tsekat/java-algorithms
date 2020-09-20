package graph.dynamicConnecctivity;

public class QuickUnion {
    int[] roots;

    public QuickUnion(int n) {
        roots = new int[n];
        for (int i = 0; i < n; i++) roots[i] = i;
    }

    public int find(int p) {
        if (roots[p] == p) return p;
        else return find(roots[p]);
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
