package practice;

import java.util.Arrays;

/***
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 *
 * The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N),
 * with one additional edge added. The added edge has two different vertices chosen from 1 to N,
 * and was not an edge that already existed.
 *
 * The resulting graph is given as a 2D-array of edges.
 * Each element of edges is a pair [u, v] with u < v,
 * that represents an undirected edge connecting nodes u and v.
 *
 * Return an edge that can be removed so that the resulting graph is a tree of N nodes.
 * If there are multiple answers, return the answer that occurs last in the given 2D-array.
 * The answer edge [u, v] should be in the same format, with u < v.
 */

public class RedundantConnection {
    public static void main(String[] args) {
        System.out.println("Expected: [1,4]. Actual: " + Arrays.toString(findRedundantConnection(new int[][]{
                {16, 25}, {7, 9}, {3, 24}, {10, 20}, {15, 24}, {2, 8}, {19, 21}, {2, 15},
                {13, 20}, {5, 21}, {7, 11}, {6, 23}, {7, 16}, {1, 8}, {17, 20}, {4, 19},
                {11, 22}, {5, 11}, {1, 16}, {14, 20}, {1, 4}, {22, 23}, {12, 20}, {15, 18},
                {12, 16}})));
    }

    public static int[] findRedundantConnection(int[][] edges) {
     return null;
    }
}
