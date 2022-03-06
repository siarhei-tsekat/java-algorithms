package graph;

import java.util.*;

public class App1 {
    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10);
        stockPrice.update(2, 5);
        System.out.println(stockPrice.current());
        System.out.println(stockPrice.maximum());
        stockPrice.update(1, 3);
        System.out.println(stockPrice.maximum());
        stockPrice.update(4, 2);
        System.out.println(stockPrice.minimum());
    }

}

class StockPrice {

    Map<Integer, Integer> map = new HashMap<>();
    MinMax minmax = new MinMax();
    int lastTime = 0;

    public void update(int time, int price) {
        Integer old = map.put(time, price);
        if (old != null) minmax.remove(old);
        minmax.add(price);
        lastTime = Math.max(lastTime, time);
    }

    public int current() {
        return map.get(lastTime);
    }

    public int maximum() {
        return minmax.firstKey();
    }

    public int minimum() {
        return minmax.lastKey();
    }
}

class MinMax {
    ArrayList<Integer> list = new ArrayList<>();

    public MinMax() {
    }

    public void add(int v) {
        int index = Collections.binarySearch(list, v, Collections.reverseOrder());
        list.add(index < 0 ? Math.abs(index) - 1 : index, v);
    }

    public void remove(int v) {
        int index = Collections.binarySearch(list, v, Collections.reverseOrder());
        list.remove((int) index);
    }

    public int firstKey() {
        return list.get(0);
    }

    public int lastKey() {
        return list.get(list.size() - 1);
    }
}


