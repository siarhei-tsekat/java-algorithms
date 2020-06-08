package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/***
 * There are n cities connected by m flights.
 * Each flight starts from city u and arrives at v with a price w.
 *
 * Now given all the cities and flights, together with starting city src and the destination dst,
 * your task is to find the cheapest price from src to dst with up to k stops.
 * If there is no such route, output -1.
 */

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    private static void test5() {
  List<Integer> list = new ArrayList<>();

        int[][] var = {{10, 14, 43}, {1, 12, 62}, {4, 2, 62}, {14, 10, 49}, {9, 5, 29}, {13, 7, 53}, {4, 12, 90}, {14, 9, 38}, {11, 2, 64}, {2, 13, 92}, {11, 5, 42}, {10, 1, 89}, {14, 0, 32}, {9, 4, 81}, {3, 6, 97}, {7, 13, 35}, {11, 9, 63}, {5, 7, 82}, {13, 6, 57}, {4, 5, 100}, {2, 9, 34}, {11, 13, 1}, {14, 8, 1}, {12, 10, 42}, {2, 4, 41}, {0, 6, 55}, {5, 12, 1}, {13, 3, 67}, {3, 13, 36}, {3, 12, 73}, {7, 5, 72}, {5, 6, 100}, {7, 6, 52}, {4, 7, 43}, {6, 3, 67}, {3, 1, 66}, {8, 12, 30}, {8, 3, 42}, {9, 3, 57}, {12, 6, 31}, {2, 7, 10}, {14, 4, 91}, {2, 3, 29}, {8, 9, 29}, {2, 11, 65}, {3, 8, 49}, {6, 14, 22}, {4, 6, 38}, {13, 0, 78}, {1, 10, 97}, {8, 14, 40}, {7, 9, 3}, {14, 6, 4}, {4, 8, 75}, {1, 6, 56}};
        Flights solution = new Flights();
        System.out.println(solution.findCheapestPrice(15, var, 1, 4, 10));
    }

    private static void test4() {
        int[][] var = {{3, 4, 4}, {2, 5, 6}, {4, 7, 10}, {9, 6, 5}, {7, 4, 4}, {6, 2, 10}, {6, 8, 6}, {7, 9, 4}, {1, 5, 4}, {1, 0, 4}, {9, 7, 3}, {7, 0, 5}, {6, 5, 8}, {1, 7, 6}, {4, 0, 9}, {5, 9, 1}, {8, 7, 3}, {1, 2, 6}, {4, 1, 5}, {5, 2, 4}, {1, 9, 1}, {7, 8, 10}, {0, 4, 2}, {7, 2, 8}};
        Flights solution = new Flights();
        System.out.println(solution.findCheapestPrice(10, var, 6, 0, 7));
    }

    private static void test3() {
        int[][] var = {{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}};
        Flights solution = new Flights();
        System.out.println(solution.findCheapestPrice(4, var, 0, 3, 1));
    }

    private static void test2() {
        int[][] var = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        Flights solution = new Flights();
        System.out.println(solution.findCheapestPrice(3, var, 0, 2, 0));
    }

    private static void test1() {
        int[][] var = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        Flights solution = new Flights();
        System.out.println(solution.findCheapestPrice(3, var, 0, 2, 1));
    }
}

class Flights {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[][] adjMap = new int[n][n];
        for (int[] flight : flights) {
            adjMap[flight[0]][flight[1]] = flight[2];
        }

        int bestTimeToGetNode[] = new int[n];
        int bestStepsToGetNode[] = new int[n];
        Arrays.fill(bestTimeToGetNode, Integer.MAX_VALUE);
        Arrays.fill(bestStepsToGetNode, Integer.MAX_VALUE);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((f, s) -> f[1] - s[1]);
        minHeap.add(new int[]{src, 0, 0});
        bestTimeToGetNode[src] = 0;
        bestStepsToGetNode[src] = 0;

        while (!minHeap.isEmpty()) {
            int[] info = minHeap.poll();
            int currentNode = info[0];
            int timeToGetNode = info[1];
            int stepsToGetNode = info[2];

            if (currentNode == dst) return timeToGetNode;

            if (stepsToGetNode == k + 1) continue;

            for (int adjNode = 0; adjNode < adjMap[currentNode].length; adjNode++) {
                if (adjMap[currentNode][adjNode] != 0) {
                    if (bestTimeToGetNode[adjNode] > timeToGetNode + adjMap[currentNode][adjNode]) {

                        bestTimeToGetNode[adjNode] = timeToGetNode + adjMap[currentNode][adjNode];
                        minHeap.add(new int[]{adjNode, bestTimeToGetNode[adjNode], stepsToGetNode + 1});

                    } else if (stepsToGetNode < bestStepsToGetNode[adjNode]) {
                        minHeap.add(new int[]{adjNode, timeToGetNode + adjMap[currentNode][adjNode], stepsToGetNode + 1});
                        bestStepsToGetNode[adjNode] = stepsToGetNode;
                    }
                }
            }
        }

        return bestTimeToGetNode[dst] == Integer.MAX_VALUE ? -1 : bestTimeToGetNode[dst];

    }
}