package array;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        List<Integer> list = topKFrequent(new int[]{5, 3, 1, 1, 1, 3, 5, 73, 1}, 3);
        System.out.println(list);
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, Node> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                Node n = map.get(nums[i]);
                n.frequency = n.frequency + 1;
            } else {
                map.put(nums[i], new Node(nums[i], 1));
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int key : map.keySet()) {
            Node n = map.get(key);
            if (pq.size() < k) {
                pq.offer(n);
            } else if (n.frequency > pq.peek().frequency) {
                pq.poll();
                pq.offer(n);
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(0, pq.poll().element);
        }
        return list;
    }
}


class Node implements Comparable<Node> {
    int element;
    int frequency;

    Node(int element, int frequency) {
        this.element = element;
        this.frequency = frequency;
    }

    public int compareTo(Node n2) {
        return this.frequency - n2.frequency;
    }
}
