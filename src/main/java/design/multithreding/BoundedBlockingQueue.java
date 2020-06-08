package design.multithreding;

import java.util.LinkedList;

public class BoundedBlockingQueue {
    LinkedList<Integer> list = new LinkedList();
    int capacity;

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(int element) throws InterruptedException {
        synchronized (list) {
            while (list.size() == capacity) list.wait();
            list.add(element);
            list.notify();
        }
    }

    public int dequeue() throws InterruptedException {
        synchronized (list) {
            while (list.size() == 0) list.wait();
            int element = list.poll();
            list.notify();
            return element;
        }
    }

    public int size() {
        synchronized(list) {
            return list.size();
        }
    }
}
