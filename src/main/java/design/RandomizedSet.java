package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/***
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 */

class RandomizedSet {
    HashMap<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random rand = new Random();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }


    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        Integer last = list.get(list.size() - 1);
        list.set(map.get(val), last);
        list.remove((int) list.size() - 1);
        map.put(last, map.get(val));
        return map.remove(val) != null;
    }

    public int getRandom() {
        if (list.isEmpty()) return -1;
        return list.get(rand.nextInt(list.size()));
    }
}


class Runner {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println("Expected: true. Actual: " + randomizedSet.insert(3));
        System.out.println("Expected: false: Actual: " + randomizedSet.insert(3));
        System.out.println("Expected: 3. Actual: " +  randomizedSet.getRandom());
        System.out.println("Expected: true. Actual: "+randomizedSet.insert(1));
        System.out.println("Expected: true. Actual: " + randomizedSet.remove(3));
        System.out.println("Expected: 1. Actual: " + randomizedSet.getRandom());
        System.out.println("Expected: 1. Actual: " + randomizedSet.getRandom());
    }
}
