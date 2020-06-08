package design.LFU;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Design and implement a data structure for Least Frequently Used (LFU) cache.
 * It should support the following operations: get and put.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item.
 * For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency),
 * the least recently used key would be evicted.
 * Note that the number of times an item is used is the number of calls to the get and put
 * functions for that item since it was inserted.
 * This number is set to zero when the item is removed.
 */

class FreqNode implements Comparable<FreqNode> {
    public int freq;
    public int time;
    public int value;
    public Integer key;

    public FreqNode(int key, int freq, int time, int value) {
        this.key = key;
        this.freq = freq;
        this.time = time;
        this.value = value;
    }

    @Override
    public int compareTo(FreqNode that) {
        return Integer.compare(this.time, that.time);
    }
}

public class LFUCache {
    int time;
    int capacity;
    HashMap<Integer, FreqNode> mapNode = new HashMap<>();
    HashMap<Integer, PriorityQueue<FreqNode>> mapFreqNode = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        FreqNode freqNode = mapNode.getOrDefault(key, null);
        if (freqNode != null) {
            mapFreqNode.get(freqNode.freq).remove(freqNode);
            freqNode.freq++;
            freqNode.time = time++;
            PriorityQueue<FreqNode> orDefault = mapFreqNode.getOrDefault(freqNode.freq, new PriorityQueue<>());
            orDefault.add(freqNode);
            mapFreqNode.put(freqNode.freq, orDefault);
            return freqNode.value;
        } else return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (mapNode.containsKey(key)) {
            FreqNode freqNode = mapNode.get(key);
            mapFreqNode.get(freqNode.freq).remove(freqNode);
            freqNode.freq++;
            freqNode.time = time++;
            freqNode.value = value;
            PriorityQueue<FreqNode> orDefault = mapFreqNode.getOrDefault(freqNode.freq, new PriorityQueue<>());
            orDefault.add(freqNode);
            mapFreqNode.put(freqNode.freq, orDefault);
        } else {
            if (capacity == mapNode.size()) delete();
            FreqNode newValue = new FreqNode(key, 1, time++, value);
            mapNode.put(key, newValue);
            PriorityQueue<FreqNode> orDefault = mapFreqNode.getOrDefault(1, new PriorityQueue<>());
            orDefault.add(newValue);
            mapFreqNode.put(1, orDefault);
        }
    }

    private void delete() {
        PriorityQueue<FreqNode> orDefault = null;
        int key = 0;

        while (true) {
            orDefault = mapFreqNode.getOrDefault(key, null);
            if (orDefault == null || orDefault.isEmpty()) key++;
            else break;
        }

        FreqNode forDelete = orDefault.poll();
        mapNode.remove(forDelete.key);
    }
}
