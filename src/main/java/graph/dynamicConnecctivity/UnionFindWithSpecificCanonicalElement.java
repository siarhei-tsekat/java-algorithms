package graph.dynamicConnecctivity;

public class UnionFindWithSpecificCanonicalElement {
    int[] roots;

    public UnionFindWithSpecificCanonicalElement(int n) {
        roots = new int[n];
        for (int i = 0; i < n; i++) roots[i] = i;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (j > i) roots[i] = j;
        else roots[j] = i;
    }

    public boolean connected(int q, int p) {
        return find(q) == find(p);
    }

    public int find(int v) {
        if (roots[v] == v) return v;
        else {
            roots[v] = roots[roots[v]];
            return find(roots[v]);
        }
    }
}
