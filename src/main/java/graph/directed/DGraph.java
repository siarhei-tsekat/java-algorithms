package graph.directed;

import java.util.LinkedList;

class Bag<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void add(T adj) {
        list.add(adj);
    }

    public Iterable<T> adj() {
        return list;
    }

    public int length() {
        return list.size();
    }
}

public class DGraph {
    private int V;
    private Bag<Integer>[] adj;

    public DGraph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < V; i++) adj[i] = new Bag<Integer>();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v].adj();
    }

    public int V() {
        return adj.length;
    }

    public int E() {
        int res = 0;

        for (int i = 0; i < adj.length; i++) res +=adj[i].length();

        return res;
    }

    public String toString() {
        return "";
    }
}
