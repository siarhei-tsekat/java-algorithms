package graph.undirected;

import java.io.InputStream;
import java.util.LinkedList;

class Bag<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void add(T adj) {
        list.add(adj);
    }

    public Iterable<T> adj() {
        return list;
    }
}

public class Graph {
    private int V;
    private Bag<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < V; i++) adj[i] = new Bag<Integer>();
    }

    public Graph(InputStream in) {
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v].adj();
    }

    public int V() {
        return 0;
    }

    public int E() {
        return 0;
    }

    public String toString() {
        return "";
    }
}
